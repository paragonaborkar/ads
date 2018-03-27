package org.talend.designer.codegen.translators.internet.scp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TSCPDeleteMainJava
{
  protected static String nl;
  public static synchronized TSCPDeleteMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSCPDeleteMainJava result = new TSCPDeleteMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t       boolean isCmdFailed_";
  protected final String TEXT_3 = " = false;" + NL + "    \t";
  protected final String TEXT_4 = NL + "    StringBuilder command_";
  protected final String TEXT_5 = " = new StringBuilder(\"rm -f\");" + NL + "    ch.ethz.ssh2.Session sessNew_";
  protected final String TEXT_6 = " = conn_";
  protected final String TEXT_7 = ".openSession();";
  protected final String TEXT_8 = NL + "\t\t\t\tcommand_";
  protected final String TEXT_9 = ".append(\" \");" + NL + "\t\t\t\tcommand_";
  protected final String TEXT_10 = ".append(\"\\\"\");" + NL + "\t\t\t\tcommand_";
  protected final String TEXT_11 = ".append(";
  protected final String TEXT_12 = ");" + NL + "\t\t\t\tcommand_";
  protected final String TEXT_13 = ".append(\"\\\"\");" + NL + "\t            nb_file_";
  protected final String TEXT_14 = " ++;" + NL + "\t\t   \t";
  protected final String TEXT_15 = NL + NL + "        String rmCmd_";
  protected final String TEXT_16 = " = command_";
  protected final String TEXT_17 = ".toString();" + NL + "        if(!\"rm -f\".equals(rmCmd_";
  protected final String TEXT_18 = ")){" + NL + "\t\t\t\tsessNew_";
  protected final String TEXT_19 = ".execCommand(rmCmd_";
  protected final String TEXT_20 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\t\tStringBuilder errMsg_";
  protected final String TEXT_22 = " = new StringBuilder(\"File(s) deleting failed.\");" + NL + "\t\t\t\t\tint returnCondition_";
  protected final String TEXT_23 = " = sessNew_";
  protected final String TEXT_24 = ".waitForCondition(ch.ethz.ssh2.ChannelCondition.EXIT_STATUS,300L);" + NL + "\t\t\t\t\tInteger exitCode_";
  protected final String TEXT_25 = " = sessNew_";
  protected final String TEXT_26 = ".getExitStatus();" + NL + "\t\t\t\t    if((returnCondition_";
  protected final String TEXT_27 = " & ch.ethz.ssh2.ChannelCondition.EXIT_STATUS) == ch.ethz.ssh2.ChannelCondition.EXIT_STATUS){" + NL + "\t\t\t\t\t\t  if (exitCode_";
  protected final String TEXT_28 = " != 0) {" + NL + "\t\t\t\t\t\t\t  isCmdFailed_";
  protected final String TEXT_29 = " = true;" + NL + "\t\t\t\t\t\t\t  errMsg_";
  protected final String TEXT_30 = ".append(\"Exit code: \");" + NL + "\t\t\t\t\t\t\t  errMsg_";
  protected final String TEXT_31 = ".append(exitCode_";
  protected final String TEXT_32 = ");" + NL + "  \t\t\t\t\t\t  }" + NL + "\t\t\t\t\t}else if((returnCondition_";
  protected final String TEXT_33 = " & ch.ethz.ssh2.ChannelCondition.TIMEOUT) == ch.ethz.ssh2.ChannelCondition.TIMEOUT){" + NL + "\t\t\t\t\t\t  isCmdFailed_";
  protected final String TEXT_34 = " = true;" + NL + "\t\t\t\t\t\t  errMsg_";
  protected final String TEXT_35 = ".append(\"The request timeout.\");" + NL + "\t\t\t\t\t}else if((returnCondition_";
  protected final String TEXT_36 = " & ch.ethz.ssh2.ChannelCondition.CLOSED) == ch.ethz.ssh2.ChannelCondition.CLOSED){" + NL + "\t\t\t\t\t\t  isCmdFailed_";
  protected final String TEXT_37 = " = true;" + NL + "\t\t\t\t\t\t  errMsg_";
  protected final String TEXT_38 = ".append(\"Unexpected closed session.\");" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t System.err.println(\"Unexpected error.\");" + NL + "\t\t\t\t\t\t isCmdFailed_";
  protected final String TEXT_39 = " = true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_40 = NL + NL + "\t\t\t\tjava.io.InputStream stderr_";
  protected final String TEXT_41 = " = sessNew_";
  protected final String TEXT_42 = ".getStderr();" + NL + "\t\t        java.io.BufferedReader breer_";
  protected final String TEXT_43 = "= new java.io.BufferedReader(new java.io.InputStreamReader(stderr_";
  protected final String TEXT_44 = "));" + NL + "\t\t        String line_err_";
  protected final String TEXT_45 = " = \"\";" + NL + "\t\t        StringBuilder stringStderr_";
  protected final String TEXT_46 = " =new StringBuilder();" + NL + "\t\t\t\twhile((line_err_";
  protected final String TEXT_47 = " = breer_";
  protected final String TEXT_48 = ".readLine()) != null) {" + NL + "\t\t\t\t\t\tString errInfo_";
  protected final String TEXT_49 = " = new String(line_err_";
  protected final String TEXT_50 = ".getBytes(),\"UTF-8\");" + NL + "\t\t\t\t\t\tSystem.err.println(errInfo_";
  protected final String TEXT_51 = ");" + NL + "\t\t\t\t\t\tstringStderr_";
  protected final String TEXT_52 = ".append(line_err_";
  protected final String TEXT_53 = " + \"\\n\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\tString stderrString_";
  protected final String TEXT_54 = " = stringStderr_";
  protected final String TEXT_55 = ".toString();" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_56 = NL + "\t\t\t\t\t\tif(stderrString_";
  protected final String TEXT_57 = " != null && stderrString_";
  protected final String TEXT_58 = ".length() > 0){" + NL + "\t\t\t\t\t\t\tisCmdFailed_";
  protected final String TEXT_59 = " = true;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif(isCmdFailed_";
  protected final String TEXT_60 = "){" + NL + "\t\t\t\t\t\t\tthrow new RuntimeException(errMsg_";
  protected final String TEXT_61 = ".toString());" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_62 = NL + NL + "\t\t\t\t";
  protected final String TEXT_63 = NL + "\t\t\t\t\tif(stderrString_";
  protected final String TEXT_64 = ".contains(";
  protected final String TEXT_65 = ")){" + NL + "\t\t\t\t    \tnb_file_";
  protected final String TEXT_66 = " --;" + NL + "\t\t\t\t    }" + NL + "\t\t\t\t";
  protected final String TEXT_67 = NL + NL + "\t\t\t\tbreer_";
  protected final String TEXT_68 = ".close();" + NL + "\t\t\t\tstderr_";
  protected final String TEXT_69 = ".close();" + NL + "" + NL + "\t\t\tif(\"\".equals(stderrString_";
  protected final String TEXT_70 = ") || (stderrString_";
  protected final String TEXT_71 = " == null)){" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_72 = "_STATUS\",\"File(s) deleted OK\");" + NL + "\t\t\t}else{" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_73 = "_STATUS\",stringStderr_";
  protected final String TEXT_74 = ".toString());" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "        }else{" + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_75 = "_STATUS\",\"No file to be deleted.\");" + NL + "        }" + NL + "\t\tsessNew_";
  protected final String TEXT_76 = ".close();";
  protected final String TEXT_77 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    List<Map<String, String>> filelist = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILELIST__");
    boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
    if(dieOnError){
    	
    stringBuffer.append(TEXT_2);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_3);
    
	}

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
		   for(Map<String,String> map : filelist){
		   	
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append( map.get("SOURCE") );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}

    stringBuffer.append(TEXT_15);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_20);
     if(dieOnError){ 
    stringBuffer.append(TEXT_21);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_39);
     } 
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
     if(dieOnError){
					
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_61);
    
				}
				
    stringBuffer.append(TEXT_62);
    for (int i = 0;i<filelist.size();i++) {
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(filelist.get(i).get("SOURCE"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    }
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(TEXT_77);
    return stringBuffer.toString();
  }
}
