package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TFileFetchMainJava
{
  protected static String nl;
  public static synchronized TFileFetchMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileFetchMainJava result = new TFileFetchMainJava();
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
  protected final String TEXT_29 = NL + "java.io.InputStream retIS_";
  protected final String TEXT_30 = " = null;" + NL;
  protected final String TEXT_31 = NL + "\t\tclass SocketFactory_";
  protected final String TEXT_32 = " implements org.apache.commons.httpclient.protocol.SecureProtocolSocketFactory {" + NL + "" + NL + "\t\t\tprivate javax.net.ssl.SSLContext sslcontext = null;" + NL + "" + NL + "\t\t\tprivate javax.net.ssl.SSLContext createSSLContext() {" + NL + "\t\t\t\tjavax.net.ssl.SSLContext sslcontext = null;" + NL + "" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tsslcontext = javax.net.ssl.SSLContext.getInstance(\"SSL\");" + NL + "\t\t\t\t\tsslcontext.init(null, new javax.net.ssl.TrustManager[] { new TrustAnyTrustManager() }, new java.security.SecureRandom());" + NL + "\t\t\t\t} catch (java.security.NoSuchAlgorithmException e) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_34 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t} catch (java.security.KeyManagementException e) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_36 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_37 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_38 = NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn sslcontext;" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tprivate javax.net.ssl.SSLContext getSSLContext() {" + NL + "" + NL + "\t\t\t\tif (this.sslcontext == null) {" + NL + "\t\t\t\t\tthis.sslcontext = createSSLContext();" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn this.sslcontext;" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tpublic java.net.Socket createSocket(java.net.Socket socket, String host, int port, boolean autoClose)" + NL + "\t\t\t\tthrows java.io.IOException, java.net.UnknownHostException {" + NL + "\t\t\t\treturn getSSLContext().getSocketFactory().createSocket(socket, host, port, autoClose);" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tpublic java.net.Socket createSocket(String host, int port) throws java.io.IOException, java.net.UnknownHostException {" + NL + "\t\t\t\treturn getSSLContext().getSocketFactory().createSocket(host, port);" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tpublic java.net.Socket createSocket(String host, int port, java.net.InetAddress clientHost, int clientPort)" + NL + "\t\t\t\tthrows java.io.IOException, java.net.UnknownHostException {" + NL + "\t\t\t\treturn getSSLContext().getSocketFactory().createSocket(host, port, clientHost, clientPort);" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tpublic java.net.Socket createSocket(String host, int port, java.net.InetAddress localAddress, int localPort, org.apache.commons.httpclient.params.HttpConnectionParams params) " + NL + "\t\t\t\tthrows java.io.IOException, java.net.UnknownHostException, org.apache.commons.httpclient.ConnectTimeoutException {" + NL + "" + NL + "\t\t\t\tif (params == null) {" + NL + "\t\t\t\t\tthrow new IllegalArgumentException(\"Parameters may not be null\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\tint timeout = params.getConnectionTimeout();" + NL + "\t\t\t\tjavax.net.SocketFactory socketfactory = getSSLContext().getSocketFactory();" + NL + "" + NL + "\t\t\t\tif (timeout == 0) {" + NL + "\t\t\t\t\treturn socketfactory.createSocket(host, port, localAddress, localPort);" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tjava.net.Socket socket = socketfactory.createSocket();" + NL + "\t\t\t\t\tjava.net.SocketAddress localaddr = new java.net.InetSocketAddress(localAddress, localPort);" + NL + "\t\t\t\t\tjava.net.SocketAddress remoteaddr = new java.net.InetSocketAddress(host, port);" + NL + "\t\t\t\t\tsocket.bind(localaddr);" + NL + "\t\t\t\t\tsocket.connect(remoteaddr, timeout);" + NL + "\t\t\t\t\treturn socket;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tclass TrustAnyTrustManager implements javax.net.ssl.X509TrustManager {" + NL + "\t\t\t\tpublic void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)" + NL + "\t\t\t\t\tthrows java.security.cert.CertificateException {" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)" + NL + "\t\t\t\t\tthrows java.security.cert.CertificateException {" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic java.security.cert.X509Certificate[] getAcceptedIssuers() {" + NL + "\t\t\t\t\treturn new java.security.cert.X509Certificate[] {};" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\tif ((";
  protected final String TEXT_39 = ").toLowerCase().startsWith(\"https://\")) {" + NL + "\t\t\torg.apache.commons.httpclient.protocol.Protocol myhttps = new org.apache.commons.httpclient.protocol.Protocol(\"https\", new SocketFactory_";
  protected final String TEXT_40 = "(), 443);" + NL + "\t\t\torg.apache.commons.httpclient.protocol.Protocol.registerProtocol(\"https\", myhttps);" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_41 = NL + "\torg.apache.commons.httpclient.HttpClient client_";
  protected final String TEXT_42 = " = new org.apache.commons.httpclient.HttpClient();" + NL + "\t";
  protected final String TEXT_43 = NL + "\t\tlog.info(\"";
  protected final String TEXT_44 = " - Connection attempt to '\" + ";
  protected final String TEXT_45 = ");" + NL + "\t";
  protected final String TEXT_46 = NL + "\tclient_";
  protected final String TEXT_47 = ".getHttpConnectionManager().getParams().setConnectionTimeout(";
  protected final String TEXT_48 = ");" + NL + "\t";
  protected final String TEXT_49 = NL + "\t\tlog.info(\"";
  protected final String TEXT_50 = " - Connection to '\" +  ";
  protected final String TEXT_51 = " + \"' has succeeded.\");" + NL + "\t";
  protected final String TEXT_52 = NL + "\tclient_";
  protected final String TEXT_53 = ".getParams().setCookiePolicy(org.apache.commons.httpclient.cookie.CookiePolicy.";
  protected final String TEXT_54 = ");" + NL + "\t";
  protected final String TEXT_55 = NL + "\tclient_";
  protected final String TEXT_56 = ".getParams().setBooleanParameter(org.apache.commons.httpclient.params.HttpMethodParams.SINGLE_COOKIE_HEADER, true);" + NL + "\t";
  protected final String TEXT_57 = NL + "\t";
  protected final String TEXT_58 = NL + "\t\tList<org.apache.commons.httpclient.Cookie> cookieList_";
  protected final String TEXT_59 = " = null;" + NL + "\t\tjava.io.FileInputStream fis_";
  protected final String TEXT_60 = " = null;" + NL + "\t\tjava.io.ObjectInputStream is_";
  protected final String TEXT_61 = " = null;" + NL + "\t\t" + NL + "\t\ttry {" + NL + "\t\t\tcookieList_";
  protected final String TEXT_62 = " = new java.util.ArrayList<org.apache.commons.httpclient.Cookie>();" + NL + "\t\t\tfis_";
  protected final String TEXT_63 = " = new java.io.FileInputStream(new java.io.File(";
  protected final String TEXT_64 = "));" + NL + "\t\t\tis_";
  protected final String TEXT_65 = " = new java.io.ObjectInputStream(fis_";
  protected final String TEXT_66 = ");" + NL + "\t\t\tObject obj_";
  protected final String TEXT_67 = " = is_";
  protected final String TEXT_68 = ".readObject();" + NL + "" + NL + "\t\t\twhile (obj_";
  protected final String TEXT_69 = " != null) {" + NL + "\t\t\t\tcookieList_";
  protected final String TEXT_70 = ".add((org.apache.commons.httpclient.Cookie) obj_";
  protected final String TEXT_71 = ");" + NL + "" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tobj_";
  protected final String TEXT_72 = " = is_";
  protected final String TEXT_73 = ".readObject();" + NL + "\t\t\t\t} catch (java.io.IOException e) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_74 = NL + "\t\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_75 = " - \" + e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\t\tobj_";
  protected final String TEXT_77 = " = null;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t} catch (java.io.FileNotFoundException e1) {" + NL + "\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_79 = " - \" + e1.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_80 = NL + "\t\t\te1.printStackTrace();" + NL + "\t\t} catch (java.io.IOException e) {" + NL + "\t\t\t";
  protected final String TEXT_81 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_82 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\te.printStackTrace();" + NL + "\t\t} catch (java.lang.ClassNotFoundException e) {" + NL + "\t\t\t";
  protected final String TEXT_84 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_85 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_86 = NL + "\t\t\te.printStackTrace();" + NL + "\t\t} finally {" + NL + "\t\t\tif (is_";
  protected final String TEXT_87 = " != null) is_";
  protected final String TEXT_88 = ".close();" + NL + "\t\t\tif (fis_";
  protected final String TEXT_89 = " != null) fis_";
  protected final String TEXT_90 = ".close();" + NL + "\t\t}" + NL + "" + NL + "\t\tif (cookieList_";
  protected final String TEXT_91 = " != null)" + NL + "\t\t\tclient_";
  protected final String TEXT_92 = ".getState().addCookies(cookieList_";
  protected final String TEXT_93 = ".toArray(new org.apache.commons.httpclient.Cookie[0]));" + NL + "\t";
  protected final String TEXT_94 = " " + NL + "\t\tclient_";
  protected final String TEXT_95 = ".getHostConfiguration().setProxy(";
  protected final String TEXT_96 = ", Integer.parseInt(";
  protected final String TEXT_97 = "));" + NL + "\t        " + NL + "\t\t";
  protected final String TEXT_98 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_99 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_100 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_101 = ");";
  protected final String TEXT_102 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_103 = " = ";
  protected final String TEXT_104 = "; ";
  protected final String TEXT_105 = NL + "\t   \t" + NL + "\t\t";
  protected final String TEXT_106 = NL + "\t\t\tclient_";
  protected final String TEXT_107 = ".getState().setProxyCredentials(" + NL + "\t\t\tnew org.apache.commons.httpclient.auth.AuthScope( ";
  protected final String TEXT_108 = ", Integer.parseInt(";
  protected final String TEXT_109 = "), null )," + NL + "\t\t\tnew org.apache.commons.httpclient.NTCredentials( ";
  protected final String TEXT_110 = "," + NL + "\t\t\tdecryptedPassword_";
  protected final String TEXT_111 = ", ";
  protected final String TEXT_112 = ", ";
  protected final String TEXT_113 = " ));" + NL + "\t\t";
  protected final String TEXT_114 = NL + "\t\t\tclient_";
  protected final String TEXT_115 = ".getState().setProxyCredentials(" + NL + "\t\t\tnew org.apache.commons.httpclient.auth.AuthScope(";
  protected final String TEXT_116 = ", Integer.parseInt(";
  protected final String TEXT_117 = "), null)," + NL + "\t\t\tnew org.apache.commons.httpclient.UsernamePasswordCredentials(";
  protected final String TEXT_118 = ", decryptedPassword_";
  protected final String TEXT_119 = "));" + NL + "\t\t";
  protected final String TEXT_120 = NL + "\t\tString decryptedPwd_";
  protected final String TEXT_121 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_122 = ");" + NL + "\t\t";
  protected final String TEXT_123 = NL + "\t\tString decryptedPwd_";
  protected final String TEXT_124 = " = ";
  protected final String TEXT_125 = ";" + NL + "\t\t";
  protected final String TEXT_126 = NL + "\t\t\tclient_";
  protected final String TEXT_127 = ".getState().setCredentials(org.apache.commons.httpclient.auth.AuthScope.ANY, new org.apache.commons.httpclient.NTCredentials(";
  protected final String TEXT_128 = ", decryptedPwd_";
  protected final String TEXT_129 = ", new java.net.URL(";
  protected final String TEXT_130 = ").getHost(), ";
  protected final String TEXT_131 = "));" + NL + "\t\t";
  protected final String TEXT_132 = NL + "\t\t\tclient_";
  protected final String TEXT_133 = ".getState().setCredentials(org.apache.commons.httpclient.auth.AuthScope.ANY, new org.apache.commons.httpclient.UsernamePasswordCredentials(";
  protected final String TEXT_134 = ", decryptedPwd_";
  protected final String TEXT_135 = "));" + NL + "\t\t";
  protected final String TEXT_136 = NL + "\t\torg.apache.commons.httpclient.methods.PostMethod method_";
  protected final String TEXT_137 = " = new org.apache.commons.httpclient.methods.PostMethod(";
  protected final String TEXT_138 = ");" + NL + "\t\t";
  protected final String TEXT_139 = NL + "\t\t\torg.apache.commons.httpclient.methods.multipart.StringPart common_";
  protected final String TEXT_140 = "_";
  protected final String TEXT_141 = " = new org.apache.commons.httpclient.methods.multipart.StringPart(";
  protected final String TEXT_142 = ", ";
  protected final String TEXT_143 = ");" + NL + "\t\t\t";
  protected final String TEXT_144 = NL + "\t\t\t\torg.apache.commons.httpclient.methods.multipart.FilePart file_";
  protected final String TEXT_145 = "_";
  protected final String TEXT_146 = "  = new org.apache.commons.httpclient.methods.multipart.FilePart(";
  protected final String TEXT_147 = ", new java.io.File(";
  protected final String TEXT_148 = "), ";
  protected final String TEXT_149 = ", ";
  protected final String TEXT_150 = ");" + NL + "\t\t\t";
  protected final String TEXT_151 = NL + "\t\torg.apache.commons.httpclient.methods.multipart.Part[] parts_";
  protected final String TEXT_152 = " = new org.apache.commons.httpclient.methods.multipart.Part[]{";
  protected final String TEXT_153 = ",";
  protected final String TEXT_154 = "};    " + NL + "\t\tmethod_";
  protected final String TEXT_155 = ".setRequestEntity(new org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity(parts_";
  protected final String TEXT_156 = ", method_";
  protected final String TEXT_157 = ".getParams()));          " + NL + "\t";
  protected final String TEXT_158 = NL + "\t\torg.apache.commons.httpclient.methods.GetMethod method_";
  protected final String TEXT_159 = " = new org.apache.commons.httpclient.methods.GetMethod(";
  protected final String TEXT_160 = ");" + NL + "\t";
  protected final String TEXT_161 = NL + "\t\t\tmethod_";
  protected final String TEXT_162 = ".addRequestHeader(";
  protected final String TEXT_163 = ",";
  protected final String TEXT_164 = ");" + NL + "\t\t";
  protected final String TEXT_165 = NL + "\tboolean isContinue_";
  protected final String TEXT_166 = " = true;" + NL + "\tint status_";
  protected final String TEXT_167 = ";" + NL + "\tString finalURL_";
  protected final String TEXT_168 = " = ";
  protected final String TEXT_169 = ";" + NL + "" + NL + "\ttry { // B_01" + NL + "\t\t";
  protected final String TEXT_170 = NL + "\t\t\tboolean redirect_";
  protected final String TEXT_171 = " = true;" + NL + "" + NL + "\t\t\twhile (redirect_";
  protected final String TEXT_172 = ") {" + NL + "\t\t\t\tstatus_";
  protected final String TEXT_173 = " = client_";
  protected final String TEXT_174 = ".executeMethod(method_";
  protected final String TEXT_175 = ");" + NL + "" + NL + "\t\t\t\tif ((status_";
  protected final String TEXT_176 = " == org.apache.commons.httpclient.HttpStatus.SC_MOVED_TEMPORARILY) " + NL + "\t\t\t\t\t|| (status_";
  protected final String TEXT_177 = " == org.apache.commons.httpclient.HttpStatus.SC_MOVED_PERMANENTLY) " + NL + "\t\t\t\t\t\t|| (status_";
  protected final String TEXT_178 = " == org.apache.commons.httpclient.HttpStatus.SC_SEE_OTHER) " + NL + "\t\t\t\t\t\t\t|| (status_";
  protected final String TEXT_179 = " == org.apache.commons.httpclient.HttpStatus.SC_TEMPORARY_REDIRECT)) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_180 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_181 = " - Closing the connection to the server.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_182 = NL + "\t\t\t\t\tmethod_";
  protected final String TEXT_183 = ".releaseConnection();" + NL + "\t\t\t\t\t";
  protected final String TEXT_184 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_185 = " - Connection to the server closed.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_186 = NL + NL + "\t\t\t\t\tif (method_";
  protected final String TEXT_187 = ".getResponseHeader(\"location\").getValue().startsWith(\"http\")) {" + NL + "\t\t\t\t\t\tmethod_";
  protected final String TEXT_188 = " = new org.apache.commons.httpclient.methods.";
  protected final String TEXT_189 = "Post";
  protected final String TEXT_190 = "Get";
  protected final String TEXT_191 = "Method(method_";
  protected final String TEXT_192 = ".getResponseHeader(\"location\").getValue());" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tmethod_";
  protected final String TEXT_193 = " = new org.apache.commons.httpclient.methods.";
  protected final String TEXT_194 = "Post";
  protected final String TEXT_195 = "Get";
  protected final String TEXT_196 = "Method(\"http://\" + method_";
  protected final String TEXT_197 = ".getURI().getHost() + method_";
  protected final String TEXT_198 = ".getResponseHeader(\"location\").getValue());" + NL + "\t\t\t\t\t\t//method_";
  protected final String TEXT_199 = ".setURI(new org.apache.commons.httpclient.URI(\"/\" + method_";
  protected final String TEXT_200 = ".getResponseHeader(\"location\").getValue(), false));" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tSystem.out.println(\"Redirect to: \" + method_";
  protected final String TEXT_201 = ".getURI());" + NL + "\t\t\t\t\tfinalURL_";
  protected final String TEXT_202 = " = method_";
  protected final String TEXT_203 = ".getURI().toString();" + NL + "\t\t\t\t} else if (status_";
  protected final String TEXT_204 = " == org.apache.commons.httpclient.HttpStatus.SC_OK) {" + NL + "\t\t\t\t\tredirect_";
  protected final String TEXT_205 = " = false;" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tthrow new java.lang.Exception(\"Method failed: \" + method_";
  protected final String TEXT_206 = ".getStatusLine());" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_207 = NL + "\t\t\tstatus_";
  protected final String TEXT_208 = "  = client_";
  protected final String TEXT_209 = ".executeMethod(method_";
  protected final String TEXT_210 = ");" + NL + "\t\t";
  protected final String TEXT_211 = NL + "\t\t\torg.apache.commons.httpclient.Cookie[] cookies_";
  protected final String TEXT_212 = " = client_";
  protected final String TEXT_213 = ".getState().getCookies();" + NL + "\t\t\tjava.io.File cookieFile_";
  protected final String TEXT_214 = " = new java.io.File(";
  protected final String TEXT_215 = ");" + NL + "\t\t\tjava.io.File cookieDir_";
  protected final String TEXT_216 = "= cookieFile_";
  protected final String TEXT_217 = ".getParentFile(); " + NL + "\t\t\tif(!cookieDir_";
  protected final String TEXT_218 = ".exists()){" + NL + "\t\t\t\tcookieDir_";
  protected final String TEXT_219 = ".mkdirs();" + NL + "\t\t\t}" + NL + "\t\t\tjava.io.FileOutputStream fos_";
  protected final String TEXT_220 = " = new java.io.FileOutputStream(cookieFile_";
  protected final String TEXT_221 = ");" + NL + "\t\t\tjava.io.ObjectOutputStream os_";
  protected final String TEXT_222 = " = new java.io.ObjectOutputStream(fos_";
  protected final String TEXT_223 = ");" + NL + "" + NL + "\t\t\tfor (org.apache.commons.httpclient.Cookie c : cookies_";
  protected final String TEXT_224 = ") {" + NL + "\t\t\t\tos_";
  protected final String TEXT_225 = ".writeObject(c);" + NL + "\t\t\t}" + NL + "\t\t\tos_";
  protected final String TEXT_226 = ".close();" + NL + "\t\t\tfos_";
  protected final String TEXT_227 = ".close();" + NL + "\t\t";
  protected final String TEXT_228 = NL + "\t\t\tif (status_";
  protected final String TEXT_229 = " != org.apache.commons.httpclient.HttpStatus.SC_OK) {      " + NL + "\t\t\t\tthrow new java.lang.Exception(\"Method failed: \" + method_";
  protected final String TEXT_230 = ".getStatusLine());" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_231 = NL + "\t} catch(java.lang.Exception e) {" + NL + "\t\t";
  protected final String TEXT_232 = NL + "\t\t\tthrow(e);" + NL + "\t\t";
  protected final String TEXT_233 = "   " + NL + "\t\t\t";
  protected final String TEXT_234 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_235 = " - There isContinue_";
  protected final String TEXT_236 = " an exception on: \" + ";
  protected final String TEXT_237 = ");" + NL + "\t\t\t";
  protected final String TEXT_238 = NL + "\t\t\tSystem.err.println(\"There isContinue_";
  protected final String TEXT_239 = " an exception on: \" + ";
  protected final String TEXT_240 = ");" + NL + "\t\t\te.printStackTrace();" + NL + "\t\t\tSystem.out.println(\"\\r\\n\");" + NL + "\t\t\tisContinue_";
  protected final String TEXT_241 = " = false;" + NL + "\t\t";
  protected final String TEXT_242 = NL + "\t}" + NL + "" + NL + "\tif (isContinue_";
  protected final String TEXT_243 = ") {    " + NL + "\t\t";
  protected final String TEXT_244 = NL + "\t\t\tSystem.out.println(\"Status Line: \" + method_";
  protected final String TEXT_245 = ".getStatusLine());  " + NL + "\t\t\tSystem.out.println(\"*** Response Header ***\");  " + NL + "\t\t\torg.apache.commons.httpclient.Header[] responseHeaders_";
  protected final String TEXT_246 = " = method_";
  protected final String TEXT_247 = ".getResponseHeaders();  " + NL + "" + NL + "\t\t\tfor (int i = 0; i < responseHeaders_";
  protected final String TEXT_248 = ".length; i++) {" + NL + "\t\t\t\tSystem.out.print(responseHeaders_";
  protected final String TEXT_249 = "[i]);" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_250 = NL + "\t\t\tretIS_";
  protected final String TEXT_251 = " = method_";
  protected final String TEXT_252 = ".getResponseBodyAsStream();" + NL + "\t\t";
  protected final String TEXT_253 = NL + "\t\t\tjava.io.InputStream in_";
  protected final String TEXT_254 = " = method_";
  protected final String TEXT_255 = ".getResponseBodyAsStream();" + NL + "\t\t\tString sDir_";
  protected final String TEXT_256 = " = (";
  protected final String TEXT_257 = ").trim();" + NL + "\t\t\tString fileName_";
  protected final String TEXT_258 = " = (";
  protected final String TEXT_259 = ").trim();    " + NL + "\t\t\t//open directory" + NL + "\t\t\tjava.net.URL url_";
  protected final String TEXT_260 = " = new java.net.URL(finalURL_";
  protected final String TEXT_261 = ");" + NL + "\t\t\tString sURIPath_";
  protected final String TEXT_262 = " = \"\";" + NL + "\t\t\tint iLastSlashIndex_";
  protected final String TEXT_263 = " = 0;" + NL + "\t\t\tsURIPath_";
  protected final String TEXT_264 = " = url_";
  protected final String TEXT_265 = ".getFile();" + NL + "\t\t\tiLastSlashIndex_";
  protected final String TEXT_266 = " = sURIPath_";
  protected final String TEXT_267 = ".lastIndexOf(\"/\");" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_268 = NL + "\t\t\t\tsDir_";
  protected final String TEXT_269 = " = sDir_";
  protected final String TEXT_270 = ".concat(iLastSlashIndex_";
  protected final String TEXT_271 = " > 0 ? sURIPath_";
  protected final String TEXT_272 = ".substring(0, iLastSlashIndex_";
  protected final String TEXT_273 = ") : \"\");" + NL + "\t\t\t";
  protected final String TEXT_274 = NL + NL + "\t\t\t// if not input file name, get the name from URI" + NL + "\t\t\tif (\"\".equals(fileName_";
  protected final String TEXT_275 = ")) {      " + NL + "\t\t\t\tif (iLastSlashIndex_";
  protected final String TEXT_276 = " > 0 && (!sURIPath_";
  protected final String TEXT_277 = ".endsWith(\"/\"))) {" + NL + "\t\t\t\t\tfileName_";
  protected final String TEXT_278 = " = sURIPath_";
  protected final String TEXT_279 = ".substring(iLastSlashIndex_";
  protected final String TEXT_280 = " + 1);" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tfileName_";
  protected final String TEXT_281 = " = \"defaultfilename.txt\";" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tjava.io.File dir_";
  protected final String TEXT_282 = " = new java.io.File(sDir_";
  protected final String TEXT_283 = ");" + NL + "" + NL + "\t\t\t// pretreatment" + NL + "\t\t\ttry {" + NL + "\t\t\t\tjava.io.File test_file_";
  protected final String TEXT_284 = " = new java.io.File(dir_";
  protected final String TEXT_285 = ", fileName_";
  protected final String TEXT_286 = ");" + NL + "\t\t\t\ttest_file_";
  protected final String TEXT_287 = ".getParentFile().mkdirs();" + NL + "" + NL + "\t\t\t\tif (test_file_";
  protected final String TEXT_288 = ".createNewFile()) {" + NL + "\t\t\t\t\ttest_file_";
  protected final String TEXT_289 = ".delete();" + NL + "\t\t\t\t}" + NL + "\t\t\t} catch(java.lang.Exception e) {" + NL + "\t\t\t\t";
  protected final String TEXT_290 = NL + "\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_291 = " - \" + e.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_292 = NL + "\t\t\t\tfileName_";
  protected final String TEXT_293 = " = \"defaultfilename.txt\";" + NL + "\t\t\t}" + NL + "\t\t\tjava.io.File file_";
  protected final String TEXT_294 = " = new java.io.File(dir_";
  protected final String TEXT_295 = ", fileName_";
  protected final String TEXT_296 = ");" + NL + "\t\t\tfile_";
  protected final String TEXT_297 = ".getParentFile().mkdirs();    " + NL + "\t\t\tjava.io.FileOutputStream out_";
  protected final String TEXT_298 = " = new java.io.FileOutputStream(file_";
  protected final String TEXT_299 = ");" + NL + "\t\t\tbyte[] buffer_";
  protected final String TEXT_300 = " = new byte[1024];" + NL + "\t\t\tint count_";
  protected final String TEXT_301 = " = 0;" + NL + "" + NL + "\t\t\twhile ((count_";
  protected final String TEXT_302 = " = in_";
  protected final String TEXT_303 = ".read(buffer_";
  protected final String TEXT_304 = ")) > 0) {" + NL + "\t\t\t\tout_";
  protected final String TEXT_305 = ".write(buffer_";
  protected final String TEXT_306 = ", 0, count_";
  protected final String TEXT_307 = ");" + NL + "\t\t\t}" + NL + "\t\t\t// close opened object" + NL + "\t\t\tin_";
  protected final String TEXT_308 = ".close();   " + NL + "\t\t\tout_";
  protected final String TEXT_309 = ".close(); " + NL + "\t\t\t";
  protected final String TEXT_310 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_311 = " - Closing the connection to the server.\");" + NL + "\t\t\t";
  protected final String TEXT_312 = NL + "\t\t\tmethod_";
  protected final String TEXT_313 = ".releaseConnection();" + NL + "\t\t\t";
  protected final String TEXT_314 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_315 = " - Connection to the server closed.\");" + NL + "\t\t\t";
  protected final String TEXT_316 = "   " + NL + "\t\t";
  protected final String TEXT_317 = "    " + NL + "\t} // B_01";
  protected final String TEXT_318 = NL + "\t\tjava.util.Properties props = System.getProperties();" + NL + "\t\tprops.put(\"socksProxyPort\", ";
  protected final String TEXT_319 = ");" + NL + "\t\tprops.put(\"socksProxyHost\", ";
  protected final String TEXT_320 = ");" + NL + "\t\tprops.put(\"java.net.socks.username\", ";
  protected final String TEXT_321 = ");" + NL + "\t        " + NL + "\t\t";
  protected final String TEXT_322 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_323 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_324 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_325 = ");";
  protected final String TEXT_326 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_327 = " = ";
  protected final String TEXT_328 = "; ";
  protected final String TEXT_329 = NL + "\t   \t" + NL + "\t\tprops.put(\"java.net.socks.password\", decryptedPassword_";
  protected final String TEXT_330 = ");        " + NL + "\t";
  protected final String TEXT_331 = NL + "\t//open url stream" + NL + "\tjava.net.URL url_";
  protected final String TEXT_332 = " = new java.net.URL(";
  protected final String TEXT_333 = ");    " + NL + "\t";
  protected final String TEXT_334 = NL + "\t\tlog.info(\"";
  protected final String TEXT_335 = " - Connection attempt to '\" + ";
  protected final String TEXT_336 = ");" + NL + "\t";
  protected final String TEXT_337 = NL + "\tjava.net.URLConnection conn_";
  protected final String TEXT_338 = " = url_";
  protected final String TEXT_339 = ".openConnection();" + NL + "\t";
  protected final String TEXT_340 = NL + "\t\tlog.info(\"";
  protected final String TEXT_341 = " - Connection to '\" +  ";
  protected final String TEXT_342 = " + \"' has succeeded.\");" + NL + "\t";
  protected final String TEXT_343 = NL + NL + "\t";
  protected final String TEXT_344 = NL + "\t\tretIS_";
  protected final String TEXT_345 = " = conn_";
  protected final String TEXT_346 = ".getInputStream();" + NL + "\t";
  protected final String TEXT_347 = NL + "\t\tjava.io.DataInputStream in_";
  protected final String TEXT_348 = " = null;" + NL + "\t\tString sDir_";
  protected final String TEXT_349 = " = (";
  protected final String TEXT_350 = ").trim();" + NL + "\t\tString fileName_";
  protected final String TEXT_351 = " = (";
  protected final String TEXT_352 = ").trim();" + NL + "" + NL + "\t\tString sURIPath_";
  protected final String TEXT_353 = " = \"\";" + NL + "\t\tint iLastSlashIndex_";
  protected final String TEXT_354 = " = 0;" + NL + "\t\tsURIPath_";
  protected final String TEXT_355 = " = url_";
  protected final String TEXT_356 = ".getFile();" + NL + "\t\tiLastSlashIndex_";
  protected final String TEXT_357 = " = sURIPath_";
  protected final String TEXT_358 = ".lastIndexOf(\"/\");" + NL + "" + NL + "\t\t";
  protected final String TEXT_359 = NL + "\t\t\tsDir_";
  protected final String TEXT_360 = " = sDir_";
  protected final String TEXT_361 = ".concat(iLastSlashIndex_";
  protected final String TEXT_362 = " > 0 ? sURIPath_";
  protected final String TEXT_363 = ".substring(0, iLastSlashIndex_";
  protected final String TEXT_364 = ") : \"\");" + NL + "\t\t";
  protected final String TEXT_365 = NL + NL + "\t\t//if not input file name, get the name from URI" + NL + "\t\tif (\"\".equals(fileName_";
  protected final String TEXT_366 = ")) {      " + NL + "\t\t\tif (iLastSlashIndex_";
  protected final String TEXT_367 = " > 0 && (!sURIPath_";
  protected final String TEXT_368 = ".endsWith(\"/\"))) {" + NL + "\t\t\t\tfileName_";
  protected final String TEXT_369 = " = sURIPath_";
  protected final String TEXT_370 = ".substring(iLastSlashIndex_";
  protected final String TEXT_371 = " + 1);" + NL + "\t\t\t} else {" + NL + "\t\t\t\tfileName_";
  protected final String TEXT_372 = " = \"defaultfilename.txt\";" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tjava.io.File dir_";
  protected final String TEXT_373 = " = new java.io.File(sDir_";
  protected final String TEXT_374 = ");" + NL + "" + NL + "\t\ttry {" + NL + "\t\t\tjava.io.File testfile_";
  protected final String TEXT_375 = " = new java.io.File(dir_";
  protected final String TEXT_376 = ", fileName_";
  protected final String TEXT_377 = ");" + NL + "\t\t\t";
  protected final String TEXT_378 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_379 = " - Creating directory '\" + testfile_";
  protected final String TEXT_380 = ".getParentFile().getCanonicalPath());" + NL + "\t\t\t";
  protected final String TEXT_381 = NL + "\t\t\ttestfile_";
  protected final String TEXT_382 = ".getParentFile().mkdirs();" + NL + "\t\t\t";
  protected final String TEXT_383 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_384 = " - Create directory '\" + testfile_";
  protected final String TEXT_385 = ".getParentFile().getCanonicalPath()+ \"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_386 = NL + NL + "\t\t\tif (testfile_";
  protected final String TEXT_387 = ".createNewFile()) {" + NL + "\t\t\t\ttestfile_";
  protected final String TEXT_388 = ".delete();" + NL + "\t\t\t}" + NL + "\t\t} catch(java.lang.Exception e) {" + NL + "\t\t\t";
  protected final String TEXT_389 = NL + "\t\t\t\tlog.warn(\"";
  protected final String TEXT_390 = " - \" + e.getMessage());" + NL + "\t\t\t";
  protected final String TEXT_391 = NL + "\t\t\tfileName_";
  protected final String TEXT_392 = " = \"defaultfilename.txt\";" + NL + "\t\t}" + NL + "" + NL + "\t\t// copy file" + NL + "\t\ttry {" + NL + "\t\t\tin_";
  protected final String TEXT_393 = " = new java.io.DataInputStream(conn_";
  protected final String TEXT_394 = ".getInputStream());" + NL + "\t\t} catch(java.lang.Exception e) {" + NL + "\t\t\t";
  protected final String TEXT_395 = "    " + NL + "\t\t\t\tthrow(e);" + NL + "\t\t\t";
  protected final String TEXT_396 = NL + "\t\t\t\t";
  protected final String TEXT_397 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_398 = " - There is an exception on: \" + ";
  protected final String TEXT_399 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_400 = NL + "\t\t\t\tSystem.err.println(\"There is an exception on: \" + ";
  protected final String TEXT_401 = ");" + NL + "\t\t\t\te.printStackTrace();" + NL + "\t\t\t\tSystem.out.println(\"\\r\\n\");" + NL + "\t\t\t\tin_";
  protected final String TEXT_402 = " = null;      " + NL + "\t\t\t";
  protected final String TEXT_403 = NL + "\t\t}  " + NL + "\t\tfinal java.io.DataOutputStream out_";
  protected final String TEXT_404 = "= new java.io.DataOutputStream(new java.io.FileOutputStream(new java.io.File(dir_";
  protected final String TEXT_405 = ", fileName_";
  protected final String TEXT_406 = ")));" + NL + "" + NL + "\t\tif (in_";
  protected final String TEXT_407 = " != null) {" + NL + "\t\t\tbyte[] buffer_";
  protected final String TEXT_408 = " = new byte[1024];" + NL + "\t\t\tint count_";
  protected final String TEXT_409 = " = 0;" + NL + "" + NL + "\t\t\twhile ((count_";
  protected final String TEXT_410 = " = in_";
  protected final String TEXT_411 = ".read(buffer_";
  protected final String TEXT_412 = ")) > 0) {" + NL + "\t\t\t\tout_";
  protected final String TEXT_413 = ".write(buffer_";
  protected final String TEXT_414 = ", 0, count_";
  protected final String TEXT_415 = ");" + NL + "\t\t\t}    " + NL + "\t\t\tin_";
  protected final String TEXT_416 = ".close();" + NL + "\t\t}    " + NL + "\t\tout_";
  protected final String TEXT_417 = ".close();" + NL + "\t";
  protected final String TEXT_418 = "     " + NL + "\tString srcurl_";
  protected final String TEXT_419 = " = ";
  protected final String TEXT_420 = ";" + NL + "\tString fileName_";
  protected final String TEXT_421 = " = ";
  protected final String TEXT_422 = ";" + NL + "\tString username_";
  protected final String TEXT_423 = " = ";
  protected final String TEXT_424 = ";" + NL + "\t        " + NL + "\t";
  protected final String TEXT_425 = NL + "\t" + NL + "\t";
  protected final String TEXT_426 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_427 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_428 = ");";
  protected final String TEXT_429 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_430 = " = ";
  protected final String TEXT_431 = "; ";
  protected final String TEXT_432 = NL + "   \t" + NL + "\tString password_";
  protected final String TEXT_433 = " = decryptedPassword_";
  protected final String TEXT_434 = ";" + NL + "" + NL + "\tif (fileName_";
  protected final String TEXT_435 = ".compareTo(\"\") == 0) {" + NL + "\t\tfileName_";
  protected final String TEXT_436 = " = srcurl_";
  protected final String TEXT_437 = ".substring(srcurl_";
  protected final String TEXT_438 = ".lastIndexOf(\"/\"));" + NL + "\t}" + NL + "\t" + NL + "\tif (username_";
  protected final String TEXT_439 = ".compareTo(\"\") == 0) {" + NL + "\t\tusername_";
  protected final String TEXT_440 = " = null;" + NL + "\t}" + NL + "\t" + NL + "\tif (password_";
  protected final String TEXT_441 = ".compareTo(\"\") == 0) {" + NL + "\t\tpassword_";
  protected final String TEXT_442 = " = null;" + NL + "\t}" + NL + "\t" + NL + "\ttry {        " + NL + "\t\tjcifs.smb.NtlmPasswordAuthentication auth_";
  protected final String TEXT_443 = " = new jcifs.smb.NtlmPasswordAuthentication(";
  protected final String TEXT_444 = ", username_";
  protected final String TEXT_445 = ", password_";
  protected final String TEXT_446 = ");" + NL + "\t\tjcifs.smb.SmbFile sf_";
  protected final String TEXT_447 = " = new jcifs.smb.SmbFile(srcurl_";
  protected final String TEXT_448 = ", auth_";
  protected final String TEXT_449 = ");" + NL + "\t" + NL + "\t\t";
  protected final String TEXT_450 = NL + "\t\t\tretIS_";
  protected final String TEXT_451 = " = new jcifs.smb.SmbFileInputStream(sf_";
  protected final String TEXT_452 = ");" + NL + "\t\t";
  protected final String TEXT_453 = NL + "\t\t\tjcifs.smb.SmbFileInputStream in_";
  protected final String TEXT_454 = " = new jcifs.smb.SmbFileInputStream(sf_";
  protected final String TEXT_455 = ");" + NL + "\t\t\tjava.io.File destFile_";
  protected final String TEXT_456 = " = new java.io.File(";
  protected final String TEXT_457 = ", fileName_";
  protected final String TEXT_458 = ");" + NL + "\t\t\tdestFile_";
  protected final String TEXT_459 = ".getParentFile().mkdirs();" + NL + "\t\t\tjava.io.OutputStream out_";
  protected final String TEXT_460 = " = new java.io.FileOutputStream(destFile_";
  protected final String TEXT_461 = ");" + NL + "\t\t\tbyte[] buf_";
  protected final String TEXT_462 = " = new byte[1024];" + NL + "\t\t\tint len_";
  protected final String TEXT_463 = ";" + NL + "\t" + NL + "\t\t\twhile ((len_";
  protected final String TEXT_464 = " = in_";
  protected final String TEXT_465 = ".read(buf_";
  protected final String TEXT_466 = ")) > 0) {" + NL + "\t\t\t\tout_";
  protected final String TEXT_467 = ".write(buf_";
  protected final String TEXT_468 = ", 0, len_";
  protected final String TEXT_469 = ");" + NL + "\t\t\t}" + NL + "\t\t\tin_";
  protected final String TEXT_470 = ".close();" + NL + "\t\t\tout_";
  protected final String TEXT_471 = ".close();" + NL + "\t\t\t} catch (java.io.FileNotFoundException ex) {" + NL + "\t\t\t\t";
  protected final String TEXT_472 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_473 = " - \" + ex.getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_474 = NL + "\t\t\t\tSystem.err.println(ex.getMessage());" + NL + "\t\t";
  protected final String TEXT_475 = " " + NL + "\t} catch (java.lang.Exception e) {" + NL + "\t\t";
  protected final String TEXT_476 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_477 = " - \" + e.getMessage());" + NL + "\t\t";
  protected final String TEXT_478 = NL + "\t\tSystem.err.println(e.getMessage());" + NL + "\t}";
  protected final String TEXT_479 = NL + "\tjava.io.InputStream stream";
  protected final String TEXT_480 = " = (java.io.InputStream)globalMap.get(\"";
  protected final String TEXT_481 = "_INPUT_STREAM\");" + NL + "\tif(stream";
  protected final String TEXT_482 = "!=null){" + NL + "\t\tstream";
  protected final String TEXT_483 = ".close();" + NL + "\t}";
  protected final String TEXT_484 = NL + "globalMap.put(\"";
  protected final String TEXT_485 = "_INPUT_STREAM\", retIS_";
  protected final String TEXT_486 = ");";
  protected final String TEXT_487 = NL;

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
String protocol = ElementParameterParser.getValue(node, "__PROTO__");
String directory = ElementParameterParser.getValue(node, "__DIRECTORY__");
String filename = ElementParameterParser.getValue(node, "__FILENAME__");
boolean bMakeDirs = "true".equals(ElementParameterParser.getValue(node, "__MAKEDIRS__"));
boolean bUseCache = "true".equals(ElementParameterParser.getValue(node, "__USE_CACHE__"));
boolean bDieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
if ("http".equals(protocol) || "https".equals(protocol)) {
	String uri = ElementParameterParser.getValue(node, "__URI__");
	String username = ElementParameterParser.getValue(node, "__AUTH_USERNAME__");
	String timeout = ElementParameterParser.getValue(node, "__TIMEOUT__");
	String cookieDir = ElementParameterParser.getValue(node, "__COOKIE_DIR__");
	String cookiePolicy = ElementParameterParser.getValue(node,"__COOKIE_POLICY__");
	boolean singleCookie = "true".equals(ElementParameterParser.getValue(node, "__SINGLE_COOKIE__"));
	String proxyHost = ElementParameterParser.getValue(node, "__PROXY_HOST__");
	String proxyPort = ElementParameterParser.getValue(node, "__PROXY_PORT__");
	String proxyUser = ElementParameterParser.getValue(node, "__PROXY_USERNAME__");
	String proxyDomain = ElementParameterParser.getValue(node, "__PROXY_DOMAIN__");
	boolean post = "true".equals(ElementParameterParser.getValue(node, "__POST__"));
	boolean printResponse = "true".equals(ElementParameterParser.getValue(node, "__PRINT__"));
	boolean needAuth = "true".equals(ElementParameterParser.getValue(node, "__NEED_AUTH__"));
	boolean saveCookie = "true".equals(ElementParameterParser.getValue(node, "__SAVE_COOKIE__"));
	boolean readCookie = "true".equals(ElementParameterParser.getValue(node, "__READ_COOKIE__"));
	boolean redirect = "true".equals(ElementParameterParser.getValue(node, "__REDIRECT__"));
	boolean useProxy = "true".equals(ElementParameterParser.getValue(node, "__USE_PROXY__"));
	boolean useProxyNTLM = "true".equals(ElementParameterParser.getValue(node, "__PROXY_NTLM__"));
	boolean addHeader = "true".equals(ElementParameterParser.getValue(node, "__ADD_HEADER__"));

	if ("https".equals(protocol)) {
	
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
    stringBuffer.append(uri );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(uri );
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(timeout );
    stringBuffer.append(TEXT_48);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(uri );
    stringBuffer.append(TEXT_51);
    }
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cookiePolicy );
    stringBuffer.append(TEXT_54);
    if(singleCookie){
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    if (readCookie) {
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cookieDir);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    }
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    }
    stringBuffer.append(TEXT_80);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    }
    stringBuffer.append(TEXT_83);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    }
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
	}

	if (useProxy) {
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(proxyPort);
    stringBuffer.append(TEXT_97);
    
		String passwordFieldName = "__PROXY_PASSWORD__";
		
    stringBuffer.append(TEXT_98);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_101);
    } else {
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_104);
    }
    stringBuffer.append(TEXT_105);
    if (useProxyNTLM) {
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(proxyPort);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(proxyUser );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(proxyDomain );
    stringBuffer.append(TEXT_113);
    } else {
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(proxyPort);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(proxyUser );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    }
	}

	if (needAuth) {
		if (ElementParameterParser.canEncrypt(node, "__AUTH_PASSWORD__")) {
		
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, "__AUTH_PASSWORD__"));
    stringBuffer.append(TEXT_122);
    
		} else {
		
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append( ElementParameterParser.getValue(node, "__AUTH_PASSWORD__"));
    stringBuffer.append(TEXT_125);
    
		}
		
		if ((!useProxy) && useProxyNTLM && (!"".equals(proxyDomain))) {
		
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(proxyDomain);
    stringBuffer.append(TEXT_131);
    } else {
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    }
	}

	if (post) {
	
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(uri );
    stringBuffer.append(TEXT_138);
    
		List<Map<String, String>> commonParams = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__COMMON_PARAMS__");	
		List<String> varPartList = new ArrayList<String>();	//common string parameter part	
		int i = 0;

		for (Map<String, String> param : commonParams) {
			i++;
			String name = param.get("COMMON_PARAMS_NAME");
			String value = param.get("COMMON_PARAMS_VALUE");
			varPartList.add("common_" + i + "_" + cid);
			
    stringBuffer.append(TEXT_139);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(name );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(value );
    stringBuffer.append(TEXT_143);
    
		}

		if ("true".equals(ElementParameterParser.getValue(node,"__UPLOAD__"))) {
			List<Map<String, String>> fileParams = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILE_PARAMS__");
			int j = 0;

			for (Map<String, String> param : fileParams) {
				j++;
				String name = param.get("FILE_PARAMS_NAME");
				String value = param.get("FILE_PARAMS_VALUE");
				String content_type = param.get("FILE_PARAMS_CONTENT_TYPE");
				String charset = param.get("FILE_PARAMS_CHARSET");
				varPartList.add("file_" + j + "_" + cid);
				
    stringBuffer.append(TEXT_144);
    stringBuffer.append(j);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(name );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(value );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(content_type);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(charset);
    stringBuffer.append(TEXT_150);
    
			}
		}
		
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    for(String var: varPartList){
    stringBuffer.append(var );
    stringBuffer.append(TEXT_153);
    }
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    } else {
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(uri );
    stringBuffer.append(TEXT_160);
    }

	if (addHeader) {
		List<Map<String, String>> headers = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HEADERS__");
		
		for (Map<String, String> header : headers) {
		
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(header.get("HEADER_NAME"));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(header.get("HEADER_VALUE"));
    stringBuffer.append(TEXT_164);
    
		}
	}
	
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_169);
    if (redirect) { //Bug13155, add support of redirection
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    }
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    }
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    if(post){
    stringBuffer.append(TEXT_189);
    }else{
    stringBuffer.append(TEXT_190);
    }
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    if(post){
    stringBuffer.append(TEXT_194);
    }else{
    stringBuffer.append(TEXT_195);
    }
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    } else {
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    
		}

		if (saveCookie) {
		
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cookieDir);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    
		}

		if (!redirect) {
		
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    
		}
		
    stringBuffer.append(TEXT_231);
    if (bDieOnError) {
    stringBuffer.append(TEXT_232);
    } else {
    stringBuffer.append(TEXT_233);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(uri );
    stringBuffer.append(TEXT_237);
    }
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(uri );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    }
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    if (printResponse) {
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    
		}

		if (bUseCache) {
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    } else {
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(directory);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    if (bMakeDirs) {
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    }
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    }
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_309);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    }
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    }
    stringBuffer.append(TEXT_316);
    }
    stringBuffer.append(TEXT_317);
    
} else if (("ftp").equals(protocol)) {
	String uri = ElementParameterParser.getValue(node, "__URI__");
	boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
	String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
	String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
	String proxyUser = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");

	//The following part support the socks proxy for FTP and SFTP (Socks V4 or V5, they are all OK). 
	//And it can not work with the FTP proxy directly, only support the socks proxy.
	if (useProxy) {
	
    stringBuffer.append(TEXT_318);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_319);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_320);
    stringBuffer.append(proxyUser );
    stringBuffer.append(TEXT_321);
    
		String passwordFieldName = "__PROXY_PASSWORD__";
		
    stringBuffer.append(TEXT_322);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_325);
    } else {
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_328);
    }
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
     }
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(uri );
    stringBuffer.append(TEXT_333);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(uri );
    stringBuffer.append(TEXT_336);
    }
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_339);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(uri );
    stringBuffer.append(TEXT_342);
    }
    stringBuffer.append(TEXT_343);
    if (bUseCache) {
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_346);
    } else {
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(directory);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_351);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    if (bMakeDirs) {
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    }
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_377);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    }
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    }
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    }
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_394);
     if (bDieOnError) {
    stringBuffer.append(TEXT_395);
    } else {
    stringBuffer.append(TEXT_396);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(uri );
    stringBuffer.append(TEXT_399);
    }
    stringBuffer.append(TEXT_400);
    stringBuffer.append(uri );
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    }
    stringBuffer.append(TEXT_403);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    
	}
} else if ("smb".equals(protocol)) {
	String srcurl = ElementParameterParser.getValue(node, "__SMB_URI__"); 
	String domain = ElementParameterParser.getValue(node,"__SMB_DOMAIN__");
	String username = ElementParameterParser.getValue(node,"__SMB_USERNAME__");
	
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_419);
    stringBuffer.append(srcurl );
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_421);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_423);
    stringBuffer.append(username );
    stringBuffer.append(TEXT_424);
    
	String passwordFieldName = "__SMB_PASSWORD__";
	
    stringBuffer.append(TEXT_425);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_428);
    } else {
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_431);
    }
    stringBuffer.append(TEXT_432);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(domain );
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    if (bUseCache) {
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    } else {
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(directory );
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    }
    stringBuffer.append(TEXT_474);
    }
    stringBuffer.append(TEXT_475);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_477);
    }
    stringBuffer.append(TEXT_478);
    }
    if (bUseCache) {
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_483);
    }
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(TEXT_487);
    return stringBuffer.toString();
  }
}
