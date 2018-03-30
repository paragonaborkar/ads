package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TFileOutputExcelBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputExcelBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputExcelBeginJava result = new TFileOutputExcelBeginJava();
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
  protected final String TEXT_29 = NL;
  protected final String TEXT_30 = NL + "\t\t\tclass ExcelDynamicUtil_";
  protected final String TEXT_31 = "{" + NL + "\t\t\t\tint dynamicColCount=0;" + NL + "\t\t\t\tprivate java.util.List<String> numberTypes = java.util.Arrays.asList(" + NL + "\t\t\t\t\tnew String[]{\"Integer\", \"Float\", \"Double\", \"Long\", \"Short\", \"Byte\", \"BigDecimal\"});" + NL + "\t\t\t\t" + NL + "\t\t\t\tpublic boolean isNumberType(String talendType){" + NL + "\t\t\t\t\tif(talendType==null){" + NL + "\t\t\t\t\t\treturn false;" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\treturn numberTypes.contains(talendType.replaceAll(\"id_\",\"\"));" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\tint[] fitWidth;" + NL + "\t\t\t\tjxl.write.WritableCellFormat cellFormat;" + NL + "\t\t\t\tjxl.write.WritableCellFormat dateCellFormat;" + NL + "\t\t\t\t" + NL + "\t\t\t\tpublic ExcelDynamicUtil_";
  protected final String TEXT_33 = "(){" + NL + "\t\t\t\t\tinitFormat();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void initFormat(){" + NL + "\t\t\t\t\t";
  protected final String TEXT_34 = NL + "\t\t\t\t\t\tjxl.write.WritableFont font = new jxl.write.WritableFont(jxl.write.WritableFont.";
  protected final String TEXT_35 = ", 10, jxl.write.WritableFont.NO_BOLD, false);" + NL + "\t\t        \t\tcellFormat  = new jxl.write.WritableCellFormat(font); " + NL + "\t\t        \t\tdateCellFormat=new jxl.write.WritableCellFormat(font ,new jxl.write.DateFormat(";
  protected final String TEXT_36 = "));" + NL + "\t\t\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\t\t\t\tdateCellFormat=new jxl.write.WritableCellFormat(new jxl.write.DateFormat(";
  protected final String TEXT_38 = "));" + NL + "\t\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tpublic String getJxlWriteType(DynamicMetadata dynamicColumn){" + NL + "\t\t\t\t\tString talendType=dynamicColumn.getType();" + NL + "\t\t\t\t\tString jxlWriteType=\"Number\";" + NL + "    \t\t\t\tboolean isNumber = false;" + NL + "\t\t\t\t\tif(\"id_Boolean\".equals(talendType)){" + NL + "\t\t\t\t\t\tjxlWriteType=\"Boolean\";" + NL + "\t\t\t\t\t}else if(\"id_Date\".equals(talendType)){" + NL + "\t\t\t\t\t\tjxlWriteType=\"DateTime\";" + NL + "\t\t\t\t    }else if(\"id_String\".equals(talendType)||" + NL + "\t\t\t\t    \t\t \"id_Character\".equals(talendType)||" + NL + "\t\t\t\t    \t\t \"id_byte[]\".equals(talendType)||" + NL + "\t\t\t\t    \t\t \"id_List\".equals(talendType)||" + NL + "\t\t\t\t    \t\t \"id_Object\".equals(talendType)||" + NL + "\t\t\t\t    \t\t (";
  protected final String TEXT_40 = " && isNumberType(talendType))" + NL + "\t\t\t\t    \t\t ){" + NL + "\t\t\t\t    \tjxlWriteType=\"Label\";" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tjxlWriteType=\"Number\";" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn jxlWriteType;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t\t\tpublic int writeHeaderToExcelFile(jxl.write.WritableSheet writableSheet,int columnIndex,int rowNum,";
  protected final String TEXT_42 = "Struct row,int [] currentFitWidths)" + NL + "\t\t\t\t\t\tthrows jxl.write.biff.RowsExceededException, jxl.write.WriteException{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\t\t\t\tif (rowNum == ";
  protected final String TEXT_44 = "){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t\t\t\tif (rowNum == 0){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\t\t\t\tjxl.write.WritableCell cell  = null;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\t\t        \tdynamicColCount = row.";
  protected final String TEXT_48 = ".getColumnCount();" + NL + "\t\t\t\t\t\t        for (int i = 0; i < dynamicColCount; i++) {" + NL + "\t\t\t\t\t\t\t\t\tDynamicMetadata dynamicColumn = row.";
  protected final String TEXT_49 = ".getColumnMetadata(i);" + NL + "\t\t\t\t\t\t\t\t\tif (dynamicColumn.getName() != null) {" + NL + "\t\t\t\t\t\t\t\t\t\tcell  = new jxl.write.Label(columnIndex+i+";
  protected final String TEXT_50 = ", rowNum, dynamicColumn.getName()";
  protected final String TEXT_51 = ",cellFormat";
  protected final String TEXT_52 = ");" + NL + "\t\t\t\t\t\t\t\t\t\twritableSheet.addCell(cell);" + NL + "\t\t\t\t\t\t\t\t\t\twritableSheet.setColumnView(columnIndex+i+";
  protected final String TEXT_53 = ", dynamicColumn.getName().trim().length());" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t        ";
  protected final String TEXT_54 = NL + "\t\t\t\t\t      \t\t" + NL + "\t\t\t\t\t\t\t\tcell  = new jxl.write.Label(columnIndex+";
  protected final String TEXT_55 = "+dynamicColCount-1";
  protected final String TEXT_56 = ", rowNum, \"";
  protected final String TEXT_57 = "\"";
  protected final String TEXT_58 = ",cellFormat";
  protected final String TEXT_59 = ");" + NL + "\t\t\t\t\t\t\t\twritableSheet.addCell(cell);" + NL + "\t\t\t\t\t\t\t\twritableSheet.setColumnView(columnIndex+";
  protected final String TEXT_60 = "+dynamicColCount-1";
  protected final String TEXT_61 = ", \"";
  protected final String TEXT_62 = "\".length());" + NL + "\t\t\t\t\t\t\t\tif(\"";
  protected final String TEXT_63 = "\".length() > currentFitWidths[";
  protected final String TEXT_64 = "]){" + NL + "\t\t\t\t\t\t\t\t\tcurrentFitWidths[";
  protected final String TEXT_65 = "] = \"";
  protected final String TEXT_66 = "\".length();" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t        ";
  protected final String TEXT_67 = NL + "\t\t\t\t\t\t\treturn 1;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\treturn 0;" + NL + "\t\t\t\t" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t\tpublic void writeValuesToExcelFile(Dynamic column, jxl.write.WritableSheet writableSheet,int columnIndex,int rowNum)" + NL + "\t\t\t\t\tthrows jxl.write.biff.RowsExceededException, jxl.write.WriteException{" + NL + "\t\t\t\t\tdynamicColCount = column.getColumnCount();" + NL + "\t\t\t\t\tif(fitWidth == null){" + NL + "\t\t\t\t\t\tfitWidth = new int[dynamicColCount];" + NL + "\t\t\t\t\t\tfor(int i=0;i<dynamicColCount;i++){" + NL + "\t\t\t\t\t\t    int fitCellViewSize=writableSheet.getColumnView(i+";
  protected final String TEXT_69 = "+";
  protected final String TEXT_70 = ").getSize();" + NL + "\t\t\t\t\t\t\tfitWidth[i]=fitCellViewSize/256;" + NL + "\t\t\t\t\t\t\tif(fitCellViewSize%256!=0){" + NL + "\t\t\t\t\t\t\t\tfitWidth[i]+=1;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tfor (int i = 0; i < dynamicColCount; i++) {" + NL + "\t\t\t\t\t\tif (column.getColumnValue(i) != null) {" + NL + "\t\t\t\t\t\t\tDynamicMetadata dynamicColumn = column.getColumnMetadata(i);" + NL + "\t\t\t\t\t\t\tString jxlWriteType = getJxlWriteType(dynamicColumn);" + NL + "\t\t\t                jxl.write.WritableCell cell = null;" + NL + "\t\t\t                if(\"Boolean\".equals(jxlWriteType)){" + NL + "\t\t\t                \tcell = new jxl.write.Boolean(columnIndex+i, rowNum, ((Boolean)column.getColumnValue(i))";
  protected final String TEXT_71 = ",cellFormat";
  protected final String TEXT_72 = ");" + NL + "\t\t\t                }else if(\"Label\".equals(jxlWriteType)){" + NL + "\t\t\t                \tif(";
  protected final String TEXT_73 = " && isNumberType(dynamicColumn.getType())) { " + NL + "\t\t\t                \t\tcell = new jxl.write.Label(columnIndex+i, rowNum, FormatterUtils.format_Number(String.valueOf(column.getColumnValue(i)), ";
  protected final String TEXT_74 = ", ";
  protected final String TEXT_75 = ")";
  protected final String TEXT_76 = ",cellFormat";
  protected final String TEXT_77 = ");" + NL + "\t\t\t                \t}else{" + NL + "\t\t\t                \t\tcell = new jxl.write.Label(columnIndex+i, rowNum, column.getColumnValue(i).toString()";
  protected final String TEXT_78 = ",cellFormat";
  protected final String TEXT_79 = ");" + NL + "\t\t\t                \t}" + NL + "\t\t\t                }else if(\"DateTime\".equals(jxlWriteType)){" + NL + "\t\t\t                \tcell = new jxl.write.DateTime(columnIndex+i, rowNum, ((java.util.Date)column.getColumnValue(i)), dateCellFormat);" + NL + "\t\t\t                }else{" + NL + "\t\t\t                \tcell = new jxl.write.Number(columnIndex+i, rowNum, Double.valueOf(column.getColumnValue(i).toString())";
  protected final String TEXT_80 = ",cellFormat";
  protected final String TEXT_81 = ");" + NL + "\t\t\t                }" + NL + "\t\t\t                writableSheet.addCell(cell);" + NL + "\t\t\t                " + NL + "\t\t\t                int currentWith = 5;" + NL + "\t\t\t                if(\"Number\".equals(jxlWriteType)){" + NL + "\t\t\t\t\t\t\t\tcurrentWith = String.valueOf(((jxl.write.Number)cell).getValue()).trim().length();" + NL + "\t\t\t\t\t\t\t\tcurrentWith=currentWith>10?10:currentWith;" + NL + "\t\t\t\t\t\t\t}else if(!\"Boolean\".equals(jxlWriteType)){" + NL + "\t\t\t\t\t\t\t\tcurrentWith = cell.getContents().trim().length();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tfitWidth[i] = fitWidth[i] > currentWith ? fitWidth[i]:currentWith+2;" + NL + "\t\t\t            }" + NL + "\t\t\t        }" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void autoDynamicColumnSize(jxl.write.WritableSheet writableSheet,int columnIndex){" + NL + "\t\t\t\t\tfor (int i = 0; i < dynamicColCount; i++) {" + NL + "\t\t\t\t\t\twritableSheet.setColumnView(columnIndex+i, fitWidth[i]);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_82 = NL + "\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\t\t\tpublic int writeHeaderToExcelFile(";
  protected final String TEXT_84 = "Struct row, org.talend.ExcelTool xlsxTool,int nbLine){" + NL + "\t\t\t\t\t\tif(nbLine < 1){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_85 = NL + "\t\t\t\t\t\t\t\tif (xlsxTool.getStartRow() == 0){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_86 = NL + "\t\t\t\t\t\t\t\txlsxTool.addRow();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_87 = NL + "\t\t\t\t\t\t\t\t\t\tdynamicColCount = row.";
  protected final String TEXT_88 = ".getColumnCount();" + NL + "\t\t\t\t\t\t\t\t        for (int i = 0; i < dynamicColCount; i++) {" + NL + "\t\t\t\t\t\t\t\t\t\t\tDynamicMetadata dynamicColumn = row.";
  protected final String TEXT_89 = ".getColumnMetadata(i);" + NL + "\t\t\t\t\t\t\t\t\t\t\tif (dynamicColumn.getName() != null) {" + NL + "\t\t\t\t\t\t\t\t\t\t\t\txlsxTool.addCellValue(dynamicColumn.getName());" + NL + "\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_90 = NL + "\t\t\t\t\t\t\t\t\t\txlsxTool.addCellValue(\"";
  protected final String TEXT_91 = "\");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_92 = NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_93 = NL + "\t\t\t\t\t\t\treturn 1;" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\treturn 0;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_94 = NL + "\t\t\t\tpublic void writeValuesToExcelFile(Dynamic column, org.talend.ExcelTool xlsxTool){" + NL + "\t\t\t\t\tdynamicColCount = column.getColumnCount();" + NL + "\t\t\t\t\tfor (int i = 0; i < dynamicColCount; i++) {" + NL + "\t\t\t\t\t\tif (column.getColumnValue(i) != null) {" + NL + "\t\t\t\t\t\t\tDynamicMetadata dynamicColumn = column.getColumnMetadata(i);" + NL + "\t\t\t\t\t\t\tString talendType=dynamicColumn.getType();" + NL + "\t\t\t                if(\"id_Date\".equals(talendType)){" + NL + "\t\t\t                \txlsxTool.addCellValue((java.util.Date)column.getColumnValue(i), ";
  protected final String TEXT_95 = ");" + NL + "\t\t\t                } else if(";
  protected final String TEXT_96 = " && isNumberType(talendType)) { " + NL + "\t\t\t\t\t\t\t\txlsxTool.addCellValue(FormatterUtils.format_Number(String.valueOf(column.getColumnValue(i)), ";
  protected final String TEXT_97 = ", ";
  protected final String TEXT_98 = "));" + NL + "\t\t\t                } else if(isNumberType(talendType)) { " + NL + "\t\t\t                \txlsxTool.addCellValue(Double.parseDouble(String.valueOf(column.getColumnValue(i))));" + NL + "\t\t\t                }else if(\"id_Boolean\".equals(talendType)){" + NL + "\t\t\t                \txlsxTool.addCellValue((Boolean)(column.getColumnValue(i)));" + NL + "\t\t\t                }else{" + NL + "\t\t\t                \txlsxTool.addCellValue(String.valueOf(column.getColumnValue(i)));" + NL + "\t\t\t                }" + NL + "\t\t\t            }else{" + NL + "\t\t\t            \txlsxTool.addCellNullValue();" + NL + "\t\t\t            }" + NL + "\t\t\t        }" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void autoDynamicColumnSize(org.talend.ExcelTool xlsxTool){" + NL + "\t\t\t\t\tfor (int i = 0; i < dynamicColCount; i++) {" + NL + "\t\t\t\t\t\txlsxTool.setColAutoSize(i+";
  protected final String TEXT_99 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_100 = NL + "\t\t\t\tpublic int getDynamicColCount(){" + NL + "\t\t\t\t\treturn dynamicColCount;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tExcelDynamicUtil_";
  protected final String TEXT_101 = " excelDynamicUtil_";
  protected final String TEXT_102 = "=new ExcelDynamicUtil_";
  protected final String TEXT_103 = "();" + NL + "\t\t\t";
  protected final String TEXT_104 = NL + "\t\tint columnIndex_";
  protected final String TEXT_105 = " = 0;" + NL + "\t\t";
  protected final String TEXT_106 = NL + "\t\tint nb_line_";
  protected final String TEXT_107 = " = 0;" + NL;
  protected final String TEXT_108 = "\t\t" + NL + "\t\tString fileName_";
  protected final String TEXT_109 = "=";
  protected final String TEXT_110 = ";" + NL + "\t\tjava.io.File file_";
  protected final String TEXT_111 = " = new java.io.File(fileName_";
  protected final String TEXT_112 = ");" + NL + "\t\tboolean isFileGenerated_";
  protected final String TEXT_113 = " = true;";
  protected final String TEXT_114 = NL + "\t\tif(file_";
  protected final String TEXT_115 = ".exists()){" + NL + "\t\t\tisFileGenerated_";
  protected final String TEXT_116 = " = false;" + NL + "\t\t}";
  protected final String TEXT_117 = NL + "//create directory only if not exists\t\t  " + NL + "          java.io.File parentFile_";
  protected final String TEXT_118 = " = file_";
  protected final String TEXT_119 = ".getParentFile();" + NL + "          if (parentFile_";
  protected final String TEXT_120 = " != null && !parentFile_";
  protected final String TEXT_121 = ".exists()) {" + NL + "        \t";
  protected final String TEXT_122 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_123 = " - Creating directory '\" +parentFile_";
  protected final String TEXT_124 = ".getCanonicalPath() + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_125 = NL + "             parentFile_";
  protected final String TEXT_126 = ".mkdirs();" + NL + "        \t";
  protected final String TEXT_127 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_128 = " - Create directory '\"+parentFile_";
  protected final String TEXT_129 = ".getCanonicalPath()+\"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_130 = NL + "          }";
  protected final String TEXT_131 = "\t\t" + NL + "\t\t" + NL + "\t\tjxl.write.WritableWorkbook writeableWorkbook_";
  protected final String TEXT_132 = " = null;" + NL + "\t\tjxl.write.WritableSheet writableSheet_";
  protected final String TEXT_133 = " = null;" + NL + "\t\t" + NL + "\t\tjxl.WorkbookSettings workbookSettings_";
  protected final String TEXT_134 = " = new jxl.WorkbookSettings();" + NL + "        workbookSettings_";
  protected final String TEXT_135 = ".setEncoding(";
  protected final String TEXT_136 = ");";
  protected final String TEXT_137 = NL + "\t\twriteableWorkbook_";
  protected final String TEXT_138 = " = new jxl.write.biff.WritableWorkbookImpl(" + NL + "            \t\tnew java.io.BufferedOutputStream(";
  protected final String TEXT_139 = "), " + NL + "            \t\tfalse, workbookSettings_";
  protected final String TEXT_140 = ");";
  protected final String TEXT_141 = "  " + NL + "        if (file_";
  protected final String TEXT_142 = ".exists()) {" + NL + "        jxl.Workbook workbook_";
  protected final String TEXT_143 = " = jxl.Workbook.getWorkbook(file_";
  protected final String TEXT_144 = ",workbookSettings_";
  protected final String TEXT_145 = ");" + NL + "        workbookSettings_";
  protected final String TEXT_146 = ".setWriteAccess(null);" + NL + "        writeableWorkbook_";
  protected final String TEXT_147 = " = new jxl.write.biff.WritableWorkbookImpl(" + NL + "                \tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(file_";
  protected final String TEXT_148 = ", false)), " + NL + "                \tworkbook_";
  protected final String TEXT_149 = ", " + NL + "                \ttrue," + NL + "                    workbookSettings_";
  protected final String TEXT_150 = ");" + NL + "        }else{        " + NL + "\t\twriteableWorkbook_";
  protected final String TEXT_151 = " = new jxl.write.biff.WritableWorkbookImpl(" + NL + "            \t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(fileName_";
  protected final String TEXT_152 = ")), " + NL + "            \t\ttrue, " + NL + "            \t\tworkbookSettings_";
  protected final String TEXT_153 = ");        " + NL + "        }     ";
  protected final String TEXT_154 = NL + "\t\twriteableWorkbook_";
  protected final String TEXT_155 = " = new jxl.write.biff.WritableWorkbookImpl(" + NL + "            \t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(fileName_";
  protected final String TEXT_156 = ")), " + NL + "            \t\ttrue, " + NL + "            \t\tworkbookSettings_";
  protected final String TEXT_157 = ");";
  protected final String TEXT_158 = "       " + NL + "" + NL + "        writableSheet_";
  protected final String TEXT_159 = " = writeableWorkbook_";
  protected final String TEXT_160 = ".getSheet(";
  protected final String TEXT_161 = ");" + NL + "        if(writableSheet_";
  protected final String TEXT_162 = " == null){" + NL + "        \twritableSheet_";
  protected final String TEXT_163 = " = writeableWorkbook_";
  protected final String TEXT_164 = ".createSheet(";
  protected final String TEXT_165 = ", writeableWorkbook_";
  protected final String TEXT_166 = ".getNumberOfSheets());" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_167 = NL + "        else {" + NL + "" + NL + "            String[] sheetNames_";
  protected final String TEXT_168 = " = writeableWorkbook_";
  protected final String TEXT_169 = ".getSheetNames();" + NL + "            for (int i = 0; i < sheetNames_";
  protected final String TEXT_170 = ".length; i++) {" + NL + "                if (sheetNames_";
  protected final String TEXT_171 = "[i].equals(";
  protected final String TEXT_172 = ")) {" + NL + "                    writeableWorkbook_";
  protected final String TEXT_173 = ".removeSheet(i);" + NL + "                    break;" + NL + "                }" + NL + "            }" + NL + "" + NL + "\t\t\twritableSheet_";
  protected final String TEXT_174 = " = writeableWorkbook_";
  protected final String TEXT_175 = ".createSheet(";
  protected final String TEXT_176 = ", writeableWorkbook_";
  protected final String TEXT_177 = ".getNumberOfSheets());" + NL + "        }";
  protected final String TEXT_178 = NL + NL + "        //modif start";
  protected final String TEXT_179 = NL + "\t\tint startRowNum_";
  protected final String TEXT_180 = " = ";
  protected final String TEXT_181 = ";";
  protected final String TEXT_182 = NL + "        int startRowNum_";
  protected final String TEXT_183 = " = writableSheet_";
  protected final String TEXT_184 = ".getRows();";
  protected final String TEXT_185 = NL + "\t\t//modif end" + NL + "\t\t" + NL + "\t\tint[] fitWidth_";
  protected final String TEXT_186 = " = new int[";
  protected final String TEXT_187 = "];" + NL + "\t\tfor(int i_";
  protected final String TEXT_188 = "=0;i_";
  protected final String TEXT_189 = "<";
  protected final String TEXT_190 = ";i_";
  protected final String TEXT_191 = "++){" + NL + "\t\t    int fitCellViewSize_";
  protected final String TEXT_192 = "=writableSheet_";
  protected final String TEXT_193 = ".getColumnView(i_";
  protected final String TEXT_194 = "+";
  protected final String TEXT_195 = ").getSize();" + NL + "\t\t\tfitWidth_";
  protected final String TEXT_196 = "[i_";
  protected final String TEXT_197 = "]=fitCellViewSize_";
  protected final String TEXT_198 = "/256;" + NL + "\t\t\tif(fitCellViewSize_";
  protected final String TEXT_199 = "%256!=0){" + NL + "\t\t\t\tfitWidth_";
  protected final String TEXT_200 = "[i_";
  protected final String TEXT_201 = "]+=1;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_202 = NL + "\t\t" + NL + "\t\tjxl.write.WritableFont wf_";
  protected final String TEXT_203 = " = new jxl.write.WritableFont(jxl.write.WritableFont.";
  protected final String TEXT_204 = ", 10, jxl.write.WritableFont.NO_BOLD, false);" + NL + "        jxl.write.WritableCellFormat format_";
  protected final String TEXT_205 = "  = new jxl.write.WritableCellFormat(wf_";
  protected final String TEXT_206 = "); ";
  protected final String TEXT_207 = NL;
  protected final String TEXT_208 = NL + "    \t\t\t\t\tfinal jxl.write.WritableCellFormat cell_format_";
  protected final String TEXT_209 = "_";
  protected final String TEXT_210 = "=new jxl.write.WritableCellFormat(wf_";
  protected final String TEXT_211 = " ,new jxl.write.DateFormat(";
  protected final String TEXT_212 = "));";
  protected final String TEXT_213 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\tfinal jxl.write.WritableCellFormat cell_format_";
  protected final String TEXT_214 = "_";
  protected final String TEXT_215 = "=new jxl.write.WritableCellFormat(new jxl.write.DateFormat(";
  protected final String TEXT_216 = "));";
  protected final String TEXT_217 = NL + "\t\tif(true){" + NL + "\t\t\tthrow new RuntimeException(\"Date pattern must be set for column ";
  protected final String TEXT_218 = " in the schema of component ";
  protected final String TEXT_219 = "!\");" + NL + "\t\t}";
  protected final String TEXT_220 = "\t\t" + NL;
  protected final String TEXT_221 = NL + "\t\tclass FileOutputExcelUtil_";
  protected final String TEXT_222 = "{";
  protected final String TEXT_223 = NL + "\t\t\tExcelDynamicUtil_";
  protected final String TEXT_224 = " excelDynamicUtil_";
  protected final String TEXT_225 = "=new ExcelDynamicUtil_";
  protected final String TEXT_226 = "();";
  protected final String TEXT_227 = NL + "\t\t\tpublic void putHeaderValue_";
  protected final String TEXT_228 = "(final jxl.write.WritableSheet writableSheet_";
  protected final String TEXT_229 = ",final int rowNum_";
  protected final String TEXT_230 = "," + NL + "\t\t\t\tfinal jxl.write.WritableCellFormat format_";
  protected final String TEXT_231 = ",final int[] fitWidth_";
  protected final String TEXT_232 = ") throws java.lang.Exception {";
  protected final String TEXT_233 = NL + "\t\t\twritableSheet_";
  protected final String TEXT_234 = ".addCell(new jxl.write.Label(";
  protected final String TEXT_235 = " + ";
  protected final String TEXT_236 = ", rowNum_";
  protected final String TEXT_237 = ", \"";
  protected final String TEXT_238 = "\"";
  protected final String TEXT_239 = NL + "\t\t\t\t\t,format_";
  protected final String TEXT_240 = NL + "\t\t\t));\t\t";
  protected final String TEXT_241 = NL + "\t\t\twritableSheet_";
  protected final String TEXT_242 = ".addCell(new jxl.write.Label(";
  protected final String TEXT_243 = ", rowNum_";
  protected final String TEXT_244 = ", \"";
  protected final String TEXT_245 = "\"";
  protected final String TEXT_246 = NL + "\t\t\t\t\t,format_";
  protected final String TEXT_247 = NL + "\t\t\t));";
  protected final String TEXT_248 = NL + "        \t\t//modif end" + NL + "    \t\tfitWidth_";
  protected final String TEXT_249 = "[";
  protected final String TEXT_250 = "]=fitWidth_";
  protected final String TEXT_251 = "[";
  protected final String TEXT_252 = "]>";
  protected final String TEXT_253 = "?fitWidth_";
  protected final String TEXT_254 = "[";
  protected final String TEXT_255 = "]:";
  protected final String TEXT_256 = ";";
  protected final String TEXT_257 = NL + "\t\t\t}";
  protected final String TEXT_258 = NL + "\t\t\t}";
  protected final String TEXT_259 = NL + "\t\t\tpublic void setColumnView_";
  protected final String TEXT_260 = "(final jxl.write.WritableSheet writableSheet_";
  protected final String TEXT_261 = "," + NL + "\t\t\t\tfinal int[] fitWidth_";
  protected final String TEXT_262 = ") throws java.lang.Exception {" + NL + "\t\t\t\t\tint columnIndex_";
  protected final String TEXT_263 = " = 0;";
  protected final String TEXT_264 = NL + "\t\t\t\t\tcolumnIndex_";
  protected final String TEXT_265 = " = excelDynamicUtil_";
  protected final String TEXT_266 = ".getDynamicColCount()+";
  protected final String TEXT_267 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_268 = NL + "\t\t\t\t\tcolumnIndex_";
  protected final String TEXT_269 = " = ";
  protected final String TEXT_270 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_271 = NL + "    \t\t\t//modif start" + NL + "        \t\t";
  protected final String TEXT_272 = NL + "        \t\t\twritableSheet_";
  protected final String TEXT_273 = ".setColumnView(columnIndex_";
  protected final String TEXT_274 = "  + ";
  protected final String TEXT_275 = ", fitWidth_";
  protected final String TEXT_276 = "[";
  protected final String TEXT_277 = "]);" + NL + "        \t\t";
  protected final String TEXT_278 = NL + "        \t\t\twritableSheet_";
  protected final String TEXT_279 = ".setColumnView(columnIndex_";
  protected final String TEXT_280 = " , fitWidth_";
  protected final String TEXT_281 = "[";
  protected final String TEXT_282 = "]);" + NL + "        \t\t";
  protected final String TEXT_283 = NL + "    \t\t\t//modif end";
  protected final String TEXT_284 = NL + "\t\t\t\t\t\t\tcolumnIndex_";
  protected final String TEXT_285 = " = excelDynamicUtil_";
  protected final String TEXT_286 = ".getDynamicColCount()+";
  protected final String TEXT_287 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_288 = NL + "\t\t\t\t\t\t\tcolumnIndex_";
  protected final String TEXT_289 = " = ";
  protected final String TEXT_290 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_291 = NL + "        \t\t\twritableSheet_";
  protected final String TEXT_292 = ".setColumnView(columnIndex_";
  protected final String TEXT_293 = " , fitWidth_";
  protected final String TEXT_294 = "[";
  protected final String TEXT_295 = "]);";
  protected final String TEXT_296 = NL + "\t\t\t}";
  protected final String TEXT_297 = NL + "\t\t\t}";
  protected final String TEXT_298 = NL + "\t\t\tpublic void putValue_";
  protected final String TEXT_299 = "(final ";
  protected final String TEXT_300 = "Struct ";
  protected final String TEXT_301 = "," + NL + "\t\t\t\tfinal jxl.write.WritableSheet writableSheet_";
  protected final String TEXT_302 = ",final int startRowNum_";
  protected final String TEXT_303 = ",final int nb_line_";
  protected final String TEXT_304 = "," + NL + "\t\t\t\tfinal jxl.write.WritableCellFormat format_";
  protected final String TEXT_305 = ",int[] fitWidth_";
  protected final String TEXT_306 = ") throws java.lang.Exception {" + NL + "\t\t\t\tint columnIndex_";
  protected final String TEXT_307 = " = 0;";
  protected final String TEXT_308 = NL + "\t\t\t";
  protected final String TEXT_309 = "\t\t\t\t";
  protected final String TEXT_310 = "   \t\t\t\t" + NL + "\t    \t\t\t\tif(";
  protected final String TEXT_311 = ".";
  protected final String TEXT_312 = " != null) {" + NL + "    \t\t\t\t";
  protected final String TEXT_313 = NL + "\t\t\t\t\t" + NL + "//modif start" + NL + "\t\t\t\t\t";
  protected final String TEXT_314 = NL + "\t\t\t\t\t\tcolumnIndex_";
  protected final String TEXT_315 = " = excelDynamicUtil_";
  protected final String TEXT_316 = ".getDynamicColCount()+";
  protected final String TEXT_317 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_318 = NL + "\t\t\t\t\t\tcolumnIndex_";
  protected final String TEXT_319 = " = ";
  protected final String TEXT_320 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_321 = NL + NL + "\t\t\t\t\t";
  protected final String TEXT_322 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_323 = NL + "\t\t\t\t\t\t\tjxl.write.WritableCell existingCell_";
  protected final String TEXT_324 = "_";
  protected final String TEXT_325 = " = writableSheet_";
  protected final String TEXT_326 = ".getWritableCell(columnIndex_";
  protected final String TEXT_327 = " + ";
  protected final String TEXT_328 = ", startRowNum_";
  protected final String TEXT_329 = " + nb_line_";
  protected final String TEXT_330 = ") ;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_331 = NL + "\t\t\t\t\t\tjxl.write.WritableCell cell_";
  protected final String TEXT_332 = "_";
  protected final String TEXT_333 = " = new jxl.write.";
  protected final String TEXT_334 = "(columnIndex_";
  protected final String TEXT_335 = " + ";
  protected final String TEXT_336 = ", startRowNum_";
  protected final String TEXT_337 = " + nb_line_";
  protected final String TEXT_338 = " ," + NL + "\t\t\t\t\t";
  protected final String TEXT_339 = NL + "\t\t\t\t\t\tjxl.write.WritableCell cell_";
  protected final String TEXT_340 = "_";
  protected final String TEXT_341 = " = new jxl.write.";
  protected final String TEXT_342 = "(columnIndex_";
  protected final String TEXT_343 = ", startRowNum_";
  protected final String TEXT_344 = " + nb_line_";
  protected final String TEXT_345 = "," + NL + "\t\t\t\t\t";
  protected final String TEXT_346 = NL + "//modif end";
  protected final String TEXT_347 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_348 = ".";
  protected final String TEXT_349 = ", cell_format_";
  protected final String TEXT_350 = "_";
  protected final String TEXT_351 = NL + "\t\t\t\t\t\t\tString.valueOf(";
  protected final String TEXT_352 = ".";
  protected final String TEXT_353 = ")";
  protected final String TEXT_354 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_355 = ".";
  protected final String TEXT_356 = ".toString()";
  protected final String TEXT_357 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_358 = ".";
  protected final String TEXT_359 = ")).toString()";
  protected final String TEXT_360 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_361 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_362 = "), ";
  protected final String TEXT_363 = ", ";
  protected final String TEXT_364 = ")\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_365 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_366 = ".";
  protected final String TEXT_367 = "), ";
  protected final String TEXT_368 = ", ";
  protected final String TEXT_369 = ")\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_370 = "\t\t" + NL + "\t\t\t\t\t\t\t(";
  protected final String TEXT_371 = ").doubleValue()";
  protected final String TEXT_372 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_373 = ".";
  protected final String TEXT_374 = NL + "\t\t\t\t\t\t,format_";
  protected final String TEXT_375 = NL + "\t\t\t\t\t\t\t);" + NL + "//modif start\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t//If we keep the cell format from the existing cell in sheet" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_376 = NL + "\t\t\t\t\t\t\t\tif(existingCell_";
  protected final String TEXT_377 = "_";
  protected final String TEXT_378 = ".getCellFormat()!=null)" + NL + "\t\t\t\t\t\t\t\t\tcell_";
  protected final String TEXT_379 = "_";
  protected final String TEXT_380 = ".setCellFormat( existingCell_";
  protected final String TEXT_381 = "_";
  protected final String TEXT_382 = ".getCellFormat());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_383 = NL + "//modif ends\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\twritableSheet_";
  protected final String TEXT_384 = ".addCell(cell_";
  protected final String TEXT_385 = "_";
  protected final String TEXT_386 = ");";
  protected final String TEXT_387 = NL + "\t\t\t\t\t\t\tint currentWith_";
  protected final String TEXT_388 = "_";
  protected final String TEXT_389 = " = String.valueOf(((jxl.write.Number)cell_";
  protected final String TEXT_390 = "_";
  protected final String TEXT_391 = ").getValue()).trim().length();" + NL + "\t\t\t\t\t\t\tcurrentWith_";
  protected final String TEXT_392 = "_";
  protected final String TEXT_393 = "=currentWith_";
  protected final String TEXT_394 = "_";
  protected final String TEXT_395 = ">10?10:currentWith_";
  protected final String TEXT_396 = "_";
  protected final String TEXT_397 = ";";
  protected final String TEXT_398 = NL + "\t\t\t\t\t\t\tint currentWith_";
  protected final String TEXT_399 = "_";
  protected final String TEXT_400 = " = cell_";
  protected final String TEXT_401 = "_";
  protected final String TEXT_402 = ".getContents().trim().length();";
  protected final String TEXT_403 = NL + "\t\t\t\t\t\t\tfitWidth_";
  protected final String TEXT_404 = "[";
  protected final String TEXT_405 = "]=fitWidth_";
  protected final String TEXT_406 = "[";
  protected final String TEXT_407 = "]>currentWith_";
  protected final String TEXT_408 = "_";
  protected final String TEXT_409 = "?fitWidth_";
  protected final String TEXT_410 = "[";
  protected final String TEXT_411 = "]:currentWith_";
  protected final String TEXT_412 = "_";
  protected final String TEXT_413 = "+2;";
  protected final String TEXT_414 = NL + "\t\t\t\t\t\t\tcurrentWith_";
  protected final String TEXT_415 = "_";
  protected final String TEXT_416 = "=";
  protected final String TEXT_417 = ";" + NL + "\t\t\t\t\t\t\tfitWidth_";
  protected final String TEXT_418 = "[";
  protected final String TEXT_419 = "]=fitWidth_";
  protected final String TEXT_420 = "[";
  protected final String TEXT_421 = "]>currentWith_";
  protected final String TEXT_422 = "_";
  protected final String TEXT_423 = "?fitWidth_";
  protected final String TEXT_424 = "[";
  protected final String TEXT_425 = "]:currentWith_";
  protected final String TEXT_426 = "_";
  protected final String TEXT_427 = "+2;";
  protected final String TEXT_428 = NL + "\t\t\t\t\t\texcelDynamicUtil_";
  protected final String TEXT_429 = ".writeValuesToExcelFile(";
  protected final String TEXT_430 = ".";
  protected final String TEXT_431 = ", writableSheet_";
  protected final String TEXT_432 = ",columnIndex_";
  protected final String TEXT_433 = "+";
  protected final String TEXT_434 = ",startRowNum_";
  protected final String TEXT_435 = " + nb_line_";
  protected final String TEXT_436 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_437 = NL + "\t\t\t\t\t\t\texcelDynamicUtil_";
  protected final String TEXT_438 = ".autoDynamicColumnSize(writableSheet_";
  protected final String TEXT_439 = ",columnIndex_";
  protected final String TEXT_440 = "+";
  protected final String TEXT_441 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_442 = NL + "\t    \t\t\t\t} " + NL + "\t\t\t\t\t";
  protected final String TEXT_443 = NL + "\t\t\t}";
  protected final String TEXT_444 = NL + "\t\t\t}";
  protected final String TEXT_445 = NL + "\t\t\t" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tFileOutputExcelUtil_";
  protected final String TEXT_446 = " fileOutputExcelUtil_";
  protected final String TEXT_447 = "=new FileOutputExcelUtil_";
  protected final String TEXT_448 = "();";
  protected final String TEXT_449 = NL;
  protected final String TEXT_450 = NL + "\t\tif (startRowNum_";
  protected final String TEXT_451 = " == ";
  protected final String TEXT_452 = "){";
  protected final String TEXT_453 = NL + "\t\tif (startRowNum_";
  protected final String TEXT_454 = " == 0){";
  protected final String TEXT_455 = NL + "\t//modif end";
  protected final String TEXT_456 = NL + "\t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_457 = ".putHeaderValue_";
  protected final String TEXT_458 = "(writableSheet_";
  protected final String TEXT_459 = ",startRowNum_";
  protected final String TEXT_460 = ",";
  protected final String TEXT_461 = "format_";
  protected final String TEXT_462 = "null";
  protected final String TEXT_463 = ",fitWidth_";
  protected final String TEXT_464 = ");";
  protected final String TEXT_465 = NL + "\t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_466 = ".putHeaderValue_";
  protected final String TEXT_467 = "(writableSheet_";
  protected final String TEXT_468 = ",nb_line_";
  protected final String TEXT_469 = ",";
  protected final String TEXT_470 = "format_";
  protected final String TEXT_471 = "null";
  protected final String TEXT_472 = ",fitWidth_";
  protected final String TEXT_473 = ");";
  protected final String TEXT_474 = NL + "\t\t//modif start";
  protected final String TEXT_475 = NL + "\t\t\twritableSheet_";
  protected final String TEXT_476 = ".addCell(new jxl.write.Label(";
  protected final String TEXT_477 = " + ";
  protected final String TEXT_478 = ", startRowNum_";
  protected final String TEXT_479 = ", \"";
  protected final String TEXT_480 = "\"";
  protected final String TEXT_481 = NL + "\t\t\t\t\t,format_";
  protected final String TEXT_482 = NL + "\t\t\t));\t\t";
  protected final String TEXT_483 = NL + "\t\t\twritableSheet_";
  protected final String TEXT_484 = ".addCell(new jxl.write.Label(";
  protected final String TEXT_485 = ", nb_line_";
  protected final String TEXT_486 = ", \"";
  protected final String TEXT_487 = "\"";
  protected final String TEXT_488 = NL + "\t\t\t\t\t,format_";
  protected final String TEXT_489 = NL + "\t\t\t));";
  protected final String TEXT_490 = NL + "\t\t//modif end" + NL + "\t\tfitWidth_";
  protected final String TEXT_491 = "[";
  protected final String TEXT_492 = "]=fitWidth_";
  protected final String TEXT_493 = "[";
  protected final String TEXT_494 = "]>";
  protected final String TEXT_495 = "?fitWidth_";
  protected final String TEXT_496 = "[";
  protected final String TEXT_497 = "]:";
  protected final String TEXT_498 = ";";
  protected final String TEXT_499 = NL + "\t\tnb_line_";
  protected final String TEXT_500 = " ++;" + NL + "\t}";
  protected final String TEXT_501 = NL + "\t\t";
  protected final String TEXT_502 = NL + "\t\tString fileName_";
  protected final String TEXT_503 = "=";
  protected final String TEXT_504 = ";";
  protected final String TEXT_505 = "\t" + NL + "\t\tjava.io.File file_";
  protected final String TEXT_506 = " = new java.io.File(fileName_";
  protected final String TEXT_507 = ");" + NL + "\t\tboolean isFileGenerated_";
  protected final String TEXT_508 = " = true;";
  protected final String TEXT_509 = NL + "\t\tif(file_";
  protected final String TEXT_510 = ".exists()){" + NL + "\t\t\tisFileGenerated_";
  protected final String TEXT_511 = " = false;" + NL + "\t\t}";
  protected final String TEXT_512 = NL + "\t\tint nb_line_";
  protected final String TEXT_513 = " = 0;" + NL + "\t\torg.talend.ExcelTool xlsxTool_";
  protected final String TEXT_514 = " = new org.talend.ExcelTool();";
  protected final String TEXT_515 = NL + "\t\t\tint\tflushRowNum_";
  protected final String TEXT_516 = "=";
  protected final String TEXT_517 = ";" + NL + "\t\t\tint bufferCount_";
  protected final String TEXT_518 = "=0;" + NL + "\t\t\txlsxTool_";
  protected final String TEXT_519 = ".setRowAccessWindowSize(-1);" + NL + "\t\t\t//turn-off auto flush";
  protected final String TEXT_520 = NL + "\t\txlsxTool_";
  protected final String TEXT_521 = ".setSheet(";
  protected final String TEXT_522 = ");" + NL + "\t\txlsxTool_";
  protected final String TEXT_523 = ".setAppend(";
  protected final String TEXT_524 = ",";
  protected final String TEXT_525 = ");" + NL + "\t\txlsxTool_";
  protected final String TEXT_526 = ".setRecalculateFormula(";
  protected final String TEXT_527 = ");" + NL + "\t\txlsxTool_";
  protected final String TEXT_528 = ".setXY(";
  protected final String TEXT_529 = ",";
  protected final String TEXT_530 = ",";
  protected final String TEXT_531 = ",";
  protected final String TEXT_532 = ");" + NL + "\t\t";
  protected final String TEXT_533 = NL + "\t\txlsxTool_";
  protected final String TEXT_534 = ".prepareXlsxFile(fileName_";
  protected final String TEXT_535 = ");" + NL + "\t\t";
  protected final String TEXT_536 = NL + "\t\txlsxTool_";
  protected final String TEXT_537 = ".prepareStream();" + NL + "\t\t";
  protected final String TEXT_538 = NL + "\t\txlsxTool_";
  protected final String TEXT_539 = ".setFont(\"";
  protected final String TEXT_540 = "\");" + NL + "\t\t";
  protected final String TEXT_541 = NL + "\t\t\tclass FileOutputExcelUtil_";
  protected final String TEXT_542 = "{";
  protected final String TEXT_543 = NL + "\t\t\t\tExcelDynamicUtil_";
  protected final String TEXT_544 = " excelDynamicUtil_";
  protected final String TEXT_545 = "=new ExcelDynamicUtil_";
  protected final String TEXT_546 = "();";
  protected final String TEXT_547 = NL + "\t\t\t\tpublic void putHeaderValue_";
  protected final String TEXT_548 = "(final org.talend.ExcelTool xlsxTool_";
  protected final String TEXT_549 = ") throws java.lang.Exception {";
  protected final String TEXT_550 = NL + "\t\t\t\t\txlsxTool_";
  protected final String TEXT_551 = ".addCellValue(\"";
  protected final String TEXT_552 = "\");";
  protected final String TEXT_553 = NL + "\t\t\t\t}";
  protected final String TEXT_554 = NL + "\t\t\t\t}";
  protected final String TEXT_555 = NL + "\t\t\t\tpublic void setColAutoSize_";
  protected final String TEXT_556 = "(final org.talend.ExcelTool xlsxTool_";
  protected final String TEXT_557 = ") throws java.lang.Exception {" + NL + "\t\t\t\t\tint columnIndex_";
  protected final String TEXT_558 = " = 0;";
  protected final String TEXT_559 = NL + "\t\t\t\t\t\tcolumnIndex_";
  protected final String TEXT_560 = " = excelDynamicUtil_";
  protected final String TEXT_561 = ".getDynamicColCount()+";
  protected final String TEXT_562 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_563 = NL + "\t\t\t\t\t\tcolumnIndex_";
  protected final String TEXT_564 = " = ";
  protected final String TEXT_565 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_566 = NL + "\t\t\t\t\txlsxTool_";
  protected final String TEXT_567 = ".setColAutoSize(columnIndex_";
  protected final String TEXT_568 = ");";
  protected final String TEXT_569 = NL + "\t\t\t\t\t\t\tcolumnIndex_";
  protected final String TEXT_570 = " = excelDynamicUtil_";
  protected final String TEXT_571 = ".getDynamicColCount()+";
  protected final String TEXT_572 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_573 = NL + "\t\t\t\t\t\t\tcolumnIndex_";
  protected final String TEXT_574 = " = ";
  protected final String TEXT_575 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_576 = NL + "\t\t\t\t\txlsxTool_";
  protected final String TEXT_577 = ".setColAutoSize(columnIndex_";
  protected final String TEXT_578 = ");";
  protected final String TEXT_579 = NL + "\t\t\t\t}";
  protected final String TEXT_580 = NL + "\t\t\t\t}";
  protected final String TEXT_581 = NL + "    \t\t\tpublic void putValue_";
  protected final String TEXT_582 = "(final ";
  protected final String TEXT_583 = "Struct ";
  protected final String TEXT_584 = "," + NL + "    \t\t\t\tfinal org.talend.ExcelTool xlsxTool_";
  protected final String TEXT_585 = ") throws java.lang.Exception {";
  protected final String TEXT_586 = NL + "\t\t\t\t";
  protected final String TEXT_587 = "\t\t\t\t\t";
  protected final String TEXT_588 = "   \t\t\t\t" + NL + "\t    \t\t\t\tif(";
  protected final String TEXT_589 = ".";
  protected final String TEXT_590 = " != null) {" + NL + "    \t\t\t\t";
  protected final String TEXT_591 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_592 = ".addCellValue(";
  protected final String TEXT_593 = ".";
  protected final String TEXT_594 = ", ";
  protected final String TEXT_595 = ");";
  protected final String TEXT_596 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_597 = ".addCellValue(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_598 = ".";
  protected final String TEXT_599 = ")).toString());";
  protected final String TEXT_600 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_601 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_602 = ".addCellValue(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_603 = "), ";
  protected final String TEXT_604 = ", ";
  protected final String TEXT_605 = "));\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_606 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_607 = ".addCellValue(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_608 = ".";
  protected final String TEXT_609 = "), ";
  protected final String TEXT_610 = ", ";
  protected final String TEXT_611 = "));" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_612 = "\t\t" + NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_613 = ".addCellValue((";
  protected final String TEXT_614 = ").doubleValue());";
  protected final String TEXT_615 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_616 = ".addCellValue(";
  protected final String TEXT_617 = ".";
  protected final String TEXT_618 = ");";
  protected final String TEXT_619 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_620 = ".addCellValue(";
  protected final String TEXT_621 = ".";
  protected final String TEXT_622 = ");";
  protected final String TEXT_623 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_624 = ".addCellValue(Double.parseDouble(String.valueOf(";
  protected final String TEXT_625 = ".";
  protected final String TEXT_626 = ")));";
  protected final String TEXT_627 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_628 = ".addCellValue(String.valueOf(";
  protected final String TEXT_629 = ".";
  protected final String TEXT_630 = "));";
  protected final String TEXT_631 = NL + "\t\t\t\t\t\texcelDynamicUtil_";
  protected final String TEXT_632 = ".writeValuesToExcelFile(";
  protected final String TEXT_633 = ".";
  protected final String TEXT_634 = ", xlsxTool_";
  protected final String TEXT_635 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_636 = NL + "\t\t\t\t\t\t\texcelDynamicUtil_";
  protected final String TEXT_637 = ".autoDynamicColumnSize(xlsxTool_";
  protected final String TEXT_638 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_639 = NL + "\t    \t\t\t\t} else {" + NL + "\t    \t\t\t\t\txlsxTool_";
  protected final String TEXT_640 = ".addCellNullValue();" + NL + "\t    \t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_641 = NL + "\t\t\t\t}";
  protected final String TEXT_642 = NL + "\t\t\t\t}";
  protected final String TEXT_643 = NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tFileOutputExcelUtil_";
  protected final String TEXT_644 = " fileOutputExcelUtil_";
  protected final String TEXT_645 = "=new FileOutputExcelUtil_";
  protected final String TEXT_646 = "();";
  protected final String TEXT_647 = NL + "\t\tif (xlsxTool_";
  protected final String TEXT_648 = ".getStartRow() == 0){" + NL + "\t\t";
  protected final String TEXT_649 = NL + "\t\txlsxTool_";
  protected final String TEXT_650 = ".addRow();" + NL + "\t\t";
  protected final String TEXT_651 = NL + "\t\t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_652 = ".putHeaderValue_";
  protected final String TEXT_653 = "(xlsxTool_";
  protected final String TEXT_654 = ");";
  protected final String TEXT_655 = NL + "\t\txlsxTool_";
  protected final String TEXT_656 = ".addCellValue(\"";
  protected final String TEXT_657 = "\");" + NL + "\t\t";
  protected final String TEXT_658 = NL + "\t\tnb_line_";
  protected final String TEXT_659 = "++; " + NL + "\t\t";
  protected final String TEXT_660 = NL + "\t}" + NL + "\t\t";
  protected final String TEXT_661 = NL;

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
String cid = node.getUniqueName();
boolean version07 = ("true").equals(ElementParameterParser.getValue(node,"__VERSION_2007__"));
	
boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
String outStream = ElementParameterParser.getValue(node,"__STREAMNAME__");

String filename = ElementParameterParser.getValue(node, "__FILENAME__");
String sheetname = ElementParameterParser.getValue(node, "__SHEETNAME__");
boolean firstCellYAbsolute = ("true").equals(ElementParameterParser.getValue(node, "__FIRST_CELL_Y_ABSOLUTE__"));
String firstCellXStr = ElementParameterParser.getValue(node, "__FIRST_CELL_X__");
String firstCellYStr = ElementParameterParser.getValue(node, "__FIRST_CELL_Y__");
boolean keepCellFormating = ("true").equals(ElementParameterParser.getValue(node, "__KEEP_CELL_FORMATING__"));
String font = ElementParameterParser.getValue(node, "__FONT__");
boolean isSettingFont = font !=null && font.length()!=0;
boolean isDeleteEmptyFile = ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__").equals("true");
boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node, "__INCLUDEHEADER__"));
boolean isAppendFile = ("true").equals(ElementParameterParser.getValue(node, "__APPEND_FILE__" ));
boolean isAppendSheet = ("true").equals(ElementParameterParser.getValue(node, "__APPEND_SHEET__" ));

boolean flushOnRow=("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__" ));
String flushRowNum=ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__" );

int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}

String allColumnAutoSize = ElementParameterParser.getValue(node, "__IS_ALL_AUTO_SZIE__");
boolean isAllColumnAutoSize = (allColumnAutoSize!=null&&!("").equals(allColumnAutoSize))?("true").equals(allColumnAutoSize):false;
List<Map<String, String>> autoSizeList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__AUTO_SZIE_SETTING__");

String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER); 
Map<String,String> autColSizeMaping=new HashMap<String,String>();

List< ? extends IConnection> conns = node.getIncomingConnections();
IConnection conn = null;
if((conns == null) || (conns.size() < 1) || ((conn = conns.get(0)) == null)) {
	return "";
}

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    	List<IMetadataColumn> columns = metadata.getListColumns();
		boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
		boolean hasDynamic = false;
		int dynamic_index = 0;
		String datePattern = "\"dd-MM-yyyy\"";
		for(int i=0; columns!=null && i< columns.size(); i++) {
			IMetadataColumn column = columns.get(i);
	        if(!hasDynamic && column.getTalendType().equals("id_Dynamic")){
	            dynamic_index = i+1;
	            hasDynamic = true;
	            datePattern= column.getPattern();
	        }
	        if(isAllColumnAutoSize){
	        	autColSizeMaping.put(column.getLabel(),"true");
	        }else{
	        	autColSizeMaping.put(column.getLabel(),autoSizeList.get(i).get("IS_AUTO_SIZE"));
	        	
	        }
		}
		if(hasDynamic){
			
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
			if(!version07){
			
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
					if(isSettingFont){
					
    stringBuffer.append(TEXT_34);
    stringBuffer.append(font);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(datePattern );
    stringBuffer.append(TEXT_36);
    
					}else{
					
    stringBuffer.append(TEXT_37);
    stringBuffer.append(datePattern );
    stringBuffer.append(TEXT_38);
    
					}
					
    stringBuffer.append(TEXT_39);
    stringBuffer.append(advancedSeparator);
    stringBuffer.append(TEXT_40);
    
				if(isIncludeHeader){
				
    stringBuffer.append(TEXT_41);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn));
    stringBuffer.append(TEXT_42);
    
						if(firstCellYAbsolute){
						
    stringBuffer.append(TEXT_43);
    stringBuffer.append(firstCellYStr);
    stringBuffer.append(TEXT_44);
    
						}else{
						
    stringBuffer.append(TEXT_45);
    
						}
						
    stringBuffer.append(TEXT_46);
    
						for(int i=0; columns!=null && i< columns.size(); i++) {
							IMetadataColumn column = columns.get(i);
					        if(column.getTalendType().equals("id_Dynamic")){
					        
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_50);
    if (isSettingFont) {
    stringBuffer.append(TEXT_51);
    }
    stringBuffer.append(TEXT_52);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_53);
    
					        }else{
					        
    stringBuffer.append(TEXT_54);
    stringBuffer.append(i);
    if(i+1>dynamic_index){
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_57);
    if (isSettingFont) {
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    stringBuffer.append(i);
    if(i+1>dynamic_index){
    stringBuffer.append(TEXT_60);
    }
    stringBuffer.append(TEXT_61);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_66);
    
					        }
						}
						
    stringBuffer.append(TEXT_67);
    
				}
				
    stringBuffer.append(TEXT_68);
    stringBuffer.append(dynamic_index-1);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_69);
    stringBuffer.append(firstCellXStr);
    }
    stringBuffer.append(TEXT_70);
    if(isSettingFont){
    stringBuffer.append(TEXT_71);
    }
    stringBuffer.append(TEXT_72);
    stringBuffer.append(advancedSeparator);
    stringBuffer.append(TEXT_73);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_74);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_75);
    if(isSettingFont){
    stringBuffer.append(TEXT_76);
    }
    stringBuffer.append(TEXT_77);
    if(isSettingFont){
    stringBuffer.append(TEXT_78);
    }
    stringBuffer.append(TEXT_79);
    if(isSettingFont){
    stringBuffer.append(TEXT_80);
    }
    stringBuffer.append(TEXT_81);
    
			}else{
			
    stringBuffer.append(TEXT_82);
    
				if(isIncludeHeader){
				
    stringBuffer.append(TEXT_83);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn));
    stringBuffer.append(TEXT_84);
    
							if(!firstCellYAbsolute) {
							
    stringBuffer.append(TEXT_85);
    
							}
							
    stringBuffer.append(TEXT_86);
    
								for (int i = 0; i < columns.size(); i++) {
									IMetadataColumn column = columns.get(i);
									if(column.getTalendType().equals("id_Dynamic")){
									
    stringBuffer.append(TEXT_87);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_89);
    
									}else{
									
    stringBuffer.append(TEXT_90);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_91);
    
									}
								}
							if(!firstCellYAbsolute) {
							
    stringBuffer.append(TEXT_92);
    
							}
							
    stringBuffer.append(TEXT_93);
    
				}
				
    stringBuffer.append(TEXT_94);
    stringBuffer.append(datePattern);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(advancedSeparator);
    stringBuffer.append(TEXT_96);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_97);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_99);
    
			}
			
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    
		}
		
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    
    	if(!version07){//version judgement

    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
		if(!useStream){ // the part of the file path

    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    
			if(isAppendFile){

    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    
			}
			if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){

    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    }
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    }
    stringBuffer.append(TEXT_130);
    
			}
		}

    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(ElementParameterParser.getValue(node,"__ENCODING__") );
    stringBuffer.append(TEXT_136);
    
		if(useStream){ // the part of the output stream support

    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    
		}else{
			if(isAppendFile){

    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append( cid );
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
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_153);
    
			} else {

    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_157);
    
			}
		}

    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(sheetname );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(sheetname );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    if(!useStream && isAppendFile && !isAppendSheet){
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(sheetname );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(sheetname );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    }
    stringBuffer.append(TEXT_178);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(firstCellYStr);
    stringBuffer.append(TEXT_181);
    }else{
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    }
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(columns.size());
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(columns.size());
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_194);
    stringBuffer.append(firstCellXStr);
    }
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    if(isSettingFont){
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(font);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    }
    stringBuffer.append(TEXT_207);
    
    	for (int i = 0; i < columns.size(); i++) {
    		IMetadataColumn column = columns.get(i);
    		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    		if (javaType == JavaTypesManager.DATE || column.getTalendType().equals("id_Dynamic")){
    			String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    			if(pattern != null && pattern.trim().length() != 0){
    				if(isSettingFont){

    stringBuffer.append(TEXT_208);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_209);
    stringBuffer.append( cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_212);
    
					}else{

    stringBuffer.append(TEXT_213);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_214);
    stringBuffer.append( cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_216);
    	
					}
				}else{

    stringBuffer.append(TEXT_217);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    				}
			}
		
	    }

    stringBuffer.append(TEXT_220);
    
	int sizeColumns = columns.size();
	if(sizeColumns> schemaOptNum){//TD64

    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    
		if(hasDynamic){

    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    
		}
		for (int i = 0; i < sizeColumns; i++) {//TD128
			IMetadataColumn column = columns.get(i);
			if(i%schemaOptNum==0){//TD256

    stringBuffer.append(TEXT_227);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    
			}//TD256
			
			if(firstCellYAbsolute){

    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_238);
    
				if (isSettingFont) {

    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    
				}

    stringBuffer.append(TEXT_240);
    
			}else{

    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_245);
    
				if (isSettingFont) {

    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    
				}

    stringBuffer.append(TEXT_247);
    
			}

    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(column.getLabel().length());
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(column.getLabel().length());
    stringBuffer.append(TEXT_256);
    
			if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_257);
    
			}
		}//TD128
		
		if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){//TD512

    stringBuffer.append(TEXT_258);
    
		}//TD512
		
		boolean emptyMethod = true;
		
		for(int i=0;i<sizeColumns;i++){//TD1024
			IMetadataColumn column = columns.get(i);
			
			if(i%schemaOptNum==0){
				if(!isAllColumnAutoSize) {
					if(autoSizeList.size() == columns.size()){
						for(int j=0;(j<schemaOptNum) && (i+j<sizeColumns);j++) {
    						Map<String,String> tmp= autoSizeList.get(i+j);
    						if(("true").equals(tmp.get("IS_AUTO_SIZE")) && (!columns.get(i+j).getTalendType().equals("id_Dynamic"))){
    							emptyMethod = false;
    							break;
    						}
						}
					}
				} else {
					emptyMethod = false;
				}
				
				if(!emptyMethod) {

    stringBuffer.append(TEXT_259);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    
				}
			}
		if(!column.getTalendType().equals("id_Dynamic")){
			if(isAllColumnAutoSize){
				if(hasDynamic && i+1>dynamic_index){
				
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_267);
    
				}else{
				
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_270);
    
				}

    stringBuffer.append(TEXT_271);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_277);
    }else{
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_282);
    }
    stringBuffer.append(TEXT_283);
    
     		} else {
     			if(autoSizeList.size() == columns.size()){
    				Map<String,String> tmp= autoSizeList.get(i);
            		if(("true").equals(tmp.get("IS_AUTO_SIZE"))){
						if(hasDynamic && i+1>dynamic_index){
						
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_287);
    
						}else{
						
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_290);
    
						}

    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_295);
    
            		}
        		}
     		}
     	}
     		if(!emptyMethod && ((i+1)%schemaOptNum==0)){
     			emptyMethod = true;

    stringBuffer.append(TEXT_296);
    
     		}
     	}//TD1024
     	
     	if(!emptyMethod && (sizeColumns>0&&(sizeColumns%schemaOptNum)>0)){

    stringBuffer.append(TEXT_297);
    
     	}
     	
     	for(int i=0;i<sizeColumns;i++){//TD2048
			IMetadataColumn column = columns.get(i);
			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_298);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_300);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    
			}

    stringBuffer.append(TEXT_308);
    stringBuffer.append(TEXT_309);
    
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_310);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_311);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_312);
    
    				} 
    				
    stringBuffer.append(TEXT_313);
    
					//Detect the format required for the cell
					String jxlWriteType;
    				int staticWidth = 0;
    				boolean isNumber = false;
					if(javaType == JavaTypesManager.BOOLEAN){
						staticWidth=5;
						jxlWriteType="Boolean";
					}else if(javaType == JavaTypesManager.DATE){
						jxlWriteType="DateTime";
				    }else if(javaType == JavaTypesManager.STRING||
				    		 javaType == JavaTypesManager.CHARACTER||
				    		 javaType == JavaTypesManager.BYTE_ARRAY||
				    		 javaType == JavaTypesManager.LIST||
				    		 javaType == JavaTypesManager.OBJECT||
				    		 column.getTalendType().equals("id_Dynamic")||
				    		 (advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable()))
				    		 ){
				    	jxlWriteType="Label";
					}else{
						isNumber=true;
						jxlWriteType="Number";
					};
					if(hasDynamic && i+1>dynamic_index){
					
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_317);
    
					}else{
					
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_320);
    
					}
					if(!column.getTalendType().equals("id_Dynamic")){
   				
    stringBuffer.append(TEXT_321);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_322);
    if(keepCellFormating){
    stringBuffer.append(TEXT_323);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    }
    stringBuffer.append(TEXT_331);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(jxlWriteType);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    }else{
    stringBuffer.append(TEXT_339);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(jxlWriteType);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    }
    stringBuffer.append(TEXT_346);
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {
						staticWidth = pattern.trim().length();

    stringBuffer.append(TEXT_347);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_348);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_349);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_350);
    stringBuffer.append( cid);
    
					} else {
						if(javaType == JavaTypesManager.CHARACTER) {

    stringBuffer.append(TEXT_351);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_352);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_353);
    
						} else if(javaType == JavaTypesManager.OBJECT || javaType == JavaTypesManager.LIST){

    stringBuffer.append(TEXT_354);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_355);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_356);
    
						} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_357);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_358);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_359);
    
						} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_360);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_361);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_362);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_363);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_364);
     } else { 
    stringBuffer.append(TEXT_365);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_366);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_367);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_368);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_369);
     } 
    
						} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_370);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_371);
    
					}else {

    stringBuffer.append(TEXT_372);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_373);
    stringBuffer.append(column.getLabel() );
    				
					}
					if(font !=null && font.length()!=0){ 

    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    
					}
				}

    stringBuffer.append(TEXT_375);
    if(keepCellFormating && firstCellYAbsolute){
    stringBuffer.append(TEXT_376);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    
							}
							
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_384);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    
					if(isNumber){

    stringBuffer.append(TEXT_387);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    
					}else{

    stringBuffer.append(TEXT_398);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    
					}
					if(staticWidth ==0){

    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    
					}else{

    stringBuffer.append(TEXT_414);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(staticWidth);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    
					}
					}else{
					
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_430);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_433);
    stringBuffer.append(firstCellYAbsolute?firstCellXStr:"0");
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
    
						if("true".equalsIgnoreCase(autColSizeMaping.get(column.getLabel()))){
						
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(firstCellYAbsolute?firstCellXStr:"0");
    stringBuffer.append(TEXT_441);
    
						}
					}
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_442);
    
    				} 
    			
    
     		if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_443);
    
     		}
		}//TD2048
		
     	if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_444);
    
     	}

    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_448);
    
	}//TD64

    stringBuffer.append(TEXT_449);
    
if(!hasDynamic && isIncludeHeader){
	if(firstCellYAbsolute){

    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_451);
    stringBuffer.append(firstCellYStr);
    stringBuffer.append(TEXT_452);
    
	}else{

    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_454);
    
	}

    stringBuffer.append(TEXT_455);
    
	for (int i = 0; i < columns.size(); i++) {
		IMetadataColumn column = columns.get(i);
		if(sizeColumns > schemaOptNum){
        	if(i%schemaOptNum==0){
        		if(firstCellYAbsolute) {

    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_460);
    if (isSettingFont) {
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid );
    } else {
    stringBuffer.append(TEXT_462);
    }
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_464);
    
        		} else {

    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    if (isSettingFont) {
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid );
    } else {
    stringBuffer.append(TEXT_471);
    }
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    
        		}

        	}
        	
        	continue;
        }

    stringBuffer.append(TEXT_474);
    
		if(firstCellYAbsolute){

    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_476);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_479);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_480);
    
				if (isSettingFont) {

    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid );
    
				}

    stringBuffer.append(TEXT_482);
    
		}else{

    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_484);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_487);
    
				if (isSettingFont) {

    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid );
    
				}

    stringBuffer.append(TEXT_489);
    
		}

    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(column.getLabel().length());
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(column.getLabel().length());
    stringBuffer.append(TEXT_498);
    
	}

    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_500);
    
}

    stringBuffer.append(TEXT_501);
    	
		}else{ //version judgement /***excel 2007 xlsx*****/
			if(!useStream){

    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_504);
    
				if(isDeleteEmptyFile){

    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_508);
    
					if(isAppendFile){

    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_511);
    
					}
				}
			}

    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_514);
    	 
		if(flushOnRow && (useStream || !isAppendFile)){

    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(flushRowNum);
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_519);
    		
		}
		
		boolean recalculateFormula = "true".equals(ElementParameterParser.getValue(node,"__RECALCULATE_FORMULA__"));

    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_521);
    stringBuffer.append(sheetname);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(isAppendFile);
    stringBuffer.append(TEXT_524);
    stringBuffer.append(isAppendSheet);
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_526);
    stringBuffer.append(recalculateFormula);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(firstCellYAbsolute);
    stringBuffer.append(TEXT_529);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(firstCellYStr);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(keepCellFormating);
    stringBuffer.append(TEXT_532);
    if(!useStream){
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_535);
    }else{
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_537);
    }
    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(font);
    stringBuffer.append(TEXT_540);
    
		int sizeColumns = columns.size();
		if(sizeColumns> schemaOptNum){//TD1

    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_542);
    
			if(hasDynamic){

    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_546);
    
			}
    		for (int i = 0; isIncludeHeader && (i < sizeColumns); i++) {
    			IMetadataColumn column = columns.get(i);
    			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_547);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_549);
    
    			}

    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_551);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_552);
    
    			if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_553);
    
    			}
    		}
    		
    		if(isIncludeHeader && sizeColumns>0 && (sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_554);
    
    		}
    		
    		boolean emptyMethod = true;
    		for(int i=0;i<sizeColumns;i++){
    			IMetadataColumn column = columns.get(i);
    			if(i%schemaOptNum==0){
    				if(!isAllColumnAutoSize) {
    					if(autoSizeList.size() == columns.size()){
    						for(int j=0;(j<schemaOptNum) && (i+j<sizeColumns);j++) {
        						Map<String,String> tmp= autoSizeList.get(i+j);
        						if(("true").equals(tmp.get("IS_AUTO_SIZE")) && (!columns.get(i+j).getTalendType().equals("id_Dynamic"))){
        							emptyMethod = false;
        							break;
        						}
    						}
    					}
    				} else {
    					emptyMethod = false;
    				}
    				
    				if(!emptyMethod) {

    stringBuffer.append(TEXT_555);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_558);
        			
					}
    			}
    		if(!column.getTalendType().equals("id_Dynamic")){
    			if(isAllColumnAutoSize){
					if(hasDynamic && i+1>dynamic_index){
					
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_560);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_561);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_562);
    
					}else{
					
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_565);
    
					}

    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_568);
    
    			} else if(autoSizeList.size() == columns.size()) {
    				Map<String,String> tmp= autoSizeList.get(i);
            		if(("true").equals(tmp.get("IS_AUTO_SIZE"))){
						if(hasDynamic && i+1>dynamic_index){
						
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_571);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_572);
    
						}else{
						
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_574);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_575);
    
						}

    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_577);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_578);
    
            		}
    			}
    		}
    			if(!emptyMethod && ((i+1)%schemaOptNum==0)){
    				emptyMethod = true;

    stringBuffer.append(TEXT_579);
        			
    			}
    		}
    		if(!emptyMethod && (sizeColumns>0 && (sizeColumns%schemaOptNum)>0)){

    stringBuffer.append(TEXT_580);
        		
    		}
    		
    		for(int i=0;i<sizeColumns;i++){
    			IMetadataColumn column = columns.get(i);
    			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_581);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_582);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_583);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_585);
        			
    			}

    stringBuffer.append(TEXT_586);
    stringBuffer.append(TEXT_587);
    
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_588);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_589);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_590);
    
    				} 
    				
    
					if(!column.getTalendType().equals("id_Dynamic")){
					
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {

    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_592);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_593);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_594);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_595);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_597);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_598);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_599);
    
					} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_600);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_601);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_602);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_603);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_604);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_605);
     } else { 
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_608);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_609);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_610);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_611);
     } 
    
					} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_613);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_614);
    
					}else if (javaType == JavaTypesManager.BOOLEAN){

    stringBuffer.append(TEXT_615);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_617);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_618);
    
					}else if (javaType == JavaTypesManager.DOUBLE){

    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_620);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_621);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_622);
    					}else if(JavaTypesManager.isNumberType(javaType)){

    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_625);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_626);
    
					}else{	

    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_628);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_629);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_630);
    				
					}
					}else{
					
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_632);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_633);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_635);
    
						if("true".equalsIgnoreCase(autColSizeMaping.get(column.getLabel()))){
						
    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_637);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_638);
    
						}
					}
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_640);
    
    				} 
    				
        			
    			if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_641);
        			
    			}
    		}
    		
    		if(sizeColumns>0 && (sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_642);
        		
    		}

    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_646);
    
		}//TD1
		
		if(!hasDynamic && isIncludeHeader){
			
			if(!firstCellYAbsolute) {
		
    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_648);
    
			}
		
    stringBuffer.append(TEXT_649);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_650);
    
			for (int i = 0; i < columns.size(); i++) {
				IMetadataColumn column = columns.get(i);
				if(sizeColumns > schemaOptNum){
        			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_651);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_652);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_653);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_654);
    
        			}
        			continue;
        		}
		
    stringBuffer.append(TEXT_655);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_656);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_657);
    
			}
		
    stringBuffer.append(TEXT_658);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_659);
    
			if(!firstCellYAbsolute) {
		
    stringBuffer.append(TEXT_660);
    
			}
		}	
		
    
		}
    }
}

    stringBuffer.append(TEXT_661);
    return stringBuffer.toString();
  }
}
