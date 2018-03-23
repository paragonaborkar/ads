package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TMomInputLoopBeginJava
{
  protected static String nl;
  public static synchronized TMomInputLoopBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMomInputLoopBeginJava result = new TMomInputLoopBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + NL + "\tint nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "\tjavax.jms.Connection connection_";
  protected final String TEXT_4 = " = null;" + NL + "\t";
  protected final String TEXT_5 = NL + "\t\tjavax.jms.Session session_";
  protected final String TEXT_6 = " = null;" + NL + "\t\tjavax.jms.MessageConsumer consumer_";
  protected final String TEXT_7 = " = null;";
  protected final String TEXT_8 = NL + "\t\tcom.ibm.mq.MQQueueManager qMgr_";
  protected final String TEXT_9 = "=null;" + NL + "\t\tcom.ibm.mq.MQQueue remoteQ_";
  protected final String TEXT_10 = "=null;";
  protected final String TEXT_11 = NL + "\t\tcom.ibm.mq.MQQueue  backoutQueue_";
  protected final String TEXT_12 = " = null;";
  protected final String TEXT_13 = NL + "\t" + NL + "\ttry {" + NL;
  protected final String TEXT_14 = NL + "            try {" + NL + "\t            ";
  protected final String TEXT_15 = "\t" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_16 = " - Get a connection from component: ";
  protected final String TEXT_17 = " .\");" + NL + "\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t        connection_";
  protected final String TEXT_19 = " = (javax.jms.Connection) globalMap.get(\"connection_";
  protected final String TEXT_20 = "\");" + NL + "\t\t        ";
  protected final String TEXT_21 = "\t" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_22 = " - Activating the connection...\");" + NL + "\t\t\t\t";
  protected final String TEXT_23 = NL + "\t            connection_";
  protected final String TEXT_24 = ".start();" + NL + "\t            ";
  protected final String TEXT_25 = "\t" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_26 = " - Activate successfully.\");" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_27 = " - Get a  session from component: ";
  protected final String TEXT_28 = " .\");" + NL + "\t\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\tsession_";
  protected final String TEXT_30 = " = (javax.jms.Session) globalMap.get(\"session_";
  protected final String TEXT_31 = "\");" + NL + "\t\t    } catch (NullPointerException npe) {" + NL + "\t\t    \t";
  protected final String TEXT_32 = "\t" + NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_33 = " - Got connection unsuccessfully.\");" + NL + "\t\t\t\t";
  protected final String TEXT_34 = NL + "\t\t    \tthrow new RuntimeException(\"";
  protected final String TEXT_35 = " still not initialized. Try to redesign job.\");" + NL + "\t\t    }" + NL + "\t    \tjavax.jms.Destination des_";
  protected final String TEXT_36 = " = null;" + NL + "\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\t\tdes_";
  protected final String TEXT_38 = " = session_";
  protected final String TEXT_39 = ".createQueue(";
  protected final String TEXT_40 = ");" + NL + "\t\t\t";
  protected final String TEXT_41 = NL + "\t\t    \tdes_";
  protected final String TEXT_42 = " = session_";
  protected final String TEXT_43 = ".createTopic(";
  protected final String TEXT_44 = ");" + NL + "\t\t\t";
  protected final String TEXT_45 = NL + NL + "\t\t\tjavax.jms.MessageProducer replyProducer_";
  protected final String TEXT_46 = " = session_";
  protected final String TEXT_47 = ".createProducer(null);" + NL + "\t\t\treplyProducer_";
  protected final String TEXT_48 = ".setDeliveryMode(javax.jms.DeliveryMode.NON_PERSISTENT);" + NL + "\t\t\tconsumer_";
  protected final String TEXT_49 = " = session_";
  protected final String TEXT_50 = ".createConsumer(des_";
  protected final String TEXT_51 = ");" + NL + "\t" + NL + "\t\t\tglobalMap.put(\"session_";
  protected final String TEXT_52 = "\",session_";
  protected final String TEXT_53 = ");" + NL + "\t\t\tglobalMap.put(\"connection_";
  protected final String TEXT_54 = "\",connection_";
  protected final String TEXT_55 = ");" + NL + "\t\t" + NL + "\t\t\t// Receive message" + NL + "\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\tSystem.out.println(\"We will consume messages while they continue to be delivered \");" + NL + "\t\t\t\tjavax.jms.Message message_";
  protected final String TEXT_57 = ";" + NL + "\t\t\t\twhile ((message_";
  protected final String TEXT_58 = " = consumer_";
  protected final String TEXT_59 = ".receive()) != null) {" + NL + "" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_60 = NL + "\t\t        \ttry {   // For rollback" + NL + "\t\t\t\t";
  protected final String TEXT_61 = NL + "\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\tint maxMsg_";
  protected final String TEXT_63 = " = ";
  protected final String TEXT_64 = ";" + NL + "\t\t\t\tSystem.out.println(\"We are about to wait until we consume: \" + maxMsg_";
  protected final String TEXT_65 = " + \" message(s) then we will shutdown\");" + NL + "\t\t\t\tfor (int i_";
  protected final String TEXT_66 = " = 0; i_";
  protected final String TEXT_67 = " < maxMsg_";
  protected final String TEXT_68 = " ;) {" + NL + "\t\t\t\t";
  protected final String TEXT_69 = NL + "\t\t        \ttry {   // For rollback" + NL + "\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_70 = NL + "\t\t\t        \tjavax.jms.Message message_";
  protected final String TEXT_71 = " = null;" + NL + "\t\t\t\t\t";
  protected final String TEXT_72 = NL + "\t\t\t\t\t\tmessage_";
  protected final String TEXT_73 = " = consumer_";
  protected final String TEXT_74 = ".receive(";
  protected final String TEXT_75 = "*1000);" + NL + "\t\t\t\t\t\tif(message_";
  protected final String TEXT_76 = " == null){" + NL + "\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t";
  protected final String TEXT_77 = NL + "\t\t\t\t\t\tmessage_";
  protected final String TEXT_78 = " = consumer_";
  protected final String TEXT_79 = ".receive();" + NL + "\t\t\t\t\t\tif (message_";
  protected final String TEXT_80 = " != null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_81 = NL + "\t\t            \ti_";
  protected final String TEXT_82 = "++;" + NL + "\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\t    System.out.println(\"We will wait for messages within: \" + ";
  protected final String TEXT_84 = "*1000 + \" ms, and then we will shutdown\");" + NL + "\t\t\t    javax.jms.Message message_";
  protected final String TEXT_85 = ";" + NL + "\t\t\t    while ((message_";
  protected final String TEXT_86 = " = consumer_";
  protected final String TEXT_87 = ".receive(";
  protected final String TEXT_88 = "*1000)) != null) {" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_89 = NL + "\t\t        \ttry {   // For rollback" + NL + "\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_90 = NL + "\t\t\t";
  protected final String TEXT_91 = NL + "\t\t\t    " + NL + "\t\t\t/*-----------------------------------------------------------4.judge message body type---------------------------------------*/" + NL + "\t\t\t";
  protected final String TEXT_92 = NL + "\t\t\t\tif (message_";
  protected final String TEXT_93 = " instanceof javax.jms.MapMessage) {" + NL + "\t\t\t\t\tjavax.jms.MapMessage txtMsg_";
  protected final String TEXT_94 = " = (javax.jms.MapMessage) message_";
  protected final String TEXT_95 = ";" + NL + "\t\t\t\t\tString msg_";
  protected final String TEXT_96 = " = txtMsg_";
  protected final String TEXT_97 = ".getString(";
  protected final String TEXT_98 = ");" + NL + "\t\t\t\t\tif(msg_";
  protected final String TEXT_99 = " !=null){" + NL + "\t" + NL + "\t\t\t";
  protected final String TEXT_100 = NL + "\t\t\t\t\tjavax.jms.TextMessage txtMsg_";
  protected final String TEXT_101 = " = (javax.jms.TextMessage) message_";
  protected final String TEXT_102 = ";" + NL + "\t\t\t\t\tString msg_";
  protected final String TEXT_103 = " = txtMsg_";
  protected final String TEXT_104 = ".getText();" + NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_105 = NL + "\t\t\t\t\tjavax.jms.BytesMessage bytesMsg_";
  protected final String TEXT_106 = " = (javax.jms.BytesMessage) message_";
  protected final String TEXT_107 = ";" + NL + "\t\t\t\t\tbyte[] bytesMsgBody_";
  protected final String TEXT_108 = " = new byte[(int)bytesMsg_";
  protected final String TEXT_109 = ".getBodyLength()];" + NL + "\t\t\t\t\tbytesMsg_";
  protected final String TEXT_110 = ".readBytes(bytesMsgBody_";
  protected final String TEXT_111 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_112 = NL + "\t\t\t\t\tString msg_";
  protected final String TEXT_113 = " = new String(bytesMsgBody_";
  protected final String TEXT_114 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_115 = NL + "\t\t\t\t\tjavax.jms.MapMessage  msg_";
  protected final String TEXT_116 = "  = (javax.jms.MapMessage) message_";
  protected final String TEXT_117 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_118 = NL + NL + "\t\t\t" + NL + "\t\t";
  protected final String TEXT_119 = NL + "\t\t\t\tjava.util.Hashtable props_";
  protected final String TEXT_120 = "=new java.util.Hashtable();" + NL + "\t\t\t\tprops_";
  protected final String TEXT_121 = ".put(javax.naming.Context.INITIAL_CONTEXT_FACTORY,\"org.jnp.interfaces.NamingContextFactory\");" + NL + "\t\t\t\tprops_";
  protected final String TEXT_122 = ".put(javax.naming.Context.PROVIDER_URL, ";
  protected final String TEXT_123 = "+\":\"+";
  protected final String TEXT_124 = ");" + NL + "\t\t\t\tprops_";
  protected final String TEXT_125 = ".put(\"java.naming.rmi.security.manager\", \"yes\");" + NL + "\t\t\t\tprops_";
  protected final String TEXT_126 = ".put(javax.naming.Context.URL_PKG_PREFIXES, \"org.jboss.naming\");" + NL + "\t\t\t\tprops_";
  protected final String TEXT_127 = ".put(\"java.naming.factory.url.pkgs\",\"org.jboss.naming:org.jnp.interfaces\");\t" + NL + "\t\t\t\t" + NL + "\t\t\t\tjavax.naming.Context context_";
  protected final String TEXT_128 = "=new javax.naming.InitialContext(props_";
  protected final String TEXT_129 = ");" + NL + "\t\t\t\tjavax.jms.ConnectionFactory factory_";
  protected final String TEXT_130 = "=(javax.jms.ConnectionFactory)context_";
  protected final String TEXT_131 = ".lookup(\"ConnectionFactory\");\t" + NL + "\t\t\t";
  protected final String TEXT_132 = NL + "\t\t\t\t\tString url_";
  protected final String TEXT_133 = " =\"\";" + NL + "\t      \t\tString endParam_";
  protected final String TEXT_134 = "=\"\";" + NL + " \t\t\t\t";
  protected final String TEXT_135 = NL + "\t\t\t\t\turl_";
  protected final String TEXT_136 = " = \"failover:(\";" + NL + "\t\t\t\t\tendParam_";
  protected final String TEXT_137 = "=";
  protected final String TEXT_138 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_139 = NL + "\t\t\t\t\turl_";
  protected final String TEXT_140 = " = \"discovery://static:(\";" + NL + "\t\t\t\t\tendParam_";
  protected final String TEXT_141 = "=";
  protected final String TEXT_142 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_143 = NL + "\t\t\t\t\t\turl_";
  protected final String TEXT_144 = " = url_";
  protected final String TEXT_145 = " +\",\";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_146 = NL + "\t\t\t\t\t\turl_";
  protected final String TEXT_147 = " = url_";
  protected final String TEXT_148 = " +\"";
  protected final String TEXT_149 = "://\";" + NL + "\t\t\t\t\t\turl_";
  protected final String TEXT_150 = " = url_";
  protected final String TEXT_151 = " +";
  protected final String TEXT_152 = ";" + NL + "\t\t\t\t\t\turl_";
  protected final String TEXT_153 = " = url_";
  protected final String TEXT_154 = " +\":\";" + NL + "\t\t\t\t\t\turl_";
  protected final String TEXT_155 = " = url_";
  protected final String TEXT_156 = " +";
  protected final String TEXT_157 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_158 = NL + "\t\t\t\t\turl_";
  protected final String TEXT_159 = " = url_";
  protected final String TEXT_160 = " +\")\"+endParam_";
  protected final String TEXT_161 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_162 = NL + "\t\t\t\t\t\turl_";
  protected final String TEXT_163 = " = url_";
  protected final String TEXT_164 = " +\"&\"+";
  protected final String TEXT_165 = "+\"=\"+";
  protected final String TEXT_166 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_167 = NL + "\t\t\t\t\turl_";
  protected final String TEXT_168 = " = \"";
  protected final String TEXT_169 = "://\"+";
  protected final String TEXT_170 = "+\":\"+";
  protected final String TEXT_171 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_172 = "\t\t\t" + NL + "\t" + NL + "\t\t\t\t";
  protected final String TEXT_173 = NL + "\t\t\t\t\torg.apache.activemq.broker.BrokerService broker_";
  protected final String TEXT_174 = " = new org.apache.activemq.broker.BrokerService();" + NL + "\t\t\t\t\tbroker_";
  protected final String TEXT_175 = ".setUseJmx(true);" + NL + "\t\t\t\t\tbroker_";
  protected final String TEXT_176 = ".addConnector(url_";
  protected final String TEXT_177 = ");" + NL + "\t\t\t\t\tbroker_";
  protected final String TEXT_178 = ".start();" + NL + "\t\t\t\t";
  protected final String TEXT_179 = NL + "\t\t\t\tSystem.out.println(\"Connecting to URL: \" + url_";
  protected final String TEXT_180 = ");" + NL + "\t\t\t\tSystem.out.println(\"Consuming \" + (";
  protected final String TEXT_181 = " ? \"topic\" : \"queue\") + \": \" + ";
  protected final String TEXT_182 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_183 = "\t" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_184 = " - Attempt to create connection from URL: \" + url_";
  protected final String TEXT_185 = " + \".\");" + NL + "\t\t\t\t";
  protected final String TEXT_186 = NL + "\t\t\t\torg.apache.activemq.ActiveMQConnectionFactory factory_";
  protected final String TEXT_187 = " = new org.apache.activemq.ActiveMQConnectionFactory(url_";
  protected final String TEXT_188 = ");" + NL + "\t\t\t";
  protected final String TEXT_189 = NL + "\t\t\t\tconnection_";
  protected final String TEXT_190 = " = factory_";
  protected final String TEXT_191 = ".createConnection();" + NL + "\t\t\t";
  protected final String TEXT_192 = NL + "\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_193 = NL + "\t" + NL + "\t\t\t\t";
  protected final String TEXT_194 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_195 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_196 = ");";
  protected final String TEXT_197 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_198 = " = ";
  protected final String TEXT_199 = "; ";
  protected final String TEXT_200 = NL + "\t\t\t" + NL + "\t\t\t\tconnection_";
  protected final String TEXT_201 = " = factory_";
  protected final String TEXT_202 = ".createConnection(";
  protected final String TEXT_203 = ",decryptedPassword_";
  protected final String TEXT_204 = ");" + NL + "\t\t\t";
  protected final String TEXT_205 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_206 = " - Created connection successfully.\");" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_207 = " - Activating the connection...\");" + NL + "\t\t\t";
  protected final String TEXT_208 = NL + "\t\t\tconnection_";
  protected final String TEXT_209 = ".start();" + NL + "\t\t\t";
  protected final String TEXT_210 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_211 = " - Activate successfully.\");" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_212 = " - Creating a session...\");" + NL + "\t\t\t";
  protected final String TEXT_213 = NL + "\t\t\tsession_";
  protected final String TEXT_214 = " = connection_";
  protected final String TEXT_215 = ".createSession(";
  protected final String TEXT_216 = ", javax.jms.Session.";
  protected final String TEXT_217 = ");" + NL + "\t\t\t";
  protected final String TEXT_218 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_219 = " - Created session successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_220 = NL + "\t\t\tjavax.jms.Destination des_";
  protected final String TEXT_221 = " = null;" + NL + "\t" + NL + "\t" + NL + "\t" + NL + "\t\t\t";
  protected final String TEXT_222 = NL + "\t\t\t\tdes_";
  protected final String TEXT_223 = " = session_";
  protected final String TEXT_224 = ".createQueue(";
  protected final String TEXT_225 = ");" + NL + "\t\t\t";
  protected final String TEXT_226 = NL + "\t\t    \tdes_";
  protected final String TEXT_227 = " = session_";
  protected final String TEXT_228 = ".createTopic(";
  protected final String TEXT_229 = ");" + NL + "\t\t\t";
  protected final String TEXT_230 = NL + "\t\t\tjavax.jms.MessageProducer replyProducer_";
  protected final String TEXT_231 = " = session_";
  protected final String TEXT_232 = ".createProducer(null);" + NL + "\t\t\treplyProducer_";
  protected final String TEXT_233 = ".setDeliveryMode(javax.jms.DeliveryMode.NON_PERSISTENT);" + NL + "\t\t\t\t" + NL + "\t\t\tconsumer_";
  protected final String TEXT_234 = " = session_";
  protected final String TEXT_235 = ".createConsumer(des_";
  protected final String TEXT_236 = ");" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_237 = NL + "\t\t\t\tglobalMap.put(\"session_";
  protected final String TEXT_238 = "\",session_";
  protected final String TEXT_239 = ");" + NL + "\t\t\t\tglobalMap.put(\"connection_";
  protected final String TEXT_240 = "\",connection_";
  protected final String TEXT_241 = ");" + NL + "\t       \t";
  protected final String TEXT_242 = NL + "\t" + NL + "\t\t\t";
  protected final String TEXT_243 = "\t" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_244 = " - Ready to receive message.\");" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_245 = " - Waiting...\");" + NL + "\t\t\t\t";
  protected final String TEXT_246 = "\t\t\t\t\t" + NL + "\t\t\t\tSystem.out.println(\"Ready to receive message\");" + NL + "\t\t\t\tSystem.out.println(\"Waiting...\");\t" + NL + "\t\t\t\tjavax.jms.Message message_";
  protected final String TEXT_247 = ";" + NL + "\t\t\t" + NL + "\t\t\t\twhile((message_";
  protected final String TEXT_248 = "=consumer_";
  protected final String TEXT_249 = ".receive())!=null){" + NL + "\t" + NL + "\t\t\t";
  protected final String TEXT_250 = "\t" + NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_251 = " - Listening to receive messages...\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_252 = NL + "\t\t\t\t\tSystem.out.println(\"We will consume messages while they continue to be delivered \");" + NL + "\t\t\t\t\tjavax.jms.Message message_";
  protected final String TEXT_253 = ";" + NL + "\t\t\t\t\twhile ((message_";
  protected final String TEXT_254 = " = consumer_";
  protected final String TEXT_255 = ".receive()) != null) {" + NL + "\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_256 = NL + "\t\t\t        \ttry {   // For rollback" + NL + "\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_257 = NL + "\t\t\t\t";
  protected final String TEXT_258 = "\t" + NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_259 = " - Listening to receive messages...\");" + NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_260 = " - Consume max message number:  \" + ";
  protected final String TEXT_261 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_262 = NL + "\t\t\t\t\tint maxMsg_";
  protected final String TEXT_263 = " = ";
  protected final String TEXT_264 = ";" + NL + "\t\t\t\t\tSystem.out.println(\"We are about to wait until we consume: \" + maxMsg_";
  protected final String TEXT_265 = " + \" message(s) then we will shutdown\");" + NL + "\t\t\t\t\tfor (int i_";
  protected final String TEXT_266 = " = 0; i_";
  protected final String TEXT_267 = " < maxMsg_";
  protected final String TEXT_268 = " ;) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_269 = NL + "\t\t\t        \ttry {   // For rollback" + NL + "\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_270 = NL + "\t\t\t\t        \tjavax.jms.Message message_";
  protected final String TEXT_271 = " = null;" + NL + "\t\t\t\t        ";
  protected final String TEXT_272 = NL + "\t\t\t\t\t\t\tmessage_";
  protected final String TEXT_273 = " = consumer_";
  protected final String TEXT_274 = ".receive(";
  protected final String TEXT_275 = "*1000);" + NL + "\t\t\t\t\t\t\tif(message_";
  protected final String TEXT_276 = " == null){" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_277 = NL + "\t\t\t\t\t\t\tmessage_";
  protected final String TEXT_278 = " = consumer_";
  protected final String TEXT_279 = ".receive();" + NL + "\t\t\t\t\t\t\tif (message_";
  protected final String TEXT_280 = " != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_281 = NL + "\t\t\t            \ti_";
  protected final String TEXT_282 = "++;" + NL + "\t\t\t\t";
  protected final String TEXT_283 = "\t" + NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_284 = " - Listening to receive messages...\");" + NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_285 = " - Listening time last for:  \" + ";
  protected final String TEXT_286 = "*1000 + \" ms, and then stop.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_287 = NL + "\t\t\t\t    System.out.println(\"We will wait for messages within: \" + ";
  protected final String TEXT_288 = "*1000 + \" ms, and then we will shutdown\");" + NL + "\t\t\t\t    javax.jms.Message message_";
  protected final String TEXT_289 = ";" + NL + "\t\t\t\t    while ((message_";
  protected final String TEXT_290 = " = consumer_";
  protected final String TEXT_291 = ".receive(";
  protected final String TEXT_292 = "*1000)) != null) {" + NL + "\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_293 = NL + "\t\t\t        \ttry {   // For rollback" + NL + "\t\t\t\t\t";
  protected final String TEXT_294 = NL + "\t\t\t\t";
  protected final String TEXT_295 = NL + "\t\t\t\tif (message_";
  protected final String TEXT_296 = " instanceof javax.jms.MapMessage) {" + NL + "\t\t\t\t\tjavax.jms.MapMessage txtMsg_";
  protected final String TEXT_297 = " = (javax.jms.MapMessage) message_";
  protected final String TEXT_298 = ";" + NL + "\t\t\t\t\tString msg_";
  protected final String TEXT_299 = " = txtMsg_";
  protected final String TEXT_300 = ".getString(";
  protected final String TEXT_301 = ");" + NL + "\t\t\t\t\tif(msg_";
  protected final String TEXT_302 = " !=null){" + NL + "\t" + NL + "\t\t\t";
  protected final String TEXT_303 = NL + "\t\t\t\t\tjavax.jms.TextMessage txtMsg_";
  protected final String TEXT_304 = " = (javax.jms.TextMessage) message_";
  protected final String TEXT_305 = ";" + NL + "\t\t\t\t\tString msg_";
  protected final String TEXT_306 = " = txtMsg_";
  protected final String TEXT_307 = ".getText();" + NL + "\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_308 = NL + "\t\t\t\t\tjavax.jms.BytesMessage bytesMsg_";
  protected final String TEXT_309 = " = (javax.jms.BytesMessage) message_";
  protected final String TEXT_310 = ";" + NL + "\t\t\t\t\tbyte[] bytesMsgBody_";
  protected final String TEXT_311 = " = new byte[(int)bytesMsg_";
  protected final String TEXT_312 = ".getBodyLength()];" + NL + "\t\t\t\t\tbytesMsg_";
  protected final String TEXT_313 = ".readBytes(bytesMsgBody_";
  protected final String TEXT_314 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_315 = NL + "\t\t\t\t\tString msg_";
  protected final String TEXT_316 = " = new String(bytesMsgBody_";
  protected final String TEXT_317 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_318 = NL + "\t\t\t\t\tjavax.jms.MapMessage  msg_";
  protected final String TEXT_319 = "  = (javax.jms.MapMessage) message_";
  protected final String TEXT_320 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_321 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_322 = NL + "\t\t\t\tqMgr_";
  protected final String TEXT_323 = " = (com.ibm.mq.MQQueueManager)globalMap.get(\"qMgr_";
  protected final String TEXT_324 = "\");" + NL + "\t\t\t\tglobalMap.put(\"qMgr_";
  protected final String TEXT_325 = "\",qMgr_";
  protected final String TEXT_326 = ");" + NL + "\t\t\t";
  protected final String TEXT_327 = NL + "\t\t\t\tjava.util.Hashtable properties";
  protected final String TEXT_328 = "=new java.util.Hashtable();" + NL + "\t\t\t\tproperties";
  protected final String TEXT_329 = ".put(\"hostname\", ";
  protected final String TEXT_330 = ");" + NL + "\t\t\t\tproperties";
  protected final String TEXT_331 = ".put(\"port\", Integer.valueOf(";
  protected final String TEXT_332 = "));" + NL + "\t\t\t\tproperties";
  protected final String TEXT_333 = ".put(\"channel\", ";
  protected final String TEXT_334 = ");" + NL + "\t\t\t\tproperties";
  protected final String TEXT_335 = ".put(\"CCSID\", new Integer(1208));" + NL + "\t\t\t\tproperties";
  protected final String TEXT_336 = ".put(\"transport\",\"MQSeries\");" + NL + "\t\t\t\t";
  protected final String TEXT_337 = NL + "\t\t\t\t\tcom.ibm.mq.MQEnvironment.sslCipherSuite = \"";
  protected final String TEXT_338 = "\";" + NL + "\t\t\t\t";
  protected final String TEXT_339 = NL + "\t\t\t\t\tproperties";
  protected final String TEXT_340 = ".put(\"userID\",";
  protected final String TEXT_341 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_342 = NL + NL + "\t\t\t\t\t";
  protected final String TEXT_343 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_344 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_345 = ");";
  protected final String TEXT_346 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_347 = " = ";
  protected final String TEXT_348 = "; ";
  protected final String TEXT_349 = NL + "\t\t\t" + NL + "\t\t\t" + NL + "\t\t\t\t\tproperties";
  protected final String TEXT_350 = ".put(\"password\",decryptedPassword_";
  protected final String TEXT_351 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_352 = NL + "\t\t\t\tqMgr_";
  protected final String TEXT_353 = "=new com.ibm.mq.MQQueueManager(";
  protected final String TEXT_354 = ",properties";
  protected final String TEXT_355 = ");" + NL + "\t\t\t\tglobalMap.put(\"qMgr_";
  protected final String TEXT_356 = "\",qMgr_";
  protected final String TEXT_357 = ");" + NL + "\t\t\t";
  protected final String TEXT_358 = NL + "\t\t\t\tString msgId_";
  protected final String TEXT_359 = " = ";
  protected final String TEXT_360 = ";" + NL + "\t\t    \tif (msgId_";
  protected final String TEXT_361 = " != null & !(\"\").equals(msgId_";
  protected final String TEXT_362 = ")) {" + NL + "\t\t\t\t\tString padding_";
  protected final String TEXT_363 = " = new String();" + NL + "\t\t\t       \tint padlen_";
  protected final String TEXT_364 = " = 24;" + NL + "\t\t\t " + NL + "\t\t\t       \tint len_";
  protected final String TEXT_365 = " = Math.abs(padlen_";
  protected final String TEXT_366 = ") - msgId_";
  protected final String TEXT_367 = ".toString().length();" + NL + "\t\t\t       \tif (len_";
  protected final String TEXT_368 = " > 0) {" + NL + "\t\t\t        \tfor (int i = 0 ; i < len_";
  protected final String TEXT_369 = " ; i++) {" + NL + "\t\t\t           \t\tpadding_";
  protected final String TEXT_370 = " = padding_";
  protected final String TEXT_371 = " + \" \";" + NL + "\t\t\t         \t}" + NL + "\t\t\t        \tmsgId_";
  protected final String TEXT_372 = " = msgId_";
  protected final String TEXT_373 = " + padding_";
  protected final String TEXT_374 = ";" + NL + "\t\t\t        }" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_375 = NL + "\t\t\ttry{" + NL + "\t" + NL + "\t\t\t\tint openOptions";
  protected final String TEXT_376 = "=com.ibm.mq.MQC.MQOO_INPUT_SHARED | com.ibm.mq.MQC.MQOO_FAIL_IF_QUIESCING | com.ibm.mq.MQC.MQOO_INQUIRE";
  protected final String TEXT_377 = " | com.ibm.mq.MQC.MQOO_BROWSE";
  protected final String TEXT_378 = ";" + NL + "\t\t\t" + NL + "\t\t\t\tcom.ibm.mq.MQGetMessageOptions gmo";
  protected final String TEXT_379 = "=new com.ibm.mq.MQGetMessageOptions();" + NL + "\t\t\t\t";
  protected final String TEXT_380 = NL + "\t\t\t\t\tgmo";
  protected final String TEXT_381 = ".options=gmo";
  protected final String TEXT_382 = ".options+com.ibm.mq.MQC.MQGMO_BROWSE_FIRST;" + NL + "\t\t\t\t\tint browseCursor_";
  protected final String TEXT_383 = " = 0;" + NL + "\t\t\t\t";
  protected final String TEXT_384 = NL + "\t\t\t\t\tgmo";
  protected final String TEXT_385 = ".options=gmo";
  protected final String TEXT_386 = ".options+com.ibm.mq.MQC.MQGMO_SYNCPOINT;" + NL + "\t\t\t\t";
  protected final String TEXT_387 = NL + "\t\t\t\tgmo";
  protected final String TEXT_388 = ".options=gmo";
  protected final String TEXT_389 = ".options+com.ibm.mq.MQC.";
  protected final String TEXT_390 = "MQGMO_NO_WAIT";
  protected final String TEXT_391 = "MQGMO_WAIT";
  protected final String TEXT_392 = ";" + NL + "\t\t\t\tgmo";
  protected final String TEXT_393 = ".options=gmo";
  protected final String TEXT_394 = ".options+com.ibm.mq.MQC.MQGMO_FAIL_IF_QUIESCING;" + NL + "\t\t\t\tgmo";
  protected final String TEXT_395 = ".waitInterval=com.ibm.mq.MQC.MQWI_UNLIMITED;" + NL + "\t\t\t\tcom.ibm.mq.MQException.log = null;" + NL + "\t\t\t\tboolean flag";
  protected final String TEXT_396 = "=true;" + NL + "\t\t\t" + NL + "\t\t\t\tremoteQ_";
  protected final String TEXT_397 = "=qMgr_";
  protected final String TEXT_398 = ".accessQueue(";
  protected final String TEXT_399 = ",openOptions";
  protected final String TEXT_400 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_401 = NL + "\t\t\t\t\tint[] selectors_";
  protected final String TEXT_402 = " = new int[2];" + NL + "\t\t\t\t\tint[] intAttrs_";
  protected final String TEXT_403 = " = new int[1];" + NL + "\t\t\t\t\tint threshold_";
  protected final String TEXT_404 = " = 0;" + NL + "\t\t\t\t\tString backoutQName_";
  protected final String TEXT_405 = " = \"\";" + NL + "\t\t\t\t\tbyte[] charAttrs_";
  protected final String TEXT_406 = " = new byte[com.ibm.mq.MQC.MQ_Q_NAME_LENGTH];" + NL + "\t\t\t\t\tselectors_";
  protected final String TEXT_407 = "[0] = com.ibm.mq.MQC.MQCA_BACKOUT_REQ_Q_NAME;" + NL + "\t\t\t\t\tselectors_";
  protected final String TEXT_408 = "[1] = com.ibm.mq.MQC.MQIA_BACKOUT_THRESHOLD;" + NL + "\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_409 = "\t" + NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_410 = " - Initing backout queue ...\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_411 = NL + "\t\t\t\t\t\tremoteQ_";
  protected final String TEXT_412 = ".inquire(selectors_";
  protected final String TEXT_413 = ", intAttrs_";
  protected final String TEXT_414 = ", charAttrs_";
  protected final String TEXT_415 = ");" + NL + "\t\t\t\t\t\tthreshold_";
  protected final String TEXT_416 = " = intAttrs_";
  protected final String TEXT_417 = "[0];" + NL + "\t\t\t\t\t\tbackoutQName_";
  protected final String TEXT_418 = " = new String(charAttrs_";
  protected final String TEXT_419 = ");" + NL + "\t\t\t\t\t\tif(threshold_";
  protected final String TEXT_420 = " > 0 && backoutQName_";
  protected final String TEXT_421 = ".trim().length()>0){" + NL + "\t\t\t\t\t\t\tbackoutQueue_";
  protected final String TEXT_422 = " = qMgr_";
  protected final String TEXT_423 = ".accessQueue(backoutQName_";
  protected final String TEXT_424 = ", 16);" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tthrow new java.lang.Exception(\"Init backout queue unsuccessfully!\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_425 = "\t" + NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_426 = " - The backout queue of \"+";
  protected final String TEXT_427 = "+\" is:\"+backoutQName_";
  protected final String TEXT_428 = ");" + NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_429 = " - The threshold value of messages in \"+";
  protected final String TEXT_430 = "+\" is:\"+threshold_";
  protected final String TEXT_431 = ");" + NL + "\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_432 = " - Init backout queue successfully.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_433 = NL + "\t\t\t\t\t}catch (java.lang.Exception e_";
  protected final String TEXT_434 = ") {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_435 = "\t" + NL + "\t\t\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_436 = " - Init backout queue unsuccessfully, poison messages will remain on the input queue.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_437 = NL + "\t\t\t\t\t\t\tSystem.err.println(\"Init backout queue unsuccessfully, poison messages will remain on the input queue.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_438 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_439 = NL + "\t" + NL + "\t\t\t";
  protected final String TEXT_440 = NL + "\t\t\t\tif(Integer.valueOf(remoteQ_";
  protected final String TEXT_441 = ".getCurrentDepth()).equals(0))" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\tflag";
  protected final String TEXT_442 = "= false;" + NL + "\t\t\t\t} \t" + NL + "\t\t\t";
  protected final String TEXT_443 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_444 = " - Ready to receive message.\");" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_445 = " - Waiting...\");" + NL + "\t\t\t";
  protected final String TEXT_446 = "\t" + NL + "\t\t\t\tSystem.out.println(\"Ready to receive message\");" + NL + "\t\t\t\tSystem.out.println(\"Waiting...\");\t" + NL + "\t\t\t\twhile(flag";
  protected final String TEXT_447 = "){" + NL + "\t\t\t";
  protected final String TEXT_448 = NL + "\t\t\t\tglobalMap.put(\"currentMessageIsConsumed_";
  protected final String TEXT_449 = "\",false);//if current message has been commited,no need to backout it to the backout queue." + NL + "\t\t\t";
  protected final String TEXT_450 = NL + "\t\t\t\tif(Integer.valueOf(remoteQ_";
  protected final String TEXT_451 = ".getCurrentDepth()).equals(1))" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\tflag";
  protected final String TEXT_452 = "= false;" + NL + "\t\t\t\t} \t\t\t" + NL + "\t\t\t";
  protected final String TEXT_453 = NL + "\t\t\t\tif(browseCursor_";
  protected final String TEXT_454 = " > 0){" + NL + "\t\t\t\t\tgmo";
  protected final String TEXT_455 = ".options=com.ibm.mq.MQC.MQGMO_BROWSE_NEXT; " + NL + "\t\t\t\t\tgmo";
  protected final String TEXT_456 = ".options=gmo";
  protected final String TEXT_457 = ".options+com.ibm.mq.MQC.";
  protected final String TEXT_458 = "MQGMO_NO_WAIT";
  protected final String TEXT_459 = "MQGMO_WAIT";
  protected final String TEXT_460 = ";" + NL + "\t\t\t\t\tgmo";
  protected final String TEXT_461 = ".options=gmo";
  protected final String TEXT_462 = ".options+com.ibm.mq.MQC.MQGMO_FAIL_IF_QUIESCING;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tbrowseCursor_";
  protected final String TEXT_463 = "++;" + NL + "\t\t\t";
  protected final String TEXT_464 = NL + "\t\t\tcom.ibm.mq.MQMessage inMessage";
  protected final String TEXT_465 = "=new com.ibm.mq.MQMessage();" + NL + "\t\t\t";
  protected final String TEXT_466 = NL + "\t\t\t\tinMessage";
  protected final String TEXT_467 = ".messageId = msgId_";
  protected final String TEXT_468 = ".getBytes(\"ISO-8859-15\");" + NL + "\t\t\t";
  protected final String TEXT_469 = "\t\t" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\tremoteQ_";
  protected final String TEXT_470 = ".get(inMessage";
  protected final String TEXT_471 = ",gmo";
  protected final String TEXT_472 = ");" + NL + "\t\t\t\t}catch (com.ibm.mq.MQException me_";
  protected final String TEXT_473 = ") {   " + NL + "\t\t            if (me_";
  protected final String TEXT_474 = ".reasonCode == com.ibm.mq.MQException.MQRC_NO_MSG_AVAILABLE) {" + NL + "\t\t            \tbreak;   " + NL + "\t\t            }else{" + NL + "\t\t            \tthrow me_";
  protected final String TEXT_475 = ";" + NL + "\t\t            }   " + NL + "     \t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_476 = NL + "\t\t\t\tremoteQ_";
  protected final String TEXT_477 = ".get(inMessage";
  protected final String TEXT_478 = ",gmo";
  protected final String TEXT_479 = ");" + NL + "\t\t\t";
  protected final String TEXT_480 = NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_481 = "\t\t\t\t" + NL + "\t\t\torg.talend.mq.headers.rfh2.MQRFH2 mqrfh2_";
  protected final String TEXT_482 = " = new org.talend.mq.headers.rfh2.MQRFH2(inMessage";
  protected final String TEXT_483 = ");" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_484 = NL + NL + "\t\t\t";
  protected final String TEXT_485 = NL + "\t    \t\tString msg_";
  protected final String TEXT_486 = "=inMessage";
  protected final String TEXT_487 = ".readStringOfByteLength(inMessage";
  protected final String TEXT_488 = ".getDataLength());" + NL + "\t\t\t";
  protected final String TEXT_489 = NL + "\t\t\t\tbyte[] bytesMsgBody_";
  protected final String TEXT_490 = " = new byte[inMessage";
  protected final String TEXT_491 = ".getDataLength()];" + NL + "\t\t\t\tinMessage";
  protected final String TEXT_492 = ".readFully(bytesMsgBody_";
  protected final String TEXT_493 = ");" + NL + "\t\t\t";
  protected final String TEXT_494 = NL + "\t\t\t\tString msg_";
  protected final String TEXT_495 = " = new String(bytesMsgBody_";
  protected final String TEXT_496 = ");" + NL + "\t\t\t";
  protected final String TEXT_497 = NL + "\t\t\t\tjava.util.Map msg_";
  protected final String TEXT_498 = " = (java.util.Map)inMessage";
  protected final String TEXT_499 = ".readObject();\t\t\t  " + NL + "\t\t\t";
  protected final String TEXT_500 = NL + "\t\t\t\tqMgr_";
  protected final String TEXT_501 = ".commit();" + NL + "\t\t\t";
  protected final String TEXT_502 = NL + NL + NL + "\t\t";
  protected final String TEXT_503 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	cid = cid.replaceAll("_Loop", "");
    boolean isUseExistConnection = ("true").equals(ElementParameterParser.getValue(node, "__USE_CONNECTION__"));
    String connectionComponentName = ElementParameterParser.getValue(node, "__CONNECTION__");
	String serverType=ElementParameterParser.getValue(node, "__SERVER__");
	String host=ElementParameterParser.getValue(node, "__SERVERADDRESS__");
	String port=ElementParameterParser.getValue(node, "__SERVERPORT__");
	String kListen=ElementParameterParser.getValue(node, "__KEEPLISTENING__");
	String msgBobyType =  ElementParameterParser.getValue(node, "__MESSAGE_BODY_TYPE__");
	String msgId=ElementParameterParser.getValue(node, "__MSG_ID__");
	String useMsgId=ElementParameterParser.getValue(node, "__IS_USE_MESSAGE_ID__");
	String from=ElementParameterParser.getValue(node, "__FROM__");
	String msgType = ElementParameterParser.getValue(node, "__MSGTYPE__");
	
	boolean transacted = "true".equals(ElementParameterParser.getValue(node, "__IS_TRANSACTED__"));
	String acknowledgmentMode = ElementParameterParser.getValue(node, "__ACKNOWLEDGMENT_MODE__");
	
	boolean failover =  ("true").equals(ElementParameterParser.getValue(node, "__FAILOVER__"));
	
	boolean staticdiscovery =  ("true").equals(ElementParameterParser.getValue(node, "__STATIC__"));
	String connectParamFailover = ElementParameterParser.getValue(node, "__CONNECTION_PARAM_FAILOVER__");
	String connectParamStatic = ElementParameterParser.getValue(node, "__CONNECTION_PARAM_STATIC__");
	boolean useMaxTimeout = ("true").equals(ElementParameterParser.getValue(node,"__USEMAX_WITH_TIMEOUT__"));
	
	List<Map<String,String>> servers = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SERVERS__");
	List<Map<String,String>> additionalOpts = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADDITIONAL_OPTIONS__");
	
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
	final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	boolean isUseSSL = ("true").equals(ElementParameterParser.getValue(node, "__USE_SSL__"));
	String transProtocol="tcp";
	if(isUseSSL){
		transProtocol = "ssl";
	}

	String strHost = null;
	String strPort = null;
	
	boolean useMqHeader = "true".equals(ElementParameterParser.getValue(node, "__USE_MQ_HEADER__"));

    List<? extends INode> commitNodes=node.getProcess().getNodesOfType("tMomCommit");
	List<? extends INode> rollBackNodes=node.getProcess().getNodesOfType("tMomRollback");
	
	boolean isCommitRollback = false;
	for(INode cNode:commitNodes){
		String cNodeName = ElementParameterParser.getValue(cNode,"__CONNECTION__");
		if(cid.equals(cNodeName) || (isUseExistConnection && connectionComponentName.equals(cNodeName))){
			isCommitRollback = true;
			break;
		}
	}
	if(!isCommitRollback){
		for(INode rNode:rollBackNodes){
			String rNodeName = ElementParameterParser.getValue(rNode,"__CONNECTION__");
			if(cid.equals(rNodeName) || (isUseExistConnection && connectionComponentName.equals(rNodeName))){
				isCommitRollback = true;
				break;
			}
		}
	}
    	
    if (isUseExistConnection) {
		for (INode pNode : node.getProcess().getNodesOfType("tMomConnection")) {
			if (pNode.getUniqueName().equals(connectionComponentName)) {
				transacted = "true".equals(ElementParameterParser.getValue(pNode, "__IS_TRANSACTED__")); 
				serverType = ElementParameterParser.getValue(pNode, "__SERVER__");
                failover =  ("true").equals(ElementParameterParser.getValue(pNode, "__FAILOVER__"));
			}	
		}
	}

	IMetadataTable metadata=null;
	List<IMetadataColumn> columns = null;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		metadata = metadatas.get(0);
		columns = metadata.getListColumns();
	} 
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
	if("ActiveMQ".equals(serverType) || "JBoss".equals(serverType)){

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
	} else {//websphere

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
		boolean isRollback = ("true").equals(ElementParameterParser.getValue(node, "__ROLLBACK__"));
		boolean isAutoBackout = ("true").equals(ElementParameterParser.getValue(node, "__AUTO_BACKOUT__"));
		
		boolean isCommit = ("true").equals(ElementParameterParser.getValue(node, "__COMMIT__"));
		boolean isBrowse = ("true").equals(ElementParameterParser.getValue(node,"__BROWSE__"));
		
		isCommit = isCommit && !isBrowse;
		isBrowse = isBrowse && !isRollback && !isCommit;
		isAutoBackout = isAutoBackout && !isBrowse && !isRollback && !isCommit;
		
		if(isAutoBackout){

    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
		}
	}

    stringBuffer.append(TEXT_13);
     if (isUseExistConnection && ("ActiveMQ").equals(serverType)) { 
    stringBuffer.append(TEXT_14);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(connectionComponentName);
    stringBuffer.append(TEXT_17);
    
				}
				
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(connectionComponentName);
    stringBuffer.append(TEXT_20);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
				}
				
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(connectionComponentName);
    stringBuffer.append(TEXT_28);
    
				}
				
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(connectionComponentName);
    stringBuffer.append(TEXT_31);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
				}
				
    stringBuffer.append(TEXT_34);
    stringBuffer.append(connectionComponentName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    
			if (("Queue").equals(msgType)) {
			
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(from );
    stringBuffer.append(TEXT_40);
    
			} else {
			
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(from );
    stringBuffer.append(TEXT_44);
    
			}
			
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
     boolean useMax = ("true").equals(ElementParameterParser.getValue(node,"__USEMAX__"));
			String maxiumMessages = ElementParameterParser.getValue(node,"__MAXMSG__");
			String receiveTimeOut = ElementParameterParser.getValue(node,"__TIMEOUT__");
			if(("true").equals(kListen)){
			
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    if(("ActiveMQ").equals(serverType) && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_60);
    
				}
				
    stringBuffer.append(TEXT_61);
    
			}else if (useMax) {
			
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(maxiumMessages );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    if(("ActiveMQ").equals(serverType) && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_69);
    
				}
				
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    if(useMaxTimeout){
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(receiveTimeOut);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    }else{
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    }
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    
			}else {
			
    stringBuffer.append(TEXT_83);
    stringBuffer.append(receiveTimeOut);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(receiveTimeOut);
    stringBuffer.append(TEXT_88);
    if(("ActiveMQ").equals(serverType) /*&& !isUseExistConnection*/ && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_89);
    
				}
				
    stringBuffer.append(TEXT_90);
    
			} 
    stringBuffer.append(TEXT_91);
    
			if(("true").equals(useMsgId) && !"Map".equals(msgBobyType)){
			
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(msgId);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    
			}else{
				if ("Text".equals(msgBobyType)) {
				
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    
				} else if ("Bytes".equals(msgBobyType)) {
				
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    
				    if(!"id_byte[]".equals(metadata.getColumn("message").getTalendType())){
				
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    
				    }
				} else if ("Map".equals(msgBobyType)) {
				
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    
				}
			}
			
    stringBuffer.append(TEXT_118);
    } else if (("JBoss").equals(serverType)||(!isUseExistConnection && ("ActiveMQ").equals(serverType))) {
	
			/*---------------------------------------1.initial jms connection factry---------------------------------*/ 
			if(("JBoss").equals(serverType) ){ // server judgement
			
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    		
			}else if(("ActiveMQ").equals(serverType)){
				boolean startServer = ("true").equals(ElementParameterParser.getValue(node, "__STARTSERVER__"));
				
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    if(failover || staticdiscovery){
      			if(failover){
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(connectParamFailover);
    stringBuffer.append(TEXT_138);
    }else if(staticdiscovery){
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(connectParamStatic);
    stringBuffer.append(TEXT_142);
    }
					int i=0;
					for(Map<String, String> serversMap : servers) {
						strHost = serversMap.get("SERVERS_HOST");
						strPort = serversMap.get("SERVERS_PORT");
	
						if(i>0) {
						
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    
						}
						
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(transProtocol);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(strHost);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(strPort);
    stringBuffer.append(TEXT_157);
    
						i++;
					}
					
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    
					for(Map<String, String> optrion : additionalOpts) {
					
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(optrion.get("OPTION_NAME"));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(optrion.get("OPTION_VALUE"));
    stringBuffer.append(TEXT_166);
    
					}
				}else{
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(transProtocol);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_171);
    }
    stringBuffer.append(TEXT_172);
    
				if(startServer){
				
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
    
				}
				
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append("Topic".equals(msgType));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(from);
    stringBuffer.append(TEXT_182);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    
				}
				
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    
			}
			
			/*---------------------------------------2.create Queue Or Topic from connection ---------------------------------*/ 
			
			if(dbuser == null || ("\"\"").equals(dbuser) || ("").equals(dbuser)) {
			
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    
			} else {
			
    stringBuffer.append(TEXT_192);
    
				String passwordFieldName = "__PASS__";
				
    stringBuffer.append(TEXT_193);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_196);
    } else {
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_199);
    }
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    
			}
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    
			}
			
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    
			}
			
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(transacted);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(acknowledgmentMode);
    stringBuffer.append(TEXT_217);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    
			}
			
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    
			if (("Queue").equals(msgType)) {
			
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(from );
    stringBuffer.append(TEXT_225);
    
			} else {
			
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(from );
    stringBuffer.append(TEXT_229);
    
			}
			
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
    	//put session to global map
			if( ("ActiveMQ").equals(serverType)) {
			
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    
			}
			
    stringBuffer.append(TEXT_242);
    		
			/*---------------------------------------3.recevice message form server ---------------------------------*/ 	
			if(("JBoss").equals(serverType) ){ 
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    
				}
				
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    		
			}else if(("ActiveMQ").equals(serverType)){
				boolean useMax = ("true").equals(ElementParameterParser.getValue(node,"__USEMAX__"));
				String maxiumMessages = ElementParameterParser.getValue(node,"__MAXMSG__");
				String receiveTimeOut = ElementParameterParser.getValue(node,"__TIMEOUT__");
				if(("true").equals(kListen)){
					if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    
					}
					
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    if(("ActiveMQ").equals(serverType) /*&& !isUseExistConnection*/ && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_256);
    
					}
					
    stringBuffer.append(TEXT_257);
    
				}else if (useMax) {
					if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(maxiumMessages );
    stringBuffer.append(TEXT_261);
    
					}
					
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(maxiumMessages );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    if(("ActiveMQ").equals(serverType) && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_269);
    
					}
					
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    if(useMaxTimeout){
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(receiveTimeOut);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    }else{
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    }
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_282);
    
				}else {
					if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(receiveTimeOut);
    stringBuffer.append(TEXT_286);
    
					}
					
    stringBuffer.append(TEXT_287);
    stringBuffer.append(receiveTimeOut);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(receiveTimeOut);
    stringBuffer.append(TEXT_292);
    if(("ActiveMQ").equals(serverType) /*&& !isUseExistConnection*/ && !isCommitRollback && transacted){
    stringBuffer.append(TEXT_293);
    
					}
					
    stringBuffer.append(TEXT_294);
    
				}
			}
			/*-----------------------------------------------------------4.judge message body type---------------------------------------*/
			if(("true").equals(useMsgId) && !"Map".equals(msgBobyType)){
			
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(msgId);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    
			}else{
				if ("Text".equals(msgBobyType)) {
				
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    
				} else if ("Bytes".equals(msgBobyType)) {
				
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    
				    if(!"id_byte[]".equals(metadata.getColumn("message").getTalendType())){
				
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    
				    }
				} else if ("Map".equals(msgBobyType)) {
				
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    
				}
			}
			
    stringBuffer.append(TEXT_321);
    
		} else if(("WebSphere").equals(serverType)){ //server judgement   /***WebSphere MQ*****/
			if(isUseExistConnection){
				String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
				
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    
			}else{
				String channel=ElementParameterParser.getValue(node, "__CHANNEL__");
				String qm=ElementParameterParser.getValue(node, "__QM__");
				boolean needSSLCipher = ("true").equals(ElementParameterParser.getValue(node,"__SET_MQ_SSL_CIPHER__"));
				String sslCipher = ElementParameterParser.getValue(node, "__MQ_SSL_CIPHER__");
				
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(channel);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    
				if(needSSLCipher){
				
    stringBuffer.append(TEXT_337);
    stringBuffer.append(sslCipher);
    stringBuffer.append(TEXT_338);
    
				}
				if(!(dbuser == null) && !("\"\"").equals(dbuser) && !("").equals(dbuser)) {
				
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_341);
    
					String passwordFieldName = "__PASS__";
					
    stringBuffer.append(TEXT_342);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_345);
    } else {
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_348);
    }
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    
				}
				
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(qm);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    
			}
			String queue = ElementParameterParser.getValue(node, "__QUEUE__");
			boolean isRollback = ("true").equals(ElementParameterParser.getValue(node, "__ROLLBACK__"));
			boolean isAutoBackout = ("true").equals(ElementParameterParser.getValue(node, "__AUTO_BACKOUT__"));
			
			boolean isCommit = ("true").equals(ElementParameterParser.getValue(node, "__COMMIT__"));
			boolean isBrowse = ("true").equals(ElementParameterParser.getValue(node,"__BROWSE__"));
			
			isCommit = isCommit && !isBrowse;
			isBrowse = isBrowse && !isRollback && !isCommit;
			isAutoBackout = isAutoBackout && !isBrowse && !isRollback && !isCommit;
			
			if(("true").equals(useMsgId)){
			
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(msgId);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    
			}
			
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    if(isBrowse){
    stringBuffer.append(TEXT_377);
    }
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    if(isBrowse){
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_383);
    }else{
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    }
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_389);
    if(("false").equals(kListen)){
    stringBuffer.append(TEXT_390);
    }else{
    stringBuffer.append(TEXT_391);
    }
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(queue);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    
				if(isAutoBackout){
				
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
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
    
						if(isLog4jEnabled){
						
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    
						}
						
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    
						if(isLog4jEnabled){
						
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(queue);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(queue);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    
						}
						
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    
						if(isLog4jEnabled){
						
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
    
						}else{
						
    stringBuffer.append(TEXT_437);
    
						}
						
    stringBuffer.append(TEXT_438);
    
				}
				
    stringBuffer.append(TEXT_439);
    
			if(("false").equals(kListen)) {
			
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    
			}	
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_443);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    
			}
			
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    
			if(isAutoBackout){
			
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    
			}
			
			if(("false").equals(kListen)){
			
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    
			}
			if(isBrowse){
			
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    if(("false").equals(kListen)){
    stringBuffer.append(TEXT_458);
    }else{
    stringBuffer.append(TEXT_459);
    }
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_463);
    
			}
			
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    
			if(("true").equals(useMsgId)&& !"Map".equals(msgBobyType)){
			
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_468);
    
			}
			if(("false").equals(kListen) && ("true").equals(useMsgId) && !"Map".equals(msgBobyType) ){
			
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_475);
    
			} else {
			
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    
			}
			
    stringBuffer.append(TEXT_480);
    
			if (useMqHeader) {
			
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_483);
    }
    stringBuffer.append(TEXT_484);
    		
			if ("Text".equals(msgBobyType)) {
			
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    
			} else if ("Bytes".equals(msgBobyType)) {
			
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_493);
    
		    	if(!"id_byte[]".equals(metadata.getColumn("message").getTalendType())){
			
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
    
		    	}
			} else if ("Map".equals(msgBobyType)) {
			
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_499);
    
			}
			if(isCommit){
			
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_501);
    
			}
			
		}
		
    stringBuffer.append(TEXT_502);
    stringBuffer.append(TEXT_503);
    return stringBuffer.toString();
  }
}
