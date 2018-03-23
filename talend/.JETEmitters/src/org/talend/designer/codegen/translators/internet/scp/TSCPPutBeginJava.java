package org.talend.designer.codegen.translators.internet.scp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.utils.NodeUtil;

public class TSCPPutBeginJava
{
  protected static String nl;
  public static synchronized TSCPPutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSCPPutBeginJava result = new TSCPPutBeginJava();
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
  protected final String TEXT_29 = NL + " ";
  protected final String TEXT_30 = NL + "\tint nb_file_";
  protected final String TEXT_31 = " = 0;" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_32 = "_STATUS\", \"\");" + NL + "    /* Create a connection instance */" + NL + "\t";
  protected final String TEXT_33 = NL + "\t\tch.ethz.ssh2.Connection conn_";
  protected final String TEXT_34 = " = (ch.ethz.ssh2.Connection)globalMap.get(\"";
  protected final String TEXT_35 = "\");" + NL + "\t\t";
  protected final String TEXT_36 = NL + "\t\t\tif(conn_";
  protected final String TEXT_37 = "!=null) {" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_38 = " - Uses an existing connection. Connection hostname: \" + conn_";
  protected final String TEXT_39 = ".getHostname() + \". Connection port: \" + conn_";
  protected final String TEXT_40 = ".getPort() + \".\"); " + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_41 = NL + "\t" + NL + "\t";
  protected final String TEXT_42 = NL + "\t    String hostname_";
  protected final String TEXT_43 = " = ";
  protected final String TEXT_44 = ";" + NL + "\t    String username_";
  protected final String TEXT_45 = " = ";
  protected final String TEXT_46 = ";";
  protected final String TEXT_47 = NL + "        \tch.ethz.ssh2.Connection conn_";
  protected final String TEXT_48 = " = new ch.ethz.ssh2.Connection(hostname_";
  protected final String TEXT_49 = ");";
  protected final String TEXT_50 = NL + "\t\t\tch.ethz.ssh2.Connection conn_";
  protected final String TEXT_51 = " = new ch.ethz.ssh2.Connection(hostname_";
  protected final String TEXT_52 = ",";
  protected final String TEXT_53 = ");";
  protected final String TEXT_54 = NL + "              /* Now connect */" + NL + "\t\t";
  protected final String TEXT_55 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_56 = " - Attempt to connect to '\" + hostname_";
  protected final String TEXT_57 = " + \"' with the username '\" + ";
  protected final String TEXT_58 = " + \"'.\");" + NL + "\t\t";
  protected final String TEXT_59 = NL + "        conn_";
  protected final String TEXT_60 = ".connect();" + NL + "\t\t";
  protected final String TEXT_61 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_62 = " - Connect to '\" + hostname_";
  protected final String TEXT_63 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_64 = NL + "\t\t\t";
  protected final String TEXT_65 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_66 = " - Authentication using a public key\");" + NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_67 = " - Private key: '\" + ";
  protected final String TEXT_68 = " + \"'.\" );" + NL + "\t\t\t";
  protected final String TEXT_69 = NL + "    \t    java.io.File keyfile_";
  protected final String TEXT_70 = " = new java.io.File(";
  protected final String TEXT_71 = "); " + NL + "    \t    ";
  protected final String TEXT_72 = NL + "            ";
  protected final String TEXT_73 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_74 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_75 = ");";
  protected final String TEXT_76 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_77 = " = ";
  protected final String TEXT_78 = "; ";
  protected final String TEXT_79 = NL + "    \t    " + NL + "    \t    " + NL + "            boolean isAuthenticated_";
  protected final String TEXT_80 = " = conn_";
  protected final String TEXT_81 = ".authenticateWithPublicKey(username_";
  protected final String TEXT_82 = ", keyfile_";
  protected final String TEXT_83 = ", decryptedPassword_";
  protected final String TEXT_84 = ");" + NL + "\t\t\tif (isAuthenticated_";
  protected final String TEXT_85 = " == false){" + NL + "\t\t\t\tthrow new RuntimeException(\"Authentication failed.\");" + NL + "\t\t\t}\t" + NL + "\t\t\t";
  protected final String TEXT_86 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_87 = " - Authentication succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\t";
  protected final String TEXT_89 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_90 = " - Authentication using a password\");" + NL + "\t\t\t";
  protected final String TEXT_91 = NL + "\t\t\t";
  protected final String TEXT_92 = NL + "            ";
  protected final String TEXT_93 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_94 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_95 = ");";
  protected final String TEXT_96 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_97 = " = ";
  protected final String TEXT_98 = "; ";
  protected final String TEXT_99 = NL + "\t\t\t" + NL + "\t\t\t" + NL + "        \tboolean isAuthenticated_";
  protected final String TEXT_100 = " = conn_";
  protected final String TEXT_101 = ".authenticateWithPassword(username_";
  protected final String TEXT_102 = ", decryptedPassword_";
  protected final String TEXT_103 = ");" + NL + "        \tif (isAuthenticated_";
  protected final String TEXT_104 = " == false){" + NL + "            \tthrow new RuntimeException(\"Authentication failed.\");" + NL + "        \t}" + NL + "\t\t\t";
  protected final String TEXT_105 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_106 = " - Authentication succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_107 = NL + "\t\t\t";
  protected final String TEXT_108 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_109 = " - Authentication using an interactive action\");" + NL + "\t\t\t";
  protected final String TEXT_110 = NL + "\t        boolean isAuthenticated_";
  protected final String TEXT_111 = " = conn_";
  protected final String TEXT_112 = ".authenticateWithKeyboardInteractive(username_";
  protected final String TEXT_113 = ", " + NL + "    \t        new ch.ethz.ssh2.InteractiveCallback() {" + NL + "        " + NL + "        \t\tpublic String[] replyToChallenge(String name," + NL + "        \t\t\t\tString instruction, int numPrompts," + NL + "        \t\t\t\tString[] prompt, boolean[] echo)" + NL + "        \t\t\t\tthrows java.lang.Exception {" + NL + "\t        \t\t\tString[] reply = new String[numPrompts];" + NL + "\t        \t\t\t";
  protected final String TEXT_114 = NL + "                        ";
  protected final String TEXT_115 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_116 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_117 = ");";
  protected final String TEXT_118 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_119 = " = ";
  protected final String TEXT_120 = "; ";
  protected final String TEXT_121 = NL + "\t        \t\t\t" + NL + "\t        \t\t\t" + NL + "    \t    \t\t\tfor (int i = 0; i < reply.length; i++) {" + NL + "        \t\t\t\t\treply[i] = decryptedPassword_";
  protected final String TEXT_122 = ";" + NL + "        \t\t\t\t}" + NL + "        " + NL + "        \t\t\t\treturn reply;" + NL + "\t        \t\t}" + NL + "    \t    \t}\t" + NL + "        \t);" + NL + "        \tif (isAuthenticated_";
  protected final String TEXT_123 = " == false){" + NL + "            \tthrow new RuntimeException(\"Authentication failed.\");" + NL + "        \t}" + NL + "\t\t\t";
  protected final String TEXT_124 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_125 = " - Authentication succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_126 = NL + "        ch.ethz.ssh2.SCPClient scp_";
  protected final String TEXT_127 = " = new  ch.ethz.ssh2.SCPClient(conn_";
  protected final String TEXT_128 = ");" + NL + "\t\t" + NL + "        java.util.List<String> sourceList_";
  protected final String TEXT_129 = " = new java.util.ArrayList<String>();";
  protected final String TEXT_130 = NL + "\t\t\tif((new java.io.File(";
  protected final String TEXT_131 = ").exists()) " + NL + "\t\t\t&& (new java.io.File(";
  protected final String TEXT_132 = ").isFile())){" + NL + "\t\t\t\tsourceList_";
  protected final String TEXT_133 = ".add(";
  protected final String TEXT_134 = ");" + NL + "\t\t\t}else{";
  protected final String TEXT_135 = NL + "                        log.warn(\"";
  protected final String TEXT_136 = " - \"+";
  protected final String TEXT_137 = "+\" doesn't exist or it isn't a file.\");";
  protected final String TEXT_138 = NL + "        }";
  protected final String TEXT_139 = "   " + NL + "\t\tString[] sourceFileNames_";
  protected final String TEXT_140 = " = new String[sourceList_";
  protected final String TEXT_141 = ".size()];" + NL + "        for(int i_";
  protected final String TEXT_142 = " = 0;i_";
  protected final String TEXT_143 = " < sourceList_";
  protected final String TEXT_144 = ".size(); i_";
  protected final String TEXT_145 = "++){" + NL + "        \tsourceFileNames_";
  protected final String TEXT_146 = "[i_";
  protected final String TEXT_147 = "] = sourceList_";
  protected final String TEXT_148 = ".get(i_";
  protected final String TEXT_149 = ");" + NL + "        }";
  protected final String TEXT_150 = NL;

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
	
    stringBuffer.append(TEXT_29);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    String cid = node.getUniqueName();
    List<Map<String, String>> filelist =(List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__FILELIST__");

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    
	String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
	if(("true").equals(useExistingConn)){
		String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
		String conn= "conn_" + connection;
	
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_35);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    }else{
          
		String host = ElementParameterParser.getValue(node,"__HOST__");
        String port = ElementParameterParser.getValue(node,"__PORT__");
        String user = ElementParameterParser.getValue(node,"__USERNAME__");
        String authMethod = ElementParameterParser.getValue(node,"__AUTH_METHOD__");
        String privatekey = ElementParameterParser.getValue(node,"__PRIVATEKEY__");
        String password = ElementParameterParser.getValue(node,"__PASSWORD__");        
        String passphrase = ElementParameterParser.getValue(node,"__PASSPHRASE__");

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_46);
    
		if(("").equals(port)){

    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
        } else {

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_53);
    
        }

    stringBuffer.append(TEXT_54);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    }
            
        if (("PUBLICKEY").equals(authMethod)) {

    stringBuffer.append(TEXT_64);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(privatekey);
    stringBuffer.append(TEXT_68);
    }
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(privatekey);
    stringBuffer.append(TEXT_71);
    
            String passwordFieldName = "__PASSPHRASE__";
            
    stringBuffer.append(TEXT_72);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_75);
    } else {
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_78);
    }
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
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    }
    
        }
        if (("PASSWORD").equals(authMethod)) {

    stringBuffer.append(TEXT_88);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    }
    stringBuffer.append(TEXT_91);
    
            String passwordFieldName = "__PASSWORD__";
            
    stringBuffer.append(TEXT_92);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_95);
    } else {
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_98);
    }
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    }
    
        }
        if (("KEYBOARDINTERACTIVE").equals(authMethod)) {

    stringBuffer.append(TEXT_107);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    }
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    
                        String passwordFieldName = "__PASSWORD__";
                        
    stringBuffer.append(TEXT_114);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_117);
    } else {
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_120);
    }
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    }
    
        }
	}//if(isExistConnection)

    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    
        for (Map<String, String> file : filelist) {

    stringBuffer.append(TEXT_130);
    stringBuffer.append(file.get("SOURCE") );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(file.get("SOURCE") );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(file.get("SOURCE") );
    stringBuffer.append(TEXT_134);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append( file.get("SOURCE") );
    stringBuffer.append(TEXT_137);
    }
    stringBuffer.append(TEXT_138);
    
        }

    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(TEXT_150);
    return stringBuffer.toString();
  }
}
