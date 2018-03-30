package org.talend.designer.codegen.translators.custom_code;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.runprocess.ProcessorUtilities;
import java.util.List;

public class THadoopConfManagerBeginJava
{
  protected static String nl;
  public static synchronized THadoopConfManagerBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THadoopConfManagerBeginJava result = new THadoopConfManagerBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL + "class DealJobLibrary_";
  protected final String TEXT_4 = " {" + NL + "" + NL + "    public String getConfJarName(String confLib, String extraId) {" + NL + "        String confJarName = confLib;" + NL + "        if (extraId != null && extraId.length() > 0) {" + NL + "            String jarName = confLib.substring(0, confLib.lastIndexOf(\".\"));" + NL + "            String jarExt = confLib.substring(confLib.lastIndexOf(\".\"));" + NL + "            confJarName = jarName + \"_\" + extraId + jarExt;" + NL + "        }" + NL + "        return confJarName;" + NL + "    }" + NL + "" + NL + "    public String replaceJarPathsFromCrcMap(String originalClassPathLine) throws java.lang.Exception {" + NL + "        String classPathLine = \"\";" + NL + "        String crcMapPath = new java.io.File(\"../crcMap\").getCanonicalPath();" + NL + "        if (isNeedAddLibsPath( crcMapPath)) {" + NL + "            java.util.Map<String, String> crcMap = null;" + NL + "            java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(crcMapPath));" + NL + "            crcMap = (java.util.Map<String, String>) ois.readObject();" + NL + "            ois.close();" + NL + "            classPathLine = addLibsPath(originalClassPathLine, crcMap);" + NL + "        } else {" + NL + "            classPathLine = originalClassPathLine;" + NL + "        }" + NL + "        return classPathLine;" + NL + "    }" + NL + "" + NL + "    private boolean isNeedAddLibsPath(String crcMapPath) {" + NL + "        if (!(new java.io.File(crcMapPath).exists())) {// when not use cache" + NL + "            return false;" + NL + "        }" + NL + "        return true;" + NL + "    }" + NL + "" + NL + "" + NL + "    private String addLibsPath(String line, java.util.Map<String, String> crcMap) {" + NL + "        for (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {" + NL + "            line = adaptLibPaths(line, entry);" + NL + "        }" + NL + "        return line;" + NL + "    }" + NL + "" + NL + "    private String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {" + NL + "        String jarName = entry.getValue();" + NL + "        String crc = entry.getKey();" + NL + "        String libStringFinder = \"../lib/\" + jarName;" + NL + "        if (line.contains(libStringFinder)) {" + NL + "            line = line.replace(libStringFinder, \"../../../cache/lib/\" + crc + \"/\" + jarName);" + NL + "        } else if (line.contains(\":$ROOT_PATH/\" + jarName + \":\")) {" + NL + "            line = line.replace(\":$ROOT_PATH/\" + jarName + \":\", \":$ROOT_PATH/../../../cache/lib/\" + crc + \"/\" + jarName + \":\");" + NL + "        } else if (line.contains(\";\" + jarName + \";\")) {" + NL + "            line = line.replace(\";\" + jarName + \";\", \";../../../cache/lib/\" + crc + \"/\" + jarName + \";\");" + NL + "        }" + NL + "        return line;" + NL + "    }" + NL + "" + NL + "}" + NL + "" + NL + "java.net.URLClassLoader currentLoader";
  protected final String TEXT_5 = " = (java.net.URLClassLoader) Thread.currentThread().getContextClassLoader();" + NL + "java.lang.reflect.Method method_";
  protected final String TEXT_6 = " = java.net.URLClassLoader.class.getDeclaredMethod(\"addURL\", new Class[] { java.net.URL.class });" + NL + "method_";
  protected final String TEXT_7 = ".setAccessible(true);" + NL + "" + NL + "DealJobLibrary_";
  protected final String TEXT_8 = " dealJobLibrary = new DealJobLibrary_";
  protected final String TEXT_9 = "();" + NL + "String confJarName = dealJobLibrary.getConfJarName(";
  protected final String TEXT_10 = ", this.contextStr);" + NL + "" + NL + "String libPath_";
  protected final String TEXT_11 = " = \"\";";
  protected final String TEXT_12 = NL + "    libPath_";
  protected final String TEXT_13 = " = \"../lib/\" + confJarName;";
  protected final String TEXT_14 = NL + "    libPath_";
  protected final String TEXT_15 = " = new java.io.File(\"";
  protected final String TEXT_16 = "/\" + confJarName).getAbsolutePath();";
  protected final String TEXT_17 = NL + "libPath_";
  protected final String TEXT_18 = " = dealJobLibrary.replaceJarPathsFromCrcMap(libPath_";
  protected final String TEXT_19 = ");" + NL + "method_";
  protected final String TEXT_20 = ".invoke(currentLoader";
  protected final String TEXT_21 = ", new Object[] { new java.io.File(libPath_";
  protected final String TEXT_22 = ").toURL() });" + NL;
  protected final String TEXT_23 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String confLib = ElementParameterParser.getValue(node, "__CONF_LIB__");

    stringBuffer.append(TEXT_2);
     if(confLib != null && confLib.length() > 0){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(confLib );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    if (ProcessorUtilities.isExportConfig()) {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    } else {
    String libFolder = ProcessorUtilities.getJavaProjectLibFolder().getAbsolutePath().replace("\\", "/");
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(libFolder );
    stringBuffer.append(TEXT_16);
    }
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
    }
    stringBuffer.append(TEXT_23);
    return stringBuffer.toString();
  }
}
