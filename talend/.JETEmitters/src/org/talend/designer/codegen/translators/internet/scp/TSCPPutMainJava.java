package org.talend.designer.codegen.translators.internet.scp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TSCPPutMainJava
{
  protected static String nl;
  public static synchronized TSCPPutMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSCPPutMainJava result = new TSCPPutMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\ttry{" + NL + "        if(sourceFileNames_";
  protected final String TEXT_3 = "!=null && sourceFileNames_";
  protected final String TEXT_4 = ".length!=0){" + NL + "           \tfor (int i_";
  protected final String TEXT_5 = " = 0; i_";
  protected final String TEXT_6 = " < sourceFileNames_";
  protected final String TEXT_7 = ".length; i_";
  protected final String TEXT_8 = "++) {" + NL + "       \t\t\tjava.io.File file_";
  protected final String TEXT_9 = " = new java.io.File(sourceFileNames_";
  protected final String TEXT_10 = "[i_";
  protected final String TEXT_11 = "]);" + NL + "       \t\t\tlong sendSize_";
  protected final String TEXT_12 = " = file_";
  protected final String TEXT_13 = ".length();" + NL + "       \t\t\tString remoteName_";
  protected final String TEXT_14 = " = file_";
  protected final String TEXT_15 = ".getName();" + NL + "       \t\t\tjava.io.OutputStream out_";
  protected final String TEXT_16 = " = null;" + NL + "       \t\t\tjava.io.InputStream is_";
  protected final String TEXT_17 = " = null;" + NL + "\t\t\t\tbyte[] buffer_";
  protected final String TEXT_18 = " = new byte[8192];" + NL + "\t\t\t\tint receive_";
  protected final String TEXT_19 = " = -1;" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tout_";
  protected final String TEXT_20 = " = scp_";
  protected final String TEXT_21 = ".put(remoteName_";
  protected final String TEXT_22 = ", sendSize_";
  protected final String TEXT_23 = ", ";
  protected final String TEXT_24 = ", \"0644\");" + NL + "\t\t\t\t\tis_";
  protected final String TEXT_25 = " = new java.io.FileInputStream(file_";
  protected final String TEXT_26 = ");" + NL + "\t\t\t\t\t" + NL + "    \t\t\t\twhile((receive_";
  protected final String TEXT_27 = " = is_";
  protected final String TEXT_28 = ".read(buffer_";
  protected final String TEXT_29 = "))!=-1) {" + NL + "\t\t\t\t\t\tout_";
  protected final String TEXT_30 = ".write(buffer_";
  protected final String TEXT_31 = ", 0, receive_";
  protected final String TEXT_32 = ");" + NL + "    \t\t\t\t}" + NL + "\t\t\t\t} finally {" + NL + "                \tif(out_";
  protected final String TEXT_33 = " != null){" + NL + "            \t\t\tout_";
  protected final String TEXT_34 = ".close();" + NL + "                \t}" + NL + "                \t" + NL + "                \tif(is_";
  protected final String TEXT_35 = " != null) {" + NL + "            \t\t\tis_";
  protected final String TEXT_36 = ".close();" + NL + "                \t}" + NL + "\t\t\t\t}" + NL + "           \t}" + NL + "\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_38 = " - Uploaded file '\" + sourceList_";
  protected final String TEXT_39 = ".toString() + \"' to remote directory '\" + ";
  protected final String TEXT_40 = "+ \"' successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_41 = NL + "            nb_file_";
  protected final String TEXT_42 = " = sourceFileNames_";
  protected final String TEXT_43 = ".length;" + NL + "            globalMap.put(\"";
  protected final String TEXT_44 = "_STATUS\", \"File put OK.\");" + NL + "        }else{" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_45 = "_STATUS\", \"No file transfered.\");" + NL + "        }" + NL + "    }catch(java.lang.Exception e){" + NL + "    \t\te.printStackTrace();" + NL + "    \t\t";
  protected final String TEXT_46 = NL + "                log.error(e.getMessage());" + NL + "    \t\t";
  protected final String TEXT_47 = NL + "    \t\tglobalMap.put(\"";
  protected final String TEXT_48 = "_STATUS\", \"File put fail.\");" + NL + "    }";
  protected final String TEXT_49 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    String cid = node.getUniqueName();      
    String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(remotedir );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(TEXT_49);
    return stringBuffer.toString();
  }
}
