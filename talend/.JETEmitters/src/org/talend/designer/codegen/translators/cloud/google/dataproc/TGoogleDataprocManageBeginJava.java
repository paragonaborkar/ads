package org.talend.designer.codegen.translators.cloud.google.dataproc;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class TGoogleDataprocManageBeginJava
{
  protected static String nl;
  public static synchronized TGoogleDataprocManageBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGoogleDataprocManageBeginJava result = new TGoogleDataprocManageBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\t\tjava.util.List<org.talend.bigdata.manage.google.dataproc.DataprocCreateCluster.InitializationActionHolder> ";
  protected final String TEXT_4 = "_initializationActions = new java.util.ArrayList<>();";
  protected final String TEXT_5 = NL + "\t\t\t";
  protected final String TEXT_6 = "_initializationActions.add(new org.talend.bigdata.manage.google.dataproc.DataprocCreateCluster.InitializationActionHolder(";
  protected final String TEXT_7 = ", ";
  protected final String TEXT_8 = "));";
  protected final String TEXT_9 = NL + "\t\torg.talend.bigdata.manage.google.dataproc.DataprocCreateCluster.newBuilder() //" + NL + "         .withProjectId(";
  protected final String TEXT_10 = ") //" + NL + "\t\t\t.withClusterName(";
  protected final String TEXT_11 = ") //" + NL + "         .withRegion(\"global\") //" + NL + "         .withZone(";
  protected final String TEXT_12 = ") //" + NL + "         .withVersion(";
  protected final String TEXT_13 = ") //" + NL + "         .withMasterNumInstances(";
  protected final String TEXT_14 = ") //" + NL + "         .withMasterBootDiskSizeGb(";
  protected final String TEXT_15 = ") //" + NL + "         .withMasterNumLocalSsds(";
  protected final String TEXT_16 = ") //" + NL + "         .withMasterInstanceType(";
  protected final String TEXT_17 = ") //" + NL + "         .withWorkerNumInstances(";
  protected final String TEXT_18 = ") //" + NL + "         .withWorkerBootDiskSizeGb(";
  protected final String TEXT_19 = ") //" + NL + "         .withWorkerInstanceType(";
  protected final String TEXT_20 = ") //" + NL + "         .withSecondaryWorkerNumInstances(";
  protected final String TEXT_21 = ") //" + NL + "         .withTalendJobName(projectName + \"_\" + jobName + \"_\" + jobVersion.replace(\".\",\"_\") + \"_\" + pid) //" + NL + "         .withWaitForClusterReady(";
  protected final String TEXT_22 = ") //";
  protected final String TEXT_23 = NL + "         \t.withNetworkName(";
  protected final String TEXT_24 = ") //";
  protected final String TEXT_25 = NL + "         \t.withSubnetworkName(";
  protected final String TEXT_26 = ") //";
  protected final String TEXT_27 = NL + "\t\t\t\t.withServiceAccountCredentialsPath(";
  protected final String TEXT_28 = ") //";
  protected final String TEXT_29 = NL + "         .withInitializationActions(";
  protected final String TEXT_30 = "_initializationActions) //" + NL + "         .build() //" + NL + "         .run();";
  protected final String TEXT_31 = NL + "\t\torg.talend.bigdata.manage.google.dataproc.DataprocDeleteCluster.newBuilder() //" + NL + "         .withProjectId(";
  protected final String TEXT_32 = ") //" + NL + "\t\t\t.withClusterName(";
  protected final String TEXT_33 = ") //" + NL + "\t\t\t.withRegion(\"global\") //" + NL + "         .withTalendJobName(projectName + \"_\" + jobName + \"_\" + jobVersion.replace(\".\",\"_\") + \"_\" + pid) //";
  protected final String TEXT_34 = NL + "\t\t\t\t.withServiceAccountCredentialsPath(";
  protected final String TEXT_35 = ") //";
  protected final String TEXT_36 = NL + "\t\t\t.build() //" + NL + "\t\t\t.run();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	String projectId = ElementParameterParser.getValue(node, "__GOOGLE_PROJECT_ID__");
	String clusterId = ElementParameterParser.getValue(node, "__GOOGLE_CLUSTER_ID__");
	
	boolean useServiceAccount = ElementParameterParser.getBooleanValue(node, "__DEFINE_PATH_TO_GOOGLE_CREDENTIALS__");
	String serviceAccountCredentialsPath = ElementParameterParser.getValue(node, "__PATH_TO_GOOGLE_CREDENTIALS__");
	
	String action = ElementParameterParser.getValue(node, "__ACTION__");
	String version = ElementParameterParser.getValue(node, "__CLUSTER_VERSION__");
	String zone = ElementParameterParser.getValue(node, "__ZONE__");
			
	String masterNumInstances = ElementParameterParser.getValue(node, "__MASTER_NUM_INSTANCES__");
	String masterInstanceType = ElementParameterParser.getValue(node, "__MASTER_INSTANCE_TYPE__");
	String workerNumInstances = ElementParameterParser.getValue(node, "__WORKER_NUM_INSTANCES__");
	String workerInstanceType = ElementParameterParser.getValue(node, "__WORKER_INSTANCE_TYPE__");
	String secondaryWorkerNumInstances = ElementParameterParser.getValue(node, "__SECONDARY_WORKER_NUM_INSTANCES__");
	
	boolean waitForClusterReady = ElementParameterParser.getBooleanValue(node, "__WAIT_FOR_CLUSTER_READY__");
	
	String masterDiskSize = ElementParameterParser.getValue(node, "__MASTER_DISK_SIZE__");
	String masterSsdNb = ElementParameterParser.getValue(node, "__MASTER_SSD_NB__");
	String workerDiskSize = ElementParameterParser.getValue(node, "__WORKER_DISK_SIZE__");
	String workerSsdNb = ElementParameterParser.getValue(node, "__WORKER_SSD_NB__");
	
	boolean defineNetwork = ElementParameterParser.getBooleanValue(node, "__DEFINE_NETWORK__");
	boolean defineSubnetwork = ElementParameterParser.getBooleanValue(node, "__DEFINE_SUBNETWORK__");
	String network = ElementParameterParser.getValue(node, "__NETWORK__");
	String subnetwork = ElementParameterParser.getValue(node, "__SUBNETWORK__");
	
	boolean isLog4jEnabled = "true".equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	List<Map<String, String>> initializationActions = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__INITIALIZATION_ACTIONS__");

    stringBuffer.append(TEXT_2);
    
	if("START".equals(action)) {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
	   for (Map<String, String> initializationAction : initializationActions) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(initializationAction.get("EXECUTABLE_FILE"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(initializationAction.get("EXECUTABLE_TIMEOUT"));
    stringBuffer.append(TEXT_8);
    
		}

    stringBuffer.append(TEXT_9);
    stringBuffer.append(projectId);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(clusterId);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(zone);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(version);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(masterNumInstances);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(masterDiskSize);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(masterSsdNb);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(masterInstanceType);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(workerNumInstances);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(workerDiskSize);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(workerInstanceType);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(secondaryWorkerNumInstances);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(waitForClusterReady);
    stringBuffer.append(TEXT_22);
    
			if(defineNetwork) {

    stringBuffer.append(TEXT_23);
    stringBuffer.append(network);
    stringBuffer.append(TEXT_24);
    
			} else if(defineSubnetwork) {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(subnetwork);
    stringBuffer.append(TEXT_26);
    
			}
			
			if(useServiceAccount) {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(serviceAccountCredentialsPath);
    stringBuffer.append(TEXT_28);
    
			}

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
	} else if("STOP".equals(action)) {

    stringBuffer.append(TEXT_31);
    stringBuffer.append(projectId);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(clusterId);
    stringBuffer.append(TEXT_33);
    
			if(useServiceAccount) {

    stringBuffer.append(TEXT_34);
    stringBuffer.append(serviceAccountCredentialsPath);
    stringBuffer.append(TEXT_35);
    
			}

    stringBuffer.append(TEXT_36);
    
	}

    return stringBuffer.toString();
  }
}
