package org.talend.designer.codegen.translators.esb.webservices;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.codegen.config.NodeConnectionsHelper;
import org.talend.designer.codegen.config.NodeParamsHelper;

public class TESBConsumerMainJava
{
  protected static String nl;
  public static synchronized TESBConsumerMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TESBConsumerMainJava result = new TESBConsumerMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        ";
  protected final String TEXT_2 = " = null;";
  protected final String TEXT_3 = NL + "    final javax.xml.namespace.QName serviceName_";
  protected final String TEXT_4 = " = new javax.xml.namespace.QName(\"";
  protected final String TEXT_5 = "\", \"";
  protected final String TEXT_6 = "\");" + NL + "    final javax.xml.namespace.QName portName_";
  protected final String TEXT_7 = " = new javax.xml.namespace.QName(\"";
  protected final String TEXT_8 = "\", \"";
  protected final String TEXT_9 = "\");" + NL + "" + NL + "\t final List<java.util.Map<String, String>> customHttpHeaders_";
  protected final String TEXT_10 = " = new java.util.ArrayList<java.util.Map<String, String>>();" + NL + "\t final HttpHeadersFeature httpHeadersFeature = new HttpHeadersFeature(customHttpHeaders_";
  protected final String TEXT_11 = ");" + NL + "\t" + NL + "    try {" + NL + "        routines.system.Document requestTalendDoc_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = ".payload;" + NL + "        try {" + NL + "            org.dom4j.Document responseDoc_";
  protected final String TEXT_14 = " = null;" + NL;
  protected final String TEXT_15 = NL + "                final java.util.Map<String, String> slCustomProps_";
  protected final String TEXT_16 = " = new java.util.HashMap<String, String>();";
  protected final String TEXT_17 = "slCustomProps_";
  protected final String TEXT_18 = ".put(";
  protected final String TEXT_19 = ", ";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + NL + "            java.util.Map<String, String> customProps_";
  protected final String TEXT_22 = " = null;";
  protected final String TEXT_23 = NL + "                    customProps_";
  protected final String TEXT_24 = " = new java.util.HashMap<String, String>();";
  protected final String TEXT_25 = NL + "                    customProps_";
  protected final String TEXT_26 = ".put(";
  protected final String TEXT_27 = ", ";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "                class EsbJobCorrelationCallbackHandler implements org.talend.esb.policy.correlation.CorrelationIDCallbackHandler {" + NL + "                    private String correlationId;" + NL + "                    public EsbJobCorrelationCallbackHandler(final String correlationId) {" + NL + "                        if (null != correlationId && correlationId.length() > 0) {" + NL + "                            this.correlationId = correlationId;" + NL + "                        }" + NL + "                    }" + NL + "                    public String getCorrelationId() {" + NL + "                        return correlationId;" + NL + "                    };" + NL + "                }" + NL + "                final Object correlationIDCallbackHandler = new EsbJobCorrelationCallbackHandler(";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = NL + NL + "            final List<org.apache.cxf.headers.Header> soapHeaders_";
  protected final String TEXT_32 = " = new java.util.ArrayList<org.apache.cxf.headers.Header>();";
  protected final String TEXT_33 = NL + "                final Object securityToken_";
  protected final String TEXT_34 = ";";
  protected final String TEXT_35 = NL + "                    securityToken_";
  protected final String TEXT_36 = " = globalMap.get(\"";
  protected final String TEXT_37 = "_SECURITY_TOKEN\");";
  protected final String TEXT_38 = NL + "                final routines.system.Document headersTalendDoc_";
  protected final String TEXT_39 = " = ";
  protected final String TEXT_40 = ".headers;" + NL + "                if (null != headersTalendDoc_";
  protected final String TEXT_41 = " && null != headersTalendDoc_";
  protected final String TEXT_42 = ".getDocument()) {" + NL + "                    javax.xml.transform.dom.DOMResult result = new javax.xml.transform.dom.DOMResult();" + NL + "                    javax.xml.transform.TransformerFactory.newInstance().newTransformer().transform(new org.dom4j.io.DocumentSource(headersTalendDoc_";
  protected final String TEXT_43 = ".getDocument()), result);" + NL + "                    for (org.w3c.dom.Node node = ((org.w3c.dom.Document) result.getNode()).getDocumentElement().getFirstChild();" + NL + "                            node != null;" + NL + "                            node = node.getNextSibling()) {" + NL + "                        if (org.w3c.dom.Node.ELEMENT_NODE == node.getNodeType()) {" + NL + "                            soapHeaders_";
  protected final String TEXT_44 = ".add(new org.apache.cxf.headers.Header(new javax.xml.namespace.QName(node.getNamespaceURI(), node.getLocalName()), node));" + NL + "                        }" + NL + "                    }" + NL + "                }";
  protected final String TEXT_45 = NL + "            List<String> propagatedHeaders = new java.util.ArrayList<String>();";
  protected final String TEXT_46 = NL + "                customHttpHeaders_";
  protected final String TEXT_47 = ".add(new java.util.HashMap<String, String>() {{put(";
  protected final String TEXT_48 = ", ";
  protected final String TEXT_49 = ");}});" + NL + "\t\t\t\t";
  protected final String TEXT_50 = NL + "                propagatedHeaders.add(";
  protected final String TEXT_51 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_52 = NL + "            final java.util.TreeMap<String, String> tESBProviderRequestHttpHeaders=(java.util.TreeMap<String, String>)globalMap.get(\"";
  protected final String TEXT_53 = "_HEADERS_HTTP\");" + NL + "            if(tESBProviderRequestHttpHeaders!=null){" + NL + "\t\t\t\t\tfor (java.util.Map.Entry<String, ?> e : tESBProviderRequestHttpHeaders.entrySet()) {" + NL + "\t\t\t\t   \tif(propagatedHeaders.contains(e.getKey().toLowerCase())){" + NL + "\t\t\t\t         if(e.getValue() instanceof java.util.List){" + NL + "\t\t\t\t\t\t\t\tfor(Object v: (java.util.List)e.getValue()){" + NL + "\t\t\t\t\t\t\t\t   java.util.Map<String, String> header = new java.util.HashMap<String, String>();" + NL + "\t\t\t\t\t\t\t\t\theader.put(e.getKey(), String.valueOf(v));" + NL + "\t\t\t\t\t\t\t\t\tcustomHttpHeaders_";
  protected final String TEXT_54 = ".add(header);" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\tjava.util.Map<String, String> header = new java.util.HashMap<String, String>();" + NL + "\t\t\t\t\t\t\t\theader.put(e.getKey(), String.valueOf(e.getValue()));" + NL + "\t\t\t\t\t\t\t\tcustomHttpHeaders_";
  protected final String TEXT_55 = ".add(header);" + NL + "\t\t\t\t\t\t\t}" + NL + "                 }" + NL + "               }" + NL + "            }";
  protected final String TEXT_56 = NL + "            if (null == registry) {" + NL + "                GenericConsumer genericConsumer_";
  protected final String TEXT_57 = " = new GenericConsumer();" + NL + "                genericConsumer_";
  protected final String TEXT_58 = ".setServiceQName(serviceName_";
  protected final String TEXT_59 = ");" + NL + "                genericConsumer_";
  protected final String TEXT_60 = ".setPortQName(portName_";
  protected final String TEXT_61 = ");" + NL + "                genericConsumer_";
  protected final String TEXT_62 = ".setOperationQName(new javax.xml.namespace.QName(\"";
  protected final String TEXT_63 = "\", \"";
  protected final String TEXT_64 = "\"));" + NL + "                genericConsumer_";
  protected final String TEXT_65 = ".setIsRequestResponse(";
  protected final String TEXT_66 = ");";
  protected final String TEXT_67 = NL + "                        genericConsumer_";
  protected final String TEXT_68 = ".setSoapAction(\"";
  protected final String TEXT_69 = "\");";
  protected final String TEXT_70 = NL + NL + "                genericConsumer_";
  protected final String TEXT_71 = ".setAddress(";
  protected final String TEXT_72 = ");" + NL + "                if (null != getClass().getResourceAsStream(\"wsdl/";
  protected final String TEXT_73 = ".wsdl\")) {" + NL + "                    genericConsumer_";
  protected final String TEXT_74 = ".setWsdlURL(\"classpath:/\" + this.getClass().getPackage().getName().replace(\".\", \"/\") + \"/wsdl/";
  protected final String TEXT_75 = ".wsdl\");" + NL + "                }" + NL + "" + NL + "                java.util.Collection<org.apache.cxf.feature.Feature> esbFeatures_";
  protected final String TEXT_76 = " =" + NL + "                        new java.util.ArrayList<org.apache.cxf.feature.Feature>();" + NL;
  protected final String TEXT_77 = NL + "                    genericConsumer_";
  protected final String TEXT_78 = ".setAddress(\"locator://\");" + NL + "                    genericConsumer_";
  protected final String TEXT_79 = ".setBus(new org.apache.cxf.bus.spring.SpringBusFactory().createBus(\"META-INF/tesb/locator/beans.xml\"));" + NL + "                    org.talend.esb.servicelocator.cxf.LocatorFeature featureSL_";
  protected final String TEXT_80 = " = new org.talend.esb.servicelocator.cxf.LocatorFeature();" + NL + "                    if (null != slCustomProps_";
  protected final String TEXT_81 = " && !slCustomProps_";
  protected final String TEXT_82 = ".isEmpty()) {" + NL + "                        featureSL_";
  protected final String TEXT_83 = ".setRequiredEndpointProperties(slCustomProps_";
  protected final String TEXT_84 = ");" + NL + "                    }" + NL + "                    esbFeatures_";
  protected final String TEXT_85 = ".add(featureSL_";
  protected final String TEXT_86 = ");";
  protected final String TEXT_87 = NL + "                    org.springframework.context.support.ClassPathXmlApplicationContext classpathXmlApplicationContext =" + NL + "                            new org.springframework.context.support.ClassPathXmlApplicationContext(\"META-INF/tesb/agent-context.xml\");" + NL + "                    org.talend.esb.sam.agent.feature.EventFeature featureSAM_";
  protected final String TEXT_88 = " = classpathXmlApplicationContext.getBean(org.talend.esb.sam.agent.feature.EventFeature.class);" + NL + "                    if (null != customProps_";
  protected final String TEXT_89 = " && !customProps_";
  protected final String TEXT_90 = ".isEmpty()) {" + NL + "                        org.talend.esb.sam.common.handler.impl.CustomInfoHandler ciHandler = new org.talend.esb.sam.common.handler.impl.CustomInfoHandler();" + NL + "                        ciHandler.setCustomInfo(customProps_";
  protected final String TEXT_91 = ");" + NL + "                        featureSAM_";
  protected final String TEXT_92 = ".setHandler(ciHandler);" + NL + "                    }" + NL + "                    esbFeatures_";
  protected final String TEXT_93 = ".add(featureSAM_";
  protected final String TEXT_94 = ");";
  protected final String TEXT_95 = NL + "                    esbFeatures_";
  protected final String TEXT_96 = ".add(new org.talend.esb.policy.correlation.feature.CorrelationIDFeature());";
  protected final String TEXT_97 = NL + "                    genericConsumer_";
  protected final String TEXT_98 = ".setCorrelationIDCallbackHandler(correlationIDCallbackHandler);";
  protected final String TEXT_99 = NL + "                genericConsumer_";
  protected final String TEXT_100 = ".setEsbFeatures(esbFeatures_";
  protected final String TEXT_101 = ");" + NL + "" + NL + "                boolean use_auth_";
  protected final String TEXT_102 = " = ";
  protected final String TEXT_103 = ";" + NL + "                if (use_auth_";
  protected final String TEXT_104 = ") {" + NL + "                    genericConsumer_";
  protected final String TEXT_105 = ".setAuthType((String) ";
  protected final String TEXT_106 = ");" + NL + "                    genericConsumer_";
  protected final String TEXT_107 = ".setUsername(";
  protected final String TEXT_108 = ");";
  protected final String TEXT_109 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_110 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_111 = ");";
  protected final String TEXT_112 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_113 = " = ";
  protected final String TEXT_114 = "; ";
  protected final String TEXT_115 = NL + "                    genericConsumer_";
  protected final String TEXT_116 = ".setPassword(decryptedPassword_";
  protected final String TEXT_117 = ");" + NL + "                }" + NL + "" + NL + "                boolean use_proxy_";
  protected final String TEXT_118 = " = ";
  protected final String TEXT_119 = ";" + NL + "                if (use_proxy_";
  protected final String TEXT_120 = "){" + NL + "                    genericConsumer_";
  protected final String TEXT_121 = ".setProxyServer(";
  protected final String TEXT_122 = ");" + NL + "                    genericConsumer_";
  protected final String TEXT_123 = ".setProxyPort(";
  protected final String TEXT_124 = ");" + NL + "                    genericConsumer_";
  protected final String TEXT_125 = ".setProxyUsername(";
  protected final String TEXT_126 = ");";
  protected final String TEXT_127 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_128 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_129 = ");";
  protected final String TEXT_130 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_131 = " = ";
  protected final String TEXT_132 = "; ";
  protected final String TEXT_133 = NL + "                    genericConsumer_";
  protected final String TEXT_134 = ".setProxyPassword(decryptedPassword_";
  protected final String TEXT_135 = ");" + NL + "                }" + NL + "" + NL + "                genericConsumer_";
  protected final String TEXT_136 = ".setConnectionTimeout((long)(";
  protected final String TEXT_137 = " * 1000L));" + NL + "                genericConsumer_";
  protected final String TEXT_138 = ".setReceiveTimeout((long)(";
  protected final String TEXT_139 = " * 1000L));" + NL + "                genericConsumer_";
  protected final String TEXT_140 = ".setAutoRedirect(";
  protected final String TEXT_141 = ");" + NL + "                genericConsumer_";
  protected final String TEXT_142 = ".setRedirectSameHostOnly(";
  protected final String TEXT_143 = ");" + NL + "                ";
  protected final String TEXT_144 = NL + "                    genericConsumer_";
  protected final String TEXT_145 = ".setDisableChunking(";
  protected final String TEXT_146 = ");";
  protected final String TEXT_147 = NL + NL + "                genericConsumer_";
  protected final String TEXT_148 = ".setLogMessages(";
  protected final String TEXT_149 = ");" + NL;
  protected final String TEXT_150 = NL + "                    {";
  protected final String TEXT_151 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_152 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_153 = ");";
  protected final String TEXT_154 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_155 = " = ";
  protected final String TEXT_156 = "; ";
  protected final String TEXT_157 = NL + "                        System.setProperty(\"java.protocol.handler.pkgs\", \"com.sun.net.ssl.internal.www.protocol\");" + NL + "                        System.setProperty(\"javax.net.ssl.trustStore\", ";
  protected final String TEXT_158 = ");" + NL + "                        System.setProperty(\"javax.net.ssl.trustStorePassword\", decryptedPassword_";
  protected final String TEXT_159 = ");" + NL + "                    }";
  protected final String TEXT_160 = NL + NL + "                if (!soapHeaders_";
  protected final String TEXT_161 = ".isEmpty()) {" + NL + "                    genericConsumer_";
  protected final String TEXT_162 = ".setSoapHeaders(soapHeaders_";
  protected final String TEXT_163 = ");" + NL + "                }" + NL + "\t\t\t\t\t esbFeatures_";
  protected final String TEXT_164 = ".add(httpHeadersFeature);" + NL + "                responseDoc_";
  protected final String TEXT_165 = " = genericConsumer_";
  protected final String TEXT_166 = ".invoke(requestTalendDoc_";
  protected final String TEXT_167 = ".getDocument());";
  protected final String TEXT_168 = NL + "                    globalMap.put(\"";
  protected final String TEXT_169 = "_CORRELATION_ID\", genericConsumer_";
  protected final String TEXT_170 = ".getCorrelationID());";
  protected final String TEXT_171 = NL + "                globalMap.put(\"";
  protected final String TEXT_172 = "_HTTP_HEADERS\", httpHeadersFeature.getResponseHeaders());" + NL + "                globalMap.put(\"";
  protected final String TEXT_173 = "_HTTP_RESPONSE_CODE\", httpHeadersFeature.getResponseCode());" + NL + "            } else {" + NL + "                ESBConsumer consumer_";
  protected final String TEXT_174 = " = registry.createConsumer(" + NL + "                    new ESBEndpointInfo() {" + NL + "" + NL + "                        @SuppressWarnings(\"serial\")" + NL + "                        private java.util.Map<String, Object> props = new java.util.HashMap<String, Object>() {{" + NL + "                            put(\"dataFormat\", \"PAYLOAD\");" + NL + "                            put(\"portName\", portName_";
  protected final String TEXT_175 = ".toString());" + NL + "                            put(\"serviceName\", serviceName_";
  protected final String TEXT_176 = ".toString());" + NL + "                            put(\"defaultOperationName\", \"";
  protected final String TEXT_177 = "\");" + NL + "                            put(\"operationNamespace\", \"";
  protected final String TEXT_178 = "\");" + NL + "                            put(\"soapAction\", \"";
  protected final String TEXT_179 = "\");" + NL + "                            if (null != getClass().getResourceAsStream(\"wsdl/";
  protected final String TEXT_180 = ".wsdl\")) {" + NL + "                                put(\"wsdlURL\", \"classpath:/\" + this.getClass().getPackage().getName().replace(\".\", \"/\") + \"/wsdl/";
  protected final String TEXT_181 = ".wsdl\");" + NL + "                            }" + NL + "                            put(\"publishedEndpointUrl\", ";
  protected final String TEXT_182 = ");" + NL + "                            put(\"COMMUNICATION_STYLE\", \"";
  protected final String TEXT_183 = "\");" + NL + "" + NL + "                            put(\"logMessages\", ";
  protected final String TEXT_184 = ");" + NL + "" + NL + "                            // use Service Locator" + NL + "                            put(\"useServiceLocator\", ";
  protected final String TEXT_185 = ");";
  protected final String TEXT_186 = NL + "                                put(\"LocatorSelectionStrategy\", \"";
  protected final String TEXT_187 = "\");";
  protected final String TEXT_188 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_189 = NL + "                                put(\"SL-PROPS\", slCustomProps_";
  protected final String TEXT_190 = ");";
  protected final String TEXT_191 = NL + NL + "                            // use Service Activity Monitor" + NL + "                            put(\"useServiceActivityMonitor\", ";
  protected final String TEXT_192 = ");" + NL + "" + NL + "                            boolean use_auth_";
  protected final String TEXT_193 = " = ";
  protected final String TEXT_194 = ";" + NL + "                            if (use_auth_";
  protected final String TEXT_195 = " || ";
  protected final String TEXT_196 = ") {";
  protected final String TEXT_197 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_198 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_199 = ");";
  protected final String TEXT_200 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_201 = " = ";
  protected final String TEXT_202 = "; ";
  protected final String TEXT_203 = NL + "                            if (";
  protected final String TEXT_204 = ") {" + NL + "                                put(\"useServiceRegistry\", ";
  protected final String TEXT_205 = ");" + NL + "                                put(\"username\", ";
  protected final String TEXT_206 = ");" + NL + "                                put(\"password\", decryptedPassword_";
  protected final String TEXT_207 = ");";
  protected final String TEXT_208 = NL + "                                    put(\"role\", ";
  protected final String TEXT_209 = ");";
  protected final String TEXT_210 = NL + "                                    put(\"useCrypto\", ";
  protected final String TEXT_211 = ");";
  protected final String TEXT_212 = NL + "                            } else if (use_auth_";
  protected final String TEXT_213 = ") {" + NL + "                                if (\"SAML\".equals(";
  protected final String TEXT_214 = ")) {";
  protected final String TEXT_215 = NL + "                                    put(\"role\", ";
  protected final String TEXT_216 = ");";
  protected final String TEXT_217 = NL + "                                    put(\"useCrypto\", ";
  protected final String TEXT_218 = ");";
  protected final String TEXT_219 = NL + "                                }" + NL + "                                put(\"esbSecurity\", ";
  protected final String TEXT_220 = ");" + NL + "                                put(\"username\", ";
  protected final String TEXT_221 = ");" + NL + "                                put(\"password\", decryptedPassword_";
  protected final String TEXT_222 = ");" + NL + "                               }" + NL + "                            }" + NL + "                            if (!soapHeaders_";
  protected final String TEXT_223 = ".isEmpty()) {" + NL + "                                put(\"soapHeaders\", soapHeaders_";
  protected final String TEXT_224 = ");" + NL + "                            }" + NL + "\t\t\t\t\t\t\tput(\"httpHeadersFeature\", httpHeadersFeature);";
  protected final String TEXT_225 = NL + "                                put(\"securityToken\", securityToken_";
  protected final String TEXT_226 = ");";
  protected final String TEXT_227 = NL + "                                String alias_";
  protected final String TEXT_228 = " = ";
  protected final String TEXT_229 = ";" + NL + "                                if (null != alias_";
  protected final String TEXT_230 = " && !\"\".equals(alias_";
  protected final String TEXT_231 = ".trim())) {" + NL + "                                    put(\"alias\", alias_";
  protected final String TEXT_232 = ");" + NL + "                                }";
  protected final String TEXT_233 = NL + "                                put(org.talend.esb.policy.correlation.feature.CorrelationIDFeature.CORRELATION_ID_CALLBACK_HANDLER, correlationIDCallbackHandler);" + NL + "                                put(\"enhancedResponse\", true);";
  protected final String TEXT_234 = NL + "                        }};" + NL + "" + NL + "                        public String getEndpointUri() {" + NL + "                            // projectName + \"_\" + processName + \"_\" + componentName" + NL + "                            return \"";
  protected final String TEXT_235 = "_";
  protected final String TEXT_236 = "_";
  protected final String TEXT_237 = "\";" + NL + "                        }" + NL + "" + NL + "                        public java.util.Map<String, Object> getEndpointProperties() {" + NL + "                            return props;" + NL + "                        }" + NL + "" + NL + "                        public String getEndpointKey() {" + NL + "                            return \"cxf\";" + NL + "                        }" + NL + "                    }" + NL + "                );" + NL + "" + NL + "                Object request_";
  protected final String TEXT_238 = " = wrapPayload(requestTalendDoc_";
  protected final String TEXT_239 = ".getDocument(), customProps_";
  protected final String TEXT_240 = ");" + NL + "                Object consumerResponse_";
  protected final String TEXT_241 = " = consumer_";
  protected final String TEXT_242 = ".invoke(request_";
  protected final String TEXT_243 = ");" + NL + "                if (null == consumerResponse_";
  protected final String TEXT_244 = ") {" + NL + "                    // one way call" + NL + "                } else {" + NL + "                    if(consumerResponse_";
  protected final String TEXT_245 = " instanceof java.util.Map) {" + NL + "                        java.util.Map<?,?> responseMap_";
  protected final String TEXT_246 = " = (java.util.Map<?,?>)consumerResponse_";
  protected final String TEXT_247 = ";" + NL + "                        responseDoc_";
  protected final String TEXT_248 = " = (org.dom4j.Document) responseMap_";
  protected final String TEXT_249 = ".get(\"payload\");";
  protected final String TEXT_250 = NL + "                            globalMap.put(\"";
  protected final String TEXT_251 = "_CORRELATION_ID\", responseMap_";
  protected final String TEXT_252 = ".get(org.talend.esb.policy.correlation.feature.CorrelationIDFeature.MESSAGE_CORRELATION_ID));";
  protected final String TEXT_253 = NL + "                    } else if (consumerResponse_";
  protected final String TEXT_254 = " instanceof org.dom4j.Document) {" + NL + "                        responseDoc_";
  protected final String TEXT_255 = " = (org.dom4j.Document) consumerResponse_";
  protected final String TEXT_256 = ";" + NL + "                    } else {" + NL + "                        throw new RuntimeException(\"Incompatible consumer response: \" + consumerResponse_";
  protected final String TEXT_257 = ".getClass().getName());" + NL + "                    }" + NL + "                    " + NL + "                    globalMap.put(\"";
  protected final String TEXT_258 = "_HTTP_HEADERS\", httpHeadersFeature.getResponseHeaders());" + NL + "               \t    globalMap.put(\"";
  protected final String TEXT_259 = "_HTTP_RESPONSE_CODE\", httpHeadersFeature.getResponseCode());" + NL + "                }" + NL + "            }";
  protected final String TEXT_260 = NL + "                if (";
  protected final String TEXT_261 = " == null) {";
  protected final String TEXT_262 = NL + "                    ";
  protected final String TEXT_263 = " = new ";
  protected final String TEXT_264 = "Struct();" + NL + "                }" + NL + "                routines.system.Document responseTalendDoc_";
  protected final String TEXT_265 = " = null;" + NL + "                if (null != responseDoc_";
  protected final String TEXT_266 = ") {" + NL + "                    responseTalendDoc_";
  protected final String TEXT_267 = " = new routines.system.Document();" + NL + "                    responseTalendDoc_";
  protected final String TEXT_268 = ".setDocument(responseDoc_";
  protected final String TEXT_269 = ");" + NL + "                }";
  protected final String TEXT_270 = NL + "                ";
  protected final String TEXT_271 = ".payload = responseTalendDoc_";
  protected final String TEXT_272 = ";";
  protected final String TEXT_273 = NL + "        } catch (Exception e_";
  protected final String TEXT_274 = ") {" + NL + "            java.util.Map<String, Object> faultInfo_";
  protected final String TEXT_275 = " = collectFaultInfo(e_";
  protected final String TEXT_276 = ");" + NL + "            if (null == faultInfo_";
  protected final String TEXT_277 = ") {" + NL + "                throw e_";
  protected final String TEXT_278 = "; // non fault exception" + NL + "            }";
  protected final String TEXT_279 = NL + "                if (";
  protected final String TEXT_280 = " == null) {";
  protected final String TEXT_281 = NL + "                    ";
  protected final String TEXT_282 = " = new ";
  protected final String TEXT_283 = "Struct();" + NL + "                }" + NL;
  protected final String TEXT_284 = NL + "                ";
  protected final String TEXT_285 = ".faultCode = (String) faultInfo_";
  protected final String TEXT_286 = ".get(\"faultCode\");";
  protected final String TEXT_287 = NL + "                ";
  protected final String TEXT_288 = ".faultString = (String) faultInfo_";
  protected final String TEXT_289 = ".get(\"faultString\");";
  protected final String TEXT_290 = NL + "                ";
  protected final String TEXT_291 = ".faultActor = (String) faultInfo_";
  protected final String TEXT_292 = ".get(\"faultActor\");";
  protected final String TEXT_293 = NL + "                ";
  protected final String TEXT_294 = ".faultNode = (String) faultInfo_";
  protected final String TEXT_295 = ".get(\"faultNode\");";
  protected final String TEXT_296 = NL + "                ";
  protected final String TEXT_297 = ".faultRole = (String) faultInfo_";
  protected final String TEXT_298 = ".get(\"faultRole\");" + NL + "" + NL + "                if (null != faultInfo_";
  protected final String TEXT_299 = ".get(\"faultDetail\")) {";
  protected final String TEXT_300 = NL + "                    ";
  protected final String TEXT_301 = ".faultDetail = new routines.system.Document();";
  protected final String TEXT_302 = NL + "                    ";
  protected final String TEXT_303 = ".faultDetail.setDocument((org.dom4j.Document) faultInfo_";
  protected final String TEXT_304 = ".get(\"faultDetail\"));" + NL + "                }" + NL;
  protected final String TEXT_305 = NL + "                printFaultInfo(faultInfo_";
  protected final String TEXT_306 = ");" + NL + "                e_";
  protected final String TEXT_307 = ".printStackTrace(System.err);";
  protected final String TEXT_308 = NL + "        }" + NL + "    } catch (Exception e_";
  protected final String TEXT_309 = "){";
  protected final String TEXT_310 = NL + "            throw(e_";
  protected final String TEXT_311 = ");";
  protected final String TEXT_312 = NL + "            new TalendException(e_";
  protected final String TEXT_313 = ", currentComponent, globalMap).printStackTrace();";
  protected final String TEXT_314 = NL + "    }" + NL + "    " + NL + "    if(httpHeadersFeature!=null){" + NL + "    \t globalMap.put(\"";
  protected final String TEXT_315 = "_HTTP_HEADERS\", httpHeadersFeature.getResponseHeaders());" + NL + "       globalMap.put(\"";
  protected final String TEXT_316 = "_HTTP_RESPONSE_CODE\",  httpHeadersFeature.getResponseCode());" + NL + "    }" + NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
/*INIT PARAMETERS AND INDICATORS.*/
NodeConnectionsHelper connsHelper = new NodeConnectionsHelper(node, true);
IConnection inputConn = connsHelper.getInputConn();
if (inputConn == null) {
    return ""; //not generate any code if no input connection.
}
IConnection connResponse = connsHelper.getOutputConnResponse();
IConnection connFault = connsHelper.getOutputConnFault();
List<IConnection> dataOutputs = connsHelper.getDataOutputs();

String projectName = codeGenArgument.getCurrentProjectName();
String cid = node.getUniqueName();
String processName = node.getProcess().getName();
String passwordFieldName;

NodeParamsHelper paramsHelper = new NodeParamsHelper(node);
String serviceNS = paramsHelper.getStringParam("__SERVICE_NS__");
String serviceName = paramsHelper.getStringParam("__SERVICE_NAME__");
String portNS = paramsHelper.getStringParam("__PORT_NS__");
String portName = paramsHelper.getStringParam("__PORT_NAME__");

String methodNS = paramsHelper.getStringParam("__METHOD_NS__");
if (methodNS == null || "".equals(methodNS)) {
    methodNS = serviceNS;
}
String methodTemp = paramsHelper.getStringParam("__METHOD__");
String method = methodTemp.indexOf("(") != -1 ? methodTemp.substring(0, methodTemp.indexOf("(")) : methodTemp;

boolean logMessages = paramsHelper.getBoolParam("__LOG_MESSAGES__");
String connTimeout = paramsHelper.getStringParam("__CONNECTION_TIMEOUT__");
String receiveTimeout = paramsHelper.getStringParam("__RECEIVE_TIMEOUT__");

String useProxy = ElementParameterParser.getValue(node, "__USE_PROXY__");
if (!node.getElementParameter("USE_PROXY").isContextMode()) {
    // non-dynamic (bug with non updating parameter value after removing field from dynamic)
    useProxy = "true".equals(useProxy) ? "true" : "false";
}

// use paramsHelper.getVisibleBoolParam to return false if the controller of this parameter is not visible.
boolean useSR = paramsHelper.getVisibleBoolParam("__USE_SR__");

boolean useSl = paramsHelper.getVisibleBoolParam("__SERVICE_LOCATOR__");
boolean useSAM = paramsHelper.getVisibleBoolParam("__SERVICE_ACTIVITY_MONITOR__");

boolean useBusinessCorrelation = paramsHelper.getVisibleBoolParam("__USE_BUSINESS_CORRELATION__");
String correlationValue = paramsHelper.getStringParam("__CORRELATION_VALUE__");

String useAuth = ElementParameterParser.getValue(node, "__NEED_AUTH__");
if (!node.getElementParameter("NEED_AUTH").isContextMode()) {
    // non-dynamic (bug with non updating parameter value after removing field from dynamic)
    useAuth = "true".equals(useAuth) ? "true" : "false";
}

String authType = paramsHelper.getStringParam("__AUTH_TYPE__");
if (!node.getElementParameter("AUTH_TYPE").isContextMode()) {
    authType = "\"" + authType + "\"";
}

String alias = paramsHelper.getStringParam("__AUTH_ALIAS__");
String username = paramsHelper.getStringParam("__AUTH_USERNAME__");

// saml features
boolean useAuthorization = paramsHelper.getVisibleBoolParam("__NEED_AUTHORIZATION__");
String authorizationRole = paramsHelper.getStringParam("__ROLE__");

boolean authPropagateUP = false;
boolean authPropagateCertificate = false;
if (useSR) {
    if (paramsHelper.getVisibleBoolParam("__AUTH_PROPAGATE__")) {
        authPropagateUP = true;
        if (alias != null && !"".equals(alias.trim())) {
            authPropagateCertificate = true;
        }
    }
} else {
    String authPropatateType = paramsHelper.getVisibleStringParam("__PROPAGATE_TYPE__");
    authPropagateUP = authPropatateType.equals("U_P");
    authPropagateCertificate = authPropatateType.equals("CERT");
}

boolean useCrypto = paramsHelper.getVisibleBoolParam("__NEED_ENCRYPTION__");

// init headers
boolean hasHeaders = false;
if (inputConn != null) {
    for (IMetadataColumn connColumn : inputConn.getMetadataTable().getListColumns()) {
        if ("headers".equals(connColumn.getLabel())) {
            hasHeaders = true;
            break;
        }
    }
}

List<Map<String, String>> customHttpHeaders = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,  "__HEADERS__");

String esbProviderRequestCid = null;
if (!node.getProcess().getNodesOfType("tESBProviderRequest").isEmpty()) {
	for (INode tESBProviderRequestNode : node.getProcess().getNodesOfType("tESBProviderRequest")){
		esbProviderRequestCid = tESBProviderRequestNode.getUniqueName();
	}
}

/*GENERATE CODE*/
if (inputConn != null) {
    for (IConnection conn : dataOutputs) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_2);
    
    }

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(serviceNS);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(serviceName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(portNS);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(portName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
     if ((useSl) || (useSR)){ 
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
                for(Entry<String, String> prop : paramsHelper.getPropertiesPram("__SERVICE_LOCATOR_CUSTOM_PROPERTIES__")) {
                    
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(prop.getKey());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(prop.getValue());
    stringBuffer.append(TEXT_20);
    
                }
            } 
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
     if (useSAM) {
                List<Entry<String, String>> customProperties = paramsHelper.getPropertiesPram("__SERVICE_ACTIVITY_CUSTOM_PROPERTIES__");
                if (!customProperties.isEmpty()) { 
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
     for (Entry<String, String> prop : customProperties) { 
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(prop.getKey());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(prop.getValue());
    stringBuffer.append(TEXT_28);
     } 
     } 
     } 
     if (useBusinessCorrelation || useSR) { 
    stringBuffer.append(TEXT_29);
    stringBuffer.append(correlationValue);
    stringBuffer.append(TEXT_30);
     } 
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
     if (authPropagateUP || authPropagateCertificate) { 
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
     List<? extends INode> nodesProviderRequest = node.getProcess().getNodesOfType("tESBProviderRequest");
                if (!nodesProviderRequest.isEmpty()) { 
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(nodesProviderRequest.iterator().next().getUniqueName());
    stringBuffer.append(TEXT_37);
     }
            } if (hasHeaders) { 
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
     } 
    if(esbProviderRequestCid!=null){
    stringBuffer.append(TEXT_45);
    }
            for (Map<String, String> h : customHttpHeaders) {
					if(!java.lang.Boolean.parseBoolean(h.get("PROPAGATE").replaceAll("\"",""))){
				
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(h.get("NAME"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(h.get("VALUE"));
    stringBuffer.append(TEXT_49);
    } else if(esbProviderRequestCid!=null && h.get("NAME")!=null){
    stringBuffer.append(TEXT_50);
    stringBuffer.append(h.get("NAME").toLowerCase());
    stringBuffer.append(TEXT_51);
    }
				}
				if(esbProviderRequestCid!=null){
    stringBuffer.append(TEXT_52);
    stringBuffer.append(esbProviderRequestCid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(methodNS);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append("request-response".equals(paramsHelper.getStringParam("__COMMUNICATION_STYLE__")));
    stringBuffer.append(TEXT_66);
     String soapAction = paramsHelper.getStringParam("__SOAP_ACTION__");
                    if (soapAction != null && (!soapAction.matches("\\s*"))) { 
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(soapAction);
    stringBuffer.append(TEXT_69);
      } 
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(paramsHelper.getStringParam("__ESB_ENDPOINT__"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
     if (useSl) { 
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
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
     } 
     if (useSAM) { 
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
     } 
     if (useBusinessCorrelation) { 
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
     } 
     if(useBusinessCorrelation || useSR) { 
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
     } 
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(useAuth);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(authType);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_108);
     passwordFieldName = "__AUTH_PASSWORD__"; 
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_111);
    } else {
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_114);
    }
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(useProxy);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(paramsHelper.getStringParam("__PROXY_HOST__"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(paramsHelper.getStringParam("__PROXY_PORT__"));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(paramsHelper.getStringParam("__PROXY_USERNAME__"));
    stringBuffer.append(TEXT_126);
     passwordFieldName = "__PROXY_PASSWORD__"; 
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_129);
    } else {
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_132);
    }
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(connTimeout);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(receiveTimeout);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(paramsHelper.getBoolParam("__FOLLOW_REDIRECTS__"));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(!paramsHelper.getBoolParam("__REDIRECT_NON_SAME_HOST__"));
    stringBuffer.append(TEXT_143);
     if(!paramsHelper.getBoolParam("__FOLLOW_REDIRECTS__")){ 
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(paramsHelper.getBoolParam("__DISABLE_CHUNKING__"));
    stringBuffer.append(TEXT_146);
     } 
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(logMessages);
    stringBuffer.append(TEXT_149);
     if (paramsHelper.getBoolParam("__NEED_SSL_TO_TRUSTSERVER__")) {
                    passwordFieldName = "__SSL_TRUSTSERVER_PASSWORD__"; 
    stringBuffer.append(TEXT_150);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_153);
    } else {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_156);
    }
    stringBuffer.append(TEXT_157);
    stringBuffer.append(paramsHelper.getStringParam("__SSL_TRUSTSERVER_TRUSTSTORE__"));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
     } 
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
     if (useBusinessCorrelation || useSR) { 
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
     } 
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(methodNS);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(paramsHelper.getStringParam("__SOAP_ACTION__"));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(paramsHelper.getStringParam("__ESB_ENDPOINT__"));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(paramsHelper.getStringParam("__COMMUNICATION_STYLE__"));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(logMessages);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(useSl);
    stringBuffer.append(TEXT_185);
     if (useSl){ 
    stringBuffer.append(TEXT_186);
    stringBuffer.append(paramsHelper.getStringParam("__SERVICE_LOCATOR_STRATEGY__"));
    stringBuffer.append(TEXT_187);
     } 
    stringBuffer.append(TEXT_188);
     if ((useSl) || (useSR)){ 
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
     } 
    stringBuffer.append(TEXT_191);
    stringBuffer.append(useSAM);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(useAuth);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(useSR);
    stringBuffer.append(TEXT_196);
     passwordFieldName = "__AUTH_PASSWORD__"; 
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_199);
    } else {
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_202);
    }
    stringBuffer.append(TEXT_203);
    stringBuffer.append(useSR);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(useSR);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
     if (!authorizationRole.isEmpty() && !"\"\"".equals(authorizationRole)) { 
    stringBuffer.append(TEXT_208);
    stringBuffer.append(authorizationRole);
    stringBuffer.append(TEXT_209);
     } 
     if (useCrypto) { 
    stringBuffer.append(TEXT_210);
    stringBuffer.append(useCrypto);
    stringBuffer.append(TEXT_211);
     } 
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(authType);
    stringBuffer.append(TEXT_214);
     if (useAuthorization) { 
    stringBuffer.append(TEXT_215);
    stringBuffer.append(authorizationRole);
    stringBuffer.append(TEXT_216);
     }if (useCrypto) { 
    stringBuffer.append(TEXT_217);
    stringBuffer.append(useCrypto);
    stringBuffer.append(TEXT_218);
     } 
    stringBuffer.append(TEXT_219);
    stringBuffer.append(authType);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
     if (authPropagateUP || authPropagateCertificate) { 
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
     }
                            if (authPropagateCertificate) { 
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(alias);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
     }
                            if (useBusinessCorrelation || useSR) { 
    stringBuffer.append(TEXT_233);
     } 
    stringBuffer.append(TEXT_234);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(processName);
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
     if (useBusinessCorrelation || useSR) { 
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
     } 
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
     if (null != connResponse) {
                String connResponseName = connResponse.getName(); 
    stringBuffer.append(TEXT_260);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
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
     if (null != connFault) {
                String connFaultName = connFault.getName(); 
    stringBuffer.append(TEXT_279);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
     } else { 
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
     } 
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
     if (paramsHelper.getBoolParam("__DIE_ON_ERROR__")) { 
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
     } else { 
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
     } 
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
     } 
    return stringBuffer.toString();
  }
}
