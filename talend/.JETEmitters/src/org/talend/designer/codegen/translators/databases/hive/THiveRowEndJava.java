package org.talend.designer.codegen.translators.databases.hive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class THiveRowEndJava
{
  protected static String nl;
  public static synchronized THiveRowEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THiveRowEndJava result = new THiveRowEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\tpstmt_";
  protected final String TEXT_3 = ".close();\t";
  protected final String TEXT_4 = NL + "\t\t\tstmt_";
  protected final String TEXT_5 = ".close();\t";
  protected final String TEXT_6 = NL + "            if(commitEvery_";
  protected final String TEXT_7 = " > commitCounter_";
  protected final String TEXT_8 = ") {" + NL + "            " + NL + "\t\t\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_10 = " - Starting to commit.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_11 = NL + "\t            \tconn_";
  protected final String TEXT_12 = ".commit();" + NL + "\t\t\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_14 = " - Commit has succeeded.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_15 = NL + "            \t" + NL + "            \tcommitCounter_";
  protected final String TEXT_16 = " = 0;" + NL + "            \t" + NL + "            }";
  protected final String TEXT_17 = NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_19 = " - Closing the connection to the database.\");" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t    \tconn_";
  protected final String TEXT_21 = " .close();" + NL + "\t\t\t";
  protected final String TEXT_22 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_23 = " - Connection to the database closed.\");" + NL + "\t\t\t";
  protected final String TEXT_24 = NL + "\t    \t";
  protected final String TEXT_25 = NL + "\t\t" + NL + "" + NL + "\t\tString currentClientPathSeparator_";
  protected final String TEXT_26 = " = (String)globalMap.get(\"current_client_path_separator\");" + NL + "\t\tif(currentClientPathSeparator_";
  protected final String TEXT_27 = "!=null) {" + NL + "\t\t\tSystem.setProperty(\"path.separator\", currentClientPathSeparator_";
  protected final String TEXT_28 = ");" + NL + "\t\t\tglobalMap.put(\"current_client_path_separator\", null);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tString currentClientUsername_";
  protected final String TEXT_29 = " = (String)globalMap.get(\"current_client_user_name\");" + NL + "\t\tif(currentClientUsername_";
  protected final String TEXT_30 = "!=null) {" + NL + "\t\t\tSystem.setProperty(\"user.name\", currentClientUsername_";
  protected final String TEXT_31 = ");" + NL + "\t\t\tglobalMap.put(\"current_client_user_name\", null);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tString originalHadoopUsername_";
  protected final String TEXT_32 = " = (String)globalMap.get(\"HADOOP_USER_NAME_";
  protected final String TEXT_33 = "\");" + NL + "\t\tif(originalHadoopUsername_";
  protected final String TEXT_34 = "!=null) {" + NL + "\t\t\tSystem.setProperty(\"HADOOP_USER_NAME\", originalHadoopUsername_";
  protected final String TEXT_35 = ");" + NL + "\t\t\tglobalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_36 = "\", null);" + NL + "\t\t} else {" + NL + "\t\t\tSystem.clearProperty(\"HADOOP_USER_NAME\");" + NL + "\t\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	String cid = node.getUniqueName();
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	String commitEvery = "0"; ElementParameterParser.getValue(node, "__COMMIT_EVERY__");
	boolean usePrepareStatement = "true".equals(ElementParameterParser.getValue(node,"__USE_PREPAREDSTATEMENT__"));
	
    String theDistribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
    String theVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");

    if("true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"))) {
        String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
        for (INode pNode : node.getProcess().getNodesOfType("tHiveConnection")) {
            if(connection!=null && connection.equals(pNode.getUniqueName())) {
                theDistribution = ElementParameterParser.getValue(pNode, "__DISTRIBUTION__");
                theVersion = ElementParameterParser.getValue(pNode, "__HIVE_VERSION__");
            }
        }
    }

    org.talend.hadoop.distribution.component.HiveComponent hiveDistrib = null;
    try {
        hiveDistrib = (org.talend.hadoop.distribution.component.HiveComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(theDistribution, theVersion);
    } catch (java.lang.Exception e) {
        e.printStackTrace();
        return "";
    }
    boolean isCustom = hiveDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;

	if(!hiveDistrib.useCloudLauncher()) {
		if (usePrepareStatement) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    
		} else {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
		}
		if(!("true").equals(useExistingConn)) {
	    	if(!("").equals(commitEvery) && !("0").equals(commitEvery)) {
            
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
			}
    		
    stringBuffer.append(TEXT_17);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    
		}
		
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
	}

    return stringBuffer.toString();
  }
}
