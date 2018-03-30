package org.talend.designer.codegen.translators.business_intelligence.olap_cube.palo;

import java.util.List;
import java.util.Map;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TPaloCubeBeginJava
{
  protected static String nl;
  public static synchronized TPaloCubeBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPaloCubeBeginJava result = new TPaloCubeBeginJava();
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
  protected final String TEXT_29 = NL + NL + "org.talend.jpalo.palo p_";
  protected final String TEXT_30 = " = null;" + NL + "org.talend.jpalo.paloconnection pConn_";
  protected final String TEXT_31 = " = null;" + NL;
  protected final String TEXT_32 = NL + "\t// Use Existing" + NL + "\tp_";
  protected final String TEXT_33 = " = (org.talend.jpalo.palo)globalMap.get(\"";
  protected final String TEXT_34 = "\");" + NL + "\tpConn_";
  protected final String TEXT_35 = " =  (org.talend.jpalo.paloconnection)globalMap.get(\"";
  protected final String TEXT_36 = "\");" + NL + "\t";
  protected final String TEXT_37 = NL + "\t\tif(pConn_";
  protected final String TEXT_38 = "!=null) {" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_39 = " - Uses an existing connection.\");" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_40 = NL + "\t// Initialize jpalo" + NL + "\tp_";
  protected final String TEXT_41 = " = new org.talend.jpalo.palo(";
  protected final String TEXT_42 = ");" + NL + "\t// Open the connection" + NL + "\t";
  protected final String TEXT_43 = NL + "\t\tlog.info(\"";
  protected final String TEXT_44 = " - Connection attempt to '\" + ";
  protected final String TEXT_45 = " + \"' with the username '\" + ";
  protected final String TEXT_46 = " + \"' .\");" + NL + "\t";
  protected final String TEXT_47 = NL + "\t        " + NL + "\t";
  protected final String TEXT_48 = NL + "\t" + NL + "\t";
  protected final String TEXT_49 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_50 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_53 = " = ";
  protected final String TEXT_54 = "; ";
  protected final String TEXT_55 = NL + "   \t" + NL + "\tpConn_";
  protected final String TEXT_56 = " = p_";
  protected final String TEXT_57 = ".connect(";
  protected final String TEXT_58 = ", decryptedPassword_";
  protected final String TEXT_59 = ", ";
  protected final String TEXT_60 = ", ";
  protected final String TEXT_61 = ");" + NL + "\t";
  protected final String TEXT_62 = NL + "\t\tlog.info(\"";
  protected final String TEXT_63 = " - Connection to '\" + ";
  protected final String TEXT_64 = " + \"' has succeeded.\");" + NL + "\t";
  protected final String TEXT_65 = NL + NL + "org.talend.jpalo.palodatabases pDBs_";
  protected final String TEXT_66 = " = pConn_";
  protected final String TEXT_67 = ".getDatabases();" + NL + "org.talend.jpalo.palodatabase pDB_";
  protected final String TEXT_68 = " = pDBs_";
  protected final String TEXT_69 = ".getDatabase(";
  protected final String TEXT_70 = ");" + NL + "" + NL + "if(pDB_";
  protected final String TEXT_71 = " == null){" + NL + "\t throw new RuntimeException (\"Database '\" + ";
  protected final String TEXT_72 = " + \"' not found. exiting...\");" + NL + "}" + NL;
  protected final String TEXT_73 = NL + "\torg.talend.jpalo.palocubes pCUBs_";
  protected final String TEXT_74 = " = pDB_";
  protected final String TEXT_75 = ".getCubes(org.talend.jpalo.palocubes.";
  protected final String TEXT_76 = ");" + NL + "\t";
  protected final String TEXT_77 = NL + "\t\tlog.info(\"";
  protected final String TEXT_78 = " - Creating cube '\" + ";
  protected final String TEXT_79 = " + \"' .\");" + NL + "\t";
  protected final String TEXT_80 = NL + "\tpCUBs_";
  protected final String TEXT_81 = ".createCube(";
  protected final String TEXT_82 = ", new String[]{";
  protected final String TEXT_83 = "}, org.talend.jpalo.palocubes.";
  protected final String TEXT_84 = ");" + NL + "\t";
  protected final String TEXT_85 = NL + "\t\tlog.info(\"";
  protected final String TEXT_86 = " - Create cube '\" + ";
  protected final String TEXT_87 = " + \"' has succeeded.\");" + NL + "\t";
  protected final String TEXT_88 = NL + "\torg.talend.jpalo.palocubes pCUBs_";
  protected final String TEXT_89 = " = pDB_";
  protected final String TEXT_90 = ".getCubes(org.talend.jpalo.palocubes.";
  protected final String TEXT_91 = ");" + NL + "\tif(null==pCUBs_";
  protected final String TEXT_92 = ".getCube(";
  protected final String TEXT_93 = ")){" + NL + "\t\t";
  protected final String TEXT_94 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_95 = " - Creating cube '\" + ";
  protected final String TEXT_96 = " + \"' .\");" + NL + "\t\t";
  protected final String TEXT_97 = NL + "\t\tpCUBs_";
  protected final String TEXT_98 = ".createCube(";
  protected final String TEXT_99 = ", new String[]{";
  protected final String TEXT_100 = "}, org.talend.jpalo.palocubes.";
  protected final String TEXT_101 = ");" + NL + "\t\t";
  protected final String TEXT_102 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_103 = " - Create cube '\" + ";
  protected final String TEXT_104 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_105 = NL + "\t}";
  protected final String TEXT_106 = NL + "\torg.talend.jpalo.palocubes pCUBs_";
  protected final String TEXT_107 = " = pDB_";
  protected final String TEXT_108 = ".getCubes(org.talend.jpalo.palocubes.";
  protected final String TEXT_109 = ");" + NL + "\t";
  protected final String TEXT_110 = NL + "\t\tlog.info(\"";
  protected final String TEXT_111 = " - Deleting cube '\" + ";
  protected final String TEXT_112 = " + \"' .\");" + NL + "\t";
  protected final String TEXT_113 = NL + "\tif(null!=pCUBs_";
  protected final String TEXT_114 = ".getCube(";
  protected final String TEXT_115 = ")) pCUBs_";
  protected final String TEXT_116 = ".deleteCube(";
  protected final String TEXT_117 = ");" + NL + "\t";
  protected final String TEXT_118 = NL + "\t\tlog.info(\"";
  protected final String TEXT_119 = " - Delete cube '\" + ";
  protected final String TEXT_120 = " + \"' has succeeded.\");" + NL + "\t\tlog.info(\"";
  protected final String TEXT_121 = " - Creating cube '\" + ";
  protected final String TEXT_122 = " + \"' .\");" + NL + "\t";
  protected final String TEXT_123 = NL + "\tpCUBs_";
  protected final String TEXT_124 = ".createCube(";
  protected final String TEXT_125 = ", new String[]{";
  protected final String TEXT_126 = "}, org.talend.jpalo.palocubes.";
  protected final String TEXT_127 = ");" + NL + "\t";
  protected final String TEXT_128 = NL + "\t\tlog.info(\"";
  protected final String TEXT_129 = " - Create cube '\" + ";
  protected final String TEXT_130 = " + \"' has succeeded.\");" + NL + "\t";
  protected final String TEXT_131 = NL + "\torg.talend.jpalo.palocubes pCUBs_";
  protected final String TEXT_132 = " = pDB_";
  protected final String TEXT_133 = ".getCubes(org.talend.jpalo.palocubes.";
  protected final String TEXT_134 = ");" + NL + "\t";
  protected final String TEXT_135 = NL + "\t\tlog.info(\"";
  protected final String TEXT_136 = " - Deleting cube '\" + ";
  protected final String TEXT_137 = " + \"' .\");" + NL + "\t";
  protected final String TEXT_138 = NL + "\tpCUBs_";
  protected final String TEXT_139 = ".deleteCube(";
  protected final String TEXT_140 = ");" + NL + "\t";
  protected final String TEXT_141 = NL + "\t\tlog.info(\"";
  protected final String TEXT_142 = " - Delete cube '\" + ";
  protected final String TEXT_143 = " + \"' has succeeded.\");" + NL + "\t";
  protected final String TEXT_144 = "\t";
  protected final String TEXT_145 = NL + "\torg.talend.jpalo.palocubes pCUBs_";
  protected final String TEXT_146 = " = pDB_";
  protected final String TEXT_147 = ".getCubes(org.talend.jpalo.palocubes.";
  protected final String TEXT_148 = ");" + NL + "\t";
  protected final String TEXT_149 = NL + "\t\tlog.info(\"";
  protected final String TEXT_150 = " - Clearing cube '\" + ";
  protected final String TEXT_151 = " + \"' .\");" + NL + "\t";
  protected final String TEXT_152 = NL + "\tpCUBs_";
  protected final String TEXT_153 = ".getCube(";
  protected final String TEXT_154 = ").clear();" + NL + "\t";
  protected final String TEXT_155 = NL + "\t\tlog.info(\"";
  protected final String TEXT_156 = " - Clear cube '\" + ";
  protected final String TEXT_157 = " + \"' has succeeded.\");" + NL + "\t";
  protected final String TEXT_158 = "\t\t";
  protected final String TEXT_159 = NL + "\t\tif(pConn_";
  protected final String TEXT_160 = " != null){" + NL + "\t\t\t";
  protected final String TEXT_161 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_162 = " - Closing the connection to the database.\");" + NL + "\t\t\t";
  protected final String TEXT_163 = NL + "\t\t\tpConn_";
  protected final String TEXT_164 = ".logout();" + NL + "\t\t\t";
  protected final String TEXT_165 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_166 = " - Connection to the database closed.\");" + NL + "\t\t\t";
  protected final String TEXT_167 = NL + "\t\t}";
  protected final String TEXT_168 = NL + "globalMap.put(\"";
  protected final String TEXT_169 = "_CUBENAME\",";
  protected final String TEXT_170 = ");" + NL;
  protected final String TEXT_171 = NL;

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
	
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));


    String sServer = ElementParameterParser.getValue(node, "__SERVER__");
    String sServerport = ElementParameterParser.getValue(node, "__SERVERPORT__");
    String sUsername = ElementParameterParser.getValue(node, "__USERNAME__");


    String sDatabaseName = ElementParameterParser.getValue(node,"__DATABASE__");
    String sCubeName = ElementParameterParser.getValue(node,"__CUBE__");
    String sCubeType = ElementParameterParser.getValue(node,"__CUBE_TYPE__");
    String sCubeAction = ElementParameterParser.getValue(node,"__CUBE_ACTION__");

    List<Map<String, String>> tCubeDimensions = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__CUBE_DIMENSIONS__");
    

    String sDeploypalolibs = ElementParameterParser.getValue(node, "__DEPLOY_PALO_LIBS__");
    boolean bDeploypalolibs=false;
    if(sDeploypalolibs.equals("true"))bDeploypalolibs=true;


    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    
if(useExistingConnection){
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	String p = "p_" + connection;
	String pConn = "pConn_" + connection;


    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(p);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(pConn);
    stringBuffer.append(TEXT_36);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    }
    
}else{

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(bDeploypalolibs);
    stringBuffer.append(TEXT_42);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(sServer);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(sUsername);
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    
	String passwordFieldName = "__PASS__";
	
    stringBuffer.append(TEXT_48);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_51);
    } else {
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_54);
    }
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(sUsername);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(sServer);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(sServerport);
    stringBuffer.append(TEXT_61);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(sServer);
    stringBuffer.append(TEXT_64);
    }
    
}

    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(sDatabaseName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(sDatabaseName);
    stringBuffer.append(TEXT_72);
    

int iNbOfCubeDimensions = tCubeDimensions.size();
StringBuilder sbX=new StringBuilder();
for(int i=0; i<iNbOfCubeDimensions; i++){
	Map<String, String> CubeDimension = tCubeDimensions.get(i);
	String strDimensionName = CubeDimension.get("DIMENSION_NAME");
	if(i>0) sbX.append(",");
	sbX.append(strDimensionName);
}


if(("CREATE").equals(sCubeAction)){

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(sCubeType);
    stringBuffer.append(TEXT_76);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(sCubeName);
    stringBuffer.append(TEXT_79);
    }
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(sCubeName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(sbX.toString());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(sCubeType);
    stringBuffer.append(TEXT_84);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(sCubeName);
    stringBuffer.append(TEXT_87);
    }
    
}else if(("CREATE_IF_NOT_EXISTS").equals(sCubeAction)){

    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(sCubeType);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(sCubeName);
    stringBuffer.append(TEXT_93);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(sCubeName);
    stringBuffer.append(TEXT_96);
    }
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(sCubeName);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(sbX.toString());
    stringBuffer.append(TEXT_100);
    stringBuffer.append(sCubeType);
    stringBuffer.append(TEXT_101);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(sCubeName);
    stringBuffer.append(TEXT_104);
    }
    stringBuffer.append(TEXT_105);
    
}else if(("DELETE_IF_EXISTS_AND_CREATE").equals(sCubeAction)){

    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(sCubeType);
    stringBuffer.append(TEXT_109);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(sCubeName);
    stringBuffer.append(TEXT_112);
    }
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(sCubeName);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(sCubeName);
    stringBuffer.append(TEXT_117);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(sCubeName);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(sCubeName);
    stringBuffer.append(TEXT_122);
    }
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(sCubeName);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(sbX.toString());
    stringBuffer.append(TEXT_126);
    stringBuffer.append(sCubeType);
    stringBuffer.append(TEXT_127);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(sCubeName);
    stringBuffer.append(TEXT_130);
    }
    
}else if(("DELETE").equals(sCubeAction)){

    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(sCubeType);
    stringBuffer.append(TEXT_134);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(sCubeName);
    stringBuffer.append(TEXT_137);
    }
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(sCubeName);
    stringBuffer.append(TEXT_140);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(sCubeName);
    stringBuffer.append(TEXT_143);
    }
    stringBuffer.append(TEXT_144);
    	
} else if(("CLEAR").equals(sCubeAction)){

    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(sCubeType);
    stringBuffer.append(TEXT_148);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(sCubeName);
    stringBuffer.append(TEXT_151);
    }
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(sCubeName);
    stringBuffer.append(TEXT_154);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(sCubeName);
    stringBuffer.append(TEXT_157);
    }
    stringBuffer.append(TEXT_158);
    	
}
	if(!useExistingConnection){

    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    }
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    }
    stringBuffer.append(TEXT_167);
    
	}

    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(sCubeName);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(TEXT_171);
    return stringBuffer.toString();
  }
}
