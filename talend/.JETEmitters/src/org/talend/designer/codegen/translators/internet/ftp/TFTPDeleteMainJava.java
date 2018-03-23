package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TFTPDeleteMainJava
{
  protected static String nl;
  public static synchronized TFTPDeleteMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPDeleteMainJava result = new TFTPDeleteMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\ttry{";
  protected final String TEXT_3 = NL + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_4 = "_CURRENT_STATUS\", \"No file deleted.\");" + NL + "\t\t\tjava.util.Set<String> keySet";
  protected final String TEXT_5 = " = map";
  protected final String TEXT_6 = ".keySet(); " + NL + "\t\t\tfor (String key";
  protected final String TEXT_7 = " : keySet";
  protected final String TEXT_8 = ") {     " + NL + "\t\t\t\tString filemask";
  protected final String TEXT_9 = " = key";
  protected final String TEXT_10 = "; " + NL + "\t\t    \tString dir";
  protected final String TEXT_11 = " = null;" + NL + "        \t\t";
  protected final String TEXT_12 = NL + "\t\t        \tString mask";
  protected final String TEXT_13 = " = filemask";
  protected final String TEXT_14 = ".replaceAll(\"\\\\\\\\\", \"/\") ;" + NL + "        \t\t";
  protected final String TEXT_15 = NL + "\t\t       \tString mask";
  protected final String TEXT_16 = " = filemask";
  protected final String TEXT_17 = ";" + NL + "        \t\t";
  protected final String TEXT_18 = NL + "\t\t    \tint i";
  protected final String TEXT_19 = " = mask";
  protected final String TEXT_20 = ".lastIndexOf('/');" + NL + "\t\t\t\tif (i";
  protected final String TEXT_21 = "!=-1) {" + NL + "\t\t\t\t\tdir";
  protected final String TEXT_22 = " = mask";
  protected final String TEXT_23 = ".substring(0, i";
  protected final String TEXT_24 = "); " + NL + "\t\t\t\t\tmask";
  protected final String TEXT_25 = " = mask";
  protected final String TEXT_26 = ".substring(i";
  protected final String TEXT_27 = "+1); " + NL + "    \t\t\t}";
  protected final String TEXT_28 = " " + NL + "\t\t        ";
  protected final String TEXT_29 = NL + "        \t\t\tmask";
  protected final String TEXT_30 = " = org.apache.oro.text.GlobCompiler.globToPerl5(mask";
  protected final String TEXT_31 = ".toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);" + NL + "\t\t        ";
  protected final String TEXT_32 = NL + "\t\t\t\tjava.util.Vector listings";
  protected final String TEXT_33 = " = c_";
  protected final String TEXT_34 = ".ls(";
  protected final String TEXT_35 = ");" + NL + "\t\t\t\tfor (int m";
  protected final String TEXT_36 = " = 0; m";
  protected final String TEXT_37 = " < listings";
  protected final String TEXT_38 = ".size(); m";
  protected final String TEXT_39 = "++) { " + NL + "\t\t\t\t\tString filePath";
  protected final String TEXT_40 = " =  ((com.jcraft.jsch.ChannelSftp.LsEntry) listings";
  protected final String TEXT_41 = ".elementAt(m";
  protected final String TEXT_42 = ")).getFilename() ;" + NL + "\t\t\t\t\tif ( filePath";
  protected final String TEXT_43 = ".matches(mask";
  protected final String TEXT_44 = ")) {" + NL + "\t\t\t\t\t\ttry {";
  protected final String TEXT_45 = "\t\t\t" + NL + "\t\t\t\t\t\t\t \tc_";
  protected final String TEXT_46 = ".rm((";
  protected final String TEXT_47 = ")+\"/\"+ filePath";
  protected final String TEXT_48 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_50 = " - File '\" + filePath";
  protected final String TEXT_51 = "  + \"' was deleted from the remote directory \" + ";
  protected final String TEXT_52 = " + \".\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\t\t\t\t\t \tc_";
  protected final String TEXT_54 = ".rmdir((";
  protected final String TEXT_55 = ")+\"/\"+ filePath";
  protected final String TEXT_56 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_58 = " - Directory '\" + filePath";
  protected final String TEXT_59 = "  + \"' was deleted from the remote directory \" + ";
  protected final String TEXT_60 = " + \".\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_61 = NL + "\t\t\t\t\t\t\t globalMap.put(\"";
  protected final String TEXT_62 = "_CURRENT_STATUS\", \"File deleted.\");" + NL + "\t\t\t\t\t\t} catch (com.jcraft.jsch.SftpException e_";
  protected final String TEXT_63 = ") {" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_64 = "_CURRENT_STATUS\", \"Deleting file action error\");" + NL + "            \t           throw e_";
  protected final String TEXT_65 = ";" + NL + "                \t\t}" + NL + "\t\t\t\t\t\tnb_file_";
  protected final String TEXT_66 = "++;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}\t     " + NL + "\t\t\t}  " + NL + "" + NL + "" + NL + "   " + NL + "    ";
  protected final String TEXT_67 = NL + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_68 = "_CURRENT_STATUS\", \"No file deleted.\");" + NL + "\t\t    java.util.Set<String> keySet";
  protected final String TEXT_69 = " = map";
  protected final String TEXT_70 = ".keySet(); " + NL + "\t\t    try {" + NL + "\t\t\t\tfor (String key";
  protected final String TEXT_71 = " : keySet";
  protected final String TEXT_72 = ") {     " + NL + "\t\t\t\t\tString filemask";
  protected final String TEXT_73 = " = key";
  protected final String TEXT_74 = "; " + NL + "\t\t\t\t   \tString dir";
  protected final String TEXT_75 = " = null;" + NL + "\t\t\t        ";
  protected final String TEXT_76 = NL + "\t\t\t\t        String mask";
  protected final String TEXT_77 = " = filemask";
  protected final String TEXT_78 = ".replaceAll(\"\\\\\\\\\", \"/\") ;" + NL + "\t\t\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\t\tString mask";
  protected final String TEXT_80 = " = filemask";
  protected final String TEXT_81 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_82 = NL + "\t\t\t\t\tint i";
  protected final String TEXT_83 = " = mask";
  protected final String TEXT_84 = ".lastIndexOf('/');" + NL + "\t\t\t\t\tif (i";
  protected final String TEXT_85 = "!=-1) {" + NL + "\t\t\t\t\t\tdir";
  protected final String TEXT_86 = " = mask";
  protected final String TEXT_87 = ".substring(0, i";
  protected final String TEXT_88 = "); " + NL + "\t\t\t\t\t\tmask";
  protected final String TEXT_89 = " = mask";
  protected final String TEXT_90 = ".substring(i";
  protected final String TEXT_91 = "+1); " + NL + "    \t\t\t\t}" + NL + "\t\t\t    \tif (dir";
  protected final String TEXT_92 = "!=null && !\"\".equals(dir";
  protected final String TEXT_93 = ")) ftp_";
  protected final String TEXT_94 = ".chdir(dir";
  protected final String TEXT_95 = ");" + NL + "\t\t\t        ";
  protected final String TEXT_96 = NL + "        \t\t\t    mask";
  protected final String TEXT_97 = " = org.apache.oro.text.GlobCompiler.globToPerl5(mask";
  protected final String TEXT_98 = ".toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);" + NL + "\t\t\t        ";
  protected final String TEXT_99 = NL + "\t\t\t    \tString[] fileName_";
  protected final String TEXT_100 = " = null;" + NL + "\t\t\t    \tboolean dirFailed_";
  protected final String TEXT_101 = " = false;" + NL + "\t\t\t    \ttry{" + NL + "    \t\t\t\t\tfileName_";
  protected final String TEXT_102 = " = ftp_";
  protected final String TEXT_103 = ".dir(null,false);" + NL + "\t\t\t\t   \t}catch(com.enterprisedt.net.ftp.FTPException e_";
  protected final String TEXT_104 = "){" + NL + "\t\t\t    \t\tdirFailed_";
  protected final String TEXT_105 = " = true;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_106 = NL + "\t\t\t\t\t\t\tlog.warn(\"";
  protected final String TEXT_107 = " - \" + e_";
  protected final String TEXT_108 = ".getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_109 = NL + "\t\t\t    \t}" + NL + "\t\t\t    \tif((fileName_";
  protected final String TEXT_110 = " == null) || dirFailed_";
  protected final String TEXT_111 = " || (fileName_";
  protected final String TEXT_112 = ".length <= 0)){" + NL + "\t\t\t\t\t\tcom.enterprisedt.net.ftp.FTPFile[] fileList_";
  protected final String TEXT_113 = " = ftp_";
  protected final String TEXT_114 = ".dirDetails(null);" + NL + "\t\t\t\t\t\tfileName_";
  protected final String TEXT_115 = " = new String[fileList_";
  protected final String TEXT_116 = ".length];" + NL + "\t\t\t\t\t\tfor (int i_";
  protected final String TEXT_117 = " = 0 ; i_";
  protected final String TEXT_118 = " < fileList_";
  protected final String TEXT_119 = ".length ; i_";
  protected final String TEXT_120 = "++){" + NL + "\t\t\t\t\t\t\tfileName_";
  protected final String TEXT_121 = "[i_";
  protected final String TEXT_122 = "] = fileList_";
  protected final String TEXT_123 = "[i_";
  protected final String TEXT_124 = "].getName();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tfor (String file_";
  protected final String TEXT_125 = " : fileName_";
  protected final String TEXT_126 = ") {" + NL + "\t\t\t\t\t\tif (file_";
  protected final String TEXT_127 = ".matches(mask";
  protected final String TEXT_128 = ")) {";
  protected final String TEXT_129 = "\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tftp_";
  protected final String TEXT_130 = ".delete(file_";
  protected final String TEXT_131 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_132 = NL + "\t\t\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_133 = " - File '\" + file_";
  protected final String TEXT_134 = "  + \"' was deleted from the remote directory \" + ";
  protected final String TEXT_135 = " + \".\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_136 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_137 = NL + "\t\t\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_138 = " - Directory '\" + file_";
  protected final String TEXT_139 = "  + \"' was deleted from the remote directory \" + ";
  protected final String TEXT_140 = " + \".\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_141 = NL + "\t\t\t\t\t\t\t\tftp_";
  protected final String TEXT_142 = ".rmdir(file_";
  protected final String TEXT_143 = ");";
  protected final String TEXT_144 = "\t\t\t\t" + NL + "\t\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_145 = "_CURRENT_STATUS\", \"File deleted.\");" + NL + "\t\t\t\t\t\t\tnb_file_";
  protected final String TEXT_146 = "++;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "   \t\t\t\t}" + NL + "\t\t   \t}catch(com.enterprisedt.net.ftp.FTPException e_";
  protected final String TEXT_147 = "){" + NL + "   \t\t\t\tglobalMap.put(\"";
  protected final String TEXT_148 = "_CURRENT_STATUS\", \"Deleting file action error\");" + NL + "   \t\t\t\tthrow e_";
  protected final String TEXT_149 = ";" + NL + "\t\t   \t}" + NL + "\t\t   ftp_";
  protected final String TEXT_150 = ".chdir(root";
  protected final String TEXT_151 = ");";
  protected final String TEXT_152 = NL + "\t}catch(java.lang.Exception e_";
  protected final String TEXT_153 = "){";
  protected final String TEXT_154 = NL + "    \t\tthrow(e_";
  protected final String TEXT_155 = ");";
  protected final String TEXT_156 = NL + "\t\t\t";
  protected final String TEXT_157 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_158 = " - \" + e_";
  protected final String TEXT_159 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_160 = NL + "\t\t\tSystem.err.print(e_";
  protected final String TEXT_161 = ".getMessage());";
  protected final String TEXT_162 = NL + "\t}";
  protected final String TEXT_163 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
	String targetType = ElementParameterParser.getValue(node, "__TARGET_TYPE__");
	String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
	String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	boolean sftp = false;
	boolean usePerl5 = ("true").equals(ElementParameterParser.getValue(node, "__PERL5_REGEX__"));
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

    stringBuffer.append(TEXT_2);
    
		if(sftp){// *** sftp *** //

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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    if(!usePerl5) {//perl5 mode not support windows(\) path separator at the mask string
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    }else{
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    }
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    
				//bug TDI-19189 make regex to match the file name with Regular Expressions  

    stringBuffer.append(TEXT_28);
    if(!usePerl5) {
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    }
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    
							if("FILE".equals(targetType)){

    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_52);
    }
    
							}else{

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_60);
    }
    
							}

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
		}else{// *** ftp *** //

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
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
    if(!usePerl5) {//perl5 mode not support windows(\) path separator at the mask string
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    }else{
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    }
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
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
    if(!usePerl5) {
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    }
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    
							if("FILE".equals(targetType)){

    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_135);
    }
    
							}else{

    stringBuffer.append(TEXT_136);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_140);
    }
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    
							}

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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    
		}

    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    
		if(("true").equals(dieOnError)){

    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    
		}else{

    stringBuffer.append(TEXT_156);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    }
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_161);
    
		}

    stringBuffer.append(TEXT_162);
    stringBuffer.append(TEXT_163);
    return stringBuffer.toString();
  }
}
