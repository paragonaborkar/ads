package org.talend.designer.codegen.translators.common;

import java.util.List;
import java.util.Set;
import org.talend.components.api.component.ComponentDefinition;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.core.generic.model.Component;
import org.talend.core.model.utils.NodeUtil;

public class Handle_rejects_startJava
{
  protected static String nl;
  public static synchronized Handle_rejects_startJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Handle_rejects_startJava result = new Handle_rejects_startJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "            boolean ";
  protected final String TEXT_3 = " = false;" + NL + "            routines.system.Dynamic ";
  protected final String TEXT_4 = " = new routines.system.Dynamic();";
  protected final String TEXT_5 = NL + "        org.talend.daikon.di.DiOutgoingSchemaEnforcer ";
  protected final String TEXT_6 = " = org.talend.daikon.di.EnforcerCreator.createOutgoingEnforcer(";
  protected final String TEXT_7 = ", ";
  protected final String TEXT_8 = ");" + NL + "" + NL + "        // Create a reusable factory that converts the output of the reader to an IndexedRecord." + NL + "        org.talend.daikon.avro.converter.IndexedRecordConverter<Object, ? extends org.apache.avro.generic.IndexedRecord> ";
  protected final String TEXT_9 = " = null;";
  protected final String TEXT_10 = NL + "        // Construct the factory once when the first data arrives." + NL + "        if (";
  protected final String TEXT_11 = " == null) {";
  protected final String TEXT_12 = NL + "            ";
  protected final String TEXT_13 = " = (org.talend.daikon.avro.converter.IndexedRecordConverter<Object, ? extends org.apache.avro.generic.IndexedRecord>)" + NL + "                    new org.talend.daikon.avro.AvroRegistry()" + NL + "                            .createIndexedRecordConverter(";
  protected final String TEXT_14 = ".getClass());" + NL + "        }" + NL + "" + NL + "        // Enforce the outgoing schema on the input.";
  protected final String TEXT_15 = NL + "        ";
  protected final String TEXT_16 = ".setWrapped(";
  protected final String TEXT_17 = ".convertToAvro(";
  protected final String TEXT_18 = "));";
  protected final String TEXT_19 = NL + "            if (!";
  protected final String TEXT_20 = ") {" + NL + "                org.apache.avro.Schema dynSchema_";
  protected final String TEXT_21 = " = ((org.talend.daikon.di.DiOutgoingDynamicSchemaEnforcer) ";
  protected final String TEXT_22 = ").getDynamicFieldsSchema();" + NL + "                for (org.apache.avro.Schema.Field dynamicField_";
  protected final String TEXT_23 = " : dynSchema_";
  protected final String TEXT_24 = ".getFields()){" + NL + "                    routines.system.DynamicMetadata dynamicMetadata_";
  protected final String TEXT_25 = " = new routines.system.DynamicMetadata();" + NL + "                    // set name and db name" + NL + "                    dynamicMetadata_";
  protected final String TEXT_26 = ".setName(dynamicField_";
  protected final String TEXT_27 = ".name());" + NL + "                    dynamicMetadata_";
  protected final String TEXT_28 = ".setDbName(dynamicField_";
  protected final String TEXT_29 = ".name());" + NL + "                    // set type" + NL + "                    String talendType_";
  protected final String TEXT_30 = " = null;" + NL + "                    org.apache.avro.Schema.Type type_";
  protected final String TEXT_31 = " = dynamicField_";
  protected final String TEXT_32 = ".schema().getType();" + NL + "                    if(type_";
  protected final String TEXT_33 = "  == org.apache.avro.Schema.Type.UNION){" + NL + "                    \tjava.util.List<org.apache.avro.Schema> fieldTypes_";
  protected final String TEXT_34 = " = dynamicField_";
  protected final String TEXT_35 = ".schema().getTypes();" + NL + "                    \tfor(org.apache.avro.Schema fieldType_";
  protected final String TEXT_36 = ":fieldTypes_";
  protected final String TEXT_37 = "){" + NL + "                    \t\tif(fieldType_";
  protected final String TEXT_38 = ".getType() == org.apache.avro.Schema.Type.NULL){" + NL + "                    \t\t\tdynamicMetadata_";
  protected final String TEXT_39 = ".setNullable(true);" + NL + "                    \t\t}else{" + NL + "                    \t\t\ttype_";
  protected final String TEXT_40 = " = fieldType_";
  protected final String TEXT_41 = ".getType();" + NL + "                    \t\t}" + NL + "                    \t}" + NL + "\t\t\t\t\t}" + NL + "                    if (type_";
  protected final String TEXT_42 = " == org.apache.avro.Schema.Type.ARRAY) {" + NL + "                        talendType_";
  protected final String TEXT_43 = " = \"";
  protected final String TEXT_44 = "\";" + NL + "                    } else if (type_";
  protected final String TEXT_45 = " == org.apache.avro.Schema.Type.BOOLEAN) {" + NL + "                        talendType_";
  protected final String TEXT_46 = " = \"";
  protected final String TEXT_47 = "\";" + NL + "                    } else if (type_";
  protected final String TEXT_48 = " == org.apache.avro.Schema.Type.BYTES) {" + NL + "                        talendType_";
  protected final String TEXT_49 = " = \"";
  protected final String TEXT_50 = "\";" + NL + "                    } else if (type_";
  protected final String TEXT_51 = " == org.apache.avro.Schema.Type.FIXED) {" + NL + "                        talendType_";
  protected final String TEXT_52 = " = \"";
  protected final String TEXT_53 = "\";" + NL + "                    } else if (type_";
  protected final String TEXT_54 = " == org.apache.avro.Schema.Type.DOUBLE) {" + NL + "                        talendType_";
  protected final String TEXT_55 = " = \"";
  protected final String TEXT_56 = "\";" + NL + "                    } else if (type_";
  protected final String TEXT_57 = " == org.apache.avro.Schema.Type.FLOAT) {" + NL + "                        talendType_";
  protected final String TEXT_58 = " = \"";
  protected final String TEXT_59 = "\";" + NL + "                    } else if (type_";
  protected final String TEXT_60 = " == org.apache.avro.Schema.Type.INT) {" + NL + "                        talendType_";
  protected final String TEXT_61 = " = \"";
  protected final String TEXT_62 = "\";" + NL + "                    } else if (type_";
  protected final String TEXT_63 = " == org.apache.avro.Schema.Type.LONG) {" + NL + "                    \tString pattern_";
  protected final String TEXT_64 = " = dynamicField_";
  protected final String TEXT_65 = ".getProp(org.talend.daikon.avro.SchemaConstants.TALEND_COLUMN_PATTERN);" + NL + "                    \tif(pattern_";
  protected final String TEXT_66 = "!=null && !pattern_";
  protected final String TEXT_67 = ".trim().isEmpty()){" + NL + "                    \t\ttalendType_";
  protected final String TEXT_68 = " = \"";
  protected final String TEXT_69 = "\";" + NL + "                    \t\tdynamicMetadata_";
  protected final String TEXT_70 = ".setFormat(pattern_";
  protected final String TEXT_71 = ");" + NL + "                    \t}else{" + NL + "                    \t\ttalendType_";
  protected final String TEXT_72 = " = \"";
  protected final String TEXT_73 = "\";" + NL + "                    \t}" + NL + "                    } else if (type_";
  protected final String TEXT_74 = " == org.apache.avro.Schema.Type.ENUM) {" + NL + "                        talendType_";
  protected final String TEXT_75 = " = \"";
  protected final String TEXT_76 = "\";" + NL + "                    } else if (type_";
  protected final String TEXT_77 = " == org.apache.avro.Schema.Type.STRING) {" + NL + "                        talendType_";
  protected final String TEXT_78 = " = \"";
  protected final String TEXT_79 = "\";" + NL + "                    }" + NL + "                    dynamicMetadata_";
  protected final String TEXT_80 = ".setType(talendType_";
  protected final String TEXT_81 = ");" + NL + "                    // set logical type" + NL + "                    org.apache.avro.Schema unwrappedSchema_";
  protected final String TEXT_82 = " = org.talend.daikon.avro.AvroUtils.unwrapIfNullable(dynamicField_";
  protected final String TEXT_83 = ".schema());" + NL + "                    String logicalType_";
  protected final String TEXT_84 = " = org.talend.daikon.avro.LogicalTypeUtils.getLogicalTypeName(unwrappedSchema_";
  protected final String TEXT_85 = ");" + NL + "                    dynamicMetadata_";
  protected final String TEXT_86 = ".setLogicalType(logicalType_";
  protected final String TEXT_87 = ");" + NL + "                    // set length" + NL + "                    Object length_";
  protected final String TEXT_88 = " = dynamicField_";
  protected final String TEXT_89 = ".getProp(org.talend.daikon.avro.SchemaConstants.TALEND_COLUMN_DB_LENGTH);" + NL + "                    if(length_";
  protected final String TEXT_90 = " != null){" + NL + "                    \tdynamicMetadata_";
  protected final String TEXT_91 = ".setLength(Integer.parseInt(String.valueOf(length_";
  protected final String TEXT_92 = ")));" + NL + "                    }" + NL + "                    // set precision" + NL + "                    Object precision_";
  protected final String TEXT_93 = " = dynamicField_";
  protected final String TEXT_94 = ".getProp(org.talend.daikon.avro.SchemaConstants.TALEND_COLUMN_PRECISION); " + NL + "                    if(precision_";
  protected final String TEXT_95 = " != null){" + NL + "\t\t\t\t\t\tdynamicMetadata_";
  protected final String TEXT_96 = ".setPrecision(Integer.parseInt(String.valueOf(precision_";
  protected final String TEXT_97 = ")));" + NL + "                    } " + NL + "                    // add dynamic field metadata to dynamic variable";
  protected final String TEXT_98 = NL + "                    ";
  protected final String TEXT_99 = ".metadatas.add(dynamicMetadata_";
  protected final String TEXT_100 = ");" + NL + "                }" + NL + "                initDyn_";
  protected final String TEXT_101 = " = true;" + NL + "            }";
  protected final String TEXT_102 = NL + "            ";
  protected final String TEXT_103 = ".clearColumnValues();";
  protected final String TEXT_104 = NL + "                java.util.Map<String, Object> dynamicValue_";
  protected final String TEXT_105 = " = (java.util.Map<String, Object>) ";
  protected final String TEXT_106 = ".get(";
  protected final String TEXT_107 = ");" + NL + "                for (java.util.Map.Entry<String, Object> dynamicValueEntry_";
  protected final String TEXT_108 = " : dynamicValue_";
  protected final String TEXT_109 = ".entrySet()) {";
  protected final String TEXT_110 = NL + "                    ";
  protected final String TEXT_111 = ".setColumnValue(";
  protected final String TEXT_112 = ".getIndex(dynamicValueEntry_";
  protected final String TEXT_113 = ".getKey()), dynamicValueEntry_";
  protected final String TEXT_114 = ".getValue());" + NL + "                }";
  protected final String TEXT_115 = NL + "                ";
  protected final String TEXT_116 = ".";
  protected final String TEXT_117 = " = ";
  protected final String TEXT_118 = ";";
  protected final String TEXT_119 = NL + "\t\t\t\tObject columnValue_";
  protected final String TEXT_120 = "_";
  protected final String TEXT_121 = " = ";
  protected final String TEXT_122 = ".get(";
  protected final String TEXT_123 = ");" + NL + "                if (columnValue_";
  protected final String TEXT_124 = "_";
  protected final String TEXT_125 = " == null) {";
  protected final String TEXT_126 = NL + "                     ";
  protected final String TEXT_127 = ".";
  protected final String TEXT_128 = " = ";
  protected final String TEXT_129 = ";" + NL + "                } else {";
  protected final String TEXT_130 = NL + "                        ";
  protected final String TEXT_131 = ".";
  protected final String TEXT_132 = " = String.valueOf(columnValue_";
  protected final String TEXT_133 = "_";
  protected final String TEXT_134 = ");";
  protected final String TEXT_135 = NL + "                        ";
  protected final String TEXT_136 = ".";
  protected final String TEXT_137 = " = String.valueOf(columnValue_";
  protected final String TEXT_138 = "_";
  protected final String TEXT_139 = ").charAt(0);";
  protected final String TEXT_140 = NL + "                    \t";
  protected final String TEXT_141 = ".";
  protected final String TEXT_142 = " = ParserUtils.parseTo_Document(String.valueOf(columnValue_";
  protected final String TEXT_143 = "_";
  protected final String TEXT_144 = "));" + NL + "                    \t";
  protected final String TEXT_145 = NL + "                        ";
  protected final String TEXT_146 = ".";
  protected final String TEXT_147 = " = (";
  protected final String TEXT_148 = ") (columnValue_";
  protected final String TEXT_149 = "_";
  protected final String TEXT_150 = ");";
  protected final String TEXT_151 = NL + "                }";
  protected final String TEXT_152 = NL + "if (writer_";
  protected final String TEXT_153 = " instanceof org.talend.components.api.component.runtime.WriterWithFeedback<?, ?, ?>) {";
  protected final String TEXT_154 = NL + "\t// Handle rejects after close" + NL + "    java.util.Iterator<?> outgoingRejectRecords_";
  protected final String TEXT_155 = " = ((org.talend.components.api.component.runtime.WriterWithFeedback<?, ?, ?>)writer_";
  protected final String TEXT_156 = ").getRejectedWrites().iterator();";
  protected final String TEXT_157 = NL + "    ";
  protected final String TEXT_158 = " = null;" + NL + "    while (outgoingRejectRecords_";
  protected final String TEXT_159 = ".hasNext()) {";
  protected final String TEXT_160 = NL + "        ";
  protected final String TEXT_161 = " = new ";
  protected final String TEXT_162 = "Struct();" + NL + "        Object outgoingReject_";
  protected final String TEXT_163 = " = outgoingRejectRecords_";
  protected final String TEXT_164 = ".next();";
  protected final String TEXT_165 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    

/**
 * Utility for generating code that can turn an IndexedRecording coming from a
 * generic component into a rowStruct expected by the Studio.
 */
class IndexedRecordToRowStructGenerator {

    /** A unique tag for generating code variables, usually based on the cid
     *  of the node. */
    private final String cid;

    /** The columns in the rowStruct to generate. */
    private final List<IMetadataColumn> columns;

    /** The connection that we're generating code for. */
    private final IConnection connection;

    /** If there is a dynamic column, its name.  Null if none. */
    private final String dynamicColName;

    /** Variable names generated in code used by this utility. */
    private final String codeVarSchemaEnforcer;
    private final String codeVarIsDynamicInitialized;
    private final String codeVarDynamic;
    private final String codeVarIndexedRecordAdapter;

    public IndexedRecordToRowStructGenerator(String cid, IConnection connection) {
        this(cid, connection, connection.getMetadataTable().getListColumns());
    }

    public IndexedRecordToRowStructGenerator(String cid, IConnection connection, List<IMetadataColumn> columns) {
        this.cid = cid;
        this.connection = connection;
        this.columns = columns;

        String tmpDynamicColName = null;
        for (IMetadataColumn column : columns) {
            if (column.getTalendType().equals("id_Dynamic")) {
                tmpDynamicColName = column.getLabel();
                break;
            }
        }
        dynamicColName = tmpDynamicColName;

        this.codeVarSchemaEnforcer = "current_" + cid;
        this.codeVarIsDynamicInitialized = "initDyn_" + cid;
        this.codeVarDynamic = "dynamic_" + cid;
        this.codeVarIndexedRecordAdapter = "factory_" + cid;
    }

    public IConnection getConnection() {
        return connection;
    }

    /**
     * Generate code that declares and initializes the variables that are used
     * in the code generated by this utility.
     */
    public void generateInitialVariables(String codeVarSchemaToEnforce, boolean dynamicByPosition) {
        if (dynamicColName != null) {
            
    stringBuffer.append(TEXT_2);
    stringBuffer.append(codeVarIsDynamicInitialized);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_4);
    
        }

        
    stringBuffer.append(TEXT_5);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(codeVarSchemaToEnforce);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(dynamicByPosition);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(codeVarIndexedRecordAdapter);
    stringBuffer.append(TEXT_9);
    
    }

    /**
     * Generate code that copies data from the IndexedRecord to the rowStruct.
     *
     * @param codeVarIndexedRecord the name of the variable that contains the
     *    IndexedRecord.
     * @param codeVarRowStruct the name of the variable that contains the
     *    rowStruct.
     */
    public void generateConvertRecord(String codeVarIndexedRecord, String codeVarRowStruct) {
        generateConvertRecord(codeVarIndexedRecord, codeVarRowStruct, columns);
    }

    /**
     * Generate code that copies data from the IndexedRecord to the rowStruct.
     *
     * @param codeVarIndexedRecord the name of the variable that contains the
     *    IndexedRecord.
     * @param codeVarRowStruct the name of the variable that contains the
     *    rowStruct.
     * @param columnsToGenerate the list of columns in the rowStruct to generate
     *    code for.
     */
    public void generateConvertRecord(String codeVarIndexedRecord, String codeVarRowStruct, List<IMetadataColumn> columnsToGenerate) {
        
    stringBuffer.append(TEXT_10);
    stringBuffer.append(codeVarIndexedRecordAdapter);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(codeVarIndexedRecordAdapter);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(codeVarIndexedRecord);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(codeVarIndexedRecordAdapter);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(codeVarIndexedRecord);
    stringBuffer.append(TEXT_18);
    

        if (dynamicColName != null) {
            
    stringBuffer.append(TEXT_19);
    stringBuffer.append(codeVarIsDynamicInitialized);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(JavaTypesManager.LIST.getId());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(JavaTypesManager.BOOLEAN.getId());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(JavaTypesManager.BYTE_ARRAY.getId());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(JavaTypesManager.BYTE_ARRAY.getId());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(JavaTypesManager.DOUBLE.getId());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(JavaTypesManager.FLOAT.getId());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(JavaTypesManager.INTEGER.getId());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(JavaTypesManager.DATE.getId());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(JavaTypesManager.LONG.getId());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(JavaTypesManager.STRING.getId());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(JavaTypesManager.STRING.getId());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_103);
    
        }

        for (int i = 0; i < columnsToGenerate.size(); i++) {
            IMetadataColumn column = columnsToGenerate.get(i);
            String columnName = column.getLabel();
            JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
            String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
            if (columnName.equals(dynamicColName)) {
                
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(dynamicColName);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_118);
    
            } else {
                
    stringBuffer.append(TEXT_119);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_129);
    
                    if (javaType == JavaTypesManager.STRING) {
                        
    stringBuffer.append(TEXT_130);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    
                    } else if (javaType == JavaTypesManager.CHARACTER) {
                        
    stringBuffer.append(TEXT_135);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    
                    } else if("id_Document".equals(column.getTalendType())){
                    	
    stringBuffer.append(TEXT_140);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    
                    } else  {
                        
    stringBuffer.append(TEXT_145);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    
                    }
                    
    stringBuffer.append(TEXT_151);
    
            }
        }
    }

}

    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
Component component = (Component)node.getComponent();
ComponentDefinition def = component.getComponentDefinition();

IndexedRecordToRowStructGenerator rejectIrToRow = null;

List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
if (outgoingConns!=null){
   for (int i = 0; i < outgoingConns.size(); i++) {
       IConnection outgoingConn = outgoingConns.get(i);
       if ("REJECT".equals(outgoingConn.getConnectorName())) {
           rejectIrToRow = new IndexedRecordToRowStructGenerator(cid + "OutReject",
                   outgoingConn);
       }
   }
}


    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    
if (rejectIrToRow != null) {

    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(rejectIrToRow.getConnection().getName());
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(rejectIrToRow.getConnection().getName());
    stringBuffer.append(TEXT_161);
    stringBuffer.append(rejectIrToRow.getConnection().getName() );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    
            rejectIrToRow.generateConvertRecord("outgoingReject_" + cid, rejectIrToRow.getConnection().getName());
        
    
	// while finished in handle_rejects_end
}
// if finished in handle_rejects_end

    stringBuffer.append(TEXT_165);
    return stringBuffer.toString();
  }
}
