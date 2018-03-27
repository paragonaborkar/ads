package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;

public class TUniqRowInBeginJava
{
  protected static String nl;
  public static synchronized TUniqRowInBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TUniqRowInBeginJava result = new TUniqRowInBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "            int bufferSizePerFile_";
  protected final String TEXT_2 = " = 10000;" + NL + "            " + NL + "            java.util.List<FileRowIterator_";
  protected final String TEXT_3 = "> rowFileList_1_";
  protected final String TEXT_4 = " = new java.util.ArrayList<FileRowIterator_";
  protected final String TEXT_5 = ">();" + NL + "            java.util.List<rowStruct_";
  protected final String TEXT_6 = "> rowList_1_";
  protected final String TEXT_7 = " = new java.util.ArrayList<rowStruct_";
  protected final String TEXT_8 = ">();" + NL + "" + NL + "            for (java.io.File file : files_1_";
  protected final String TEXT_9 = ") {" + NL + "                FileRowIterator_";
  protected final String TEXT_10 = " fri = new FileRowIterator_";
  protected final String TEXT_11 = "(file, bufferSizePerFile_";
  protected final String TEXT_12 = ");" + NL + "                rowFileList_1_";
  protected final String TEXT_13 = ".add(fri);" + NL + "                rowList_1_";
  protected final String TEXT_14 = ".add(fri.next());" + NL + "            }" + NL + "            " + NL + "            // comparator for second sort" + NL + "\t\t\tclass Comparator_2_";
  protected final String TEXT_15 = " implements Comparator<rowStruct_";
  protected final String TEXT_16 = "> {" + NL + "" + NL + "    \t\t\tpublic int compare(rowStruct_";
  protected final String TEXT_17 = " arg0, rowStruct_";
  protected final String TEXT_18 = " arg1) {" + NL + "        \t\t\treturn arg0.id_";
  protected final String TEXT_19 = " - arg1.id_";
  protected final String TEXT_20 = ";" + NL + "    \t\t\t}" + NL + "" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "            //For second sort init begin" + NL + "            int bufferSize_2_";
  protected final String TEXT_21 = " = bufferSize_";
  protected final String TEXT_22 = ";" + NL + "            rowStruct_";
  protected final String TEXT_23 = "[] buffer_2_";
  protected final String TEXT_24 = " = new rowStruct_";
  protected final String TEXT_25 = "[bufferSize_1_";
  protected final String TEXT_26 = "];" + NL + "            int rowsInBuffer_2_";
  protected final String TEXT_27 = " = 0;" + NL + "            Comparator<rowStruct_";
  protected final String TEXT_28 = "> comparator_2_";
  protected final String TEXT_29 = " = new Comparator_2_";
  protected final String TEXT_30 = "();" + NL + "" + NL + "            java.util.ArrayList<java.io.File> files_2_";
  protected final String TEXT_31 = " = new java.util.ArrayList<java.io.File>();" + NL + "            //For second sort init end" + NL + "" + NL + "            while (rowList_1_";
  protected final String TEXT_32 = ".size() > 0) {" + NL + "                int minIndex_";
  protected final String TEXT_33 = " = 0;" + NL + "                if (rowList_1_";
  protected final String TEXT_34 = ".size() > 1) {" + NL + "                    for (int i = 1; i < rowList_1_";
  protected final String TEXT_35 = ".size(); i++) {" + NL + "                        if (comparator_1_";
  protected final String TEXT_36 = ".compare(rowList_1_";
  protected final String TEXT_37 = ".get(minIndex_";
  protected final String TEXT_38 = "), rowList_1_";
  protected final String TEXT_39 = ".get(i)) > 0) {" + NL + "                            minIndex_";
  protected final String TEXT_40 = " = i;" + NL + "                        }" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                // /////////////" + NL + "                if (rowsInBuffer_2_";
  protected final String TEXT_41 = " >= bufferSize_2_";
  protected final String TEXT_42 = ") {// buffer is full do sort and" + NL + "" + NL + "                    java.util.Arrays.<rowStruct_";
  protected final String TEXT_43 = "> sort(buffer_2_";
  protected final String TEXT_44 = ", 0, bufferSize_2_";
  protected final String TEXT_45 = ", comparator_2_";
  protected final String TEXT_46 = ");" + NL + "                    java.io.File file = new java.io.File(workDirectory_";
  protected final String TEXT_47 = " + \"/";
  protected final String TEXT_48 = "_TEMP_uniq_\" + files_2_";
  protected final String TEXT_49 = ".size());";
  protected final String TEXT_50 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_51 = " - Invoke request to delete file: \"+file.getPath()+\" When VM exit.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_52 = NL + "                    file.deleteOnExit();" + NL + "                    java.io.ObjectOutputStream rw = new java.io.ObjectOutputStream(new java.io.BufferedOutputStream(" + NL + "                            new java.io.FileOutputStream(file)));" + NL + "                \t";
  protected final String TEXT_53 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_54 = " - Writing the data into: \"+file.getPath());" + NL + "\t\t\t\t\t";
  protected final String TEXT_55 = NL + "                    for (int i = 0; i < bufferSize_2_";
  protected final String TEXT_56 = "; i++) {" + NL + "                        buffer_2_";
  protected final String TEXT_57 = "[i].writeData(rw);" + NL + "                    }" + NL + "                    rw.close();" + NL + "\t\t\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_59 = " - Wrote successfully.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_60 = NL + NL + "                    files_2_";
  protected final String TEXT_61 = ".add(file);" + NL + "" + NL + "                    rowsInBuffer_2_";
  protected final String TEXT_62 = " = 0;" + NL + "                }" + NL + "                rowStruct_";
  protected final String TEXT_63 = " minItem = rowList_1_";
  protected final String TEXT_64 = ".get(minIndex_";
  protected final String TEXT_65 = ");" + NL + "                buffer_2_";
  protected final String TEXT_66 = "[rowsInBuffer_2_";
  protected final String TEXT_67 = "++] = minItem;" + NL + "                FileRowIterator_";
  protected final String TEXT_68 = " fri = rowFileList_1_";
  protected final String TEXT_69 = ".get(minIndex_";
  protected final String TEXT_70 = ");" + NL + "                if (fri.hasNext()) {" + NL + "                    rowList_1_";
  protected final String TEXT_71 = ".set(minIndex_";
  protected final String TEXT_72 = ", fri.next());" + NL + "                } else {" + NL + "                    fri.close();" + NL + "                    rowFileList_1_";
  protected final String TEXT_73 = ".remove(minIndex_";
  protected final String TEXT_74 = ");" + NL + "                    rowList_1_";
  protected final String TEXT_75 = ".remove(minIndex_";
  protected final String TEXT_76 = ");" + NL + "                }" + NL + "" + NL + "                //skip duplicates....begin-->this case is suitable for no duplicate connection" + NL + "                for (int i = 0; i < rowList_1_";
  protected final String TEXT_77 = ".size(); ) {" + NL + "                    if (rowList_1_";
  protected final String TEXT_78 = ".get(i).duplicateTo(minItem)) {" + NL + "                        rowStruct_";
  protected final String TEXT_79 = " noDuplicateItem = null;" + NL + "                        FileRowIterator_";
  protected final String TEXT_80 = " fri2 = rowFileList_1_";
  protected final String TEXT_81 = ".get(i);" + NL + "                        while (fri2.hasNext()) {" + NL + "                            rowStruct_";
  protected final String TEXT_82 = " current = fri2.next();" + NL + "                            if (!minItem.duplicateTo(current)) {" + NL + "                                noDuplicateItem = current;" + NL + "                                break;" + NL + "                            }" + NL + "                        }" + NL + "                        if (noDuplicateItem == null) {" + NL + "                            fri2.close();" + NL + "                            rowFileList_1_";
  protected final String TEXT_83 = ".remove(i);" + NL + "                            rowList_1_";
  protected final String TEXT_84 = ".remove(i);" + NL + "                        } else {" + NL + "                            rowList_1_";
  protected final String TEXT_85 = ".set(i, noDuplicateItem);" + NL + "                            i++;" + NL + "                        }" + NL + "                    }else{" + NL + "                        i++;" + NL + "                    }" + NL + "                }" + NL + "                //skip duplicates....end" + NL + "            }" + NL + "" + NL + "" + NL + "            if (rowsInBuffer_2_";
  protected final String TEXT_86 = " > 0) {" + NL + "                " + NL + "                java.util.Arrays.<rowStruct_";
  protected final String TEXT_87 = "> sort(buffer_2_";
  protected final String TEXT_88 = ", 0, rowsInBuffer_2_";
  protected final String TEXT_89 = ", comparator_2_";
  protected final String TEXT_90 = ");" + NL + "                " + NL + "                java.io.File file = new java.io.File(workDirectory_";
  protected final String TEXT_91 = " + \"/";
  protected final String TEXT_92 = "_TEMP_uniq_\" + files_2_";
  protected final String TEXT_93 = ".size());" + NL + "                ";
  protected final String TEXT_94 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_95 = " - Invoke request to delete file: \"+file.getPath()+\" When VM exit.\");" + NL + "\t\t\t\t";
  protected final String TEXT_96 = NL + "                " + NL + "                file.deleteOnExit();" + NL + "                " + NL + "                java.io.ObjectOutputStream rw = new java.io.ObjectOutputStream(new java.io.BufferedOutputStream(" + NL + "                        new java.io.FileOutputStream(file)));" + NL + "                        " + NL + "            \t";
  protected final String TEXT_97 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_98 = " - Writing the data into: \"+file.getPath());" + NL + "\t\t\t\t";
  protected final String TEXT_99 = NL + "                " + NL + "                for (int i = 0; i < rowsInBuffer_2_";
  protected final String TEXT_100 = "; i++) {" + NL + "                    buffer_2_";
  protected final String TEXT_101 = "[i].writeData(rw);" + NL + "                }" + NL + "                " + NL + "                rw.close();" + NL + "                " + NL + "             \t";
  protected final String TEXT_102 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_103 = " - Wrote successfully.\");" + NL + "\t\t\t\t";
  protected final String TEXT_104 = NL + NL + "                files_2_";
  protected final String TEXT_105 = ".add(file);" + NL + "" + NL + "                rowsInBuffer_2_";
  protected final String TEXT_106 = " = 0;" + NL + "            }" + NL + "            buffer_2_";
  protected final String TEXT_107 = " = null;" + NL + "            java.util.List<FileRowIterator_";
  protected final String TEXT_108 = "> rowFileList_2_";
  protected final String TEXT_109 = " = new java.util.ArrayList<FileRowIterator_";
  protected final String TEXT_110 = ">();" + NL + "            java.util.List<rowStruct_";
  protected final String TEXT_111 = "> rowList_2_";
  protected final String TEXT_112 = " = new java.util.ArrayList<rowStruct_";
  protected final String TEXT_113 = ">();" + NL + "" + NL + "            for (java.io.File file : files_2_";
  protected final String TEXT_114 = ") {" + NL + "                FileRowIterator_";
  protected final String TEXT_115 = " fri = new FileRowIterator_";
  protected final String TEXT_116 = "(file, bufferSizePerFile_";
  protected final String TEXT_117 = ");" + NL + "                rowFileList_2_";
  protected final String TEXT_118 = ".add(fri);" + NL + "                rowList_2_";
  protected final String TEXT_119 = ".add(fri.next());" + NL + "            }" + NL + "" + NL + "            int nb_uniq_";
  protected final String TEXT_120 = " = 0;" + NL + "            while (rowList_2_";
  protected final String TEXT_121 = ".size() > 0) {" + NL + "                int minIndex_";
  protected final String TEXT_122 = " = 0;" + NL + "                if (rowList_2_";
  protected final String TEXT_123 = ".size() > 1) {" + NL + "                    for (int i = 1; i < rowList_2_";
  protected final String TEXT_124 = ".size(); i++) {" + NL + "                        if (comparator_2_";
  protected final String TEXT_125 = ".compare(rowList_2_";
  protected final String TEXT_126 = ".get(minIndex_";
  protected final String TEXT_127 = "), rowList_2_";
  protected final String TEXT_128 = ".get(i)) > 0) {" + NL + "                            minIndex_";
  protected final String TEXT_129 = " = i;" + NL + "                        }" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                // /////////////" + NL + "" + NL + "                rowStruct_";
  protected final String TEXT_130 = " current = rowList_2_";
  protected final String TEXT_131 = ".get(minIndex_";
  protected final String TEXT_132 = ");" + NL + "" + NL + "                // ////////////" + NL + "                FileRowIterator_";
  protected final String TEXT_133 = " fri = rowFileList_2_";
  protected final String TEXT_134 = ".get(minIndex_";
  protected final String TEXT_135 = ");" + NL + "                if (fri.hasNext()) {" + NL + "                    rowList_2_";
  protected final String TEXT_136 = ".set(minIndex_";
  protected final String TEXT_137 = ", fri.next());" + NL + "                } else {" + NL + "                    fri.close();" + NL + "                    rowFileList_2_";
  protected final String TEXT_138 = ".remove(minIndex_";
  protected final String TEXT_139 = ");" + NL + "                    rowList_2_";
  protected final String TEXT_140 = ".remove(minIndex_";
  protected final String TEXT_141 = ");" + NL + "                }" + NL + "\t";
  protected final String TEXT_142 = NL + "\t\tlog.info(\"";
  protected final String TEXT_143 = " - Writing the unique record \" + (nb_uniq_";
  protected final String TEXT_144 = "+1) + \" into ";
  protected final String TEXT_145 = ".\");" + NL + "\t";
  protected final String TEXT_146 = NL + "\t\t\t\t";
  protected final String TEXT_147 = ".";
  protected final String TEXT_148 = " = current.";
  protected final String TEXT_149 = ";" + NL + "    \t";
  protected final String TEXT_150 = NL + "                " + NL + "                nb_uniq_";
  protected final String TEXT_151 = "++;";
  protected final String TEXT_152 = NL + "            int bufferSizePerFile_";
  protected final String TEXT_153 = " = 10000;" + NL + "" + NL + "            java.util.List<FileRowIterator_";
  protected final String TEXT_154 = "> rowFileList_1_";
  protected final String TEXT_155 = " = new java.util.ArrayList<FileRowIterator_";
  protected final String TEXT_156 = ">();" + NL + "            java.util.List<rowStruct_";
  protected final String TEXT_157 = "> rowList_1_";
  protected final String TEXT_158 = " = new java.util.ArrayList<rowStruct_";
  protected final String TEXT_159 = ">();" + NL + "" + NL + "            for (java.io.File file : files_1_";
  protected final String TEXT_160 = ") {" + NL + "                FileRowIterator_";
  protected final String TEXT_161 = " fri = new FileRowIterator_";
  protected final String TEXT_162 = "(file," + NL + "                        bufferSizePerFile_";
  protected final String TEXT_163 = ");" + NL + "                rowFileList_1_";
  protected final String TEXT_164 = ".add(fri);" + NL + "                rowList_1_";
  protected final String TEXT_165 = ".add(fri.next());" + NL + "            }" + NL + "" + NL + "            // comparator for second sort" + NL + "            class Comparator_2_";
  protected final String TEXT_166 = " implements Comparator<rowStruct_";
  protected final String TEXT_167 = "> {" + NL + "" + NL + "                public int compare(rowStruct_";
  protected final String TEXT_168 = " arg0, rowStruct_";
  protected final String TEXT_169 = " arg1) {" + NL + "                    return arg0.id_";
  protected final String TEXT_170 = " - arg1.id_";
  protected final String TEXT_171 = ";" + NL + "                }" + NL + "" + NL + "            }" + NL + "" + NL + "            // For second sort init begin" + NL + "            int bufferSize_2_";
  protected final String TEXT_172 = " = bufferSize_";
  protected final String TEXT_173 = "/2;" + NL + "            rowStruct_";
  protected final String TEXT_174 = "[] buffer_2_";
  protected final String TEXT_175 = " = new rowStruct_";
  protected final String TEXT_176 = "[bufferSize_1_";
  protected final String TEXT_177 = "];" + NL + "            int rowsInBuffer_2_";
  protected final String TEXT_178 = " = 0;" + NL + "            Comparator<rowStruct_";
  protected final String TEXT_179 = "> comparator_2_";
  protected final String TEXT_180 = " = new Comparator_2_";
  protected final String TEXT_181 = "();" + NL + "" + NL + "            java.util.ArrayList<java.io.File> files_2_";
  protected final String TEXT_182 = " = new java.util.ArrayList<java.io.File>();" + NL + "            // For second sort init end" + NL + "" + NL + "            // For second sort duplicate init begin" + NL + "            int bufferSize_3_";
  protected final String TEXT_183 = " = bufferSize_";
  protected final String TEXT_184 = "/2;" + NL + "            rowStruct_";
  protected final String TEXT_185 = "[] buffer_3_";
  protected final String TEXT_186 = " = new rowStruct_";
  protected final String TEXT_187 = "[bufferSize_3_";
  protected final String TEXT_188 = "];" + NL + "            int rowsInBuffer_3_";
  protected final String TEXT_189 = " = 0;" + NL + "            Comparator<rowStruct_";
  protected final String TEXT_190 = "> comparator_3_";
  protected final String TEXT_191 = " = new Comparator_2_";
  protected final String TEXT_192 = "();" + NL + "" + NL + "            java.util.ArrayList<java.io.File> files_3_";
  protected final String TEXT_193 = " = new java.util.ArrayList<java.io.File>();" + NL + "            // For second sort duplicate init end" + NL + "" + NL + "            while (rowList_1_";
  protected final String TEXT_194 = ".size() > 0) {" + NL + "                int minIndex_";
  protected final String TEXT_195 = " = 0;" + NL + "                if (rowList_1_";
  protected final String TEXT_196 = ".size() > 1) {" + NL + "                    for (int i = 1; i < rowList_1_";
  protected final String TEXT_197 = ".size(); i++) {" + NL + "                        if (comparator_1_";
  protected final String TEXT_198 = ".compare(rowList_1_";
  protected final String TEXT_199 = ".get(minIndex_";
  protected final String TEXT_200 = ")," + NL + "                                rowList_1_";
  protected final String TEXT_201 = ".get(i)) > 0) {" + NL + "                            minIndex_";
  protected final String TEXT_202 = " = i;" + NL + "                        }" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                // /////////////" + NL + "                if (rowsInBuffer_2_";
  protected final String TEXT_203 = " >= bufferSize_2_";
  protected final String TEXT_204 = ") {" + NL + "" + NL + "                    java.util.Arrays.<rowStruct_";
  protected final String TEXT_205 = "> sort(buffer_2_";
  protected final String TEXT_206 = ", 0," + NL + "                            bufferSize_2_";
  protected final String TEXT_207 = ", comparator_2_";
  protected final String TEXT_208 = ");" + NL + "                    java.io.File file = new java.io.File(workDirectory_";
  protected final String TEXT_209 = " + \"/";
  protected final String TEXT_210 = "_TEMP_uniq_\"" + NL + "                            + files_2_";
  protected final String TEXT_211 = ".size());" + NL + "                   \t";
  protected final String TEXT_212 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_213 = " - Invoke request to delete file: \"+file.getPath()+\" When VM exit.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_214 = NL + "                    file.deleteOnExit();" + NL + "                    java.io.ObjectOutputStream rw = new java.io.ObjectOutputStream(new java.io.BufferedOutputStream(" + NL + "                            new java.io.FileOutputStream(file)));" + NL + "                \t";
  protected final String TEXT_215 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_216 = " - Writing the data into: \"+file.getPath());" + NL + "\t\t\t\t\t";
  protected final String TEXT_217 = NL + "                    for (int i = 0; i < bufferSize_2_";
  protected final String TEXT_218 = "; i++) {" + NL + "                        buffer_2_";
  protected final String TEXT_219 = "[i].writeData(rw);" + NL + "                    }" + NL + "                    rw.close();" + NL + "\t             \t";
  protected final String TEXT_220 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_221 = " - Wrote successfully.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_222 = NL + NL + "                    files_2_";
  protected final String TEXT_223 = ".add(file);" + NL + "" + NL + "                    rowsInBuffer_2_";
  protected final String TEXT_224 = " = 0;" + NL + "                }" + NL + "                rowStruct_";
  protected final String TEXT_225 = " minItem = rowList_1_";
  protected final String TEXT_226 = ".get(minIndex_";
  protected final String TEXT_227 = ");" + NL + "                buffer_2_";
  protected final String TEXT_228 = "[rowsInBuffer_2_";
  protected final String TEXT_229 = "++] = minItem;" + NL + "                FileRowIterator_";
  protected final String TEXT_230 = " fri = rowFileList_1_";
  protected final String TEXT_231 = ".get(minIndex_";
  protected final String TEXT_232 = ");" + NL + "                if (fri.hasNext()) {" + NL + "                    rowList_1_";
  protected final String TEXT_233 = ".set(minIndex_";
  protected final String TEXT_234 = ", fri.next());" + NL + "                } else {" + NL + "                    fri.close();" + NL + "                    rowFileList_1_";
  protected final String TEXT_235 = ".remove(minIndex_";
  protected final String TEXT_236 = ");" + NL + "                    rowList_1_";
  protected final String TEXT_237 = ".remove(minIndex_";
  protected final String TEXT_238 = ");" + NL + "                }" + NL + "" + NL + "                // get duplicates....begin" + NL + "                for (int i = 0; i < rowList_1_";
  protected final String TEXT_239 = ".size();) {" + NL + "                    rowStruct_";
  protected final String TEXT_240 = " current = rowList_1_";
  protected final String TEXT_241 = ".get(i);" + NL + "                    if (current.duplicateTo(minItem)) {" + NL + "                        // current is duplicate...." + NL + "                        if (rowsInBuffer_3_";
  protected final String TEXT_242 = " >= bufferSize_3_";
  protected final String TEXT_243 = ") {" + NL + "" + NL + "                            java.util.Arrays.<rowStruct_";
  protected final String TEXT_244 = "> sort(buffer_3_";
  protected final String TEXT_245 = ", 0," + NL + "                                    bufferSize_3_";
  protected final String TEXT_246 = ", comparator_3_";
  protected final String TEXT_247 = ");" + NL + "                            java.io.File file = new java.io.File(workDirectory_";
  protected final String TEXT_248 = " + \"/";
  protected final String TEXT_249 = "_TEMP_duplicate_\"" + NL + "                                    + files_3_";
  protected final String TEXT_250 = ".size());";
  protected final String TEXT_251 = NL + "\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_252 = " - Invoke request to delete file: \"+file.getPath()+\" When VM exit.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_253 = NL + "                            file.deleteOnExit();" + NL + "                            java.io.ObjectOutputStream rw = new java.io.ObjectOutputStream(new java.io.BufferedOutputStream(" + NL + "                                    new java.io.FileOutputStream(file)));" + NL + "                        \t";
  protected final String TEXT_254 = NL + "\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_255 = " - Writing the data into: \"+file.getPath());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_256 = NL + "                            for (int j = 0; j < bufferSize_3_";
  protected final String TEXT_257 = "; j++) {" + NL + "                                buffer_3_";
  protected final String TEXT_258 = "[j].writeData(rw);" + NL + "                            }" + NL + "                            rw.close();" + NL + "\t\t\t             \t";
  protected final String TEXT_259 = NL + "\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_260 = " - Wrote successfully.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_261 = NL + NL + "                            files_3_";
  protected final String TEXT_262 = ".add(file);" + NL + "" + NL + "                            rowsInBuffer_3_";
  protected final String TEXT_263 = " = 0;" + NL + "                        }" + NL + "" + NL + "                        buffer_3_";
  protected final String TEXT_264 = "[rowsInBuffer_3_";
  protected final String TEXT_265 = "++] = current;" + NL + "                        rowStruct_";
  protected final String TEXT_266 = " noDuplicateItem = null;" + NL + "                        FileRowIterator_";
  protected final String TEXT_267 = " fri2 = rowFileList_1_";
  protected final String TEXT_268 = ".get(i);" + NL + "                        while (fri2.hasNext()) {" + NL + "                            current = fri2.next();" + NL + "                            if (!minItem.duplicateTo(current)) {" + NL + "                                noDuplicateItem = current;" + NL + "                                break;" + NL + "                            } else {" + NL + "                                // current is duplicate...." + NL + "                                if (rowsInBuffer_3_";
  protected final String TEXT_269 = " >= bufferSize_3_";
  protected final String TEXT_270 = ") {" + NL + "" + NL + "                                    java.util.Arrays.<rowStruct_";
  protected final String TEXT_271 = "> sort(buffer_3_";
  protected final String TEXT_272 = ", 0," + NL + "                                            bufferSize_3_";
  protected final String TEXT_273 = ", comparator_3_";
  protected final String TEXT_274 = ");" + NL + "                                    java.io.File file = new java.io.File(workDirectory_";
  protected final String TEXT_275 = " + \"/";
  protected final String TEXT_276 = "_TEMP_duplicate_\"" + NL + "                                            + files_3_";
  protected final String TEXT_277 = ".size());";
  protected final String TEXT_278 = NL + "\t\t\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_279 = " - Invoke request to delete file: \"+file.getPath()+\" When VM exit.\");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_280 = NL + "                                    file.deleteOnExit();" + NL + "                                    java.io.ObjectOutputStream rw = new java.io.ObjectOutputStream(" + NL + "                                            new java.io.BufferedOutputStream(new java.io.FileOutputStream(file)));" + NL + "\t\t                        \t";
  protected final String TEXT_281 = NL + "\t\t\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_282 = " - Writing the data into: \"+file.getPath());" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_283 = NL + "                                    for (int j = 0; j < bufferSize_3_";
  protected final String TEXT_284 = "; j++) {" + NL + "                                        buffer_3_";
  protected final String TEXT_285 = "[j].writeData(rw);" + NL + "                                    }" + NL + "                                    rw.close();" + NL + "\t\t\t\t\t             \t";
  protected final String TEXT_286 = NL + "\t\t\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_287 = " - Wrote successfully.\");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_288 = NL + NL + "                                    files_3_";
  protected final String TEXT_289 = ".add(file);" + NL + "" + NL + "                                    rowsInBuffer_3_";
  protected final String TEXT_290 = " = 0;" + NL + "                                }" + NL + "" + NL + "                                buffer_3_";
  protected final String TEXT_291 = "[rowsInBuffer_3_";
  protected final String TEXT_292 = "++] = current;" + NL + "                            }" + NL + "                        }" + NL + "                        if (noDuplicateItem == null) {" + NL + "                            fri2.close();" + NL + "                            rowFileList_1_";
  protected final String TEXT_293 = ".remove(i);" + NL + "                            rowList_1_";
  protected final String TEXT_294 = ".remove(i);" + NL + "                        } else {" + NL + "                            rowList_1_";
  protected final String TEXT_295 = ".set(i, noDuplicateItem);" + NL + "                            i++;" + NL + "                        }" + NL + "                    } else {" + NL + "                        i++;" + NL + "                    }" + NL + "                }" + NL + "                // get duplicates...." + NL + "            }" + NL + "" + NL + "            if (rowsInBuffer_2_";
  protected final String TEXT_296 = " > 0) {" + NL + "" + NL + "                java.util.Arrays.<rowStruct_";
  protected final String TEXT_297 = "> sort(buffer_2_";
  protected final String TEXT_298 = ", 0," + NL + "                        rowsInBuffer_2_";
  protected final String TEXT_299 = ", comparator_2_";
  protected final String TEXT_300 = ");" + NL + "" + NL + "                java.io.File file = new java.io.File(workDirectory_";
  protected final String TEXT_301 = " + \"/";
  protected final String TEXT_302 = "_TEMP_uniq_\"" + NL + "                        + files_2_";
  protected final String TEXT_303 = ".size());" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_304 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_305 = " - Invoke request to delete file: \"+file.getPath()+\" When VM exit.\");" + NL + "\t\t\t\t";
  protected final String TEXT_306 = NL + "                file.deleteOnExit();" + NL + "" + NL + "                java.io.ObjectOutputStream rw = new java.io.ObjectOutputStream(new java.io.BufferedOutputStream(" + NL + "                        new java.io.FileOutputStream(file)));" + NL + "                        " + NL + "            \t";
  protected final String TEXT_307 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_308 = " - Writing the data into: \"+file.getPath());" + NL + "\t\t\t\t";
  protected final String TEXT_309 = NL + NL + "                for (int i = 0; i < rowsInBuffer_2_";
  protected final String TEXT_310 = "; i++) {" + NL + "                    buffer_2_";
  protected final String TEXT_311 = "[i].writeData(rw);" + NL + "                }" + NL + "" + NL + "                rw.close();" + NL + "\t\t\t\t";
  protected final String TEXT_312 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_313 = " - Wrote successfully.\");" + NL + "\t\t\t\t";
  protected final String TEXT_314 = NL + NL + "                files_2_";
  protected final String TEXT_315 = ".add(file);" + NL + "" + NL + "                rowsInBuffer_2_";
  protected final String TEXT_316 = " = 0;" + NL + "            }" + NL + "            buffer_2_";
  protected final String TEXT_317 = " = null;" + NL + "" + NL + "            // current is duplicate...." + NL + "            if (rowsInBuffer_3_";
  protected final String TEXT_318 = " > 0) {" + NL + "" + NL + "                java.util.Arrays.<rowStruct_";
  protected final String TEXT_319 = "> sort(buffer_3_";
  protected final String TEXT_320 = ", 0," + NL + "                        rowsInBuffer_3_";
  protected final String TEXT_321 = ", comparator_3_";
  protected final String TEXT_322 = ");" + NL + "                java.io.File file = new java.io.File(workDirectory_";
  protected final String TEXT_323 = " + \"/";
  protected final String TEXT_324 = "_TEMP_duplicate_\"" + NL + "                        + files_3_";
  protected final String TEXT_325 = ".size());";
  protected final String TEXT_326 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_327 = " - Invoke request to delete file: \"+file.getPath()+\" When VM exit.\");" + NL + "\t\t\t\t";
  protected final String TEXT_328 = NL + "                file.deleteOnExit();" + NL + "                java.io.ObjectOutputStream rw = new java.io.ObjectOutputStream(new java.io.BufferedOutputStream(" + NL + "                        new java.io.FileOutputStream(file)));" + NL + "            \t";
  protected final String TEXT_329 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_330 = " - Writing the data into: \"+file.getPath());" + NL + "\t\t\t\t";
  protected final String TEXT_331 = NL + "                for (int j = 0; j < rowsInBuffer_3_";
  protected final String TEXT_332 = "; j++) {" + NL + "                    buffer_3_";
  protected final String TEXT_333 = "[j].writeData(rw);" + NL + "                }" + NL + "                rw.close();" + NL + "\t\t\t\t";
  protected final String TEXT_334 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_335 = " - Wrote successfully.\");" + NL + "\t\t\t\t";
  protected final String TEXT_336 = NL + "                files_3_";
  protected final String TEXT_337 = ".add(file);" + NL + "" + NL + "                rowsInBuffer_3_";
  protected final String TEXT_338 = " = 0;" + NL + "            }" + NL + "            buffer_3_";
  protected final String TEXT_339 = " = null;" + NL + "" + NL + "            java.util.List<FileRowIterator_";
  protected final String TEXT_340 = "> rowFileList_2_";
  protected final String TEXT_341 = " = new java.util.ArrayList<FileRowIterator_";
  protected final String TEXT_342 = ">();" + NL + "            java.util.List<rowStruct_";
  protected final String TEXT_343 = "> rowList_2_";
  protected final String TEXT_344 = " = new java.util.ArrayList<rowStruct_";
  protected final String TEXT_345 = ">();" + NL + "" + NL + "            for (java.io.File file : files_2_";
  protected final String TEXT_346 = ") {" + NL + "                FileRowIterator_";
  protected final String TEXT_347 = " fri = new FileRowIterator_";
  protected final String TEXT_348 = "(file," + NL + "                        bufferSizePerFile_";
  protected final String TEXT_349 = ");" + NL + "                rowFileList_2_";
  protected final String TEXT_350 = ".add(fri);" + NL + "                rowList_2_";
  protected final String TEXT_351 = ".add(fri.next());" + NL + "            }" + NL + "" + NL + "            java.util.List<FileRowIterator_";
  protected final String TEXT_352 = "> rowFileList_3_";
  protected final String TEXT_353 = " = new java.util.ArrayList<FileRowIterator_";
  protected final String TEXT_354 = ">();" + NL + "            java.util.List<rowStruct_";
  protected final String TEXT_355 = "> rowList_3_";
  protected final String TEXT_356 = " = new java.util.ArrayList<rowStruct_";
  protected final String TEXT_357 = ">();" + NL + "" + NL + "            for (java.io.File file : files_3_";
  protected final String TEXT_358 = ") {" + NL + "                FileRowIterator_";
  protected final String TEXT_359 = " fri = new FileRowIterator_";
  protected final String TEXT_360 = "(file," + NL + "                        bufferSizePerFile_";
  protected final String TEXT_361 = ");" + NL + "                rowFileList_3_";
  protected final String TEXT_362 = ".add(fri);" + NL + "                rowList_3_";
  protected final String TEXT_363 = ".add(fri.next());" + NL + "            }" + NL + "" + NL + "            int nb_uniq_";
  protected final String TEXT_364 = " = 0;" + NL + "            int nb_duplicate_";
  protected final String TEXT_365 = " = 0;" + NL + "            rowStruct_";
  protected final String TEXT_366 = " uniq_";
  protected final String TEXT_367 = " = null;" + NL + "            rowStruct_";
  protected final String TEXT_368 = " duplicate_";
  protected final String TEXT_369 = " = null;" + NL + "            int minIndex_";
  protected final String TEXT_370 = " = 0;" + NL + "            /////////////////////" + NL + "            if(rowList_2_";
  protected final String TEXT_371 = ".size() > 0){" + NL + "                minIndex_";
  protected final String TEXT_372 = " = 0;" + NL + "                if (rowList_2_";
  protected final String TEXT_373 = ".size() > 1) {" + NL + "                    for (int i = 1; i < rowList_2_";
  protected final String TEXT_374 = ".size(); i++) {" + NL + "                        if (comparator_2_";
  protected final String TEXT_375 = ".compare(rowList_2_";
  protected final String TEXT_376 = ".get(minIndex_";
  protected final String TEXT_377 = ")," + NL + "                                rowList_2_";
  protected final String TEXT_378 = ".get(i)) > 0) {" + NL + "                            minIndex_";
  protected final String TEXT_379 = " = i;" + NL + "                        }" + NL + "                    }" + NL + "                }" + NL + "                uniq_";
  protected final String TEXT_380 = " = rowList_2_";
  protected final String TEXT_381 = ".get(minIndex_";
  protected final String TEXT_382 = ");" + NL + "                FileRowIterator_";
  protected final String TEXT_383 = " fri = rowFileList_2_";
  protected final String TEXT_384 = ".get(minIndex_";
  protected final String TEXT_385 = ");" + NL + "                if (fri.hasNext()) {" + NL + "                    rowList_2_";
  protected final String TEXT_386 = ".set(minIndex_";
  protected final String TEXT_387 = ", fri.next());" + NL + "                } else {" + NL + "                    fri.close();" + NL + "                    rowFileList_2_";
  protected final String TEXT_388 = ".remove(minIndex_";
  protected final String TEXT_389 = ");" + NL + "                    rowList_2_";
  protected final String TEXT_390 = ".remove(minIndex_";
  protected final String TEXT_391 = ");" + NL + "                }" + NL + "            }" + NL + "            if(rowList_3_";
  protected final String TEXT_392 = ".size() > 0){" + NL + "                minIndex_";
  protected final String TEXT_393 = " = 0;" + NL + "                if (rowList_3_";
  protected final String TEXT_394 = ".size() > 1) {" + NL + "                    for (int i = 1; i < rowList_3_";
  protected final String TEXT_395 = ".size(); i++) {" + NL + "                        if (comparator_3_";
  protected final String TEXT_396 = ".compare(rowList_3_";
  protected final String TEXT_397 = ".get(minIndex_";
  protected final String TEXT_398 = ")," + NL + "                                rowList_3_";
  protected final String TEXT_399 = ".get(i)) > 0) {" + NL + "                            minIndex_";
  protected final String TEXT_400 = " = i;" + NL + "                        }" + NL + "                    }" + NL + "                }" + NL + "                duplicate_";
  protected final String TEXT_401 = " = rowList_3_";
  protected final String TEXT_402 = ".get(minIndex_";
  protected final String TEXT_403 = ");" + NL + "                FileRowIterator_";
  protected final String TEXT_404 = " fri = rowFileList_3_";
  protected final String TEXT_405 = ".get(minIndex_";
  protected final String TEXT_406 = ");" + NL + "                if (fri.hasNext()) {" + NL + "                    rowList_3_";
  protected final String TEXT_407 = ".set(minIndex_";
  protected final String TEXT_408 = ", fri.next());" + NL + "                } else {" + NL + "                    fri.close();" + NL + "                    rowFileList_3_";
  protected final String TEXT_409 = ".remove(minIndex_";
  protected final String TEXT_410 = ");" + NL + "                    rowList_3_";
  protected final String TEXT_411 = ".remove(minIndex_";
  protected final String TEXT_412 = ");" + NL + "                }" + NL + "            }" + NL + "            while (true) {";
  protected final String TEXT_413 = NL + "                ";
  protected final String TEXT_414 = " = null;";
  protected final String TEXT_415 = NL + "                ";
  protected final String TEXT_416 = " = null;" + NL + "                " + NL + "                if(uniq_";
  protected final String TEXT_417 = " == null){" + NL + "                    if(duplicate_";
  protected final String TEXT_418 = " == null){" + NL + "                        break;" + NL + "                    }else{";
  protected final String TEXT_419 = NL + "                        ";
  protected final String TEXT_420 = " = new ";
  protected final String TEXT_421 = "Struct();" + NL + "\t";
  protected final String TEXT_422 = NL + "\t\tlog.info(\"";
  protected final String TEXT_423 = " - Writing the duplicate record \" + (nb_duplicate_";
  protected final String TEXT_424 = "+1) + \" into ";
  protected final String TEXT_425 = ".\");" + NL + "\t";
  protected final String TEXT_426 = NL + "\t\t\t\t";
  protected final String TEXT_427 = ".";
  protected final String TEXT_428 = " = duplicate_";
  protected final String TEXT_429 = ".";
  protected final String TEXT_430 = ";" + NL + "    \t";
  protected final String TEXT_431 = NL + "                    \tnb_duplicate_";
  protected final String TEXT_432 = "++;" + NL + "                        duplicate_";
  protected final String TEXT_433 = " = null;" + NL + "                        if(rowList_3_";
  protected final String TEXT_434 = ".size() > 0){" + NL + "                            minIndex_";
  protected final String TEXT_435 = " = 0;" + NL + "                            if (rowList_3_";
  protected final String TEXT_436 = ".size() > 1) {" + NL + "                                for (int i = 1; i < rowList_3_";
  protected final String TEXT_437 = ".size(); i++) {" + NL + "                                    if (comparator_3_";
  protected final String TEXT_438 = ".compare(rowList_3_";
  protected final String TEXT_439 = ".get(minIndex_";
  protected final String TEXT_440 = ")," + NL + "                                            rowList_3_";
  protected final String TEXT_441 = ".get(i)) > 0) {" + NL + "                                        minIndex_";
  protected final String TEXT_442 = " = i;" + NL + "                                    }" + NL + "                                }" + NL + "                            }" + NL + "                            duplicate_";
  protected final String TEXT_443 = " = rowList_3_";
  protected final String TEXT_444 = ".get(minIndex_";
  protected final String TEXT_445 = ");" + NL + "                            FileRowIterator_";
  protected final String TEXT_446 = " fri = rowFileList_3_";
  protected final String TEXT_447 = ".get(minIndex_";
  protected final String TEXT_448 = ");" + NL + "                            if (fri.hasNext()) {" + NL + "                                rowList_3_";
  protected final String TEXT_449 = ".set(minIndex_";
  protected final String TEXT_450 = ", fri.next());" + NL + "                            } else {" + NL + "                                fri.close();" + NL + "                                rowFileList_3_";
  protected final String TEXT_451 = ".remove(minIndex_";
  protected final String TEXT_452 = ");" + NL + "                                rowList_3_";
  protected final String TEXT_453 = ".remove(minIndex_";
  protected final String TEXT_454 = ");" + NL + "                            }" + NL + "                        }" + NL + "                    }" + NL + "                }else{" + NL + "                    if(duplicate_";
  protected final String TEXT_455 = " == null){";
  protected final String TEXT_456 = NL + "                        ";
  protected final String TEXT_457 = " = new ";
  protected final String TEXT_458 = "Struct();" + NL + "                        " + NL + "\t";
  protected final String TEXT_459 = NL + "\t\tlog.info(\"";
  protected final String TEXT_460 = " - Writing the unique record \" + (nb_uniq_";
  protected final String TEXT_461 = "+1) + \" into ";
  protected final String TEXT_462 = ".\");" + NL + "\t";
  protected final String TEXT_463 = NL + "\t\t\t\t";
  protected final String TEXT_464 = ".";
  protected final String TEXT_465 = " = uniq_";
  protected final String TEXT_466 = ".";
  protected final String TEXT_467 = ";" + NL + "    \t";
  protected final String TEXT_468 = NL + "                        nb_uniq_";
  protected final String TEXT_469 = "++;" + NL + "                        " + NL + "                        uniq_";
  protected final String TEXT_470 = " = null;" + NL + "                        " + NL + "                        if(rowList_2_";
  protected final String TEXT_471 = ".size() > 0){" + NL + "                            minIndex_";
  protected final String TEXT_472 = " = 0;" + NL + "                            if (rowList_2_";
  protected final String TEXT_473 = ".size() > 1) {" + NL + "                                for (int i = 1; i < rowList_2_";
  protected final String TEXT_474 = ".size(); i++) {" + NL + "                                    if (comparator_2_";
  protected final String TEXT_475 = ".compare(rowList_2_";
  protected final String TEXT_476 = ".get(minIndex_";
  protected final String TEXT_477 = ")," + NL + "                                            rowList_2_";
  protected final String TEXT_478 = ".get(i)) > 0) {" + NL + "                                        minIndex_";
  protected final String TEXT_479 = " = i;" + NL + "                                    }" + NL + "                                }" + NL + "                            }" + NL + "                            uniq_";
  protected final String TEXT_480 = " = rowList_2_";
  protected final String TEXT_481 = ".get(minIndex_";
  protected final String TEXT_482 = ");" + NL + "                            FileRowIterator_";
  protected final String TEXT_483 = " fri = rowFileList_2_";
  protected final String TEXT_484 = ".get(minIndex_";
  protected final String TEXT_485 = ");" + NL + "                            if (fri.hasNext()) {" + NL + "                                rowList_2_";
  protected final String TEXT_486 = ".set(minIndex_";
  protected final String TEXT_487 = ", fri.next());" + NL + "                            } else {" + NL + "                                fri.close();" + NL + "                                rowFileList_2_";
  protected final String TEXT_488 = ".remove(minIndex_";
  protected final String TEXT_489 = ");" + NL + "                                rowList_2_";
  protected final String TEXT_490 = ".remove(minIndex_";
  protected final String TEXT_491 = ");" + NL + "                            }" + NL + "                        }" + NL + "                        " + NL + "                    }else{" + NL + "                        if(uniq_";
  protected final String TEXT_492 = ".id_";
  protected final String TEXT_493 = " < duplicate_";
  protected final String TEXT_494 = ".id_";
  protected final String TEXT_495 = "){";
  protected final String TEXT_496 = NL + "                        ";
  protected final String TEXT_497 = " = new ";
  protected final String TEXT_498 = "Struct();" + NL + "                        " + NL + "\t";
  protected final String TEXT_499 = NL + "\t\tlog.info(\"";
  protected final String TEXT_500 = " - Writing the unique record \" + (nb_uniq_";
  protected final String TEXT_501 = "+1) + \" into ";
  protected final String TEXT_502 = ".\");" + NL + "\t";
  protected final String TEXT_503 = NL + "\t\t\t\t";
  protected final String TEXT_504 = ".";
  protected final String TEXT_505 = " = uniq_";
  protected final String TEXT_506 = ".";
  protected final String TEXT_507 = ";" + NL + "    \t";
  protected final String TEXT_508 = NL + "                            " + NL + "                            nb_uniq_";
  protected final String TEXT_509 = "++;" + NL + "                            " + NL + "                            uniq_";
  protected final String TEXT_510 = " = null;" + NL + "                            " + NL + "                            if(rowList_2_";
  protected final String TEXT_511 = ".size() > 0){" + NL + "                                minIndex_";
  protected final String TEXT_512 = " = 0;" + NL + "                                if (rowList_2_";
  protected final String TEXT_513 = ".size() > 1) {" + NL + "                                    for (int i = 1; i < rowList_2_";
  protected final String TEXT_514 = ".size(); i++) {" + NL + "                                        if (comparator_2_";
  protected final String TEXT_515 = ".compare(rowList_2_";
  protected final String TEXT_516 = ".get(minIndex_";
  protected final String TEXT_517 = ")," + NL + "                                                rowList_2_";
  protected final String TEXT_518 = ".get(i)) > 0) {" + NL + "                                            minIndex_";
  protected final String TEXT_519 = " = i;" + NL + "                                        }" + NL + "                                    }" + NL + "                                }" + NL + "                                uniq_";
  protected final String TEXT_520 = " = rowList_2_";
  protected final String TEXT_521 = ".get(minIndex_";
  protected final String TEXT_522 = ");" + NL + "                                FileRowIterator_";
  protected final String TEXT_523 = " fri = rowFileList_2_";
  protected final String TEXT_524 = ".get(minIndex_";
  protected final String TEXT_525 = ");" + NL + "                                if (fri.hasNext()) {" + NL + "                                    rowList_2_";
  protected final String TEXT_526 = ".set(minIndex_";
  protected final String TEXT_527 = ", fri.next());" + NL + "                                } else {" + NL + "                                    fri.close();" + NL + "                                    rowFileList_2_";
  protected final String TEXT_528 = ".remove(minIndex_";
  protected final String TEXT_529 = ");" + NL + "                                    rowList_2_";
  protected final String TEXT_530 = ".remove(minIndex_";
  protected final String TEXT_531 = ");" + NL + "                                }" + NL + "                            }" + NL + "                        }else{";
  protected final String TEXT_532 = NL + "                        ";
  protected final String TEXT_533 = " = new ";
  protected final String TEXT_534 = "Struct();" + NL + "\t";
  protected final String TEXT_535 = NL + "\t\tlog.info(\"";
  protected final String TEXT_536 = " - Writing the duplicate record \" + (nb_duplicate_";
  protected final String TEXT_537 = "+1) + \" into ";
  protected final String TEXT_538 = ".\");" + NL + "\t";
  protected final String TEXT_539 = NL + "\t\t\t\t";
  protected final String TEXT_540 = ".";
  protected final String TEXT_541 = " = duplicate_";
  protected final String TEXT_542 = ".";
  protected final String TEXT_543 = ";" + NL + "    \t";
  protected final String TEXT_544 = NL + "\t\t\t\t\t\t\tnb_duplicate_";
  protected final String TEXT_545 = "++;" + NL + "                            duplicate_";
  protected final String TEXT_546 = " = null;" + NL + "                            if(rowList_3_";
  protected final String TEXT_547 = ".size() > 0){" + NL + "                                minIndex_";
  protected final String TEXT_548 = " = 0;" + NL + "                                if (rowList_3_";
  protected final String TEXT_549 = ".size() > 1) {" + NL + "                                    for (int i = 1; i < rowList_3_";
  protected final String TEXT_550 = ".size(); i++) {" + NL + "                                        if (comparator_3_";
  protected final String TEXT_551 = ".compare(rowList_3_";
  protected final String TEXT_552 = ".get(minIndex_";
  protected final String TEXT_553 = ")," + NL + "                                                rowList_3_";
  protected final String TEXT_554 = ".get(i)) > 0) {" + NL + "                                            minIndex_";
  protected final String TEXT_555 = " = i;" + NL + "                                        }" + NL + "                                    }" + NL + "                                }" + NL + "                                duplicate_";
  protected final String TEXT_556 = " = rowList_3_";
  protected final String TEXT_557 = ".get(minIndex_";
  protected final String TEXT_558 = ");" + NL + "                                FileRowIterator_";
  protected final String TEXT_559 = " fri = rowFileList_3_";
  protected final String TEXT_560 = ".get(minIndex_";
  protected final String TEXT_561 = ");" + NL + "                                if (fri.hasNext()) {" + NL + "                                    rowList_3_";
  protected final String TEXT_562 = ".set(minIndex_";
  protected final String TEXT_563 = ", fri.next());" + NL + "                                } else {" + NL + "                                    fri.close();" + NL + "                                    rowFileList_3_";
  protected final String TEXT_564 = ".remove(minIndex_";
  protected final String TEXT_565 = ");" + NL + "                                    rowList_3_";
  protected final String TEXT_566 = ".remove(minIndex_";
  protected final String TEXT_567 = ");" + NL + "                                }" + NL + "                            }" + NL + "                        }" + NL + "                        " + NL + "                    }" + NL + "                }" + NL;
  protected final String TEXT_568 = NL + "            int bufferSizePerFile_";
  protected final String TEXT_569 = " = 10000;" + NL + "" + NL + "            java.util.List<FileRowIterator_";
  protected final String TEXT_570 = "> rowFileList_1_";
  protected final String TEXT_571 = " = new java.util.ArrayList<FileRowIterator_";
  protected final String TEXT_572 = ">();" + NL + "            java.util.List<rowStruct_";
  protected final String TEXT_573 = "> rowList_1_";
  protected final String TEXT_574 = " = new java.util.ArrayList<rowStruct_";
  protected final String TEXT_575 = ">();" + NL + "" + NL + "            for (java.io.File file : files_1_";
  protected final String TEXT_576 = ") {" + NL + "                FileRowIterator_";
  protected final String TEXT_577 = " fri = new FileRowIterator_";
  protected final String TEXT_578 = "(file," + NL + "                        bufferSizePerFile_";
  protected final String TEXT_579 = ");" + NL + "                rowFileList_1_";
  protected final String TEXT_580 = ".add(fri);" + NL + "                rowList_1_";
  protected final String TEXT_581 = ".add(fri.next());" + NL + "            }" + NL + "" + NL + "            // comparator for second sort" + NL + "            class Comparator_2_";
  protected final String TEXT_582 = " implements Comparator<rowStruct_";
  protected final String TEXT_583 = "> {" + NL + "" + NL + "                public int compare(rowStruct_";
  protected final String TEXT_584 = " arg0, rowStruct_";
  protected final String TEXT_585 = " arg1) {" + NL + "                    return arg0.id_";
  protected final String TEXT_586 = " - arg1.id_";
  protected final String TEXT_587 = ";" + NL + "                }" + NL + "" + NL + "            }" + NL + "" + NL + "            // For second sort init begin" + NL + "            int bufferSize_2_";
  protected final String TEXT_588 = " = bufferSize_";
  protected final String TEXT_589 = "/2;" + NL + "            rowStruct_";
  protected final String TEXT_590 = "[] buffer_2_";
  protected final String TEXT_591 = " = new rowStruct_";
  protected final String TEXT_592 = "[bufferSize_1_";
  protected final String TEXT_593 = "];" + NL + "            int rowsInBuffer_2_";
  protected final String TEXT_594 = " = 0;" + NL + "            Comparator<rowStruct_";
  protected final String TEXT_595 = "> comparator_2_";
  protected final String TEXT_596 = " = new Comparator_2_";
  protected final String TEXT_597 = "();" + NL + "" + NL + "            java.util.ArrayList<java.io.File> files_2_";
  protected final String TEXT_598 = " = new java.util.ArrayList<java.io.File>();" + NL + "            // For second sort init end" + NL + "" + NL + "            // For second sort duplicate init begin" + NL + "            int bufferSize_3_";
  protected final String TEXT_599 = " = bufferSize_";
  protected final String TEXT_600 = "/2;" + NL + "            rowStruct_";
  protected final String TEXT_601 = "[] buffer_3_";
  protected final String TEXT_602 = " = new rowStruct_";
  protected final String TEXT_603 = "[bufferSize_3_";
  protected final String TEXT_604 = "];" + NL + "            int rowsInBuffer_3_";
  protected final String TEXT_605 = " = 0;" + NL + "            Comparator<rowStruct_";
  protected final String TEXT_606 = "> comparator_3_";
  protected final String TEXT_607 = " = new Comparator_2_";
  protected final String TEXT_608 = "();" + NL + "" + NL + "            java.util.ArrayList<java.io.File> files_3_";
  protected final String TEXT_609 = " = new java.util.ArrayList<java.io.File>();" + NL + "            // For second sort duplicate init end" + NL + "            boolean forDuplicateFlag_";
  protected final String TEXT_610 = " = false;" + NL + "            rowStruct_";
  protected final String TEXT_611 = " minItem = null;" + NL + "            while (rowList_1_";
  protected final String TEXT_612 = ".size() > 0) {" + NL + "                int minIndex_";
  protected final String TEXT_613 = " = 0;" + NL + "                if (rowList_1_";
  protected final String TEXT_614 = ".size() > 1) {" + NL + "                    for (int i = 1; i < rowList_1_";
  protected final String TEXT_615 = ".size(); i++) {" + NL + "                        if (comparator_1_";
  protected final String TEXT_616 = ".compare(rowList_1_";
  protected final String TEXT_617 = ".get(minIndex_";
  protected final String TEXT_618 = ")," + NL + "                                rowList_1_";
  protected final String TEXT_619 = ".get(i)) > 0) {" + NL + "                            minIndex_";
  protected final String TEXT_620 = " = i;" + NL + "                        }" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                // /////////////" + NL + "                if(forDuplicateFlag_";
  protected final String TEXT_621 = "){" + NL + "                \tif(!rowList_1_";
  protected final String TEXT_622 = ".get(minIndex_";
  protected final String TEXT_623 = ").duplicateTo(minItem)){" + NL + "                \t\tif (rowsInBuffer_2_";
  protected final String TEXT_624 = " >= bufferSize_2_";
  protected final String TEXT_625 = ") {" + NL + "" + NL + "\t                        java.util.Arrays.<rowStruct_";
  protected final String TEXT_626 = "> sort(buffer_2_";
  protected final String TEXT_627 = ", 0," + NL + "\t                                bufferSize_2_";
  protected final String TEXT_628 = ", comparator_2_";
  protected final String TEXT_629 = ");" + NL + "\t                        java.io.File file = new java.io.File(workDirectory_";
  protected final String TEXT_630 = " + \"/";
  protected final String TEXT_631 = "_TEMP_unique_\"" + NL + "\t                                + files_2_";
  protected final String TEXT_632 = ".size());" + NL + "\t                        ";
  protected final String TEXT_633 = NL + "\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_634 = " - Invoke request to delete file: \"+file.getPath()+\" When VM exit.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_635 = NL + "\t                        file.deleteOnExit();" + NL + "\t                        java.io.ObjectOutputStream rw = new java.io.ObjectOutputStream(new java.io.BufferedOutputStream(" + NL + "\t                                new java.io.FileOutputStream(file)));" + NL + "                        \t";
  protected final String TEXT_636 = NL + "\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_637 = " - Writing the data into: \"+file.getPath());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_638 = NL + "\t                        for (int i = 0; i < bufferSize_2_";
  protected final String TEXT_639 = "; i++) {" + NL + "\t                            buffer_2_";
  protected final String TEXT_640 = "[i].writeData(rw);" + NL + "\t                        }" + NL + "\t                        rw.close();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_641 = NL + "\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_642 = " - Wrote successfully.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_643 = NL + "\t" + NL + "\t                        files_2_";
  protected final String TEXT_644 = ".add(file);" + NL + "\t" + NL + "\t                        rowsInBuffer_2_";
  protected final String TEXT_645 = " = 0;" + NL + "\t                    }" + NL + "\t                    minItem = rowList_1_";
  protected final String TEXT_646 = ".get(minIndex_";
  protected final String TEXT_647 = ");" + NL + "\t                    buffer_2_";
  protected final String TEXT_648 = "[rowsInBuffer_2_";
  protected final String TEXT_649 = "++] = minItem;" + NL + "\t                    FileRowIterator_";
  protected final String TEXT_650 = " fri = rowFileList_1_";
  protected final String TEXT_651 = ".get(minIndex_";
  protected final String TEXT_652 = ");" + NL + "\t                    if (fri.hasNext()) {" + NL + "\t                        rowList_1_";
  protected final String TEXT_653 = ".set(minIndex_";
  protected final String TEXT_654 = ", fri.next());" + NL + "\t                    } else {" + NL + "\t                        fri.close();" + NL + "\t                        rowFileList_1_";
  protected final String TEXT_655 = ".remove(minIndex_";
  protected final String TEXT_656 = ");" + NL + "\t                        rowList_1_";
  protected final String TEXT_657 = ".remove(minIndex_";
  protected final String TEXT_658 = ");" + NL + "\t                    }\t" + NL + "                \t}else{" + NL + "\t                    if (rowsInBuffer_3_";
  protected final String TEXT_659 = " >= bufferSize_3_";
  protected final String TEXT_660 = ") {" + NL + "\t" + NL + "\t                        java.util.Arrays.<rowStruct_";
  protected final String TEXT_661 = "> sort(buffer_3_";
  protected final String TEXT_662 = ", 0," + NL + "\t                                bufferSize_3_";
  protected final String TEXT_663 = ", comparator_3_";
  protected final String TEXT_664 = ");" + NL + "\t                        java.io.File file = new java.io.File(workDirectory_";
  protected final String TEXT_665 = " + \"/";
  protected final String TEXT_666 = "_TEMP_duplicate_\"" + NL + "\t                                + files_3_";
  protected final String TEXT_667 = ".size());" + NL + "\t                        ";
  protected final String TEXT_668 = NL + "\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_669 = " - Invoke request to delete file: \"+file.getPath()+\" When VM exit.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_670 = NL + "\t                        file.deleteOnExit();" + NL + "\t                        " + NL + "\t                        java.io.ObjectOutputStream rw = new java.io.ObjectOutputStream(new java.io.BufferedOutputStream(" + NL + "\t                                new java.io.FileOutputStream(file)));" + NL + "                        \t";
  protected final String TEXT_671 = NL + "\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_672 = " - Writing the data into: \"+file.getPath());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_673 = NL + "\t                        for (int i = 0; i < bufferSize_3_";
  protected final String TEXT_674 = "; i++) {" + NL + "\t                            buffer_3_";
  protected final String TEXT_675 = "[i].writeData(rw);" + NL + "\t                        }" + NL + "\t                        rw.close();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_676 = NL + "\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_677 = " - Wrote successfully.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_678 = NL + "\t" + NL + "\t                        files_3_";
  protected final String TEXT_679 = ".add(file);" + NL + "\t" + NL + "\t                        rowsInBuffer_3_";
  protected final String TEXT_680 = " = 0;" + NL + "\t                    }" + NL + "\t                    minItem = rowList_1_";
  protected final String TEXT_681 = ".get(minIndex_";
  protected final String TEXT_682 = ");" + NL + "\t                    buffer_3_";
  protected final String TEXT_683 = "[rowsInBuffer_3_";
  protected final String TEXT_684 = "++] = minItem;" + NL + "\t                    FileRowIterator_";
  protected final String TEXT_685 = " fri = rowFileList_1_";
  protected final String TEXT_686 = ".get(minIndex_";
  protected final String TEXT_687 = ");" + NL + "\t                    if (fri.hasNext()) {" + NL + "\t                        rowList_1_";
  protected final String TEXT_688 = ".set(minIndex_";
  protected final String TEXT_689 = ", fri.next());" + NL + "\t                    } else {" + NL + "\t                        fri.close();" + NL + "\t                        rowFileList_1_";
  protected final String TEXT_690 = ".remove(minIndex_";
  protected final String TEXT_691 = ");" + NL + "\t                        rowList_1_";
  protected final String TEXT_692 = ".remove(minIndex_";
  protected final String TEXT_693 = ");" + NL + "\t                    }" + NL + "\t                    " + NL + "\t                    forDuplicateFlag_";
  protected final String TEXT_694 = " = false;" + NL + "\t                    " + NL + "\t                    // skip other duplicates....begin" + NL + "\t                    for (int i = 0; i < rowList_1_";
  protected final String TEXT_695 = ".size();) {" + NL + "\t                        if (rowList_1_";
  protected final String TEXT_696 = ".get(i).duplicateTo(minItem)) {" + NL + "\t                            rowStruct_";
  protected final String TEXT_697 = " noDuplicateItem = null;" + NL + "\t                            FileRowIterator_";
  protected final String TEXT_698 = " fri2 = rowFileList_1_";
  protected final String TEXT_699 = ".get(i);" + NL + "\t                            while (fri2.hasNext()) {" + NL + "\t                                rowStruct_";
  protected final String TEXT_700 = " current = fri2.next();" + NL + "\t                                if (!minItem.duplicateTo(current)) {" + NL + "\t                                    noDuplicateItem = current;" + NL + "\t                                    break;" + NL + "\t                                }" + NL + "\t                            }" + NL + "\t                            if (noDuplicateItem == null) {" + NL + "\t                                fri2.close();" + NL + "\t                                rowFileList_1_";
  protected final String TEXT_701 = ".remove(i);" + NL + "\t                                rowList_1_";
  protected final String TEXT_702 = ".remove(i);" + NL + "\t                            } else {" + NL + "\t                                rowList_1_";
  protected final String TEXT_703 = ".set(i, noDuplicateItem);" + NL + "\t                                i++;" + NL + "\t                            }" + NL + "\t                        } else {" + NL + "\t                            i++;" + NL + "\t                        }" + NL + "\t                    }" + NL + "\t                    // skip duplicates....end" + NL + "                    }" + NL + "                }else{" + NL + "                    if (rowsInBuffer_2_";
  protected final String TEXT_704 = " >= bufferSize_2_";
  protected final String TEXT_705 = ") {" + NL + "" + NL + "                        java.util.Arrays.<rowStruct_";
  protected final String TEXT_706 = "> sort(buffer_2_";
  protected final String TEXT_707 = ", 0," + NL + "                                bufferSize_2_";
  protected final String TEXT_708 = ", comparator_2_";
  protected final String TEXT_709 = ");" + NL + "                        java.io.File file = new java.io.File(workDirectory_";
  protected final String TEXT_710 = " + \"/";
  protected final String TEXT_711 = "_TEMP_unique_\"" + NL + "                                + files_2_";
  protected final String TEXT_712 = ".size());";
  protected final String TEXT_713 = NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_714 = " - Invoke request to delete file: \"+file.getPath()+\" When VM exit.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_715 = NL + "                        file.deleteOnExit();" + NL + "                        java.io.ObjectOutputStream rw = new java.io.ObjectOutputStream(new java.io.BufferedOutputStream(" + NL + "                                new java.io.FileOutputStream(file)));" + NL + "                    \t";
  protected final String TEXT_716 = NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_717 = " - Writing the data into: \"+file.getPath());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_718 = NL + "                        for (int i = 0; i < bufferSize_2_";
  protected final String TEXT_719 = "; i++) {" + NL + "                            buffer_2_";
  protected final String TEXT_720 = "[i].writeData(rw);" + NL + "                        }" + NL + "                        rw.close();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_721 = NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_722 = " - Wrote successfully.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_723 = NL + NL + "                        files_2_";
  protected final String TEXT_724 = ".add(file);" + NL + "" + NL + "                        rowsInBuffer_2_";
  protected final String TEXT_725 = " = 0;" + NL + "                    }" + NL + "                    minItem = rowList_1_";
  protected final String TEXT_726 = ".get(minIndex_";
  protected final String TEXT_727 = ");" + NL + "                    buffer_2_";
  protected final String TEXT_728 = "[rowsInBuffer_2_";
  protected final String TEXT_729 = "++] = minItem;" + NL + "                    FileRowIterator_";
  protected final String TEXT_730 = " fri = rowFileList_1_";
  protected final String TEXT_731 = ".get(minIndex_";
  protected final String TEXT_732 = ");" + NL + "                    if (fri.hasNext()) {" + NL + "                        rowList_1_";
  protected final String TEXT_733 = ".set(minIndex_";
  protected final String TEXT_734 = ", fri.next());" + NL + "                    } else {" + NL + "                        fri.close();" + NL + "                        rowFileList_1_";
  protected final String TEXT_735 = ".remove(minIndex_";
  protected final String TEXT_736 = ");" + NL + "                        rowList_1_";
  protected final String TEXT_737 = ".remove(minIndex_";
  protected final String TEXT_738 = ");" + NL + "                    }" + NL + "                    " + NL + "                    forDuplicateFlag_";
  protected final String TEXT_739 = " = true;" + NL + "                }" + NL + "            }" + NL + "" + NL + "            if (rowsInBuffer_2_";
  protected final String TEXT_740 = " > 0) {" + NL + "" + NL + "                java.util.Arrays.<rowStruct_";
  protected final String TEXT_741 = "> sort(buffer_2_";
  protected final String TEXT_742 = ", 0," + NL + "                        rowsInBuffer_2_";
  protected final String TEXT_743 = ", comparator_2_";
  protected final String TEXT_744 = ");" + NL + "" + NL + "                java.io.File file = new java.io.File(workDirectory_";
  protected final String TEXT_745 = " + \"/";
  protected final String TEXT_746 = "_TEMP_uniq_\"" + NL + "                        + files_2_";
  protected final String TEXT_747 = ".size());" + NL + "                        ";
  protected final String TEXT_748 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_749 = " - Invoke request to delete file: \"+file.getPath()+\" When VM exit.\");" + NL + "\t\t\t\t";
  protected final String TEXT_750 = NL + NL + "                file.deleteOnExit();" + NL + "" + NL + "                java.io.ObjectOutputStream rw = new java.io.ObjectOutputStream(new java.io.BufferedOutputStream(" + NL + "                        new java.io.FileOutputStream(file)));" + NL + "                        " + NL + "            \t";
  protected final String TEXT_751 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_752 = " - Writing the data into: \"+file.getPath());" + NL + "\t\t\t\t";
  protected final String TEXT_753 = NL + NL + "                for (int i = 0; i < rowsInBuffer_2_";
  protected final String TEXT_754 = "; i++) {" + NL + "                    buffer_2_";
  protected final String TEXT_755 = "[i].writeData(rw);" + NL + "                }" + NL + "" + NL + "                rw.close();" + NL + "\t\t\t\t";
  protected final String TEXT_756 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_757 = " - Wrote successfully.\");" + NL + "\t\t\t\t";
  protected final String TEXT_758 = NL + NL + "                files_2_";
  protected final String TEXT_759 = ".add(file);" + NL + "" + NL + "                rowsInBuffer_2_";
  protected final String TEXT_760 = " = 0;" + NL + "            }" + NL + "            buffer_2_";
  protected final String TEXT_761 = " = null;" + NL + "" + NL + "            // current is duplicate...." + NL + "            if (rowsInBuffer_3_";
  protected final String TEXT_762 = " > 0) {" + NL + "" + NL + "                java.util.Arrays.<rowStruct_";
  protected final String TEXT_763 = "> sort(buffer_3_";
  protected final String TEXT_764 = ", 0," + NL + "                        rowsInBuffer_3_";
  protected final String TEXT_765 = ", comparator_3_";
  protected final String TEXT_766 = ");" + NL + "                java.io.File file = new java.io.File(workDirectory_";
  protected final String TEXT_767 = " + \"/";
  protected final String TEXT_768 = "_TEMP_duplicate_\"" + NL + "                        + files_3_";
  protected final String TEXT_769 = ".size());";
  protected final String TEXT_770 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_771 = " - Invoke request to delete file: \"+file.getPath()+\" When VM exit.\");" + NL + "\t\t\t\t";
  protected final String TEXT_772 = NL + "                file.deleteOnExit();" + NL + "                java.io.ObjectOutputStream rw = new java.io.ObjectOutputStream(new java.io.BufferedOutputStream(" + NL + "                        new java.io.FileOutputStream(file)));" + NL + "            \t";
  protected final String TEXT_773 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_774 = " - Writing the data into: \"+file.getPath());" + NL + "\t\t\t\t";
  protected final String TEXT_775 = NL + "                for (int j = 0; j < rowsInBuffer_3_";
  protected final String TEXT_776 = "; j++) {" + NL + "                    buffer_3_";
  protected final String TEXT_777 = "[j].writeData(rw);" + NL + "                }" + NL + "                rw.close();" + NL + "\t\t\t\t";
  protected final String TEXT_778 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_779 = " - Wrote successfully.\");" + NL + "\t\t\t\t";
  protected final String TEXT_780 = NL + NL + "                files_3_";
  protected final String TEXT_781 = ".add(file);" + NL + "" + NL + "                rowsInBuffer_3_";
  protected final String TEXT_782 = " = 0;" + NL + "            }" + NL + "            buffer_3_";
  protected final String TEXT_783 = " = null;" + NL + "" + NL + "            java.util.List<FileRowIterator_";
  protected final String TEXT_784 = "> rowFileList_2_";
  protected final String TEXT_785 = " = new java.util.ArrayList<FileRowIterator_";
  protected final String TEXT_786 = ">();" + NL + "            java.util.List<rowStruct_";
  protected final String TEXT_787 = "> rowList_2_";
  protected final String TEXT_788 = " = new java.util.ArrayList<rowStruct_";
  protected final String TEXT_789 = ">();" + NL + "" + NL + "            for (java.io.File file : files_2_";
  protected final String TEXT_790 = ") {" + NL + "                FileRowIterator_";
  protected final String TEXT_791 = " fri = new FileRowIterator_";
  protected final String TEXT_792 = "(file," + NL + "                        bufferSizePerFile_";
  protected final String TEXT_793 = ");" + NL + "                rowFileList_2_";
  protected final String TEXT_794 = ".add(fri);" + NL + "                rowList_2_";
  protected final String TEXT_795 = ".add(fri.next());" + NL + "            }" + NL + "" + NL + "            java.util.List<FileRowIterator_";
  protected final String TEXT_796 = "> rowFileList_3_";
  protected final String TEXT_797 = " = new java.util.ArrayList<FileRowIterator_";
  protected final String TEXT_798 = ">();" + NL + "            java.util.List<rowStruct_";
  protected final String TEXT_799 = "> rowList_3_";
  protected final String TEXT_800 = " = new java.util.ArrayList<rowStruct_";
  protected final String TEXT_801 = ">();" + NL + "" + NL + "            for (java.io.File file : files_3_";
  protected final String TEXT_802 = ") {" + NL + "                FileRowIterator_";
  protected final String TEXT_803 = " fri = new FileRowIterator_";
  protected final String TEXT_804 = "(file," + NL + "                        bufferSizePerFile_";
  protected final String TEXT_805 = ");" + NL + "                rowFileList_3_";
  protected final String TEXT_806 = ".add(fri);" + NL + "                rowList_3_";
  protected final String TEXT_807 = ".add(fri.next());" + NL + "            }" + NL + "" + NL + "            int nb_uniq_";
  protected final String TEXT_808 = " = 0;" + NL + "            int nb_duplicate_";
  protected final String TEXT_809 = " = 0;" + NL + "            rowStruct_";
  protected final String TEXT_810 = " uniq_";
  protected final String TEXT_811 = " = null;" + NL + "            rowStruct_";
  protected final String TEXT_812 = " duplicate_";
  protected final String TEXT_813 = " = null;" + NL + "            int minIndex_";
  protected final String TEXT_814 = " = 0;" + NL + "            /////////////////////" + NL + "            if(rowList_2_";
  protected final String TEXT_815 = ".size() > 0){" + NL + "                minIndex_";
  protected final String TEXT_816 = " = 0;" + NL + "                if (rowList_2_";
  protected final String TEXT_817 = ".size() > 1) {" + NL + "                    for (int i = 1; i < rowList_2_";
  protected final String TEXT_818 = ".size(); i++) {" + NL + "                        if (comparator_2_";
  protected final String TEXT_819 = ".compare(rowList_2_";
  protected final String TEXT_820 = ".get(minIndex_";
  protected final String TEXT_821 = ")," + NL + "                                rowList_2_";
  protected final String TEXT_822 = ".get(i)) > 0) {" + NL + "                            minIndex_";
  protected final String TEXT_823 = " = i;" + NL + "                        }" + NL + "                    }" + NL + "                }" + NL + "                uniq_";
  protected final String TEXT_824 = " = rowList_2_";
  protected final String TEXT_825 = ".get(minIndex_";
  protected final String TEXT_826 = ");" + NL + "                FileRowIterator_";
  protected final String TEXT_827 = " fri = rowFileList_2_";
  protected final String TEXT_828 = ".get(minIndex_";
  protected final String TEXT_829 = ");" + NL + "                if (fri.hasNext()) {" + NL + "                    rowList_2_";
  protected final String TEXT_830 = ".set(minIndex_";
  protected final String TEXT_831 = ", fri.next());" + NL + "                } else {" + NL + "                    fri.close();" + NL + "                    rowFileList_2_";
  protected final String TEXT_832 = ".remove(minIndex_";
  protected final String TEXT_833 = ");" + NL + "                    rowList_2_";
  protected final String TEXT_834 = ".remove(minIndex_";
  protected final String TEXT_835 = ");" + NL + "                }" + NL + "            }" + NL + "            if(rowList_3_";
  protected final String TEXT_836 = ".size() > 0){" + NL + "                minIndex_";
  protected final String TEXT_837 = " = 0;" + NL + "                if (rowList_3_";
  protected final String TEXT_838 = ".size() > 1) {" + NL + "                    for (int i = 1; i < rowList_3_";
  protected final String TEXT_839 = ".size(); i++) {" + NL + "                        if (comparator_3_";
  protected final String TEXT_840 = ".compare(rowList_3_";
  protected final String TEXT_841 = ".get(minIndex_";
  protected final String TEXT_842 = ")," + NL + "                                rowList_3_";
  protected final String TEXT_843 = ".get(i)) > 0) {" + NL + "                            minIndex_";
  protected final String TEXT_844 = " = i;" + NL + "                        }" + NL + "                    }" + NL + "                }" + NL + "                duplicate_";
  protected final String TEXT_845 = " = rowList_3_";
  protected final String TEXT_846 = ".get(minIndex_";
  protected final String TEXT_847 = ");" + NL + "                FileRowIterator_";
  protected final String TEXT_848 = " fri = rowFileList_3_";
  protected final String TEXT_849 = ".get(minIndex_";
  protected final String TEXT_850 = ");" + NL + "                if (fri.hasNext()) {" + NL + "                    rowList_3_";
  protected final String TEXT_851 = ".set(minIndex_";
  protected final String TEXT_852 = ", fri.next());" + NL + "                } else {" + NL + "                    fri.close();" + NL + "                    rowFileList_3_";
  protected final String TEXT_853 = ".remove(minIndex_";
  protected final String TEXT_854 = ");" + NL + "                    rowList_3_";
  protected final String TEXT_855 = ".remove(minIndex_";
  protected final String TEXT_856 = ");" + NL + "                }" + NL + "            }" + NL + "            while (true) {";
  protected final String TEXT_857 = NL + "                ";
  protected final String TEXT_858 = " = null;";
  protected final String TEXT_859 = NL + "                ";
  protected final String TEXT_860 = " = null;" + NL + "                " + NL + "                if(uniq_";
  protected final String TEXT_861 = " == null){" + NL + "                    if(duplicate_";
  protected final String TEXT_862 = " == null){" + NL + "                        break;" + NL + "                    }else{";
  protected final String TEXT_863 = NL + "                        ";
  protected final String TEXT_864 = " = new ";
  protected final String TEXT_865 = "Struct();" + NL + "\t";
  protected final String TEXT_866 = NL + "\t\tlog.info(\"";
  protected final String TEXT_867 = " - Writing the duplicate record \" + (nb_duplicate_";
  protected final String TEXT_868 = "+1) + \" into ";
  protected final String TEXT_869 = ".\");" + NL + "\t";
  protected final String TEXT_870 = NL + "\t\t\t\t";
  protected final String TEXT_871 = ".";
  protected final String TEXT_872 = " = duplicate_";
  protected final String TEXT_873 = ".";
  protected final String TEXT_874 = ";" + NL + "    \t";
  protected final String TEXT_875 = NL + "                    \tnb_duplicate_";
  protected final String TEXT_876 = "++;" + NL + "                        duplicate_";
  protected final String TEXT_877 = " = null;" + NL + "                        if(rowList_3_";
  protected final String TEXT_878 = ".size() > 0){" + NL + "                            minIndex_";
  protected final String TEXT_879 = " = 0;" + NL + "                            if (rowList_3_";
  protected final String TEXT_880 = ".size() > 1) {" + NL + "                                for (int i = 1; i < rowList_3_";
  protected final String TEXT_881 = ".size(); i++) {" + NL + "                                    if (comparator_3_";
  protected final String TEXT_882 = ".compare(rowList_3_";
  protected final String TEXT_883 = ".get(minIndex_";
  protected final String TEXT_884 = ")," + NL + "                                            rowList_3_";
  protected final String TEXT_885 = ".get(i)) > 0) {" + NL + "                                        minIndex_";
  protected final String TEXT_886 = " = i;" + NL + "                                    }" + NL + "                                }" + NL + "                            }" + NL + "                            duplicate_";
  protected final String TEXT_887 = " = rowList_3_";
  protected final String TEXT_888 = ".get(minIndex_";
  protected final String TEXT_889 = ");" + NL + "                            FileRowIterator_";
  protected final String TEXT_890 = " fri = rowFileList_3_";
  protected final String TEXT_891 = ".get(minIndex_";
  protected final String TEXT_892 = ");" + NL + "                            if (fri.hasNext()) {" + NL + "                                rowList_3_";
  protected final String TEXT_893 = ".set(minIndex_";
  protected final String TEXT_894 = ", fri.next());" + NL + "                            } else {" + NL + "                                fri.close();" + NL + "                                rowFileList_3_";
  protected final String TEXT_895 = ".remove(minIndex_";
  protected final String TEXT_896 = ");" + NL + "                                rowList_3_";
  protected final String TEXT_897 = ".remove(minIndex_";
  protected final String TEXT_898 = ");" + NL + "                            }" + NL + "                        }" + NL + "                    }" + NL + "                }else{" + NL + "                    if(duplicate_";
  protected final String TEXT_899 = " == null){";
  protected final String TEXT_900 = NL + "                        ";
  protected final String TEXT_901 = " = new ";
  protected final String TEXT_902 = "Struct();" + NL + "                        " + NL + "\t";
  protected final String TEXT_903 = NL + "\t\tlog.info(\"";
  protected final String TEXT_904 = " - Writing the unique record \" + (nb_uniq_";
  protected final String TEXT_905 = "+1) + \" into ";
  protected final String TEXT_906 = ".\");" + NL + "\t";
  protected final String TEXT_907 = NL + "\t\t\t\t";
  protected final String TEXT_908 = ".";
  protected final String TEXT_909 = " = uniq_";
  protected final String TEXT_910 = ".";
  protected final String TEXT_911 = ";" + NL + "    \t";
  protected final String TEXT_912 = NL + "                        nb_uniq_";
  protected final String TEXT_913 = "++;" + NL + "                        " + NL + "                        uniq_";
  protected final String TEXT_914 = " = null;" + NL + "                        " + NL + "                        if(rowList_2_";
  protected final String TEXT_915 = ".size() > 0){" + NL + "                            minIndex_";
  protected final String TEXT_916 = " = 0;" + NL + "                            if (rowList_2_";
  protected final String TEXT_917 = ".size() > 1) {" + NL + "                                for (int i = 1; i < rowList_2_";
  protected final String TEXT_918 = ".size(); i++) {" + NL + "                                    if (comparator_2_";
  protected final String TEXT_919 = ".compare(rowList_2_";
  protected final String TEXT_920 = ".get(minIndex_";
  protected final String TEXT_921 = ")," + NL + "                                            rowList_2_";
  protected final String TEXT_922 = ".get(i)) > 0) {" + NL + "                                        minIndex_";
  protected final String TEXT_923 = " = i;" + NL + "                                    }" + NL + "                                }" + NL + "                            }" + NL + "                            uniq_";
  protected final String TEXT_924 = " = rowList_2_";
  protected final String TEXT_925 = ".get(minIndex_";
  protected final String TEXT_926 = ");" + NL + "                            FileRowIterator_";
  protected final String TEXT_927 = " fri = rowFileList_2_";
  protected final String TEXT_928 = ".get(minIndex_";
  protected final String TEXT_929 = ");" + NL + "                            if (fri.hasNext()) {" + NL + "                                rowList_2_";
  protected final String TEXT_930 = ".set(minIndex_";
  protected final String TEXT_931 = ", fri.next());" + NL + "                            } else {" + NL + "                                fri.close();" + NL + "                                rowFileList_2_";
  protected final String TEXT_932 = ".remove(minIndex_";
  protected final String TEXT_933 = ");" + NL + "                                rowList_2_";
  protected final String TEXT_934 = ".remove(minIndex_";
  protected final String TEXT_935 = ");" + NL + "                            }" + NL + "                        }" + NL + "                        " + NL + "                    }else{" + NL + "                        if(uniq_";
  protected final String TEXT_936 = ".id_";
  protected final String TEXT_937 = " < duplicate_";
  protected final String TEXT_938 = ".id_";
  protected final String TEXT_939 = "){";
  protected final String TEXT_940 = NL + "                        ";
  protected final String TEXT_941 = " = new ";
  protected final String TEXT_942 = "Struct();" + NL + "                        " + NL + "\t";
  protected final String TEXT_943 = NL + "\t\tlog.info(\"";
  protected final String TEXT_944 = " - Writing the unique record \" + (nb_uniq_";
  protected final String TEXT_945 = "+1) + \" into ";
  protected final String TEXT_946 = ".\");" + NL + "\t";
  protected final String TEXT_947 = NL + "\t\t\t\t";
  protected final String TEXT_948 = ".";
  protected final String TEXT_949 = " = uniq_";
  protected final String TEXT_950 = ".";
  protected final String TEXT_951 = ";" + NL + "    \t";
  protected final String TEXT_952 = NL + "                            " + NL + "                            nb_uniq_";
  protected final String TEXT_953 = "++;" + NL + "                            " + NL + "                            uniq_";
  protected final String TEXT_954 = " = null;" + NL + "                            " + NL + "                            if(rowList_2_";
  protected final String TEXT_955 = ".size() > 0){" + NL + "                                minIndex_";
  protected final String TEXT_956 = " = 0;" + NL + "                                if (rowList_2_";
  protected final String TEXT_957 = ".size() > 1) {" + NL + "                                    for (int i = 1; i < rowList_2_";
  protected final String TEXT_958 = ".size(); i++) {" + NL + "                                        if (comparator_2_";
  protected final String TEXT_959 = ".compare(rowList_2_";
  protected final String TEXT_960 = ".get(minIndex_";
  protected final String TEXT_961 = ")," + NL + "                                                rowList_2_";
  protected final String TEXT_962 = ".get(i)) > 0) {" + NL + "                                            minIndex_";
  protected final String TEXT_963 = " = i;" + NL + "                                        }" + NL + "                                    }" + NL + "                                }" + NL + "                                uniq_";
  protected final String TEXT_964 = " = rowList_2_";
  protected final String TEXT_965 = ".get(minIndex_";
  protected final String TEXT_966 = ");" + NL + "                                FileRowIterator_";
  protected final String TEXT_967 = " fri = rowFileList_2_";
  protected final String TEXT_968 = ".get(minIndex_";
  protected final String TEXT_969 = ");" + NL + "                                if (fri.hasNext()) {" + NL + "                                    rowList_2_";
  protected final String TEXT_970 = ".set(minIndex_";
  protected final String TEXT_971 = ", fri.next());" + NL + "                                } else {" + NL + "                                    fri.close();" + NL + "                                    rowFileList_2_";
  protected final String TEXT_972 = ".remove(minIndex_";
  protected final String TEXT_973 = ");" + NL + "                                    rowList_2_";
  protected final String TEXT_974 = ".remove(minIndex_";
  protected final String TEXT_975 = ");" + NL + "                                }" + NL + "                            }" + NL + "                        }else{";
  protected final String TEXT_976 = NL + "                        ";
  protected final String TEXT_977 = " = new ";
  protected final String TEXT_978 = "Struct();" + NL + "\t";
  protected final String TEXT_979 = NL + "\t\tlog.info(\"";
  protected final String TEXT_980 = " - Writing the duplicate record \" + (nb_duplicate_";
  protected final String TEXT_981 = "+1) + \" into ";
  protected final String TEXT_982 = ".\");" + NL + "\t";
  protected final String TEXT_983 = NL + "\t\t\t\t";
  protected final String TEXT_984 = ".";
  protected final String TEXT_985 = " = duplicate_";
  protected final String TEXT_986 = ".";
  protected final String TEXT_987 = ";" + NL + "    \t";
  protected final String TEXT_988 = NL + "\t\t\t\t\t\t\tnb_duplicate_";
  protected final String TEXT_989 = "++;" + NL + "                            duplicate_";
  protected final String TEXT_990 = " = null;" + NL + "                            if(rowList_3_";
  protected final String TEXT_991 = ".size() > 0){" + NL + "                                minIndex_";
  protected final String TEXT_992 = " = 0;" + NL + "                                if (rowList_3_";
  protected final String TEXT_993 = ".size() > 1) {" + NL + "                                    for (int i = 1; i < rowList_3_";
  protected final String TEXT_994 = ".size(); i++) {" + NL + "                                        if (comparator_3_";
  protected final String TEXT_995 = ".compare(rowList_3_";
  protected final String TEXT_996 = ".get(minIndex_";
  protected final String TEXT_997 = ")," + NL + "                                                rowList_3_";
  protected final String TEXT_998 = ".get(i)) > 0) {" + NL + "                                            minIndex_";
  protected final String TEXT_999 = " = i;" + NL + "                                        }" + NL + "                                    }" + NL + "                                }" + NL + "                                duplicate_";
  protected final String TEXT_1000 = " = rowList_3_";
  protected final String TEXT_1001 = ".get(minIndex_";
  protected final String TEXT_1002 = ");" + NL + "                                FileRowIterator_";
  protected final String TEXT_1003 = " fri = rowFileList_3_";
  protected final String TEXT_1004 = ".get(minIndex_";
  protected final String TEXT_1005 = ");" + NL + "                                if (fri.hasNext()) {" + NL + "                                    rowList_3_";
  protected final String TEXT_1006 = ".set(minIndex_";
  protected final String TEXT_1007 = ", fri.next());" + NL + "                                } else {" + NL + "                                    fri.close();" + NL + "                                    rowFileList_3_";
  protected final String TEXT_1008 = ".remove(minIndex_";
  protected final String TEXT_1009 = ");" + NL + "                                    rowList_3_";
  protected final String TEXT_1010 = ".remove(minIndex_";
  protected final String TEXT_1011 = ");" + NL + "                                }" + NL + "                            }" + NL + "                        }" + NL + "                        " + NL + "                    }" + NL + "                }" + NL;
  protected final String TEXT_1012 = NL + "            int bufferSizePerFile_";
  protected final String TEXT_1013 = " = 10000;" + NL + "" + NL + "            java.util.List<FileRowIterator_";
  protected final String TEXT_1014 = "> rowFileList_1_";
  protected final String TEXT_1015 = " = new java.util.ArrayList<FileRowIterator_";
  protected final String TEXT_1016 = ">();" + NL + "            java.util.List<rowStruct_";
  protected final String TEXT_1017 = "> rowList_1_";
  protected final String TEXT_1018 = " = new java.util.ArrayList<rowStruct_";
  protected final String TEXT_1019 = ">();" + NL + "" + NL + "            for (java.io.File file : files_1_";
  protected final String TEXT_1020 = ") {" + NL + "                FileRowIterator_";
  protected final String TEXT_1021 = " fri = new FileRowIterator_";
  protected final String TEXT_1022 = "(file," + NL + "                        bufferSizePerFile_";
  protected final String TEXT_1023 = ");" + NL + "                rowFileList_1_";
  protected final String TEXT_1024 = ".add(fri);" + NL + "                rowList_1_";
  protected final String TEXT_1025 = ".add(fri.next());" + NL + "            }" + NL + "" + NL + "            // comparator for second sort" + NL + "            class Comparator_2_";
  protected final String TEXT_1026 = " implements Comparator<rowStruct_";
  protected final String TEXT_1027 = "> {" + NL + "" + NL + "                public int compare(rowStruct_";
  protected final String TEXT_1028 = " arg0, rowStruct_";
  protected final String TEXT_1029 = " arg1) {" + NL + "                    return arg0.id_";
  protected final String TEXT_1030 = " - arg1.id_";
  protected final String TEXT_1031 = ";" + NL + "                }" + NL + "" + NL + "            }" + NL + "" + NL + "            // For second sort duplicate init begin" + NL + "            int bufferSize_3_";
  protected final String TEXT_1032 = " = bufferSize_";
  protected final String TEXT_1033 = ";" + NL + "            rowStruct_";
  protected final String TEXT_1034 = "[] buffer_3_";
  protected final String TEXT_1035 = " = new rowStruct_";
  protected final String TEXT_1036 = "[bufferSize_3_";
  protected final String TEXT_1037 = "];" + NL + "            int rowsInBuffer_3_";
  protected final String TEXT_1038 = " = 0;" + NL + "            Comparator<rowStruct_";
  protected final String TEXT_1039 = "> comparator_3_";
  protected final String TEXT_1040 = " = new Comparator_2_";
  protected final String TEXT_1041 = "();" + NL + "" + NL + "            java.util.ArrayList<java.io.File> files_3_";
  protected final String TEXT_1042 = " = new java.util.ArrayList<java.io.File>();" + NL + "            // For second sort duplicate init end" + NL + "" + NL + "            while (rowList_1_";
  protected final String TEXT_1043 = ".size() > 0) {" + NL + "                int minIndex_";
  protected final String TEXT_1044 = " = 0;" + NL + "                if (rowList_1_";
  protected final String TEXT_1045 = ".size() > 1) {" + NL + "                    for (int i = 1; i < rowList_1_";
  protected final String TEXT_1046 = ".size(); i++) {" + NL + "                        if (comparator_1_";
  protected final String TEXT_1047 = ".compare(rowList_1_";
  protected final String TEXT_1048 = ".get(minIndex_";
  protected final String TEXT_1049 = ")," + NL + "                                rowList_1_";
  protected final String TEXT_1050 = ".get(i)) > 0) {" + NL + "                            minIndex_";
  protected final String TEXT_1051 = " = i;" + NL + "                        }" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                // /////////////" + NL + "                rowStruct_";
  protected final String TEXT_1052 = " minItem = rowList_1_";
  protected final String TEXT_1053 = ".get(minIndex_";
  protected final String TEXT_1054 = ");" + NL + "                FileRowIterator_";
  protected final String TEXT_1055 = " fri = rowFileList_1_";
  protected final String TEXT_1056 = ".get(minIndex_";
  protected final String TEXT_1057 = ");" + NL + "                if (fri.hasNext()) {" + NL + "                    rowList_1_";
  protected final String TEXT_1058 = ".set(minIndex_";
  protected final String TEXT_1059 = ", fri.next());" + NL + "                } else {" + NL + "                    fri.close();" + NL + "                    rowFileList_1_";
  protected final String TEXT_1060 = ".remove(minIndex_";
  protected final String TEXT_1061 = ");" + NL + "                    rowList_1_";
  protected final String TEXT_1062 = ".remove(minIndex_";
  protected final String TEXT_1063 = ");" + NL + "                }" + NL + "" + NL + "                // get duplicates....begin" + NL + "                for (int i = 0; i < rowList_1_";
  protected final String TEXT_1064 = ".size();) {" + NL + "                    rowStruct_";
  protected final String TEXT_1065 = " current = rowList_1_";
  protected final String TEXT_1066 = ".get(i);" + NL + "                    if (current.duplicateTo(minItem)) {" + NL + "                        // current is duplicate...." + NL + "                        if (rowsInBuffer_3_";
  protected final String TEXT_1067 = " >= bufferSize_3_";
  protected final String TEXT_1068 = ") {" + NL + "" + NL + "                            java.util.Arrays.<rowStruct_";
  protected final String TEXT_1069 = "> sort(buffer_3_";
  protected final String TEXT_1070 = ", 0," + NL + "                                    bufferSize_3_";
  protected final String TEXT_1071 = ", comparator_3_";
  protected final String TEXT_1072 = ");" + NL + "                            java.io.File file = new java.io.File(workDirectory_";
  protected final String TEXT_1073 = " + \"/";
  protected final String TEXT_1074 = "_TEMP_duplicate_\"" + NL + "                                    + files_3_";
  protected final String TEXT_1075 = ".size());";
  protected final String TEXT_1076 = NL + "\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_1077 = " - Invoke request to delete file: \"+file.getPath()+\" When VM exit.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_1078 = NL + "                            file.deleteOnExit();" + NL + "                            java.io.ObjectOutputStream rw = new java.io.ObjectOutputStream(new java.io.BufferedOutputStream(" + NL + "                                    new java.io.FileOutputStream(file)));" + NL + "                        \t";
  protected final String TEXT_1079 = NL + "\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_1080 = " - Writing the data into: \"+file.getPath());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_1081 = NL + "                            for (int j = 0; j < bufferSize_3_";
  protected final String TEXT_1082 = "; j++) {" + NL + "                                buffer_3_";
  protected final String TEXT_1083 = "[j].writeData(rw);" + NL + "                            }" + NL + "                            rw.close();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_1084 = NL + "\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_1085 = " - Wrote successfully.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_1086 = NL + NL + "                            files_3_";
  protected final String TEXT_1087 = ".add(file);" + NL + "" + NL + "                            rowsInBuffer_3_";
  protected final String TEXT_1088 = " = 0;" + NL + "                        }" + NL + "" + NL + "                        buffer_3_";
  protected final String TEXT_1089 = "[rowsInBuffer_3_";
  protected final String TEXT_1090 = "++] = current;" + NL + "                        rowStruct_";
  protected final String TEXT_1091 = " noDuplicateItem = null;" + NL + "                        FileRowIterator_";
  protected final String TEXT_1092 = " fri2 = rowFileList_1_";
  protected final String TEXT_1093 = ".get(i);" + NL + "                        while (fri2.hasNext()) {" + NL + "                            current = fri2.next();" + NL + "                            if (!minItem.duplicateTo(current)) {" + NL + "                                noDuplicateItem = current;" + NL + "                                break;" + NL + "                            } else {" + NL + "                                // current is duplicate...." + NL + "                                if (rowsInBuffer_3_";
  protected final String TEXT_1094 = " >= bufferSize_3_";
  protected final String TEXT_1095 = ") {" + NL + "" + NL + "                                    java.util.Arrays.<rowStruct_";
  protected final String TEXT_1096 = "> sort(buffer_3_";
  protected final String TEXT_1097 = ", 0," + NL + "                                            bufferSize_3_";
  protected final String TEXT_1098 = ", comparator_3_";
  protected final String TEXT_1099 = ");" + NL + "                                    java.io.File file = new java.io.File(workDirectory_";
  protected final String TEXT_1100 = " + \"/";
  protected final String TEXT_1101 = "_TEMP_duplicate_\"" + NL + "                                            + files_3_";
  protected final String TEXT_1102 = ".size());";
  protected final String TEXT_1103 = NL + "\t\t\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_1104 = " - Invoke request to delete file: \"+file.getPath()+\" When VM exit.\");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_1105 = NL + "                                    file.deleteOnExit();" + NL + "                                    java.io.ObjectOutputStream rw = new java.io.ObjectOutputStream(" + NL + "                                            new java.io.BufferedOutputStream(new java.io.FileOutputStream(file)));";
  protected final String TEXT_1106 = NL + "\t\t\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_1107 = " - Writing the data into: \"+file.getPath());" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_1108 = NL + "                                    for (int j = 0; j < bufferSize_3_";
  protected final String TEXT_1109 = "; j++) {" + NL + "                                        buffer_3_";
  protected final String TEXT_1110 = "[j].writeData(rw);" + NL + "                                    }" + NL + "                                    rw.close();" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_1111 = NL + "\t\t\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_1112 = " - Wrote successfully.\");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_1113 = NL + NL + "                                    files_3_";
  protected final String TEXT_1114 = ".add(file);" + NL + "" + NL + "                                    rowsInBuffer_3_";
  protected final String TEXT_1115 = " = 0;" + NL + "                                }" + NL + "" + NL + "                                buffer_3_";
  protected final String TEXT_1116 = "[rowsInBuffer_3_";
  protected final String TEXT_1117 = "++] = current;" + NL + "                            }" + NL + "                        }" + NL + "                        if (noDuplicateItem == null) {" + NL + "                            fri2.close();" + NL + "                            rowFileList_1_";
  protected final String TEXT_1118 = ".remove(i);" + NL + "                            rowList_1_";
  protected final String TEXT_1119 = ".remove(i);" + NL + "                        } else {" + NL + "                            rowList_1_";
  protected final String TEXT_1120 = ".set(i, noDuplicateItem);" + NL + "                            i++;" + NL + "                        }" + NL + "                    } else {" + NL + "                        i++;" + NL + "                    }" + NL + "                }" + NL + "                // get duplicates...." + NL + "            }" + NL + "" + NL + "            // current is duplicate...." + NL + "            if (rowsInBuffer_3_";
  protected final String TEXT_1121 = " > 0) {" + NL + "" + NL + "                java.util.Arrays.<rowStruct_";
  protected final String TEXT_1122 = "> sort(buffer_3_";
  protected final String TEXT_1123 = ", 0," + NL + "                        rowsInBuffer_3_";
  protected final String TEXT_1124 = ", comparator_3_";
  protected final String TEXT_1125 = ");" + NL + "                java.io.File file = new java.io.File(workDirectory_";
  protected final String TEXT_1126 = " + \"/";
  protected final String TEXT_1127 = "_TEMP_duplicate_\"" + NL + "                        + files_3_";
  protected final String TEXT_1128 = ".size());";
  protected final String TEXT_1129 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_1130 = " - Invoke request to delete file: \"+file.getPath()+\" When VM exit.\");" + NL + "\t\t\t\t";
  protected final String TEXT_1131 = NL + "                file.deleteOnExit();" + NL + "                java.io.ObjectOutputStream rw = new java.io.ObjectOutputStream(new java.io.BufferedOutputStream(" + NL + "                        new java.io.FileOutputStream(file)));" + NL + "              \t";
  protected final String TEXT_1132 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_1133 = " - Writing the data into: \"+file.getPath());" + NL + "\t\t\t\t";
  protected final String TEXT_1134 = NL + "                for (int j = 0; j < rowsInBuffer_3_";
  protected final String TEXT_1135 = "; j++) {" + NL + "                    buffer_3_";
  protected final String TEXT_1136 = "[j].writeData(rw);" + NL + "                }" + NL + "                rw.close();" + NL + "\t\t\t\t";
  protected final String TEXT_1137 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_1138 = " - Wrote successfully.\");" + NL + "\t\t\t\t";
  protected final String TEXT_1139 = NL + NL + "                files_3_";
  protected final String TEXT_1140 = ".add(file);" + NL + "" + NL + "                rowsInBuffer_3_";
  protected final String TEXT_1141 = " = 0;" + NL + "            }" + NL + "            buffer_3_";
  protected final String TEXT_1142 = " = null;" + NL + "" + NL + "            java.util.List<FileRowIterator_";
  protected final String TEXT_1143 = "> rowFileList_3_";
  protected final String TEXT_1144 = " = new java.util.ArrayList<FileRowIterator_";
  protected final String TEXT_1145 = ">();" + NL + "            java.util.List<rowStruct_";
  protected final String TEXT_1146 = "> rowList_3_";
  protected final String TEXT_1147 = " = new java.util.ArrayList<rowStruct_";
  protected final String TEXT_1148 = ">();" + NL + "" + NL + "            for (java.io.File file : files_3_";
  protected final String TEXT_1149 = ") {" + NL + "                FileRowIterator_";
  protected final String TEXT_1150 = " fri = new FileRowIterator_";
  protected final String TEXT_1151 = "(file," + NL + "                        bufferSizePerFile_";
  protected final String TEXT_1152 = ");" + NL + "                rowFileList_3_";
  protected final String TEXT_1153 = ".add(fri);" + NL + "                rowList_3_";
  protected final String TEXT_1154 = ".add(fri.next());" + NL + "            }" + NL + "            int nb_uniq_";
  protected final String TEXT_1155 = " = 0;" + NL + "            int nb_duplicate_";
  protected final String TEXT_1156 = " = 0;" + NL + "            rowStruct_";
  protected final String TEXT_1157 = " duplicate_";
  protected final String TEXT_1158 = " = null;" + NL + "            " + NL + "            while (rowList_3_";
  protected final String TEXT_1159 = ".size() > 0) {" + NL + "                int minIndex_";
  protected final String TEXT_1160 = " = 0;" + NL + "                if (rowList_3_";
  protected final String TEXT_1161 = ".size() > 1) {" + NL + "                    for (int i = 1; i < rowList_3_";
  protected final String TEXT_1162 = ".size(); i++) {" + NL + "                        if (comparator_3_";
  protected final String TEXT_1163 = ".compare(rowList_3_";
  protected final String TEXT_1164 = ".get(minIndex_";
  protected final String TEXT_1165 = ")," + NL + "                                rowList_3_";
  protected final String TEXT_1166 = ".get(i)) > 0) {" + NL + "                            minIndex_";
  protected final String TEXT_1167 = " = i;" + NL + "                        }" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                // /////////////" + NL + "" + NL + "                rowStruct_";
  protected final String TEXT_1168 = " current = rowList_3_";
  protected final String TEXT_1169 = ".get(minIndex_";
  protected final String TEXT_1170 = ");" + NL + "" + NL + "                // ////////////" + NL + "                FileRowIterator_";
  protected final String TEXT_1171 = " fri = rowFileList_3_";
  protected final String TEXT_1172 = ".get(minIndex_";
  protected final String TEXT_1173 = ");" + NL + "                if (fri.hasNext()) {" + NL + "                    rowList_3_";
  protected final String TEXT_1174 = ".set(minIndex_";
  protected final String TEXT_1175 = ", fri.next());" + NL + "                } else {" + NL + "                    fri.close();" + NL + "                    rowFileList_3_";
  protected final String TEXT_1176 = ".remove(minIndex_";
  protected final String TEXT_1177 = ");" + NL + "                    rowList_3_";
  protected final String TEXT_1178 = ".remove(minIndex_";
  protected final String TEXT_1179 = ");" + NL + "                }" + NL + "\t";
  protected final String TEXT_1180 = NL + "\t\tlog.info(\"";
  protected final String TEXT_1181 = " - Writing the duplicate record \" + (nb_duplicate_";
  protected final String TEXT_1182 = "+1) + \" into ";
  protected final String TEXT_1183 = ".\");" + NL + "\t";
  protected final String TEXT_1184 = NL + "\t\t\t\t";
  protected final String TEXT_1185 = ".";
  protected final String TEXT_1186 = " = current.";
  protected final String TEXT_1187 = ";" + NL + "    \t";
  protected final String TEXT_1188 = NL + NL + "                nb_duplicate_";
  protected final String TEXT_1189 = "++;";
  protected final String TEXT_1190 = NL + "            int bufferSizePerFile_";
  protected final String TEXT_1191 = " = 10000;" + NL + "" + NL + "            java.util.List<FileRowIterator_";
  protected final String TEXT_1192 = "> rowFileList_1_";
  protected final String TEXT_1193 = " = new java.util.ArrayList<FileRowIterator_";
  protected final String TEXT_1194 = ">();" + NL + "            java.util.List<rowStruct_";
  protected final String TEXT_1195 = "> rowList_1_";
  protected final String TEXT_1196 = " = new java.util.ArrayList<rowStruct_";
  protected final String TEXT_1197 = ">();" + NL + "" + NL + "            for (java.io.File file : files_1_";
  protected final String TEXT_1198 = ") {" + NL + "                FileRowIterator_";
  protected final String TEXT_1199 = " fri = new FileRowIterator_";
  protected final String TEXT_1200 = "(file," + NL + "                        bufferSizePerFile_";
  protected final String TEXT_1201 = ");" + NL + "                rowFileList_1_";
  protected final String TEXT_1202 = ".add(fri);" + NL + "                rowList_1_";
  protected final String TEXT_1203 = ".add(fri.next());" + NL + "            }" + NL + "" + NL + "            // comparator for second sort" + NL + "            class Comparator_2_";
  protected final String TEXT_1204 = " implements Comparator<rowStruct_";
  protected final String TEXT_1205 = "> {" + NL + "" + NL + "                public int compare(rowStruct_";
  protected final String TEXT_1206 = " arg0, rowStruct_";
  protected final String TEXT_1207 = " arg1) {" + NL + "                    return arg0.id_";
  protected final String TEXT_1208 = " - arg1.id_";
  protected final String TEXT_1209 = ";" + NL + "                }" + NL + "" + NL + "            }" + NL + "" + NL + "            // For second sort duplicate init begin" + NL + "            int bufferSize_3_";
  protected final String TEXT_1210 = " = bufferSize_";
  protected final String TEXT_1211 = ";" + NL + "            rowStruct_";
  protected final String TEXT_1212 = "[] buffer_3_";
  protected final String TEXT_1213 = " = new rowStruct_";
  protected final String TEXT_1214 = "[bufferSize_3_";
  protected final String TEXT_1215 = "];" + NL + "            int rowsInBuffer_3_";
  protected final String TEXT_1216 = " = 0;" + NL + "            Comparator<rowStruct_";
  protected final String TEXT_1217 = "> comparator_3_";
  protected final String TEXT_1218 = " = new Comparator_2_";
  protected final String TEXT_1219 = "();" + NL + "" + NL + "            java.util.ArrayList<java.io.File> files_3_";
  protected final String TEXT_1220 = " = new java.util.ArrayList<java.io.File>();" + NL + "            // For second sort duplicate init end" + NL + "            " + NL + "            boolean forDuplicateFlag_";
  protected final String TEXT_1221 = " = false;" + NL + "            rowStruct_";
  protected final String TEXT_1222 = " minItem = null;" + NL + "            " + NL + "            while (rowList_1_";
  protected final String TEXT_1223 = ".size() > 0) {" + NL + "                int minIndex_";
  protected final String TEXT_1224 = " = 0;" + NL + "                if (rowList_1_";
  protected final String TEXT_1225 = ".size() > 1) {" + NL + "                    for (int i = 1; i < rowList_1_";
  protected final String TEXT_1226 = ".size(); i++) {" + NL + "                        if (comparator_1_";
  protected final String TEXT_1227 = ".compare(rowList_1_";
  protected final String TEXT_1228 = ".get(minIndex_";
  protected final String TEXT_1229 = ")," + NL + "                                rowList_1_";
  protected final String TEXT_1230 = ".get(i)) > 0) {" + NL + "                            minIndex_";
  protected final String TEXT_1231 = " = i;" + NL + "                        }" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                // /////////////" + NL + "                if(forDuplicateFlag_";
  protected final String TEXT_1232 = "){" + NL + "                \tif(!minItem.duplicateTo(rowList_1_";
  protected final String TEXT_1233 = ".get(minIndex_";
  protected final String TEXT_1234 = "))){" + NL + "                \t\tminItem = rowList_1_";
  protected final String TEXT_1235 = ".get(minIndex_";
  protected final String TEXT_1236 = ");" + NL + "\t                    FileRowIterator_";
  protected final String TEXT_1237 = " fri = rowFileList_1_";
  protected final String TEXT_1238 = ".get(minIndex_";
  protected final String TEXT_1239 = ");" + NL + "\t                    if (fri.hasNext()) {" + NL + "\t                        rowList_1_";
  protected final String TEXT_1240 = ".set(minIndex_";
  protected final String TEXT_1241 = ", fri.next());" + NL + "\t                    } else {" + NL + "\t                        fri.close();" + NL + "\t                        rowFileList_1_";
  protected final String TEXT_1242 = ".remove(minIndex_";
  protected final String TEXT_1243 = ");" + NL + "\t                        rowList_1_";
  protected final String TEXT_1244 = ".remove(minIndex_";
  protected final String TEXT_1245 = ");" + NL + "\t                    }" + NL + "                \t}else{" + NL + "                \t" + NL + "\t                    if (rowsInBuffer_3_";
  protected final String TEXT_1246 = " >= bufferSize_3_";
  protected final String TEXT_1247 = ") {" + NL + "\t" + NL + "\t                        java.util.Arrays.<rowStruct_";
  protected final String TEXT_1248 = "> sort(buffer_3_";
  protected final String TEXT_1249 = ", 0," + NL + "\t                                bufferSize_3_";
  protected final String TEXT_1250 = ", comparator_3_";
  protected final String TEXT_1251 = ");" + NL + "\t                        java.io.File file = new java.io.File(workDirectory_";
  protected final String TEXT_1252 = " + \"/";
  protected final String TEXT_1253 = "_TEMP_duplicate_\"" + NL + "\t                                + files_3_";
  protected final String TEXT_1254 = ".size());" + NL + "\t                        ";
  protected final String TEXT_1255 = NL + "\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_1256 = " - Invoke request to delete file: \"+file.getPath()+\" When VM exit.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_1257 = NL + "\t                        file.deleteOnExit();" + NL + "\t                        java.io.ObjectOutputStream rw = new java.io.ObjectOutputStream(new java.io.BufferedOutputStream(" + NL + "\t                                new java.io.FileOutputStream(file)));" + NL + "                        \t";
  protected final String TEXT_1258 = NL + "\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_1259 = " - Writing the data into: \"+file.getPath());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_1260 = NL + "\t                        for (int i = 0; i < bufferSize_3_";
  protected final String TEXT_1261 = "; i++) {" + NL + "\t                            buffer_3_";
  protected final String TEXT_1262 = "[i].writeData(rw);" + NL + "\t                        }" + NL + "\t                        rw.close();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_1263 = NL + "\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_1264 = " - Wrote successfully.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_1265 = NL + "\t                        files_3_";
  protected final String TEXT_1266 = ".add(file);" + NL + "\t" + NL + "\t                        rowsInBuffer_3_";
  protected final String TEXT_1267 = " = 0;" + NL + "\t                    }" + NL + "\t                    minItem = rowList_1_";
  protected final String TEXT_1268 = ".get(minIndex_";
  protected final String TEXT_1269 = ");" + NL + "\t                    buffer_3_";
  protected final String TEXT_1270 = "[rowsInBuffer_3_";
  protected final String TEXT_1271 = "++] = minItem;" + NL + "\t                    FileRowIterator_";
  protected final String TEXT_1272 = " fri = rowFileList_1_";
  protected final String TEXT_1273 = ".get(minIndex_";
  protected final String TEXT_1274 = ");" + NL + "\t                    if (fri.hasNext()) {" + NL + "\t                        rowList_1_";
  protected final String TEXT_1275 = ".set(minIndex_";
  protected final String TEXT_1276 = ", fri.next());" + NL + "\t                    } else {" + NL + "\t                        fri.close();" + NL + "\t                        rowFileList_1_";
  protected final String TEXT_1277 = ".remove(minIndex_";
  protected final String TEXT_1278 = ");" + NL + "\t                        rowList_1_";
  protected final String TEXT_1279 = ".remove(minIndex_";
  protected final String TEXT_1280 = ");" + NL + "\t                    }" + NL + "\t                    " + NL + "\t                    forDuplicateFlag_";
  protected final String TEXT_1281 = " = false;" + NL + "\t                    " + NL + "\t                    // skip other duplicates....begin" + NL + "\t                    for (int i = 0; i < rowList_1_";
  protected final String TEXT_1282 = ".size();) {" + NL + "\t                        if (rowList_1_";
  protected final String TEXT_1283 = ".get(i).duplicateTo(minItem)) {" + NL + "\t                            rowStruct_";
  protected final String TEXT_1284 = " noDuplicateItem = null;" + NL + "\t                            FileRowIterator_";
  protected final String TEXT_1285 = " fri2 = rowFileList_1_";
  protected final String TEXT_1286 = ".get(i);" + NL + "\t                            while (fri2.hasNext()) {" + NL + "\t                                rowStruct_";
  protected final String TEXT_1287 = " current = fri2.next();" + NL + "\t                                if (!minItem.duplicateTo(current)) {" + NL + "\t                                    noDuplicateItem = current;" + NL + "\t                                    break;" + NL + "\t                                }" + NL + "\t                            }" + NL + "\t                            if (noDuplicateItem == null) {" + NL + "\t                                fri2.close();" + NL + "\t                                rowFileList_1_";
  protected final String TEXT_1288 = ".remove(i);" + NL + "\t                                rowList_1_";
  protected final String TEXT_1289 = ".remove(i);" + NL + "\t                            } else {" + NL + "\t                                rowList_1_";
  protected final String TEXT_1290 = ".set(i, noDuplicateItem);" + NL + "\t                                i++;" + NL + "\t                            }" + NL + "\t                        } else {" + NL + "\t                            i++;" + NL + "\t                        }" + NL + "\t                    }" + NL + "\t                    // skip duplicates....end" + NL + "                    }" + NL + "                }else{" + NL + "                    minItem = rowList_1_";
  protected final String TEXT_1291 = ".get(minIndex_";
  protected final String TEXT_1292 = ");" + NL + "                    FileRowIterator_";
  protected final String TEXT_1293 = " fri = rowFileList_1_";
  protected final String TEXT_1294 = ".get(minIndex_";
  protected final String TEXT_1295 = ");" + NL + "                    if (fri.hasNext()) {" + NL + "                        rowList_1_";
  protected final String TEXT_1296 = ".set(minIndex_";
  protected final String TEXT_1297 = ", fri.next());" + NL + "                    } else {" + NL + "                        fri.close();" + NL + "                        rowFileList_1_";
  protected final String TEXT_1298 = ".remove(minIndex_";
  protected final String TEXT_1299 = ");" + NL + "                        rowList_1_";
  protected final String TEXT_1300 = ".remove(minIndex_";
  protected final String TEXT_1301 = ");" + NL + "                    }" + NL + "                    forDuplicateFlag_";
  protected final String TEXT_1302 = " = true;" + NL + "                }" + NL + "            }" + NL + "" + NL + "            // current is duplicate...." + NL + "            if (rowsInBuffer_3_";
  protected final String TEXT_1303 = " > 0) {" + NL + "" + NL + "                java.util.Arrays.<rowStruct_";
  protected final String TEXT_1304 = "> sort(buffer_3_";
  protected final String TEXT_1305 = ", 0," + NL + "                        rowsInBuffer_3_";
  protected final String TEXT_1306 = ", comparator_3_";
  protected final String TEXT_1307 = ");" + NL + "                java.io.File file = new java.io.File(workDirectory_";
  protected final String TEXT_1308 = " + \"/";
  protected final String TEXT_1309 = "_TEMP_duplicate_\"" + NL + "                        + files_3_";
  protected final String TEXT_1310 = ".size());";
  protected final String TEXT_1311 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_1312 = " - Invoke request to delete file: \"+file.getPath()+\" When VM exit.\");" + NL + "\t\t\t\t";
  protected final String TEXT_1313 = NL + "                file.deleteOnExit();" + NL + "                java.io.ObjectOutputStream rw = new java.io.ObjectOutputStream(new java.io.BufferedOutputStream(" + NL + "                        new java.io.FileOutputStream(file)));" + NL + "            \t";
  protected final String TEXT_1314 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_1315 = " - Writing the data into: \"+file.getPath());" + NL + "\t\t\t\t";
  protected final String TEXT_1316 = NL + "                for (int j = 0; j < rowsInBuffer_3_";
  protected final String TEXT_1317 = "; j++) {" + NL + "                    buffer_3_";
  protected final String TEXT_1318 = "[j].writeData(rw);" + NL + "                }" + NL + "                rw.close();" + NL + "\t\t\t\t";
  protected final String TEXT_1319 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_1320 = " - Wrote successfully.\");" + NL + "\t\t\t\t";
  protected final String TEXT_1321 = NL + NL + "                files_3_";
  protected final String TEXT_1322 = ".add(file);" + NL + "" + NL + "                rowsInBuffer_3_";
  protected final String TEXT_1323 = " = 0;" + NL + "            }" + NL + "            buffer_3_";
  protected final String TEXT_1324 = " = null;" + NL + "" + NL + "            java.util.List<FileRowIterator_";
  protected final String TEXT_1325 = "> rowFileList_3_";
  protected final String TEXT_1326 = " = new java.util.ArrayList<FileRowIterator_";
  protected final String TEXT_1327 = ">();" + NL + "            java.util.List<rowStruct_";
  protected final String TEXT_1328 = "> rowList_3_";
  protected final String TEXT_1329 = " = new java.util.ArrayList<rowStruct_";
  protected final String TEXT_1330 = ">();" + NL + "" + NL + "            for (java.io.File file : files_3_";
  protected final String TEXT_1331 = ") {" + NL + "                FileRowIterator_";
  protected final String TEXT_1332 = " fri = new FileRowIterator_";
  protected final String TEXT_1333 = "(file," + NL + "                        bufferSizePerFile_";
  protected final String TEXT_1334 = ");" + NL + "                rowFileList_3_";
  protected final String TEXT_1335 = ".add(fri);" + NL + "                rowList_3_";
  protected final String TEXT_1336 = ".add(fri.next());" + NL + "            }" + NL + "            int nb_uniq_";
  protected final String TEXT_1337 = " = 0;" + NL + "            int nb_duplicate_";
  protected final String TEXT_1338 = " = 0;" + NL + "" + NL + "            while (rowList_3_";
  protected final String TEXT_1339 = ".size() > 0) {" + NL + "                int minIndex_";
  protected final String TEXT_1340 = " = 0;" + NL + "                if (rowList_3_";
  protected final String TEXT_1341 = ".size() > 1) {" + NL + "                    for (int i = 1; i < rowList_3_";
  protected final String TEXT_1342 = ".size(); i++) {" + NL + "                        if (comparator_3_";
  protected final String TEXT_1343 = ".compare(rowList_3_";
  protected final String TEXT_1344 = ".get(minIndex_";
  protected final String TEXT_1345 = ")," + NL + "                                rowList_3_";
  protected final String TEXT_1346 = ".get(i)) > 0) {" + NL + "                            minIndex_";
  protected final String TEXT_1347 = " = i;" + NL + "                        }" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                // /////////////" + NL + "" + NL + "                rowStruct_";
  protected final String TEXT_1348 = " current = rowList_3_";
  protected final String TEXT_1349 = ".get(minIndex_";
  protected final String TEXT_1350 = ");" + NL + "" + NL + "                // ////////////" + NL + "                FileRowIterator_";
  protected final String TEXT_1351 = " fri = rowFileList_3_";
  protected final String TEXT_1352 = ".get(minIndex_";
  protected final String TEXT_1353 = ");" + NL + "                if (fri.hasNext()) {" + NL + "                    rowList_3_";
  protected final String TEXT_1354 = ".set(minIndex_";
  protected final String TEXT_1355 = ", fri.next());" + NL + "                } else {" + NL + "                    fri.close();" + NL + "                    rowFileList_3_";
  protected final String TEXT_1356 = ".remove(minIndex_";
  protected final String TEXT_1357 = ");" + NL + "                    rowList_3_";
  protected final String TEXT_1358 = ".remove(minIndex_";
  protected final String TEXT_1359 = ");" + NL + "                }" + NL + "\t";
  protected final String TEXT_1360 = NL + "\t\tlog.info(\"";
  protected final String TEXT_1361 = " - Writing the duplicate record \" + (nb_duplicate_";
  protected final String TEXT_1362 = "+1) + \" into ";
  protected final String TEXT_1363 = ".\");" + NL + "\t";
  protected final String TEXT_1364 = NL + "\t\t\t\t";
  protected final String TEXT_1365 = ".";
  protected final String TEXT_1366 = " = current.";
  protected final String TEXT_1367 = ";" + NL + "    \t";
  protected final String TEXT_1368 = NL + NL + "                nb_duplicate_";
  protected final String TEXT_1369 = "++;";
  protected final String TEXT_1370 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = ElementParameterParser.getValue(node, "__CID__");

int UNIQUE = 1;
int UNIQUE_AND_DUPLICATE = 2;
int UNIQUE_AND_DUPLICATE_ONCE = 3;
int DUPLICATE = 4;
int DUPLICATE_ONCE = 5;

int mode = 0;
String connUniqName = null;
String connDuplicateName = null;
boolean onlyOnceEachDuplicatedKey = ("true").equals(ElementParameterParser.getValue(node, "__ONLY_ONCE_EACH_DUPLICATED_KEY__"));
List<? extends IConnection> connsUnique = node.getOutgoingConnections("UNIQUE");
List<? extends IConnection> connsDuplicate = node.getOutgoingConnections("DUPLICATE");
final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
if(connsUnique.size() > 0){
	connUniqName = connsUnique.get(0).getName();
	if(connsDuplicate.size() > 0){
		connDuplicateName = connsDuplicate.get(0).getName();
		if(onlyOnceEachDuplicatedKey){
			mode =3;
		}else{
			mode = 2;
		}
	}else{
		mode = 1;
	}
}else{
	if(connsDuplicate.size() > 0){
		connDuplicateName = connsDuplicate.get(0).getName();
		if(onlyOnceEachDuplicatedKey){
			mode =5;
		}else{
			mode = 4;
		}
	}
}

List<IMetadataTable> metadatas = node.getMetadataList();
IMetadataTable metadata = null;
List<IMetadataColumn> columnList = null;
if ((metadatas!=null)&&(metadatas.size()>0)) {
    metadata = metadatas.get(0);
    columnList = metadata.getListColumns();
}else{
	mode = 0;
}

if(mode == UNIQUE){//HSS_____0

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    
					if (isLog4jEnabled) {
					
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
					}
					
    stringBuffer.append(TEXT_52);
    
					if (isLog4jEnabled) {
					
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
					}
					
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    
					if (isLog4jEnabled) {
					
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
					}
					
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
				}
				
    stringBuffer.append(TEXT_96);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
				}
				
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    
				}
				
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
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
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(connUniqName );
    stringBuffer.append(TEXT_145);
    
	}
    for(IMetadataColumn column : columnList){//HSS_____0_____1
    	
    stringBuffer.append(TEXT_146);
    stringBuffer.append(connUniqName );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_149);
    
    }//HSS_____0_____1

    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    
}else if(mode == UNIQUE_AND_DUPLICATE){//HSS_____0

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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    
					if (isLog4jEnabled) {
					
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    
					}
					
    stringBuffer.append(TEXT_214);
    
					if (isLog4jEnabled) {
					
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    
					}
					
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    
					if (isLog4jEnabled) {
					
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    
					}
					
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
    stringBuffer.append(cid );
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
    
							if (isLog4jEnabled) {
							
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    
							}
							
    stringBuffer.append(TEXT_253);
    
							if (isLog4jEnabled) {
							
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    
							}
							
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_258);
    
							if (isLog4jEnabled) {
							
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    
							}
							
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid );
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
    
									if (isLog4jEnabled) {
									
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    
									}
									
    stringBuffer.append(TEXT_280);
    
									if (isLog4jEnabled) {
									
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    
									}
									
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_285);
    
									if (isLog4jEnabled) {
									
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    
									}
									
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
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
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    
				}
				
    stringBuffer.append(TEXT_306);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    
				}
				
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_311);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    
				}
				
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
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    
				}
				
    stringBuffer.append(TEXT_328);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    
				}
				
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_333);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    
				}
				
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_412);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(connUniqName );
    stringBuffer.append(TEXT_414);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(connDuplicateName );
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_418);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(connDuplicateName );
    stringBuffer.append(TEXT_420);
    stringBuffer.append(connDuplicateName );
    stringBuffer.append(TEXT_421);
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_424);
    stringBuffer.append(connDuplicateName );
    stringBuffer.append(TEXT_425);
    
	}
    for(IMetadataColumn column : columnList){//HSS_____0_____1
    	
    stringBuffer.append(TEXT_426);
    stringBuffer.append(connDuplicateName );
    stringBuffer.append(TEXT_427);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_429);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_430);
    
    }//HSS_____0_____1

    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_455);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(connUniqName );
    stringBuffer.append(TEXT_457);
    stringBuffer.append(connUniqName );
    stringBuffer.append(TEXT_458);
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_461);
    stringBuffer.append(connUniqName );
    stringBuffer.append(TEXT_462);
    
	}
    for(IMetadataColumn column : columnList){//HSS_____0_____1
    	
    stringBuffer.append(TEXT_463);
    stringBuffer.append(connUniqName );
    stringBuffer.append(TEXT_464);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_466);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_467);
    
    }//HSS_____0_____1

    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_495);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(connUniqName );
    stringBuffer.append(TEXT_497);
    stringBuffer.append(connUniqName );
    stringBuffer.append(TEXT_498);
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_501);
    stringBuffer.append(connUniqName );
    stringBuffer.append(TEXT_502);
    
	}
    for(IMetadataColumn column : columnList){//HSS_____0_____1
    	
    stringBuffer.append(TEXT_503);
    stringBuffer.append(connUniqName );
    stringBuffer.append(TEXT_504);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_506);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_507);
    
    }//HSS_____0_____1

    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_531);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(connDuplicateName );
    stringBuffer.append(TEXT_533);
    stringBuffer.append(connDuplicateName );
    stringBuffer.append(TEXT_534);
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_537);
    stringBuffer.append(connDuplicateName );
    stringBuffer.append(TEXT_538);
    
	}
    for(IMetadataColumn column : columnList){//HSS_____0_____1
    	
    stringBuffer.append(TEXT_539);
    stringBuffer.append(connDuplicateName );
    stringBuffer.append(TEXT_540);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_542);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_543);
    
    }//HSS_____0_____1

    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_547);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_551);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_553);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_567);
    
}else if(mode == UNIQUE_AND_DUPLICATE_ONCE){//HSS_____0

    stringBuffer.append(TEXT_568);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_571);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_577);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_586);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_588);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_598);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_600);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_601);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_602);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_604);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_607);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_610);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_615);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_621);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_624);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_626);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_632);
    
							if (isLog4jEnabled) {
							
    stringBuffer.append(TEXT_633);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_634);
    
							}
							
    stringBuffer.append(TEXT_635);
    
							if (isLog4jEnabled) {
							
    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_637);
    
							}
							
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_640);
    
							if (isLog4jEnabled) {
							
    stringBuffer.append(TEXT_641);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_642);
    
							}
							
    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_644);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_648);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_649);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_650);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_651);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_652);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_653);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_654);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_655);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_656);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_657);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_658);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_659);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_660);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_661);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_662);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_663);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_664);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_665);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_666);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_667);
    
							if (isLog4jEnabled) {
							
    stringBuffer.append(TEXT_668);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_669);
    
							}
							
    stringBuffer.append(TEXT_670);
    
							if (isLog4jEnabled) {
							
    stringBuffer.append(TEXT_671);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_672);
    
							}
							
    stringBuffer.append(TEXT_673);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_674);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_675);
    
							if (isLog4jEnabled) {
							
    stringBuffer.append(TEXT_676);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_677);
    
							}
							
    stringBuffer.append(TEXT_678);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_679);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_680);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_682);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_683);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_684);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_692);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_693);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_694);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_695);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_696);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_697);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_698);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_699);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_700);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_701);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_702);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_703);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_704);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_705);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_706);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_707);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_708);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_709);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_710);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_711);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_712);
    
						if (isLog4jEnabled) {
						
    stringBuffer.append(TEXT_713);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_714);
    
						}
						
    stringBuffer.append(TEXT_715);
    
						if (isLog4jEnabled) {
						
    stringBuffer.append(TEXT_716);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_717);
    
						}
						
    stringBuffer.append(TEXT_718);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_719);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_720);
    
						if (isLog4jEnabled) {
						
    stringBuffer.append(TEXT_721);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_722);
    
						}
						
    stringBuffer.append(TEXT_723);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_724);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_725);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_726);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_727);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_728);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_729);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_730);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_731);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_732);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_733);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_734);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_735);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_736);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_737);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_738);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_739);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_740);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_741);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_742);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_743);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_744);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_745);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_746);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_747);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_748);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_749);
    
				}
				
    stringBuffer.append(TEXT_750);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_751);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_752);
    
				}
				
    stringBuffer.append(TEXT_753);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_754);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_755);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_756);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_757);
    
				}
				
    stringBuffer.append(TEXT_758);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_759);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_760);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_761);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_762);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_763);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_764);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_765);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_766);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_767);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_768);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_769);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_770);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_771);
    
				}
				
    stringBuffer.append(TEXT_772);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_773);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_774);
    
				}
				
    stringBuffer.append(TEXT_775);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_776);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_777);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_778);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_779);
    
				}
				
    stringBuffer.append(TEXT_780);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_781);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_782);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_783);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_784);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_785);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_786);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_787);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_788);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_789);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_790);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_791);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_792);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_793);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_794);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_795);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_796);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_797);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_798);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_799);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_800);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_801);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_802);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_803);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_804);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_805);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_806);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_807);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_808);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_809);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_810);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_811);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_812);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_813);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_814);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_815);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_816);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_817);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_818);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_819);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_820);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_821);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_822);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_823);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_824);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_825);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_826);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_827);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_828);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_829);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_830);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_831);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_832);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_833);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_834);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_835);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_836);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_837);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_838);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_839);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_840);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_841);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_842);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_843);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_844);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_845);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_846);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_847);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_848);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_849);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_850);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_851);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_852);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_853);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_854);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_855);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_856);
    stringBuffer.append(TEXT_857);
    stringBuffer.append(connUniqName );
    stringBuffer.append(TEXT_858);
    stringBuffer.append(TEXT_859);
    stringBuffer.append(connDuplicateName );
    stringBuffer.append(TEXT_860);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_861);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_862);
    stringBuffer.append(TEXT_863);
    stringBuffer.append(connDuplicateName );
    stringBuffer.append(TEXT_864);
    stringBuffer.append(connDuplicateName );
    stringBuffer.append(TEXT_865);
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_866);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_867);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_868);
    stringBuffer.append(connDuplicateName );
    stringBuffer.append(TEXT_869);
    
	}
    for(IMetadataColumn column : columnList){//HSS_____0_____1
    	
    stringBuffer.append(TEXT_870);
    stringBuffer.append(connDuplicateName );
    stringBuffer.append(TEXT_871);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_872);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_873);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_874);
    
    }//HSS_____0_____1

    stringBuffer.append(TEXT_875);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_876);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_877);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_878);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_879);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_880);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_881);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_882);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_883);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_884);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_885);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_886);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_887);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_888);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_889);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_890);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_891);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_892);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_893);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_894);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_895);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_896);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_897);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_898);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_899);
    stringBuffer.append(TEXT_900);
    stringBuffer.append(connUniqName );
    stringBuffer.append(TEXT_901);
    stringBuffer.append(connUniqName );
    stringBuffer.append(TEXT_902);
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_903);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_904);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_905);
    stringBuffer.append(connUniqName );
    stringBuffer.append(TEXT_906);
    
	}
    for(IMetadataColumn column : columnList){//HSS_____0_____1
    	
    stringBuffer.append(TEXT_907);
    stringBuffer.append(connUniqName );
    stringBuffer.append(TEXT_908);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_909);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_910);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_911);
    
    }//HSS_____0_____1

    stringBuffer.append(TEXT_912);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_913);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_914);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_915);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_916);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_917);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_918);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_919);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_920);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_921);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_922);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_923);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_924);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_925);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_926);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_927);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_928);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_929);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_930);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_931);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_932);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_933);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_934);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_935);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_936);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_937);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_938);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_939);
    stringBuffer.append(TEXT_940);
    stringBuffer.append(connUniqName );
    stringBuffer.append(TEXT_941);
    stringBuffer.append(connUniqName );
    stringBuffer.append(TEXT_942);
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_943);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_944);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_945);
    stringBuffer.append(connUniqName );
    stringBuffer.append(TEXT_946);
    
	}
    for(IMetadataColumn column : columnList){//HSS_____0_____1
    	
    stringBuffer.append(TEXT_947);
    stringBuffer.append(connUniqName );
    stringBuffer.append(TEXT_948);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_949);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_950);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_951);
    
    }//HSS_____0_____1

    stringBuffer.append(TEXT_952);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_953);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_954);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_955);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_956);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_957);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_958);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_959);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_960);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_961);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_962);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_963);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_964);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_965);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_966);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_967);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_968);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_969);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_970);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_971);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_972);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_973);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_974);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_975);
    stringBuffer.append(TEXT_976);
    stringBuffer.append(connDuplicateName );
    stringBuffer.append(TEXT_977);
    stringBuffer.append(connDuplicateName );
    stringBuffer.append(TEXT_978);
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_979);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_980);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_981);
    stringBuffer.append(connDuplicateName );
    stringBuffer.append(TEXT_982);
    
	}
    for(IMetadataColumn column : columnList){//HSS_____0_____1
    	
    stringBuffer.append(TEXT_983);
    stringBuffer.append(connDuplicateName );
    stringBuffer.append(TEXT_984);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_985);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_986);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_987);
    
    }//HSS_____0_____1

    stringBuffer.append(TEXT_988);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_989);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_990);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_991);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_992);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_993);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_994);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_995);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_996);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_997);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_998);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_999);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1000);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1001);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1002);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1003);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1004);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1005);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1006);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1007);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1008);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1009);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1010);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1011);
    
}else if(mode == DUPLICATE){//HSS_____0

    stringBuffer.append(TEXT_1012);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1013);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1014);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1015);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1016);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1017);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1018);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1019);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1020);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1021);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1022);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1023);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1024);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1025);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1026);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1027);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1028);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1029);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1030);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1031);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1032);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1033);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1034);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1035);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1036);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1037);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1038);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1039);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1040);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1041);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1042);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1043);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1044);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1045);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1046);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1047);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1048);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1049);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1050);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1051);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1052);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1053);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1054);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1055);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1056);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1057);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1058);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1059);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1060);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1061);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1062);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1063);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1064);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1065);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1066);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1067);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1068);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1069);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1070);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1071);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1072);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1073);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1074);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1075);
    
							if (isLog4jEnabled) {
							
    stringBuffer.append(TEXT_1076);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1077);
    
							}
							
    stringBuffer.append(TEXT_1078);
    
							if (isLog4jEnabled) {
							
    stringBuffer.append(TEXT_1079);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1080);
    
							}
							
    stringBuffer.append(TEXT_1081);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1082);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1083);
    
							if (isLog4jEnabled) {
							
    stringBuffer.append(TEXT_1084);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1085);
    
							}
							
    stringBuffer.append(TEXT_1086);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1087);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1088);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1089);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1090);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1091);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1092);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1093);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1094);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1095);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1096);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1097);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1098);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1099);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1102);
    
									if (isLog4jEnabled) {
									
    stringBuffer.append(TEXT_1103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1104);
    
									}
									
    stringBuffer.append(TEXT_1105);
    
									if (isLog4jEnabled) {
									
    stringBuffer.append(TEXT_1106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1107);
    
									}
									
    stringBuffer.append(TEXT_1108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1110);
    
									if (isLog4jEnabled) {
									
    stringBuffer.append(TEXT_1111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1112);
    
									}
									
    stringBuffer.append(TEXT_1113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1124);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1128);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_1129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1130);
    
				}
				
    stringBuffer.append(TEXT_1131);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_1132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1133);
    
				}
				
    stringBuffer.append(TEXT_1134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1136);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_1137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1138);
    
				}
				
    stringBuffer.append(TEXT_1139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1179);
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_1180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1182);
    stringBuffer.append(connDuplicateName );
    stringBuffer.append(TEXT_1183);
    
	}
    for(IMetadataColumn column : columnList){//HSS_____0_____1
    	
    stringBuffer.append(TEXT_1184);
    stringBuffer.append(connDuplicateName );
    stringBuffer.append(TEXT_1185);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_1186);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_1187);
    
    }//HSS_____0_____1

    stringBuffer.append(TEXT_1188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1189);
    
}else if(mode == DUPLICATE_ONCE){//HSS_____0

    stringBuffer.append(TEXT_1190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1249);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1250);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1251);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1254);
    
							if (isLog4jEnabled) {
							
    stringBuffer.append(TEXT_1255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1256);
    
							}
							
    stringBuffer.append(TEXT_1257);
    
							if (isLog4jEnabled) {
							
    stringBuffer.append(TEXT_1258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1259);
    
							}
							
    stringBuffer.append(TEXT_1260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1262);
    
							if (isLog4jEnabled) {
							
    stringBuffer.append(TEXT_1263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1264);
    
							}
							
    stringBuffer.append(TEXT_1265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1268);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1274);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1275);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1277);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1279);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1281);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1282);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1283);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1285);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1286);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1289);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1290);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1292);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1293);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1295);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1296);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1297);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1298);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1299);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1302);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1304);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1305);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1306);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1307);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1308);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1309);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1310);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_1311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1312);
    
				}
				
    stringBuffer.append(TEXT_1313);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_1314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1315);
    
				}
				
    stringBuffer.append(TEXT_1316);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1317);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1318);
    
				if (isLog4jEnabled) {
				
    stringBuffer.append(TEXT_1319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1320);
    
				}
				
    stringBuffer.append(TEXT_1321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1322);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1323);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1324);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1325);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1327);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1328);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1330);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1331);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1332);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1333);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1334);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1335);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1336);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1337);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1338);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1339);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1340);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1341);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1342);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1343);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1344);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1345);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1346);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1347);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1348);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1349);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1350);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1351);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1352);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1353);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1354);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1355);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1356);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1357);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1358);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1359);
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_1360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_1361);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1362);
    stringBuffer.append(connDuplicateName );
    stringBuffer.append(TEXT_1363);
    
	}
    for(IMetadataColumn column : columnList){//HSS_____0_____1
    	
    stringBuffer.append(TEXT_1364);
    stringBuffer.append(connDuplicateName );
    stringBuffer.append(TEXT_1365);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_1366);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_1367);
    
    }//HSS_____0_____1

    stringBuffer.append(TEXT_1368);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_1369);
    
}//HSS_____0


    stringBuffer.append(TEXT_1370);
    return stringBuffer.toString();
  }
}
