package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TFTPTruncateEndJava
{
  protected static String nl;
  public static synchronized TFTPTruncateEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPTruncateEndJava result = new TFTPTruncateEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t}";
  protected final String TEXT_2 = NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_4 = " - Closing the connection to the server.\");" + NL + "\t\t\t";
  protected final String TEXT_5 = NL + "    \t\tsession_";
  protected final String TEXT_6 = ".disconnect(); " + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_8 = " - Connection to the server closed.\");" + NL + "\t\t\t";
  protected final String TEXT_9 = "  ";
  protected final String TEXT_10 = NL + "\t\t} ";
  protected final String TEXT_11 = NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_13 = " - Closing the connection to the server.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\t\t\tftp_";
  protected final String TEXT_15 = ".quit();" + NL + "\t\t\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_17 = " - Connection to the server closed.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_18 = "  " + NL + "\t\t\t\t}catch(java.net.SocketException se_";
  protected final String TEXT_19 = "){" + NL + "\t\t\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_21 = " - \" + se_";
  protected final String TEXT_22 = ".getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_23 = " " + NL + "\t\t\t\t\t//ignore failure" + NL + "\t\t\t\t}";
  protected final String TEXT_24 = NL + "\t\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_26 = " - Closing the connection to the server.\");" + NL + "\t\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\tftp_";
  protected final String TEXT_28 = ".quit();" + NL + "\t\t\t\t";
  protected final String TEXT_29 = NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_30 = " - Connection to the server closed.\");" + NL + "\t\t\t\t";
  protected final String TEXT_31 = "  ";
  protected final String TEXT_32 = NL + "\t\t  \t\tftp_";
  protected final String TEXT_33 = ".chdir(rootDir_";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = NL + NL + "globalMap.put(\"";
  protected final String TEXT_36 = "_NB_FILE\",nb_file_";
  protected final String TEXT_37 = ");" + NL;
  protected final String TEXT_38 = NL + "\tlog.info(\"";
  protected final String TEXT_39 = " - Truncated files count: \" + nb_file_";
  protected final String TEXT_40 = "  + \".\");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String ignoreFailureAtQuit= ElementParameterParser.getValue(node,"__IGNORE_FAILURE_AT_QUIT__");
	String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
	String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	boolean moveToCurrentDir = ("true").equals(ElementParameterParser.getValue(node, "__MOVE_TO_THE_CURRENT_DIRECTORY__"));
	boolean sftp = false;
	if(("true").equals(useExistingConn)){
		List<? extends INode> nodeList = node.getProcess().getGeneratingNodes();
		for(INode n : nodeList){
			if(n.getUniqueName().equals(connection)){
				sftp = ("true").equals(ElementParameterParser.getValue(n, "__SFTP__"));
			}
		}
	}else{
		sftp = ("true").equals(ElementParameterParser.getValue(node, "__SFTP__"));
	}
	if(sftp){// *** sftp *** //

    stringBuffer.append(TEXT_1);
    
		if(!("true").equals(useExistingConn)){

    stringBuffer.append(TEXT_2);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    }
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    
		}

    	
	}else{// *** ftp *** //

    stringBuffer.append(TEXT_10);
    
		if(!("true").equals(useExistingConn)){
 			if(("true").equals(ignoreFailureAtQuit)){

    stringBuffer.append(TEXT_11);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    }
    stringBuffer.append(TEXT_23);
    
			}else{

    stringBuffer.append(TEXT_24);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    }
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    }
    stringBuffer.append(TEXT_31);
    
			}
		}else{
		    if(!moveToCurrentDir){

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    	
			}
		}
	}

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    }
    return stringBuffer.toString();
  }
}
