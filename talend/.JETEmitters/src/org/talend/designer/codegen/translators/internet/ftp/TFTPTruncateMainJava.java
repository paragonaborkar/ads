package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TFTPTruncateMainJava
{
  protected static String nl;
  public static synchronized TFTPTruncateMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPTruncateMainJava result = new TFTPTruncateMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_3 = "_CURRENT_STATUS\", \"No file truncated.\");" + NL + "\t\tjava.util.Set<String> keySet";
  protected final String TEXT_4 = " = map";
  protected final String TEXT_5 = ".keySet(); " + NL + "\t\tfor (String key";
  protected final String TEXT_6 = " : keySet";
  protected final String TEXT_7 = ") {     " + NL + "    \t\tString filemask";
  protected final String TEXT_8 = " = key";
  protected final String TEXT_9 = "; " + NL + "\t    \tString dir";
  protected final String TEXT_10 = " = null;" + NL + "    \t    ";
  protected final String TEXT_11 = NL + "       \t\t\tString mask";
  protected final String TEXT_12 = " = filemask";
  protected final String TEXT_13 = ".replaceAll(\"\\\\\\\\\", \"/\") ;" + NL + "\t        ";
  protected final String TEXT_14 = NL + "\t\t        String mask";
  protected final String TEXT_15 = " = filemask";
  protected final String TEXT_16 = ";" + NL + "        \t";
  protected final String TEXT_17 = NL + "\t    \tint i";
  protected final String TEXT_18 = " = mask";
  protected final String TEXT_19 = ".lastIndexOf('/');" + NL + "\t\t\tif (i";
  protected final String TEXT_20 = "!=-1) {" + NL + "\t\t\t\tdir";
  protected final String TEXT_21 = " = mask";
  protected final String TEXT_22 = ".substring(0, i";
  protected final String TEXT_23 = "); " + NL + "\t\t\t\tmask";
  protected final String TEXT_24 = " = mask";
  protected final String TEXT_25 = ".substring(i";
  protected final String TEXT_26 = "+1); " + NL + "    \t\t}";
  protected final String TEXT_27 = "    \t" + NL + "    \t    ";
  protected final String TEXT_28 = NL + "        \t    mask";
  protected final String TEXT_29 = " = org.apache.oro.text.GlobCompiler.globToPerl5(mask";
  protected final String TEXT_30 = ".toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);" + NL + "\t        ";
  protected final String TEXT_31 = NL + "\t\t\tjava.util.Vector listings";
  protected final String TEXT_32 = " = c_";
  protected final String TEXT_33 = ".ls(";
  protected final String TEXT_34 = ");" + NL + "\t\t\tfor (int m";
  protected final String TEXT_35 = " = 0; m";
  protected final String TEXT_36 = " < listings";
  protected final String TEXT_37 = ".size(); m";
  protected final String TEXT_38 = "++) { " + NL + "\t\t\t\tString filePath";
  protected final String TEXT_39 = " =  ((com.jcraft.jsch.ChannelSftp.LsEntry) listings";
  protected final String TEXT_40 = ".elementAt(m";
  protected final String TEXT_41 = ")).getFilename() ;" + NL + "\t\t\t\tif ( filePath";
  protected final String TEXT_42 = ".matches(mask";
  protected final String TEXT_43 = ")) {" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tc_";
  protected final String TEXT_44 = ".put(new java.io.ByteArrayInputStream(new byte[]{}), ";
  protected final String TEXT_45 = "+\"/\"+filePath";
  protected final String TEXT_46 = ");" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_47 = "_CURRENT_STATUS\", \"File truncate OK.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_49 = " - '\" + filePath";
  protected final String TEXT_50 = "  + \"' truncate ok.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\t\t} catch (com.jcraft.jsch.SftpException se) {" + NL + "                \t\tglobalMap.put(\"";
  protected final String TEXT_52 = "_CURRENT_STATUS\", \"File truncate fail.\");" + NL + "    \t                throw se;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tnb_file_";
  protected final String TEXT_53 = "++;" + NL + "\t\t\t\t}" + NL + "\t\t\t}\t     " + NL + "   \t\t}  ";
  protected final String TEXT_54 = NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_55 = "_CURRENT_STATUS\", \"No file truncated.\");" + NL + "    \tjava.util.Set<String> keySet";
  protected final String TEXT_56 = " = map";
  protected final String TEXT_57 = ".keySet(); " + NL + "\t    try {" + NL + "\t\t\tfor (String key";
  protected final String TEXT_58 = " : keySet";
  protected final String TEXT_59 = ") {     " + NL + "\t\t\t\tString filemask";
  protected final String TEXT_60 = " = key";
  protected final String TEXT_61 = "; " + NL + "\t\t\t\tString dir";
  protected final String TEXT_62 = " = null;" + NL + "\t\t\t\t";
  protected final String TEXT_63 = NL + "    \t    \t\tString mask";
  protected final String TEXT_64 = " = filemask";
  protected final String TEXT_65 = ".replaceAll(\"\\\\\\\\\", \"/\") ;" + NL + "\t\t\t\t";
  protected final String TEXT_66 = NL + "\t\t\t\t\tString mask";
  protected final String TEXT_67 = " = filemask";
  protected final String TEXT_68 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_69 = NL + "\t\t    \tint i";
  protected final String TEXT_70 = " = mask";
  protected final String TEXT_71 = ".lastIndexOf('/');" + NL + "\t\t\t\tif (i";
  protected final String TEXT_72 = "!=-1) {" + NL + "\t\t\t\t\tdir";
  protected final String TEXT_73 = " = mask";
  protected final String TEXT_74 = ".substring(0, i";
  protected final String TEXT_75 = "); " + NL + "\t\t\t\t\tmask";
  protected final String TEXT_76 = " = mask";
  protected final String TEXT_77 = ".substring(i";
  protected final String TEXT_78 = "+1); " + NL + "\t    \t\t}" + NL + "\t\t\t\tif (dir";
  protected final String TEXT_79 = "!=null && !\"\".equals(dir";
  protected final String TEXT_80 = ")) ftp_";
  protected final String TEXT_81 = ".chdir(dir";
  protected final String TEXT_82 = ");" + NL + "\t\t        ";
  protected final String TEXT_83 = NL + "    \t\t\t\tmask";
  protected final String TEXT_84 = " = org.apache.oro.text.GlobCompiler.globToPerl5(mask";
  protected final String TEXT_85 = ".toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);" + NL + "\t\t       \t";
  protected final String TEXT_86 = NL + "\t\t\t\tString[] listings";
  protected final String TEXT_87 = " = ftp_";
  protected final String TEXT_88 = ".dir(null, false);" + NL + "\t\t\t\tfor (int m";
  protected final String TEXT_89 = " = 0; m";
  protected final String TEXT_90 = " < listings";
  protected final String TEXT_91 = ".length; m";
  protected final String TEXT_92 = "++) {" + NL + "\t\t\t\t\tif (listings";
  protected final String TEXT_93 = "[m";
  protected final String TEXT_94 = "].matches(mask";
  protected final String TEXT_95 = ")) {" + NL + "\t\t\t\t\t\tftp_";
  protected final String TEXT_96 = ".put(new ByteArrayInputStream(new byte[]{}), listings";
  protected final String TEXT_97 = "[m";
  protected final String TEXT_98 = "]);" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_99 = "_CURRENT_STATUS\", \"File truncate OK.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_100 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_101 = " - '\" + listings";
  protected final String TEXT_102 = "[m";
  protected final String TEXT_103 = "] + \"' truncate ok.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_104 = NL + "\t\t\t\t\t\tnb_file_";
  protected final String TEXT_105 = "++;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t   \t\t}" + NL + "\t\t}catch(com.enterprisedt.net.ftp.FTPException e){" + NL + "   \t\t\tglobalMap.put(\"";
  protected final String TEXT_106 = "_CURRENT_STATUS\", \"File truncate fail.\");" + NL + "\t   \t\tthrow e;" + NL + "   \t\t}" + NL + "\t\tftp_";
  protected final String TEXT_107 = ".chdir(root";
  protected final String TEXT_108 = ");";
  protected final String TEXT_109 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
	String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
	String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	boolean sftp = false;
	boolean useGlob = ("true").equals(ElementParameterParser.getValue(node, "__PERL5_REGEX__"));
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
	if(sftp){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    if(!useGlob) {//perl5 mode not support windows(\) path separator at the mask string
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    }else{
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
			//bug TDI-19189 make regex to match the file name with Regular Expressions  

    stringBuffer.append(TEXT_27);
    if(!useGlob) {
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    }
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    }
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
	}else{

    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    if(!useGlob) {//perl5 mode not support windows(\) path separator at the mask string
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    }else{
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    }
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    if(!useGlob) {
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    }
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    }
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    }
    stringBuffer.append(TEXT_109);
    return stringBuffer.toString();
  }
}
