package org.talend.designer.codegen.translators.generic.component;

import org.talend.designer.core.generic.model.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import org.talend.components.api.component.ComponentDefinition;
import org.talend.components.api.component.ConnectorTopology;
import org.talend.components.api.container.RuntimeContainer;
import org.talend.components.api.properties.ComponentProperties;
import org.talend.components.api.properties.ComponentReferenceProperties;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.EParameterFieldType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.process.INode;
import org.talend.core.model.utils.TalendTextUtils;
import org.talend.daikon.NamedThing;
import org.talend.daikon.properties.property.Property;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.NodeUtil;
import org.talend.designer.core.generic.constants.IGenericConstants;

public class ComponentBegin
{
  protected static String nl;
  public static synchronized ComponentBegin create(String lineSeparator)
  {
    nl = lineSeparator;
    ComponentBegin result = new ComponentBegin();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "            boolean ";
  protected final String TEXT_2 = " = false;" + NL + "            routines.system.Dynamic ";
  protected final String TEXT_3 = " = new routines.system.Dynamic();";
  protected final String TEXT_4 = NL + "        org.talend.daikon.di.DiOutgoingSchemaEnforcer ";
  protected final String TEXT_5 = " = org.talend.daikon.di.EnforcerCreator.createOutgoingEnforcer(";
  protected final String TEXT_6 = ", ";
  protected final String TEXT_7 = ");" + NL + "" + NL + "        // Create a reusable factory that converts the output of the reader to an IndexedRecord." + NL + "        org.talend.daikon.avro.converter.IndexedRecordConverter<Object, ? extends org.apache.avro.generic.IndexedRecord> ";
  protected final String TEXT_8 = " = null;";
  protected final String TEXT_9 = NL + "        // Construct the factory once when the first data arrives." + NL + "        if (";
  protected final String TEXT_10 = " == null) {";
  protected final String TEXT_11 = NL + "            ";
  protected final String TEXT_12 = " = (org.talend.daikon.avro.converter.IndexedRecordConverter<Object, ? extends org.apache.avro.generic.IndexedRecord>)" + NL + "                    new org.talend.daikon.avro.AvroRegistry()" + NL + "                            .createIndexedRecordConverter(";
  protected final String TEXT_13 = ".getClass());" + NL + "        }" + NL + "" + NL + "        // Enforce the outgoing schema on the input.";
  protected final String TEXT_14 = NL + "        ";
  protected final String TEXT_15 = ".setWrapped(";
  protected final String TEXT_16 = ".convertToAvro(";
  protected final String TEXT_17 = "));";
  protected final String TEXT_18 = NL + "            if (!";
  protected final String TEXT_19 = ") {" + NL + "                org.apache.avro.Schema dynSchema_";
  protected final String TEXT_20 = " = ((org.talend.daikon.di.DiOutgoingDynamicSchemaEnforcer) ";
  protected final String TEXT_21 = ").getDynamicFieldsSchema();" + NL + "                for (org.apache.avro.Schema.Field dynamicField_";
  protected final String TEXT_22 = " : dynSchema_";
  protected final String TEXT_23 = ".getFields()){" + NL + "                    routines.system.DynamicMetadata dynamicMetadata_";
  protected final String TEXT_24 = " = new routines.system.DynamicMetadata();" + NL + "                    // set name and db name" + NL + "                    dynamicMetadata_";
  protected final String TEXT_25 = ".setName(dynamicField_";
  protected final String TEXT_26 = ".name());" + NL + "                    dynamicMetadata_";
  protected final String TEXT_27 = ".setDbName(dynamicField_";
  protected final String TEXT_28 = ".name());" + NL + "                    // set type" + NL + "                    String talendType_";
  protected final String TEXT_29 = " = null;" + NL + "                    org.apache.avro.Schema.Type type_";
  protected final String TEXT_30 = " = dynamicField_";
  protected final String TEXT_31 = ".schema().getType();" + NL + "                    if(type_";
  protected final String TEXT_32 = "  == org.apache.avro.Schema.Type.UNION){" + NL + "                    \tjava.util.List<org.apache.avro.Schema> fieldTypes_";
  protected final String TEXT_33 = " = dynamicField_";
  protected final String TEXT_34 = ".schema().getTypes();" + NL + "                    \tfor(org.apache.avro.Schema fieldType_";
  protected final String TEXT_35 = ":fieldTypes_";
  protected final String TEXT_36 = "){" + NL + "                    \t\tif(fieldType_";
  protected final String TEXT_37 = ".getType() == org.apache.avro.Schema.Type.NULL){" + NL + "                    \t\t\tdynamicMetadata_";
  protected final String TEXT_38 = ".setNullable(true);" + NL + "                    \t\t}else{" + NL + "                    \t\t\ttype_";
  protected final String TEXT_39 = " = fieldType_";
  protected final String TEXT_40 = ".getType();" + NL + "                    \t\t}" + NL + "                    \t}" + NL + "\t\t\t\t\t}" + NL + "                    if (type_";
  protected final String TEXT_41 = " == org.apache.avro.Schema.Type.ARRAY) {" + NL + "                        talendType_";
  protected final String TEXT_42 = " = \"";
  protected final String TEXT_43 = "\";" + NL + "                    } else if (type_";
  protected final String TEXT_44 = " == org.apache.avro.Schema.Type.BOOLEAN) {" + NL + "                        talendType_";
  protected final String TEXT_45 = " = \"";
  protected final String TEXT_46 = "\";" + NL + "                    } else if (type_";
  protected final String TEXT_47 = " == org.apache.avro.Schema.Type.BYTES) {" + NL + "                        talendType_";
  protected final String TEXT_48 = " = \"";
  protected final String TEXT_49 = "\";" + NL + "                    } else if (type_";
  protected final String TEXT_50 = " == org.apache.avro.Schema.Type.FIXED) {" + NL + "                        talendType_";
  protected final String TEXT_51 = " = \"";
  protected final String TEXT_52 = "\";" + NL + "                    } else if (type_";
  protected final String TEXT_53 = " == org.apache.avro.Schema.Type.DOUBLE) {" + NL + "                        talendType_";
  protected final String TEXT_54 = " = \"";
  protected final String TEXT_55 = "\";" + NL + "                    } else if (type_";
  protected final String TEXT_56 = " == org.apache.avro.Schema.Type.FLOAT) {" + NL + "                        talendType_";
  protected final String TEXT_57 = " = \"";
  protected final String TEXT_58 = "\";" + NL + "                    } else if (type_";
  protected final String TEXT_59 = " == org.apache.avro.Schema.Type.INT) {" + NL + "                        talendType_";
  protected final String TEXT_60 = " = \"";
  protected final String TEXT_61 = "\";" + NL + "                    } else if (type_";
  protected final String TEXT_62 = " == org.apache.avro.Schema.Type.LONG) {" + NL + "                    \tString pattern_";
  protected final String TEXT_63 = " = dynamicField_";
  protected final String TEXT_64 = ".getProp(org.talend.daikon.avro.SchemaConstants.TALEND_COLUMN_PATTERN);" + NL + "                    \tif(pattern_";
  protected final String TEXT_65 = "!=null && !pattern_";
  protected final String TEXT_66 = ".trim().isEmpty()){" + NL + "                    \t\ttalendType_";
  protected final String TEXT_67 = " = \"";
  protected final String TEXT_68 = "\";" + NL + "                    \t\tdynamicMetadata_";
  protected final String TEXT_69 = ".setFormat(pattern_";
  protected final String TEXT_70 = ");" + NL + "                    \t}else{" + NL + "                    \t\ttalendType_";
  protected final String TEXT_71 = " = \"";
  protected final String TEXT_72 = "\";" + NL + "                    \t}" + NL + "                    } else if (type_";
  protected final String TEXT_73 = " == org.apache.avro.Schema.Type.ENUM) {" + NL + "                        talendType_";
  protected final String TEXT_74 = " = \"";
  protected final String TEXT_75 = "\";" + NL + "                    } else if (type_";
  protected final String TEXT_76 = " == org.apache.avro.Schema.Type.STRING) {" + NL + "                        talendType_";
  protected final String TEXT_77 = " = \"";
  protected final String TEXT_78 = "\";" + NL + "                    }" + NL + "                    dynamicMetadata_";
  protected final String TEXT_79 = ".setType(talendType_";
  protected final String TEXT_80 = ");" + NL + "                    // set logical type" + NL + "                    org.apache.avro.Schema unwrappedSchema_";
  protected final String TEXT_81 = " = org.talend.daikon.avro.AvroUtils.unwrapIfNullable(dynamicField_";
  protected final String TEXT_82 = ".schema());" + NL + "                    String logicalType_";
  protected final String TEXT_83 = " = org.talend.daikon.avro.LogicalTypeUtils.getLogicalTypeName(unwrappedSchema_";
  protected final String TEXT_84 = ");" + NL + "                    dynamicMetadata_";
  protected final String TEXT_85 = ".setLogicalType(logicalType_";
  protected final String TEXT_86 = ");" + NL + "                    // set length" + NL + "                    Object length_";
  protected final String TEXT_87 = " = dynamicField_";
  protected final String TEXT_88 = ".getProp(org.talend.daikon.avro.SchemaConstants.TALEND_COLUMN_DB_LENGTH);" + NL + "                    if(length_";
  protected final String TEXT_89 = " != null){" + NL + "                    \tdynamicMetadata_";
  protected final String TEXT_90 = ".setLength(Integer.parseInt(String.valueOf(length_";
  protected final String TEXT_91 = ")));" + NL + "                    }" + NL + "                    // set precision" + NL + "                    Object precision_";
  protected final String TEXT_92 = " = dynamicField_";
  protected final String TEXT_93 = ".getProp(org.talend.daikon.avro.SchemaConstants.TALEND_COLUMN_PRECISION); " + NL + "                    if(precision_";
  protected final String TEXT_94 = " != null){" + NL + "\t\t\t\t\t\tdynamicMetadata_";
  protected final String TEXT_95 = ".setPrecision(Integer.parseInt(String.valueOf(precision_";
  protected final String TEXT_96 = ")));" + NL + "                    } " + NL + "                    // add dynamic field metadata to dynamic variable";
  protected final String TEXT_97 = NL + "                    ";
  protected final String TEXT_98 = ".metadatas.add(dynamicMetadata_";
  protected final String TEXT_99 = ");" + NL + "                }" + NL + "                initDyn_";
  protected final String TEXT_100 = " = true;" + NL + "            }";
  protected final String TEXT_101 = NL + "            ";
  protected final String TEXT_102 = ".clearColumnValues();";
  protected final String TEXT_103 = NL + "                java.util.Map<String, Object> dynamicValue_";
  protected final String TEXT_104 = " = (java.util.Map<String, Object>) ";
  protected final String TEXT_105 = ".get(";
  protected final String TEXT_106 = ");" + NL + "                for (java.util.Map.Entry<String, Object> dynamicValueEntry_";
  protected final String TEXT_107 = " : dynamicValue_";
  protected final String TEXT_108 = ".entrySet()) {";
  protected final String TEXT_109 = NL + "                    ";
  protected final String TEXT_110 = ".setColumnValue(";
  protected final String TEXT_111 = ".getIndex(dynamicValueEntry_";
  protected final String TEXT_112 = ".getKey()), dynamicValueEntry_";
  protected final String TEXT_113 = ".getValue());" + NL + "                }";
  protected final String TEXT_114 = NL + "                ";
  protected final String TEXT_115 = ".";
  protected final String TEXT_116 = " = ";
  protected final String TEXT_117 = ";";
  protected final String TEXT_118 = NL + "\t\t\t\tObject columnValue_";
  protected final String TEXT_119 = "_";
  protected final String TEXT_120 = " = ";
  protected final String TEXT_121 = ".get(";
  protected final String TEXT_122 = ");" + NL + "                if (columnValue_";
  protected final String TEXT_123 = "_";
  protected final String TEXT_124 = " == null) {";
  protected final String TEXT_125 = NL + "                     ";
  protected final String TEXT_126 = ".";
  protected final String TEXT_127 = " = ";
  protected final String TEXT_128 = ";" + NL + "                } else {";
  protected final String TEXT_129 = NL + "                        ";
  protected final String TEXT_130 = ".";
  protected final String TEXT_131 = " = String.valueOf(columnValue_";
  protected final String TEXT_132 = "_";
  protected final String TEXT_133 = ");";
  protected final String TEXT_134 = NL + "                        ";
  protected final String TEXT_135 = ".";
  protected final String TEXT_136 = " = String.valueOf(columnValue_";
  protected final String TEXT_137 = "_";
  protected final String TEXT_138 = ").charAt(0);";
  protected final String TEXT_139 = NL + "                    \t";
  protected final String TEXT_140 = ".";
  protected final String TEXT_141 = " = ParserUtils.parseTo_Document(String.valueOf(columnValue_";
  protected final String TEXT_142 = "_";
  protected final String TEXT_143 = "));" + NL + "                    \t";
  protected final String TEXT_144 = NL + "                        ";
  protected final String TEXT_145 = ".";
  protected final String TEXT_146 = " = (";
  protected final String TEXT_147 = ") (columnValue_";
  protected final String TEXT_148 = "_";
  protected final String TEXT_149 = ");";
  protected final String TEXT_150 = NL + "                }";
  protected final String TEXT_151 = NL + NL + "org.talend.components.api.component.ComponentDefinition def_";
  protected final String TEXT_152 = " =" + NL + "        new ";
  protected final String TEXT_153 = "();";
  protected final String TEXT_154 = NL;
  protected final String TEXT_155 = NL;
  protected final String TEXT_156 = " props_";
  protected final String TEXT_157 = " =" + NL + "        (";
  protected final String TEXT_158 = ") def_";
  protected final String TEXT_159 = ".createRuntimeProperties();";
  protected final String TEXT_160 = NL + "                    java.util.List<Object> ";
  protected final String TEXT_161 = " = new java.util.ArrayList<Object>();";
  protected final String TEXT_162 = NL + "                            ";
  protected final String TEXT_163 = ".add(\"";
  protected final String TEXT_164 = "\");";
  protected final String TEXT_165 = NL + "                                ";
  protected final String TEXT_166 = ".add(";
  protected final String TEXT_167 = ");";
  protected final String TEXT_168 = NL + "                            ";
  protected final String TEXT_169 = ".add(\"\");";
  protected final String TEXT_170 = NL + "                    ((org.talend.daikon.properties.Properties)props_";
  protected final String TEXT_171 = ").setValue(\"";
  protected final String TEXT_172 = "\",";
  protected final String TEXT_173 = ");";
  protected final String TEXT_174 = NL + "                        props_";
  protected final String TEXT_175 = ".setValue(\"";
  protected final String TEXT_176 = "\"," + NL + "                        routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_177 = "));";
  protected final String TEXT_178 = NL + "                    props_";
  protected final String TEXT_179 = ".setValue(\"";
  protected final String TEXT_180 = "\"," + NL + "                        TalendDate.parseDate(\"yyyy-MM-dd HH:mm:ss\",";
  protected final String TEXT_181 = "));";
  protected final String TEXT_182 = NL + "                    props_";
  protected final String TEXT_183 = ".setValue(\"";
  protected final String TEXT_184 = "\",";
  protected final String TEXT_185 = NL + "                        ";
  protected final String TEXT_186 = ".";
  protected final String TEXT_187 = ");";
  protected final String TEXT_188 = NL + "                    props_";
  protected final String TEXT_189 = ".setValue(\"";
  protected final String TEXT_190 = "\"," + NL + "                        new org.apache.avro.Schema.Parser().parse(";
  protected final String TEXT_191 = "));";
  protected final String TEXT_192 = NL + "                    props_";
  protected final String TEXT_193 = ".setValue(\"";
  protected final String TEXT_194 = "\",";
  protected final String TEXT_195 = NL + "                    ";
  protected final String TEXT_196 = ");";
  protected final String TEXT_197 = NL + "                props_";
  protected final String TEXT_198 = ".setValue(\"";
  protected final String TEXT_199 = "\", null);";
  protected final String TEXT_200 = NL + "    if (org.talend.components.api.properties.ComponentReferenceProperties.ReferenceType.COMPONENT_INSTANCE == props_";
  protected final String TEXT_201 = ".referenceType.getValue()) {" + NL + "        final String referencedComponentInstanceId_";
  protected final String TEXT_202 = " = props_";
  protected final String TEXT_203 = ".componentInstanceId.getStringValue();" + NL + "        if (referencedComponentInstanceId_";
  protected final String TEXT_204 = " != null) {" + NL + "            org.talend.daikon.properties.Properties referencedComponentProperties_";
  protected final String TEXT_205 = " = (org.talend.daikon.properties.Properties) globalMap.get(" + NL + "                referencedComponentInstanceId_";
  protected final String TEXT_206 = " + \"_COMPONENT_RUNTIME_PROPERTIES\");" + NL + "            props_";
  protected final String TEXT_207 = ".setReference(referencedComponentProperties_";
  protected final String TEXT_208 = ");" + NL + "        }" + NL + "    }";
  protected final String TEXT_209 = NL + "globalMap.put(\"";
  protected final String TEXT_210 = "_COMPONENT_RUNTIME_PROPERTIES\", props_";
  protected final String TEXT_211 = ");" + NL + "" + NL + "org.talend.components.api.container.RuntimeContainer container_";
  protected final String TEXT_212 = " = new org.talend.components.api.container.RuntimeContainer() {" + NL + "    public Object getComponentData(String componentId, String key) {" + NL + "        return globalMap.get(componentId + \"_\" + key);" + NL + "    }" + NL + "" + NL + "    public void setComponentData(String componentId, String key, Object data) {" + NL + "        globalMap.put(componentId + \"_\" + key, data);" + NL + "    }" + NL + "" + NL + "    public String getCurrentComponentId() {" + NL + "        return \"";
  protected final String TEXT_213 = "\";" + NL + "    }" + NL + "" + NL + "    public Object getGlobalData(String key) {" + NL + "    \treturn globalMap.get(key);" + NL + "    }" + NL + "};" + NL + "" + NL + "int nb_line_";
  protected final String TEXT_214 = " = 0;" + NL + "" + NL + "org.talend.components.api.component.ConnectorTopology topology_";
  protected final String TEXT_215 = " = null;";
  protected final String TEXT_216 = NL + "topology_";
  protected final String TEXT_217 = " = org.talend.components.api.component.ConnectorTopology.INCOMING_AND_OUTGOING;";
  protected final String TEXT_218 = NL + "topology_";
  protected final String TEXT_219 = " = org.talend.components.api.component.ConnectorTopology.INCOMING;";
  protected final String TEXT_220 = NL + "topology_";
  protected final String TEXT_221 = " = org.talend.components.api.component.ConnectorTopology.OUTGOING;";
  protected final String TEXT_222 = NL + "topology_";
  protected final String TEXT_223 = " = org.talend.components.api.component.ConnectorTopology.NONE;";
  protected final String TEXT_224 = NL + NL + "org.talend.daikon.runtime.RuntimeInfo runtime_info_";
  protected final String TEXT_225 = " = def_";
  protected final String TEXT_226 = ".getRuntimeInfo(" + NL + "    org.talend.components.api.component.runtime.ExecutionEngine.DI, props_";
  protected final String TEXT_227 = ", topology_";
  protected final String TEXT_228 = ");" + NL + "java.util.Set<org.talend.components.api.component.ConnectorTopology> supported_connector_topologies_";
  protected final String TEXT_229 = " = def_";
  protected final String TEXT_230 = ".getSupportedConnectorTopologies();" + NL + "" + NL + "org.talend.components.api.component.runtime.RuntimableRuntime componentRuntime_";
  protected final String TEXT_231 = " = (org.talend.components.api.component.runtime.RuntimableRuntime)(Class.forName(runtime_info_";
  protected final String TEXT_232 = ".getRuntimeClassName()).newInstance());" + NL + "org.talend.daikon.properties.ValidationResult initVr_";
  protected final String TEXT_233 = " = componentRuntime_";
  protected final String TEXT_234 = ".initialize(container_";
  protected final String TEXT_235 = ", props_";
  protected final String TEXT_236 = ");" + NL + "" + NL + "if (initVr_";
  protected final String TEXT_237 = ".getStatus() == org.talend.daikon.properties.ValidationResult.Result.ERROR ) {" + NL + "    throw new RuntimeException(initVr_";
  protected final String TEXT_238 = ".getMessage());" + NL + "}" + NL + "" + NL + "if(componentRuntime_";
  protected final String TEXT_239 = " instanceof org.talend.components.api.component.runtime.ComponentDriverInitialization) {" + NL + "\torg.talend.components.api.component.runtime.ComponentDriverInitialization compDriverInitialization_";
  protected final String TEXT_240 = " = (org.talend.components.api.component.runtime.ComponentDriverInitialization)componentRuntime_";
  protected final String TEXT_241 = ";" + NL + "\tcompDriverInitialization_";
  protected final String TEXT_242 = ".runAtDriver(container_";
  protected final String TEXT_243 = ");" + NL + "}" + NL + "" + NL + "org.talend.components.api.component.runtime.SourceOrSink sourceOrSink_";
  protected final String TEXT_244 = " = null;" + NL + "if(componentRuntime_";
  protected final String TEXT_245 = " instanceof org.talend.components.api.component.runtime.SourceOrSink) {" + NL + "\tsourceOrSink_";
  protected final String TEXT_246 = " = (org.talend.components.api.component.runtime.SourceOrSink)componentRuntime_";
  protected final String TEXT_247 = ";" + NL + "\torg.talend.daikon.properties.ValidationResult vr_";
  protected final String TEXT_248 = " = sourceOrSink_";
  protected final String TEXT_249 = ".validate(container_";
  protected final String TEXT_250 = ");" + NL + "\tif (vr_";
  protected final String TEXT_251 = ".getStatus() == org.talend.daikon.properties.ValidationResult.Result.ERROR ) {" + NL + "    \tthrow new RuntimeException(vr_";
  protected final String TEXT_252 = ".getMessage());" + NL + "\t}" + NL + "}" + NL;
  protected final String TEXT_253 = NL + "    org.talend.components.api.component.runtime.Source source_";
  protected final String TEXT_254 = " =" + NL + "            (org.talend.components.api.component.runtime.Source)sourceOrSink_";
  protected final String TEXT_255 = ";" + NL + "    org.talend.components.api.component.runtime.Reader reader_";
  protected final String TEXT_256 = " =" + NL + "            source_";
  protected final String TEXT_257 = ".createReader(container_";
  protected final String TEXT_258 = ");" + NL + "\treader_";
  protected final String TEXT_259 = " = new org.talend.codegen.flowvariables.runtime.FlowVariablesReader(reader_";
  protected final String TEXT_260 = ", container_";
  protected final String TEXT_261 = ");" + NL;
  protected final String TEXT_262 = NL + "        boolean multi_output_is_allowed_";
  protected final String TEXT_263 = " = false;";
  protected final String TEXT_264 = NL + "        org.talend.components.api.component.Connector c_";
  protected final String TEXT_265 = " = null;" + NL + "        for (org.talend.components.api.component.Connector currentConnector : props_";
  protected final String TEXT_266 = ".getAvailableConnectors(null, true)) {" + NL + "            if (currentConnector.getName().equals(\"";
  protected final String TEXT_267 = "\")) {" + NL + "                c_";
  protected final String TEXT_268 = " = currentConnector;" + NL + "            }" + NL + "" + NL + "            if (currentConnector.getName().equals(\"REJECT\")) {//it's better to move the code to javajet" + NL + "                multi_output_is_allowed_";
  protected final String TEXT_269 = " = true;" + NL + "            }" + NL + "        }" + NL + "        org.apache.avro.Schema schema_";
  protected final String TEXT_270 = " = props_";
  protected final String TEXT_271 = ".getSchema(c_";
  protected final String TEXT_272 = ", true);" + NL;
  protected final String TEXT_273 = NL + NL + "    // Iterate through the incoming data." + NL + "    boolean available_";
  protected final String TEXT_274 = " = reader_";
  protected final String TEXT_275 = ".start();" + NL + "" + NL + "    resourceMap.put(\"reader_";
  protected final String TEXT_276 = "\", reader_";
  protected final String TEXT_277 = ");" + NL + "" + NL + "    for (; available_";
  protected final String TEXT_278 = "; available_";
  protected final String TEXT_279 = " = reader_";
  protected final String TEXT_280 = ".advance()) {" + NL + "    \tnb_line_";
  protected final String TEXT_281 = "++;" + NL + "" + NL + "    \t";
  protected final String TEXT_282 = NL + "        if (multi_output_is_allowed_";
  protected final String TEXT_283 = ") {";
  protected final String TEXT_284 = NL + "                ";
  protected final String TEXT_285 = " = null;";
  protected final String TEXT_286 = NL;
  protected final String TEXT_287 = NL + "                ";
  protected final String TEXT_288 = " = null;";
  protected final String TEXT_289 = NL + "        }";
  protected final String TEXT_290 = NL + NL + "        try {" + NL + "            Object data_";
  protected final String TEXT_291 = " = reader_";
  protected final String TEXT_292 = ".getCurrent();";
  protected final String TEXT_293 = NL + NL + "                if(multi_output_is_allowed_";
  protected final String TEXT_294 = ") {";
  protected final String TEXT_295 = NL + "                    ";
  protected final String TEXT_296 = " = new ";
  protected final String TEXT_297 = "Struct();" + NL + "                }" + NL;
  protected final String TEXT_298 = NL + "        } catch (org.talend.components.api.exception.DataRejectException e_";
  protected final String TEXT_299 = ") {" + NL + "        \tjava.util.Map<String,Object> info_";
  protected final String TEXT_300 = " = e_";
  protected final String TEXT_301 = ".getRejectInfo();";
  protected final String TEXT_302 = NL + "                Object data_";
  protected final String TEXT_303 = " = info_";
  protected final String TEXT_304 = ".get(\"talend_record\");" + NL + "" + NL + "                if (multi_output_is_allowed_";
  protected final String TEXT_305 = ") {";
  protected final String TEXT_306 = NL + "                    ";
  protected final String TEXT_307 = " = new ";
  protected final String TEXT_308 = "Struct();" + NL + "                }" + NL + "\t\t\t\ttry{";
  protected final String TEXT_309 = NL + "                }catch(java.lang.Exception e){" + NL + "                \t// do nothing" + NL + "                }";
  protected final String TEXT_310 = NL + "                        ";
  protected final String TEXT_311 = ".";
  protected final String TEXT_312 = " = (";
  protected final String TEXT_313 = ")info_";
  protected final String TEXT_314 = ".get(\"";
  protected final String TEXT_315 = "\");";
  protected final String TEXT_316 = NL + "            \t//TODO use a method instead of getting method by the special key \"error/errorMessage\"" + NL + "            \tObject errorMessage_";
  protected final String TEXT_317 = " = null;" + NL + "            \tif(info_";
  protected final String TEXT_318 = ".containsKey(\"error\")){" + NL + "            \t\terrorMessage_";
  protected final String TEXT_319 = " = info_";
  protected final String TEXT_320 = ".get(\"error\");" + NL + "        \t\t}else if(info_";
  protected final String TEXT_321 = ".containsKey(\"errorMessage\")){" + NL + "            \t\terrorMessage_";
  protected final String TEXT_322 = " = info_";
  protected final String TEXT_323 = ".get(\"errorMessage\");" + NL + "        \t\t}else{" + NL + "        \t\t\terrorMessage_";
  protected final String TEXT_324 = " = \"Rejected but error message missing\";" + NL + "        \t\t}" + NL + "        \t\terrorMessage_";
  protected final String TEXT_325 = " = \"Row \"+ nb_line_";
  protected final String TEXT_326 = " + \": \"+errorMessage_";
  protected final String TEXT_327 = ";" + NL + "    \t\t\tSystem.err.println(errorMessage_";
  protected final String TEXT_328 = ");";
  protected final String TEXT_329 = NL + "            \t// If the record is reject, the main line record should put NULL" + NL + "            \t";
  protected final String TEXT_330 = " = null;";
  protected final String TEXT_331 = NL + "    }";
  protected final String TEXT_332 = NL + "    org.talend.components.api.component.runtime.Sink sink_";
  protected final String TEXT_333 = " =" + NL + "            (org.talend.components.api.component.runtime.Sink)sourceOrSink_";
  protected final String TEXT_334 = ";" + NL + "    org.talend.components.api.component.runtime.WriteOperation writeOperation_";
  protected final String TEXT_335 = " = sink_";
  protected final String TEXT_336 = ".createWriteOperation();" + NL + "    writeOperation_";
  protected final String TEXT_337 = ".initialize(container_";
  protected final String TEXT_338 = ");" + NL + "    org.talend.components.api.component.runtime.Writer writer_";
  protected final String TEXT_339 = " = writeOperation_";
  protected final String TEXT_340 = ".createWriter(container_";
  protected final String TEXT_341 = ");" + NL + "    writer_";
  protected final String TEXT_342 = ".open(\"";
  protected final String TEXT_343 = "\");" + NL + "" + NL + "    resourceMap.put(\"writer_";
  protected final String TEXT_344 = "\", writer_";
  protected final String TEXT_345 = ");" + NL + "" + NL + "    org.talend.components.api.component.Connector c_";
  protected final String TEXT_346 = " = null;" + NL + "    for (org.talend.components.api.component.Connector currentConnector : props_";
  protected final String TEXT_347 = ".getAvailableConnectors(null, false)) {" + NL + "        if (currentConnector.getName().equals(\"MAIN\")) {" + NL + "            c_";
  protected final String TEXT_348 = " = currentConnector;" + NL + "            break;" + NL + "        }" + NL + "    }" + NL + "    org.apache.avro.Schema designSchema_";
  protected final String TEXT_349 = " = props_";
  protected final String TEXT_350 = ".getSchema(c_";
  protected final String TEXT_351 = ", false);" + NL + "    org.talend.daikon.di.DiIncomingSchemaEnforcer current_";
  protected final String TEXT_352 = NL + "            = new org.talend.daikon.di.DiIncomingSchemaEnforcer(designSchema_";
  protected final String TEXT_353 = ");";
  protected final String TEXT_354 = NL + "                c_";
  protected final String TEXT_355 = " = null;" + NL + "                for (org.talend.components.api.component.Connector currentConnector : props_";
  protected final String TEXT_356 = ".getAvailableConnectors(null, true)) {" + NL + "                    if (currentConnector.getName().equals(\"MAIN\")) {" + NL + "                        c_";
  protected final String TEXT_357 = " = currentConnector;" + NL + "                    }" + NL + "                }" + NL + "                org.apache.avro.Schema mainSchema_";
  protected final String TEXT_358 = " = props_";
  protected final String TEXT_359 = ".getSchema(c_";
  protected final String TEXT_360 = ", true);";
  protected final String TEXT_361 = NL + "                c_";
  protected final String TEXT_362 = " = null;" + NL + "                for (org.talend.components.api.component.Connector currentConnector : props_";
  protected final String TEXT_363 = ".getAvailableConnectors(null, true)) {" + NL + "                    if (currentConnector.getName().equals(\"REJECT\")) {" + NL + "                        c_";
  protected final String TEXT_364 = " = currentConnector;" + NL + "                    }" + NL + "                }" + NL + "                org.apache.avro.Schema rejectSchema_";
  protected final String TEXT_365 = " = props_";
  protected final String TEXT_366 = ".getSchema(c_";
  protected final String TEXT_367 = ", true);";
  protected final String TEXT_368 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    

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
            
    stringBuffer.append(TEXT_1);
    stringBuffer.append(codeVarIsDynamicInitialized);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_3);
    
        }

        
    stringBuffer.append(TEXT_4);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(codeVarSchemaToEnforce);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(dynamicByPosition);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(codeVarIndexedRecordAdapter);
    stringBuffer.append(TEXT_8);
    
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
        
    stringBuffer.append(TEXT_9);
    stringBuffer.append(codeVarIndexedRecordAdapter);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(codeVarIndexedRecordAdapter);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(codeVarIndexedRecord);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(codeVarIndexedRecordAdapter);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(codeVarIndexedRecord);
    stringBuffer.append(TEXT_17);
    

        if (dynamicColName != null) {
            
    stringBuffer.append(TEXT_18);
    stringBuffer.append(codeVarIsDynamicInitialized);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
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
    stringBuffer.append(JavaTypesManager.LIST.getId());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(JavaTypesManager.BOOLEAN.getId());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(JavaTypesManager.BYTE_ARRAY.getId());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(JavaTypesManager.BYTE_ARRAY.getId());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(JavaTypesManager.DOUBLE.getId());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(JavaTypesManager.FLOAT.getId());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(JavaTypesManager.INTEGER.getId());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
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
    stringBuffer.append(JavaTypesManager.DATE.getId());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(JavaTypesManager.LONG.getId());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(JavaTypesManager.STRING.getId());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(JavaTypesManager.STRING.getId());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
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
    stringBuffer.append(TEXT_97);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_102);
    
        }

        for (int i = 0; i < columnsToGenerate.size(); i++) {
            IMetadataColumn column = columnsToGenerate.get(i);
            String columnName = column.getLabel();
            JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
            String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
            if (columnName.equals(dynamicColName)) {
                
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(dynamicColName);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_117);
    
            } else {
                
    stringBuffer.append(TEXT_118);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_128);
    
                    if (javaType == JavaTypesManager.STRING) {
                        
    stringBuffer.append(TEXT_129);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    
                    } else if (javaType == JavaTypesManager.CHARACTER) {
                        
    stringBuffer.append(TEXT_134);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    
                    } else if("id_Document".equals(column.getTalendType())){
                    	
    stringBuffer.append(TEXT_139);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    
                    } else  {
                        
    stringBuffer.append(TEXT_144);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    
                    }
                    
    stringBuffer.append(TEXT_150);
    
            }
        }
    }

}

    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
Component component = (Component)node.getComponent();
ComponentProperties componentProps = node.getComponentProperties();
ComponentDefinition def = component.getComponentDefinition();

List<IMetadataTable> metadatas = node.getMetadataList();
IMetadataTable metadata = null;
List<IMetadataColumn> columnList = null;
if ((metadatas != null) && (metadatas.size() > 0)) { // metadata
    metadata = metadatas.get(0);
    if(metadata != null){
        columnList = metadata.getListColumns();
    }
}

// Set up the component definition, and the properties for all types of
// components.


    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append( def.getClass().getName());
    stringBuffer.append(TEXT_153);
    
List<Component.CodegenPropInfo> propsToProcess = component.getCodegenPropInfos(componentProps);

    stringBuffer.append(TEXT_154);
    stringBuffer.append(TEXT_155);
    stringBuffer.append( componentProps.getClass().getName());
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append( componentProps.getClass().getName());
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    

final Set<String> referenceProperties = new HashSet<String>();

for (Component.CodegenPropInfo propInfo : propsToProcess) { // propInfo
    List<NamedThing> properties = propInfo.props.getProperties();
    for (NamedThing prop : properties) { // property
        if (prop instanceof Property) { // if, only deal with valued Properties
            Property property = (Property)prop;
            if (property.getFlags() != null && (property.getFlags().contains(Property.Flags.DESIGN_TIME_ONLY) || property.getFlags().contains(Property.Flags.HIDDEN)))
                continue;
            Object value = property.getStoredValue();
            if (value != null) {
                if (value instanceof List) {
                    // added for the support of tables
                    String tmpVarName = cid+propInfo.fieldName.replace('.','_')+"_"+property.getName();
                    
    stringBuffer.append(TEXT_160);
    stringBuffer.append(tmpVarName );
    stringBuffer.append(TEXT_161);
    
                    for (Object subPropertyValue : (java.util.List<Object>)property.getValue()) {
                        if ((property.getPossibleValues() != null && property.getPossibleValues().size() > 0)||
                        	Boolean.valueOf(String.valueOf(property.getTaggedValue(IGenericConstants.ADD_QUOTES)))) {
                            
    stringBuffer.append(TEXT_162);
    stringBuffer.append(tmpVarName );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(subPropertyValue );
    stringBuffer.append(TEXT_164);
    
                        } else if(!"".equals(subPropertyValue)) {
                                
    stringBuffer.append(TEXT_165);
    stringBuffer.append(tmpVarName );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(subPropertyValue );
    stringBuffer.append(TEXT_167);
    
                        } else {
                            
    stringBuffer.append(TEXT_168);
    stringBuffer.append(tmpVarName );
    stringBuffer.append(TEXT_169);
    
                        }
                    }
                    
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(propInfo.fieldName);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(property.getName());
    stringBuffer.append(TEXT_172);
    stringBuffer.append(tmpVarName );
    stringBuffer.append(TEXT_173);
    
                }  else if (value instanceof String && property.isFlag(Property.Flags.ENCRYPT) && ElementParameterParser.canEncryptValue((String) value)) {
                    if (!"".equals(property.getStringValue())) {
                        
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(propInfo.fieldName);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(property.getName());
    stringBuffer.append(TEXT_176);
    stringBuffer.append(component.getCodegenValue(property, (String) value));
    stringBuffer.append(TEXT_177);
    
                    }
                } else if (value != null && "java.util.Date".equals(property.getType())){
                    
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(propInfo.fieldName);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(property.getName());
    stringBuffer.append(TEXT_180);
    stringBuffer.append(component.getCodegenValue(property, value.toString()));
    stringBuffer.append(TEXT_181);
    
                } else if (property instanceof org.talend.daikon.properties.property.EnumProperty) {
                    
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(propInfo.fieldName);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(property.getName());
    stringBuffer.append(TEXT_184);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(property.getType().replaceAll("<.*>", ""));
    stringBuffer.append(TEXT_186);
    stringBuffer.append(property.getValue());
    stringBuffer.append(TEXT_187);
    
                } else if (property instanceof org.talend.daikon.properties.property.SchemaProperty) {
                    
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(propInfo.fieldName);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(property.getName());
    stringBuffer.append(TEXT_190);
    stringBuffer.append(component.getCodegenValue(property, property.getStringValue()));
    stringBuffer.append(TEXT_191);
    
                } else if (!(value instanceof String) || !((String)value).equals("")) {
                    
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(propInfo.fieldName);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(property.getName());
    stringBuffer.append(TEXT_194);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(component.getCodegenValue(property, value.toString()));
    stringBuffer.append(TEXT_196);
    
                }
            }

            if("java.lang.Integer".equals(property.getType()) && (value == null || ((value instanceof String) && ((String)value).isEmpty()))) {//need to overwrite the default value when the passed value is null or empty string from the model
        	
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(propInfo.fieldName);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(property.getName());
    stringBuffer.append(TEXT_199);
    
            }
        } else if (prop instanceof ComponentReferenceProperties) {
            final String fieldString = propInfo.fieldName + "." + prop.getName();
            referenceProperties.add(fieldString);
        } //else may be a ComponentProperties so ignore
    } // property
} // propInfo

for (final String fieldString : referenceProperties) {
    
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(fieldString );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(fieldString );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(fieldString );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    
}

    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    
boolean hasInput = !NodeUtil.getIncomingConnections(node, IConnectionCategory.DATA).isEmpty();
boolean hasOutput = !NodeUtil.getOutgoingConnections(node, IConnectionCategory.DATA).isEmpty();
boolean hasOutputOnly = hasOutput && !hasInput;

if (hasInput && hasOutput) {

    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    
} else if (hasInput) {

    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    
} else if (hasOutput) {

    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    
} else {

    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    
}

    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    
// Return at this point if there is no metadata.
if (metadata == null) {
    return stringBuffer.toString();
}

Set<ConnectorTopology> connectorTopologies = def.getSupportedConnectorTopologies();
boolean asInputComponent = connectorTopologies!=null && (connectorTopologies.size() < 3) && connectorTopologies.contains(ConnectorTopology.OUTGOING);

if (hasOutputOnly || asInputComponent) {
    
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    
    IConnection main = null;
    List<? extends IConnection> mains = node.getOutgoingConnections("MAIN");
    if (mains!=null && !mains.isEmpty()) {
        main = mains.get(0);
    }

    IConnection reject = null;
    List<? extends IConnection> rejects = node.getOutgoingConnections("REJECT");
    if (rejects != null && !rejects.isEmpty()) {
        reject = rejects.get(0);
    }

	boolean hasDataOutput = (main != null || reject != null);
	IndexedRecordToRowStructGenerator irToRow = null;

	if(hasDataOutput) {
    	IConnection schemaSourceConnector = (main!=null ? main : reject);
    	String schemaSourceConnectorName = schemaSourceConnector.getMetadataTable().getAttachedConnector();
	
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
     //take care SourceOrSink.validate will change the schema if it contains include-all-fields, so need to get design Avro schema before validate 
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(schemaSourceConnectorName);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    
    	irToRow = new IndexedRecordToRowStructGenerator(cid, null, columnList);
    	irToRow.generateInitialVariables("schema_" + cid, false);
    }
    
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    if(hasDataOutput) {
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    if(main!=null){
    stringBuffer.append(TEXT_284);
    stringBuffer.append(main.getName());
    stringBuffer.append(TEXT_285);
    }
    stringBuffer.append(TEXT_286);
    if(reject!=null){
    stringBuffer.append(TEXT_287);
    stringBuffer.append(reject.getName());
    stringBuffer.append(TEXT_288);
    }
    stringBuffer.append(TEXT_289);
    }
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    
            if (main != null) {
                
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(main.getName());
    stringBuffer.append(TEXT_296);
    stringBuffer.append(main.getName() );
    stringBuffer.append(TEXT_297);
    
                irToRow.generateConvertRecord("data_" + cid, main.getName(), main.getMetadataTable().getListColumns());
            }
            
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    
            if (reject!=null) {
                
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(reject.getName());
    stringBuffer.append(TEXT_307);
    stringBuffer.append(reject.getName() );
    stringBuffer.append(TEXT_308);
    
                irToRow.generateConvertRecord("data_" + cid, reject.getName());
                
    stringBuffer.append(TEXT_309);
    
                Set<String> commonColumns = new HashSet<String>();

                for (IMetadataColumn column : columnList) {
                    commonColumns.add(column.getLabel());
                }

                //pass error columns
                List<IMetadataColumn> rejectColumns = reject.getMetadataTable().getListColumns();
                for(IMetadataColumn column : rejectColumns) {
                    String columnName = column.getLabel();

                    // JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                    String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());

                    //error columns
                    if(!commonColumns.contains(columnName)) {
                        
    stringBuffer.append(TEXT_310);
    stringBuffer.append(reject.getName());
    stringBuffer.append(TEXT_311);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_315);
    
                    }
                }
            } else {
            
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    
            }
            if (main != null) {
            
    stringBuffer.append(TEXT_329);
    stringBuffer.append(main.getName());
    stringBuffer.append(TEXT_330);
    
            }
        
    stringBuffer.append(TEXT_331);
    
    // The for loop around the incoming records from the reader is left open.


} else if (hasInput) {
    
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    
    List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
    if (outgoingConns!=null){
        for (IConnection outgoingConn : outgoingConns) {
            if ("MAIN".equals(outgoingConn.getConnectorName())) {
                
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    
                IndexedRecordToRowStructGenerator mainIrToRow = new IndexedRecordToRowStructGenerator(
                        cid + "OutMain", outgoingConn);
                mainIrToRow.generateInitialVariables("mainSchema_" + cid, false);
            }
            if ("REJECT".equals(outgoingConn.getConnectorName())) {
                
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    
                IndexedRecordToRowStructGenerator rejectIrToRow = new IndexedRecordToRowStructGenerator(
                        cid + "OutReject", outgoingConn);
                rejectIrToRow.generateInitialVariables("rejectSchema_" + cid, false);
            }
        }
    }
}

    stringBuffer.append(TEXT_368);
    return stringBuffer.toString();
  }
}
