package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TFTPGetEndJava
{
  protected static String nl;
  public static synchronized TFTPGetEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPGetEndJava result = new TFTPGetEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "}" + NL + "nb_file_";
  protected final String TEXT_2 = " = getter_";
  protected final String TEXT_3 = ".count;" + NL;
  protected final String TEXT_4 = NL + "\tmsg_";
  protected final String TEXT_5 = ".add(getter_";
  protected final String TEXT_6 = ".count + \" files have been downloaded.\");" + NL + "\tStringBuffer sb_";
  protected final String TEXT_7 = " = new StringBuffer();" + NL + "" + NL + "\tfor (String item_";
  protected final String TEXT_8 = " : msg_";
  protected final String TEXT_9 = ") {" + NL + "\t\tsb_";
  protected final String TEXT_10 = ".append(item_";
  protected final String TEXT_11 = ").append(\"\\n\");" + NL + "\t}" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_12 = "_TRANSFER_MESSAGES\", sb_";
  protected final String TEXT_13 = ".toString());" + NL + "" + NL + "\t";
  protected final String TEXT_14 = NL + "\t\t";
  protected final String TEXT_15 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_16 = " - Closing the connection to the server.\");" + NL + "\t\t";
  protected final String TEXT_17 = NL + "\t\tsession_";
  protected final String TEXT_18 = ".disconnect(); " + NL + "\t\t";
  protected final String TEXT_19 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_20 = " - Connection to the server closed.\");" + NL + "\t\t";
  protected final String TEXT_21 = NL + "\t";
  protected final String TEXT_22 = "    ";
  protected final String TEXT_23 = NL + "\tmsg_";
  protected final String TEXT_24 = ".add(ftp_";
  protected final String TEXT_25 = ".getDownloadCount() + \" files have been downloaded.\");" + NL + "\tString[] msgAll_";
  protected final String TEXT_26 = " = msg_";
  protected final String TEXT_27 = ".getAll();" + NL + "\tStringBuffer sb_";
  protected final String TEXT_28 = " = new StringBuffer();" + NL + "" + NL + "\tif (msgAll_";
  protected final String TEXT_29 = " != null) {" + NL + "    \tfor (String item_";
  protected final String TEXT_30 = " : msgAll_";
  protected final String TEXT_31 = ") {" + NL + "\t\t\tsb_";
  protected final String TEXT_32 = ".append(item_";
  protected final String TEXT_33 = ").append(\"\\n\");" + NL + "    \t}" + NL + "\t}" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_34 = "_TRANSFER_MESSAGES\", sb_";
  protected final String TEXT_35 = ".toString());" + NL;
  protected final String TEXT_36 = NL + "\t\t\ttry {" + NL + "\t\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_38 = " - Closing the connection to the server.\");" + NL + "\t\t\t\t";
  protected final String TEXT_39 = NL + "        \t\tftp_";
  protected final String TEXT_40 = ".quit();" + NL + "\t\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_42 = " - Connection to the server closed.\");" + NL + "\t\t\t\t";
  protected final String TEXT_43 = NL + "    \t\t} catch(java.net.SocketException se_";
  protected final String TEXT_44 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t\tlog.error(\"";
  protected final String TEXT_46 = " - \" + se_";
  protected final String TEXT_47 = ".getMessage());" + NL + "\t\t\t\t";
  protected final String TEXT_48 = NL + "        \t\t//ignore failure" + NL + "      \t\t}";
  protected final String TEXT_49 = NL + "\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_51 = " - Closing the connection to the server.\");" + NL + "\t\t\t";
  protected final String TEXT_52 = NL + "      \t\tftp_";
  protected final String TEXT_53 = ".quit();" + NL + "\t\t\t";
  protected final String TEXT_54 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_55 = " - Connection to the server closed.\");" + NL + "\t\t\t";
  protected final String TEXT_56 = NL + "\t  \t\tftp_";
  protected final String TEXT_57 = ".chdir(rootDir_";
  protected final String TEXT_58 = ");";
  protected final String TEXT_59 = NL + "\t\t";
  protected final String TEXT_60 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_61 = " - Closing the connection to the server.\");" + NL + "\t\t";
  protected final String TEXT_62 = NL + "    \tftp_";
  protected final String TEXT_63 = ".disconnect(true);" + NL + "\t\t";
  protected final String TEXT_64 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_65 = " - Connection to the server closed.\");" + NL + "\t\t";
  protected final String TEXT_66 = NL + "\t  \t\tftp_";
  protected final String TEXT_67 = ".changeDirectory(rootDir_";
  protected final String TEXT_68 = ");";
  protected final String TEXT_69 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_70 = "_NB_FILE\",nb_file_";
  protected final String TEXT_71 = ");";
  protected final String TEXT_72 = NL + "\tlog.info(\"";
  protected final String TEXT_73 = " - Downloaded files count: \" + nb_file_";
  protected final String TEXT_74 = "  + \".\");";
  protected final String TEXT_75 = NL;
  protected final String TEXT_76 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String ignoreFailureAtQuit= ElementParameterParser.getValue(node,"__IGNORE_FAILURE_AT_QUIT__");
String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
boolean moveToCurrentDir = ("true").equals(ElementParameterParser.getValue(node, "__MOVE_TO_THE_CURRENT_DIRECTORY__"));
boolean sftp = false;
boolean ftps = false;

boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
if (("true").equals(useExistingConn)) {
  List<? extends INode> nodeList = node.getProcess().getGeneratingNodes();

  for(INode n : nodeList){
    if(n.getUniqueName().equals(connection)){
      sftp = ("true").equals(ElementParameterParser.getValue(n, "__SFTP__"));
      ftps = ("true").equals(ElementParameterParser.getValue(n, "__FTPS__"));
    }
  }
} else {
  sftp = ("true").equals(ElementParameterParser.getValue(node, "__SFTP__"));
  ftps = ("true").equals(ElementParameterParser.getValue(node, "__FTPS__"));
}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    if (sftp) {
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    if (!("true").equals(useExistingConn)) {
    stringBuffer.append(TEXT_14);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    } else if (!ftps) {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    
	if (!("true").equals(useExistingConn)) {
  
		if(("true").equals(ignoreFailureAtQuit)){
    
    stringBuffer.append(TEXT_36);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    
		} else {
    
    stringBuffer.append(TEXT_49);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    }
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    }
    
		}
	}else{
		if(!moveToCurrentDir){

    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    	
		}
	}
} else { // *** ftps *** //

	if (!("true").equals(useExistingConn)){
  
    stringBuffer.append(TEXT_59);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    }
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    }
    
  	}else{
	    if(!moveToCurrentDir){

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    	
		}
	}
}

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    }
    stringBuffer.append(TEXT_75);
    stringBuffer.append(TEXT_76);
    return stringBuffer.toString();
  }
}
