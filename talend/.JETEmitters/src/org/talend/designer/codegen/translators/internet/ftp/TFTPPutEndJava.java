package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TFTPPutEndJava
{
  protected static String nl;
  public static synchronized TFTPPutEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPPutEndJava result = new TFTPPutEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + " \t}";
  protected final String TEXT_3 = NL + "\t\t";
  protected final String TEXT_4 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_5 = " - Closing the connection to the server.\");" + NL + "\t\t";
  protected final String TEXT_6 = NL + "    \tsession_";
  protected final String TEXT_7 = ".disconnect(); " + NL + "\t\t";
  protected final String TEXT_8 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_9 = " - Connection to the server closed.\");" + NL + "\t\t";
  protected final String TEXT_10 = NL + "    msg_";
  protected final String TEXT_11 = ".add(nb_file_";
  protected final String TEXT_12 = " + \" files have been uploaded.\");  " + NL + "    \t" + NL + "\tStringBuffer sb_";
  protected final String TEXT_13 = " = new StringBuffer();" + NL + "    for (String item_";
  protected final String TEXT_14 = " : msg_";
  protected final String TEXT_15 = ") {" + NL + "        sb_";
  protected final String TEXT_16 = ".append(item_";
  protected final String TEXT_17 = ").append(\"\\n\");" + NL + "    }" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_18 = "_TRANSFER_MESSAGES\", sb_";
  protected final String TEXT_19 = ".toString());" + NL + "    ";
  protected final String TEXT_20 = " // *** ftp *** //" + NL + "\t}" + NL + "\t" + NL + "\tmsg_";
  protected final String TEXT_21 = ".add(ftp_";
  protected final String TEXT_22 = ".getUploadCount() + \" files have been uploaded.\");" + NL + "\t" + NL + "\tString[] msgAll_";
  protected final String TEXT_23 = " = msg_";
  protected final String TEXT_24 = ".getAll();" + NL + "    StringBuffer sb_";
  protected final String TEXT_25 = " = new StringBuffer();" + NL + "    if (msgAll_";
  protected final String TEXT_26 = " != null) {" + NL + "        for (String item_";
  protected final String TEXT_27 = " : msgAll_";
  protected final String TEXT_28 = ") {" + NL + "            sb_";
  protected final String TEXT_29 = ".append(item_";
  protected final String TEXT_30 = ").append(\"\\n\");" + NL + "        }" + NL + "    }" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_31 = "_TRANSFER_MESSAGES\", sb_";
  protected final String TEXT_32 = ".toString());" + NL + "\t";
  protected final String TEXT_33 = NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\t";
  protected final String TEXT_34 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_35 = " - Closing the connection to the server.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_36 = NL + "\t\t\t\t\tftp_";
  protected final String TEXT_37 = ".quit();" + NL + "\t\t\t\t\t";
  protected final String TEXT_38 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_39 = " - Connection to the server closed.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t\t}catch(java.net.SocketException se_";
  protected final String TEXT_41 = "){" + NL + "\t\t\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_43 = " - \" + se_";
  protected final String TEXT_44 = ".getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t\t//ignore failure" + NL + "\t\t\t\t}";
  protected final String TEXT_46 = NL + "\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_48 = " - Closing the connection to the server.\");" + NL + "\t\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\tftp_";
  protected final String TEXT_50 = ".quit();" + NL + "\t\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_52 = " - Connection to the server closed.\");" + NL + "\t\t\t\t";
  protected final String TEXT_53 = NL + "\t\t  \t\tftp_";
  protected final String TEXT_54 = ".chdir(rootDir_";
  protected final String TEXT_55 = ");";
  protected final String TEXT_56 = NL + "\t}";
  protected final String TEXT_57 = " " + NL + "\t\t";
  protected final String TEXT_58 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_59 = " - Closing the connection to the server.\");" + NL + "\t\t";
  protected final String TEXT_60 = NL + "        ftp_";
  protected final String TEXT_61 = ".disconnect(true); " + NL + "\t\t";
  protected final String TEXT_62 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_63 = " - Connection to the server closed.\");" + NL + "\t\t";
  protected final String TEXT_64 = NL + "\t  \t\tftp_";
  protected final String TEXT_65 = ".changeDirectory(rootDir_";
  protected final String TEXT_66 = ");";
  protected final String TEXT_67 = NL + "\t" + NL + "\t" + NL + "globalMap.put(\"";
  protected final String TEXT_68 = "_NB_FILE\",nb_file_";
  protected final String TEXT_69 = ");";
  protected final String TEXT_70 = NL + "\tlog.info(\"";
  protected final String TEXT_71 = " - Uploaded files count: \" + nb_file_";
  protected final String TEXT_72 = " +  \".\");";
  protected final String TEXT_73 = NL;
  protected final String TEXT_74 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
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
	if(("true").equals(useExistingConn)){
		List<? extends INode> nodeList = node.getProcess().getGeneratingNodes();
		for(INode n : nodeList){
			if(n.getUniqueName().equals(connection)){
				sftp = ("true").equals(ElementParameterParser.getValue(n, "__SFTP__"));
				ftps = ("true").equals(ElementParameterParser.getValue(n, "__FTPS__")); 
			}
		}
	}else{
		sftp = ("true").equals(ElementParameterParser.getValue(node, "__SFTP__"));
		ftps = ("true").equals(ElementParameterParser.getValue(node, "__FTPS__")); 
	}
if(sftp){ // *** sftp *** //

    stringBuffer.append(TEXT_2);
    
	if(!("true").equals(useExistingConn)){

    stringBuffer.append(TEXT_3);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    }
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    }
    
	}

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    }else if(!ftps){
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    
		if(!("true").equals(useExistingConn)){
 			if(("true").equals(ignoreFailureAtQuit)){

    stringBuffer.append(TEXT_33);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    }
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    }
    stringBuffer.append(TEXT_45);
    
			}else{

    stringBuffer.append(TEXT_46);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    }
    
			}
		}else{
		    if(!moveToCurrentDir){

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    	
			}
		}
}else{  // *** ftps *** // 

    stringBuffer.append(TEXT_56);
    
    if(!("true").equals(useExistingConn)){ 

    stringBuffer.append(TEXT_57);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    }
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    }
     
  	}else{
	    if(!moveToCurrentDir){

    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    	
		}
	}
}

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    }
    stringBuffer.append(TEXT_73);
    stringBuffer.append(TEXT_74);
    return stringBuffer.toString();
  }
}
