package org.talend.designer.codegen.translators.business_intelligence.olap_cube.palo;

import java.util.List;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TPaloRuleListBeginJava
{
  protected static String nl;
  public static synchronized TPaloRuleListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPaloRuleListBeginJava result = new TPaloRuleListBeginJava();
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
  protected final String TEXT_29 = NL + "\tint NB_RULES";
  protected final String TEXT_30 = " = 0;  " + NL + "\torg.talend.jpalo.palo p_";
  protected final String TEXT_31 = " = null;" + NL + "\torg.talend.jpalo.paloconnection pConn_";
  protected final String TEXT_32 = " = null;" + NL;
  protected final String TEXT_33 = NL + "\t\t// Use Existing" + NL + "\t\tp_";
  protected final String TEXT_34 = " = (org.talend.jpalo.palo)globalMap.get(\"";
  protected final String TEXT_35 = "\");" + NL + "\t\tpConn_";
  protected final String TEXT_36 = " =  (org.talend.jpalo.paloconnection)globalMap.get(\"";
  protected final String TEXT_37 = "\");" + NL + "\t\t";
  protected final String TEXT_38 = NL + "\t\t\tif(pConn_";
  protected final String TEXT_39 = "!=null) {" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_40 = " - Uses an existing connection.\");" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_41 = NL + "\t\t// Initialize jpalo" + NL + "\t\tp_";
  protected final String TEXT_42 = " = new org.talend.jpalo.palo(";
  protected final String TEXT_43 = ");" + NL + "\t\t// Open the connection" + NL + "\t\t";
  protected final String TEXT_44 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_45 = " - Connection attempt to '\" + ";
  protected final String TEXT_46 = " + \"' with the username '\" + ";
  protected final String TEXT_47 = " + \"' .\");" + NL + "\t\t";
  protected final String TEXT_48 = NL + "\t        " + NL + "\t\t";
  protected final String TEXT_49 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_50 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_51 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_52 = ");";
  protected final String TEXT_53 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_54 = " = ";
  protected final String TEXT_55 = "; ";
  protected final String TEXT_56 = NL + "\t   \t" + NL + "\t\tpConn_";
  protected final String TEXT_57 = " = p_";
  protected final String TEXT_58 = ".connect(";
  protected final String TEXT_59 = ", decryptedPassword_";
  protected final String TEXT_60 = ", ";
  protected final String TEXT_61 = ", ";
  protected final String TEXT_62 = ");" + NL + "\t\t";
  protected final String TEXT_63 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_64 = " - Connection to '\" + ";
  protected final String TEXT_65 = " + \"' has succeeded.\");" + NL + "\t\t";
  protected final String TEXT_66 = NL + NL;
  protected final String TEXT_67 = NL + NL + "\torg.talend.jpalo.palodatabases pDBs_";
  protected final String TEXT_68 = " = pConn_";
  protected final String TEXT_69 = ".getDatabases();" + NL + "\torg.talend.jpalo.palodatabase pDB_";
  protected final String TEXT_70 = " = pDBs_";
  protected final String TEXT_71 = ".getDatabase(";
  protected final String TEXT_72 = ");" + NL + "\tif(pDB_";
  protected final String TEXT_73 = " == null){" + NL + "\t\t throw new RuntimeException (\"Database '\" + ";
  protected final String TEXT_74 = " + \"' not found. exiting...\");" + NL + "\t}" + NL + "" + NL + "\torg.talend.jpalo.palocube pCUB_";
  protected final String TEXT_75 = " = null;" + NL + "\tfor(int i=0;i<4;i++){" + NL + "\t\torg.talend.jpalo.palocubes pCUBs_";
  protected final String TEXT_76 = " = pDB_";
  protected final String TEXT_77 = ".getCubes(i);" + NL + "\t" + NL + "\t\tfor(int j=0;j< pCUBs_";
  protected final String TEXT_78 = ".getNumberOfCubes();j++){" + NL + "\t\t\tpCUB_";
  protected final String TEXT_79 = "=pCUBs_";
  protected final String TEXT_80 = ".getCube(j);" + NL + "\t\t\tif(pCUB_";
  protected final String TEXT_81 = ".getName().equals(";
  protected final String TEXT_82 = ")) " + NL + "\t\t\tbreak;" + NL + "\t\t\t" + NL + "\t\t}" + NL + "\t\tif(null!=pCUB_";
  protected final String TEXT_83 = "\t) {" + NL + "\t\t\tbreak;" + NL + "\t\t}else{" + NL + "\t\t\tthrow new RuntimeException (\"Cube '\" + ";
  protected final String TEXT_84 = " + \"' not found in database '\" + ";
  protected final String TEXT_85 = " + \"'. exiting...\" );" + NL + "\t\t} " + NL + "\t}" + NL + NL;
  protected final String TEXT_86 = NL + "\t\t";
  protected final String TEXT_87 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_88 = " - Listing rules ...\");" + NL + "\t\t";
  protected final String TEXT_89 = NL + "\t\torg.talend.jpalo.palorules pRULs_";
  protected final String TEXT_90 = " = pCUB_";
  protected final String TEXT_91 = ".getCubeRules();" + NL + "\t\tfor(int j=0;j< pRULs_";
  protected final String TEXT_92 = ".getNumberOfRules();j++){\t\t" + NL + "\t\t\torg.talend.jpalo.palorule pRUL_";
  protected final String TEXT_93 = " = pRULs_";
  protected final String TEXT_94 = ".getRule(j);\t\t\t" + NL + "\t\t\tNB_RULES";
  protected final String TEXT_95 = "++;";
  protected final String TEXT_96 = "\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_97 = ".rule_identifier=pRUL_";
  protected final String TEXT_98 = ".getIdentifier();" + NL + "\t\t\t\t";
  protected final String TEXT_99 = ".rule_definition=pRUL_";
  protected final String TEXT_100 = ".getDefinition();" + NL + "\t\t\t\t";
  protected final String TEXT_101 = ".rule_extern_id=pRUL_";
  protected final String TEXT_102 = ".getExtern_Id();" + NL + "\t\t\t\t";
  protected final String TEXT_103 = ".rule_comment=pRUL_";
  protected final String TEXT_104 = ".getComment();" + NL + "\t\t\t\t";
  protected final String TEXT_105 = ".rule_activated=pRUL_";
  protected final String TEXT_106 = ".getActivated();";
  protected final String TEXT_107 = NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_108 = "_EXTERNAL_RULEID\", pRUL_";
  protected final String TEXT_109 = ".getExtern_Id());" + NL + "\t\t";
  protected final String TEXT_110 = NL;
  protected final String TEXT_111 = NL;

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

    String sDeploypalolibs = ElementParameterParser.getValue(node, "__DEPLOY_PALO_LIBS__");
    boolean bDeploypalolibs=false;
    if(sDeploypalolibs.equals("true"))bDeploypalolibs=true;


    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    
	if(useExistingConnection){
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		String p = "p_" + connection;
		String pConn = "pConn_" + connection;


    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(p);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(pConn);
    stringBuffer.append(TEXT_37);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    }
    
	}else{

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(bDeploypalolibs);
    stringBuffer.append(TEXT_43);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(sServer);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(sUsername);
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    
		String passwordFieldName = "__PASS__";
		
    stringBuffer.append(TEXT_49);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_52);
    } else {
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(sUsername);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(sServer);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(sServerport);
    stringBuffer.append(TEXT_62);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(sServer);
    stringBuffer.append(TEXT_65);
    }
    
	}

    stringBuffer.append(TEXT_66);
    
	String outputConnName = null;
	boolean bIterate=false;
	boolean bData=false;
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	if (conns!=null) {
		if (conns.size()>0) {
			for (int i=0;i<conns.size();i++) {
				IConnection connTemp = conns.get(i);
				if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					outputConnName = connTemp.getName();
					bData=true;
					//break;
				}
			}
			for (int i=0;i<conns.size();i++) {
				IConnection connTemp = conns.get(i);
				if(connTemp.getLineStyle().toString().equals("ITERATE")) {
					bIterate=true;
					//break;
				}
			}

		}
	}

    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(sDatabaseName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(sDatabaseName);
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
    stringBuffer.append(sCubeName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(sCubeName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(sDatabaseName);
    stringBuffer.append(TEXT_85);
    
	if (outputConnName != null || bIterate){

    stringBuffer.append(TEXT_86);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    }
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
			if(bData){

    stringBuffer.append(TEXT_96);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    
			}
			if(bIterate){

    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    
			}
		}

    stringBuffer.append(TEXT_110);
    stringBuffer.append(TEXT_111);
    return stringBuffer.toString();
  }
}
