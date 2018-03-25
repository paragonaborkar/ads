package org.talend.designer.codegen.translators.internet.scp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.utils.NodeUtil;

public class TSCPConnectionBeginJava
{
  protected static String nl;
  public static synchronized TSCPConnectionBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSCPConnectionBeginJava result = new TSCPConnectionBeginJava();
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
  protected final String TEXT_30 = "\t" + NL + "\tString hostname_";
  protected final String TEXT_31 = " = ";
  protected final String TEXT_32 = ";" + NL + "    String username_";
  protected final String TEXT_33 = " = ";
  protected final String TEXT_34 = ";" + NL + "    /* Create a connection instance */";
  protected final String TEXT_35 = NL + "\t\t\tch.ethz.ssh2.Connection conn_";
  protected final String TEXT_36 = " = new ch.ethz.ssh2.Connection(hostname_";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = NL + "\t\t\tch.ethz.ssh2.Connection conn_";
  protected final String TEXT_39 = " = new ch.ethz.ssh2.Connection(hostname_";
  protected final String TEXT_40 = ",";
  protected final String TEXT_41 = ");";
  protected final String TEXT_42 = NL + "              /* Now connect */" + NL + "\t\t";
  protected final String TEXT_43 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_44 = " - Attempt to connect to '\" + hostname_";
  protected final String TEXT_45 = " + \"' with username '\" + ";
  protected final String TEXT_46 = " + \"'.\");" + NL + "\t\t";
  protected final String TEXT_47 = NL + "        conn_";
  protected final String TEXT_48 = ".connect();" + NL + "\t\t";
  protected final String TEXT_49 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_50 = " - Connect to '\" + hostname_";
  protected final String TEXT_51 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_52 = NL + "\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_54 = " - Authentication using a public key\");" + NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_55 = " - Private key: '\" + ";
  protected final String TEXT_56 = " + \"'.\" );" + NL + "\t\t\t";
  protected final String TEXT_57 = NL + "        \tjava.io.File keyfile_";
  protected final String TEXT_58 = " = new java.io.File(";
  protected final String TEXT_59 = "); " + NL + "        \t";
  protected final String TEXT_60 = NL + "            ";
  protected final String TEXT_61 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_62 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_63 = ");";
  protected final String TEXT_64 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_65 = " = ";
  protected final String TEXT_66 = "; ";
  protected final String TEXT_67 = NL + "        \t" + NL + "            boolean isAuthenticated_";
  protected final String TEXT_68 = " = conn_";
  protected final String TEXT_69 = ".authenticateWithPublicKey(username_";
  protected final String TEXT_70 = ", keyfile_";
  protected final String TEXT_71 = ", decryptedPassword_";
  protected final String TEXT_72 = ");" + NL + "\t\t\tif (isAuthenticated_";
  protected final String TEXT_73 = " == false){" + NL + "                throw new RuntimeException(\"Authentication failed.\");" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_74 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_75 = " - Authentication succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t";
  protected final String TEXT_77 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_78 = " - Authentication using a password\");" + NL + "\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t";
  protected final String TEXT_80 = NL + "            ";
  protected final String TEXT_81 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_82 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_83 = ");";
  protected final String TEXT_84 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_85 = " = ";
  protected final String TEXT_86 = "; ";
  protected final String TEXT_87 = NL + "\t\t\t" + NL + "        \tboolean isAuthenticated_";
  protected final String TEXT_88 = " = conn_";
  protected final String TEXT_89 = ".authenticateWithPassword(username_";
  protected final String TEXT_90 = ", decryptedPassword_";
  protected final String TEXT_91 = ");" + NL + "        \tif (isAuthenticated_";
  protected final String TEXT_92 = " == false){" + NL + "            \tthrow new RuntimeException(\"Authentication failed.\");" + NL + "            }" + NL + "\t\t\t";
  protected final String TEXT_93 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_94 = " - Authentication succeeded.\");" + NL + "\t\t    ";
  protected final String TEXT_95 = NL + "\t\t\t";
  protected final String TEXT_96 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_97 = " - Authentication using an interactive action\");" + NL + "\t\t\t";
  protected final String TEXT_98 = NL + "\t        boolean isAuthenticated_";
  protected final String TEXT_99 = " = conn_";
  protected final String TEXT_100 = ".authenticateWithKeyboardInteractive(username_";
  protected final String TEXT_101 = ", " + NL + "\t            new ch.ethz.ssh2.InteractiveCallback() {" + NL + "\t        \t\tpublic String[] replyToChallenge(String name," + NL + "\t        \t\t\t\tString instruction, int numPrompts," + NL + "\t        \t\t\t\tString[] prompt, boolean[] echo)" + NL + "\t        \t\t\t\tthrows java.lang.Exception {" + NL + "\t        \t\t\tString[] reply = new String[numPrompts];" + NL + "\t        \t\t\t";
  protected final String TEXT_102 = NL + "                        ";
  protected final String TEXT_103 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_104 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_105 = ");";
  protected final String TEXT_106 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_107 = " = ";
  protected final String TEXT_108 = "; ";
  protected final String TEXT_109 = NL + "\t        \t\t\t" + NL + "\t        \t\t\t" + NL + "\t        \t\t\tfor (int i = 0; i < reply.length; i++) {" + NL + "\t        \t\t\t\treply[i] = decryptedPassword_";
  protected final String TEXT_110 = ";" + NL + "\t        \t\t\t}" + NL + "\t        " + NL + "\t        \t\t\treturn reply;" + NL + "\t        \t\t}" + NL + "\t        \t}\t" + NL + "\t        );" + NL + "        \tif (isAuthenticated_";
  protected final String TEXT_111 = " == false){" + NL + "            \tthrow new RuntimeException(\"Authentication failed.\");" + NL + "            }" + NL + "\t\t\t";
  protected final String TEXT_112 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_113 = " - Authentication succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_114 = NL + "\t\tglobalMap.put(\"conn_";
  protected final String TEXT_115 = "\",conn_";
  protected final String TEXT_116 = ");";
  protected final String TEXT_117 = NL;

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
    String host = ElementParameterParser.getValue(node, "__HOST__");
    String port = ElementParameterParser.getValue(node, "__PORT__");
    String user = ElementParameterParser.getValue(node, "__USERNAME__");
    String authMethod = ElementParameterParser.getValue(node,"__AUTH_METHOD__");
    String privatekey = ElementParameterParser.getValue(node,"__PRIVATEKEY__");
    String password = ElementParameterParser.getValue(node,"__PASSWORD__");
    String passphrase = ElementParameterParser.getValue(node,"__PASSPHRASE__");

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_34);
    
        if(("").equals(port)){

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
     
        } else {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_41);
    
        }

    stringBuffer.append(TEXT_42);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    }
            
        if (("PUBLICKEY").equals(authMethod)) {

    stringBuffer.append(TEXT_52);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(privatekey);
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(privatekey);
    stringBuffer.append(TEXT_59);
    
            String passwordFieldName = "__PASSPHRASE__";
            
    stringBuffer.append(TEXT_60);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_63);
    } else {
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_66);
    }
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
    
        }
        if (("PASSWORD").equals(authMethod)) {

    stringBuffer.append(TEXT_76);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    }
    stringBuffer.append(TEXT_79);
    
            String passwordFieldName = "__PASSWORD__";
            
    stringBuffer.append(TEXT_80);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_83);
    } else {
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_86);
    }
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
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    }
    
        }
        if (("KEYBOARDINTERACTIVE").equals(authMethod)) {

    stringBuffer.append(TEXT_95);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    }
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    
                        String passwordFieldName = "__PASSWORD__";
                        
    stringBuffer.append(TEXT_102);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_105);
    } else {
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_108);
    }
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    }
    
        }
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(TEXT_117);
    return stringBuffer.toString();
  }
}
