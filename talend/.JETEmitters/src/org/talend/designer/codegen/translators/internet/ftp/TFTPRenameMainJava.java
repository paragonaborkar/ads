package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TFTPRenameMainJava
{
  protected static String nl;
  public static synchronized TFTPRenameMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPRenameMainJava result = new TFTPRenameMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "try{";
  protected final String TEXT_2 = "\t" + NL + "" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_3 = "_CURRENT_STATUS\", \"No file renamed.\");" + NL + "    \tjava.util.Set<String> keySet";
  protected final String TEXT_4 = " = map";
  protected final String TEXT_5 = ".keySet();   " + NL + "    \tfor (String key";
  protected final String TEXT_6 = " : keySet";
  protected final String TEXT_7 = ") {    " + NL + "   \t\t\ttry{" + NL + "   \t\t\t\tc_";
  protected final String TEXT_8 = ".rename(";
  protected final String TEXT_9 = "+\"/\"+key";
  protected final String TEXT_10 = ", ";
  protected final String TEXT_11 = "+\"/\"+map";
  protected final String TEXT_12 = ".get(key";
  protected final String TEXT_13 = "));" + NL + "\t\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_15 = " - '\" + key";
  protected final String TEXT_16 = "  + \"' rename ok.\");" + NL + "\t\t\t\t";
  protected final String TEXT_17 = NL + "\t   \t\t\tglobalMap.put(\"";
  protected final String TEXT_18 = "_CURRENT_STATUS\", \"File rename OK.\");" + NL + "   \t\t\t}catch(com.jcraft.jsch.SftpException se){" + NL + "   \t\t\t\tglobalMap.put(\"";
  protected final String TEXT_19 = "_CURRENT_STATUS\", \"File rename fail.\");" + NL + "   \t\t\t\tthrow se;" + NL + "   \t\t\t}" + NL + "   \t\t\tnb_file_";
  protected final String TEXT_20 = "++;" + NL + "   \t\t}" + NL + "\t" + NL + "" + NL + "" + NL + "\t";
  protected final String TEXT_21 = "//normal ftp" + NL + "\t \t" + NL + "\t\tjava.util.Set<String> keySet";
  protected final String TEXT_22 = " = map";
  protected final String TEXT_23 = ".keySet();" + NL + "\t\tString tmp_";
  protected final String TEXT_24 = " = pid + System.currentTimeMillis();" + NL + "    \ttry{  " + NL + "    \t\tfor (String key";
  protected final String TEXT_25 = " : keySet";
  protected final String TEXT_26 = ") {" + NL + "\t     \t\t";
  protected final String TEXT_27 = NL + "    \t \t\t  " + NL + "     \t\t\t\tString fromFile_";
  protected final String TEXT_28 = " = key";
  protected final String TEXT_29 = ";" + NL + "     \t\t\t\tString toFile_";
  protected final String TEXT_30 = " = map";
  protected final String TEXT_31 = ".get(key";
  protected final String TEXT_32 = ");" + NL + "     \t\t\t" + NL + "     \t\t    \tif (!fromFile_";
  protected final String TEXT_33 = ".equals(toFile_";
  protected final String TEXT_34 = ")){" + NL + "     \t\t    \t\tif(ftp_";
  protected final String TEXT_35 = ".exists(fromFile_";
  protected final String TEXT_36 = ")){" + NL + "\t\t     \t\t    \tif(ftp_";
  protected final String TEXT_37 = ".exists(toFile_";
  protected final String TEXT_38 = " + \".\" + tmp_";
  protected final String TEXT_39 = ")){" + NL + "     \t\t\t\t    \t\tftp_";
  protected final String TEXT_40 = ".delete(toFile_";
  protected final String TEXT_41 = " + \".\" + tmp_";
  protected final String TEXT_42 = ");" + NL + "     \t\t    \t\t\t}" + NL + "\t\t     \t\t    \tif(ftp_";
  protected final String TEXT_43 = ".exists(toFile_";
  protected final String TEXT_44 = ")){" + NL + "\t\t\t     \t\t\t\tftp_";
  protected final String TEXT_45 = ".rename(toFile_";
  protected final String TEXT_46 = ", toFile_";
  protected final String TEXT_47 = " + \".\" + tmp_";
  protected final String TEXT_48 = ");" + NL + "     \t\t\t    \t\t}" + NL + "\t     \t\t\t\t\tftp_";
  protected final String TEXT_49 = ".rename(fromFile_";
  protected final String TEXT_50 = ", toFile_";
  protected final String TEXT_51 = ");" + NL + "\t     \t\t\t\t\tif(ftp_";
  protected final String TEXT_52 = ".exists(toFile_";
  protected final String TEXT_53 = " + \".\" + tmp_";
  protected final String TEXT_54 = ")){" + NL + "\t\t     \t\t\t\t\tftp_";
  protected final String TEXT_55 = ".delete(toFile_";
  protected final String TEXT_56 = " + \".\" + tmp_";
  protected final String TEXT_57 = ");" + NL + "\t     \t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_59 = " - '\" + toFile_";
  protected final String TEXT_60 = "  + \"' rename ok\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_61 = NL + "\t     \t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_62 = "_CURRENT_STATUS\", \"File rename OK.\");" + NL + "\t     \t\t\t\t\tnb_file_";
  protected final String TEXT_63 = "++;" + NL + "     \t\t\t  \t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\t";
  protected final String TEXT_65 = NL + "     \t\t\t\tif(!(ftp_";
  protected final String TEXT_66 = ".exists(map";
  protected final String TEXT_67 = ".get(key";
  protected final String TEXT_68 = ")))) {" + NL + "\t\t\t\t\t\tftp_";
  protected final String TEXT_69 = ".rename(key";
  protected final String TEXT_70 = ", map";
  protected final String TEXT_71 = ".get(key";
  protected final String TEXT_72 = "));" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_74 = " - '\" + key";
  protected final String TEXT_75 = "  + \"' rename ok\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_76 = NL + "     \t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_77 = "_CURRENT_STATUS\", \"File rename OK.\");" + NL + "     \t\t\t\t\tnb_file_";
  protected final String TEXT_78 = "++;" + NL + "     \t\t\t\t}" + NL + "     \t\t\t";
  protected final String TEXT_79 = NL + "     \t\t\t";
  protected final String TEXT_80 = NL + "     \t\t\t\tif((ftp_";
  protected final String TEXT_81 = ".exists(map";
  protected final String TEXT_82 = ".get(key";
  protected final String TEXT_83 = ")))){" + NL + "\t\t\t\t\t\tcom.enterprisedt.net.ftp.FTPFile ftpnewNamefile";
  protected final String TEXT_84 = "=ftp_";
  protected final String TEXT_85 = ".fileDetails(map";
  protected final String TEXT_86 = ".get(key";
  protected final String TEXT_87 = "));" + NL + "\t\t\t\t\t\tcom.enterprisedt.net.ftp.FTPFile ftporigNamefile";
  protected final String TEXT_88 = "=ftp_";
  protected final String TEXT_89 = ".fileDetails(key";
  protected final String TEXT_90 = ");" + NL + "\t\t\t\t\t\tlong newNameSize";
  protected final String TEXT_91 = "=ftpnewNamefile";
  protected final String TEXT_92 = ".size();" + NL + "\t\t\t\t\t\tlong origNameSize";
  protected final String TEXT_93 = "=ftporigNamefile";
  protected final String TEXT_94 = ".size();" + NL + "\t\t\t\t\t\tif(!(newNameSize";
  protected final String TEXT_95 = "==origNameSize";
  protected final String TEXT_96 = ")) {" + NL + "\t\t     \t\t\t\tString fromFile_";
  protected final String TEXT_97 = " = key";
  protected final String TEXT_98 = ";" + NL + "\t\t     \t\t\t\tString toFile_";
  protected final String TEXT_99 = " = map";
  protected final String TEXT_100 = ".get(key";
  protected final String TEXT_101 = ");" + NL + "\t\t\t\t\t\t\tif(ftp_";
  protected final String TEXT_102 = ".exists(fromFile_";
  protected final String TEXT_103 = ")){" + NL + "\t\t     \t\t    \t\tif(ftp_";
  protected final String TEXT_104 = ".exists(toFile_";
  protected final String TEXT_105 = " + \".\" + tmp_";
  protected final String TEXT_106 = ")){" + NL + "\t\t     \t\t    \t\t\tftp_";
  protected final String TEXT_107 = ".delete(toFile_";
  protected final String TEXT_108 = " + \".\" + tmp_";
  protected final String TEXT_109 = ");" + NL + "\t\t     \t\t    \t\t}" + NL + "\t\t     \t\t    \t\tif(ftp_";
  protected final String TEXT_110 = ".exists(toFile_";
  protected final String TEXT_111 = ")){" + NL + "\t\t\t\t     \t\t\t\tftp_";
  protected final String TEXT_112 = ".rename(toFile_";
  protected final String TEXT_113 = ", toFile_";
  protected final String TEXT_114 = " + \".\" + tmp_";
  protected final String TEXT_115 = ");" + NL + "\t\t     \t\t    \t\t}" + NL + "\t\t\t     \t\t\t\tftp_";
  protected final String TEXT_116 = ".rename(fromFile_";
  protected final String TEXT_117 = ", toFile_";
  protected final String TEXT_118 = ");" + NL + "\t\t\t     \t\t\t\tif(ftp_";
  protected final String TEXT_119 = ".exists(toFile_";
  protected final String TEXT_120 = " + \".\" + tmp_";
  protected final String TEXT_121 = ")){" + NL + "\t\t\t\t     \t\t\t\tftp_";
  protected final String TEXT_122 = ".delete(toFile_";
  protected final String TEXT_123 = " + \".\" + tmp_";
  protected final String TEXT_124 = ");" + NL + "\t\t\t     \t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_125 = NL + "\t\t\t\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_126 = " - '\" + toFile_";
  protected final String TEXT_127 = "  + \"' rename ok\");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_128 = NL + "\t\t\t     \t\t\t\tglobalMap.put(\"";
  protected final String TEXT_129 = "_CURRENT_STATUS\", \"File rename OK.\");" + NL + "\t\t\t     \t\t\t\tnb_file_";
  protected final String TEXT_130 = "++;" + NL + "\t\t     \t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tftp_";
  protected final String TEXT_131 = ".rename(key";
  protected final String TEXT_132 = ", map";
  protected final String TEXT_133 = ".get(key";
  protected final String TEXT_134 = "));" + NL + "\t\t\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_135 = "_CURRENT_STATUS\", \"File rename OK.\");" + NL + "\t\t\t\t\t\tnb_file_";
  protected final String TEXT_136 = "++;" + NL + "\t\t\t\t\t}" + NL + "     \t\t\t";
  protected final String TEXT_137 = NL + "\t\t\t}" + NL + "\t\t}catch(com.enterprisedt.net.ftp.FTPException e){" + NL + "   \t\t\tglobalMap.put(\"";
  protected final String TEXT_138 = "_CURRENT_STATUS\", \"File rename fail.\");" + NL + "        \tthrow e;" + NL + "   \t\t}" + NL + "" + NL + "\t";
  protected final String TEXT_139 = NL + "}catch(java.lang.Exception e){";
  protected final String TEXT_140 = NL + "        throw(e);";
  protected final String TEXT_141 = NL + "\t\t";
  protected final String TEXT_142 = NL + "\t\t\tlog.error(\"";
  protected final String TEXT_143 = " - \" + e.getMessage());" + NL + "\t\t";
  protected final String TEXT_144 = NL + "\t\tSystem.err.print(e.getMessage());";
  protected final String TEXT_145 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String overwrite=ElementParameterParser.getValue(node, "__OVERWRITE__");
	String cid = node.getUniqueName();
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
	String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
	String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
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

    stringBuffer.append(TEXT_1);
    
	if(sftp){//sftp support

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    }else{
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
    if(("always").equals(overwrite)){
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    }
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    }
    stringBuffer.append(TEXT_64);
    if(("never").equals(overwrite)){
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
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
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    }
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    }
    stringBuffer.append(TEXT_79);
    if(("size_differ").equals(overwrite)){
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
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
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    }
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    }
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    }
    stringBuffer.append(TEXT_139);
    
	if(("true").equals(dieOnError)){

    stringBuffer.append(TEXT_140);
    
	}else{

    stringBuffer.append(TEXT_141);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    }
    stringBuffer.append(TEXT_144);
    
	}

    stringBuffer.append(TEXT_145);
    return stringBuffer.toString();
  }
}
