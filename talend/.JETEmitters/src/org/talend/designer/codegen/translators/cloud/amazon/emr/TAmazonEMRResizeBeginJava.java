package org.talend.designer.codegen.translators.cloud.amazon.emr;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;

public class TAmazonEMRResizeBeginJava
{
  protected static String nl;
  public static synchronized TAmazonEMRResizeBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAmazonEMRResizeBeginJava result = new TAmazonEMRResizeBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t        " + NL + "\t";
  protected final String TEXT_3 = NL + NL + "\t";
  protected final String TEXT_4 = "\t" + NL + "\t";
  protected final String TEXT_5 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_6 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_7 = ");";
  protected final String TEXT_8 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_9 = " = ";
  protected final String TEXT_10 = "; ";
  protected final String TEXT_11 = NL + "\t" + NL + "\tcom.amazonaws.auth.AWSCredentialsProvider credentialsProvider_";
  protected final String TEXT_12 = " = null;" + NL + "\t" + NL + "\t";
  protected final String TEXT_13 = NL + "\tcredentialsProvider_";
  protected final String TEXT_14 = " = new com.amazonaws.auth.InstanceProfileCredentialsProvider();" + NL + "\t";
  protected final String TEXT_15 = NL + "\t" + NL + "\tcom.amazonaws.auth.AWSCredentials credentials_";
  protected final String TEXT_16 = " = new com.amazonaws.auth.BasicAWSCredentials(";
  protected final String TEXT_17 = ",decryptedPassword_";
  protected final String TEXT_18 = ");" + NL + "\tcredentialsProvider_";
  protected final String TEXT_19 = " = new com.amazonaws.internal.StaticCredentialsProvider(credentials_";
  protected final String TEXT_20 = ");" + NL + "\t" + NL + "\t";
  protected final String TEXT_21 = NL + "\tint sessionDurationSeconds_";
  protected final String TEXT_22 = " = ";
  protected final String TEXT_23 = " * 60;" + NL + "\tcom.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider.Builder credentialsProviderBuilder_";
  protected final String TEXT_24 = " = new com.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider" + NL + "\t\t\t\t\t\t.Builder(";
  protected final String TEXT_25 = ", ";
  protected final String TEXT_26 = ")";
  protected final String TEXT_27 = ".withServiceEndpoint(";
  protected final String TEXT_28 = ")";
  protected final String TEXT_29 = NL + "\t\t\t\t\t\t.withLongLivedCredentialsProvider(credentialsProvider_";
  protected final String TEXT_30 = ")" + NL + "\t\t\t\t\t\t.withRoleSessionDurationSeconds(sessionDurationSeconds_";
  protected final String TEXT_31 = ");" + NL + "\t" + NL + "\tcredentialsProvider_";
  protected final String TEXT_32 = " = credentialsProviderBuilder_";
  protected final String TEXT_33 = ".build();" + NL + "\t";
  protected final String TEXT_34 = NL + "\t" + NL + "\tcom.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceClient emr_";
  protected final String TEXT_35 = " = new com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceClient(credentialsProvider_";
  protected final String TEXT_36 = ");" + NL + "\t" + NL + "\t";
  protected final String TEXT_37 = NL + "\t\temr_";
  protected final String TEXT_38 = ".setRegion(com.amazonaws.regions.RegionUtils.getRegion(";
  protected final String TEXT_39 = "));" + NL + "\t\t";
  protected final String TEXT_40 = NL + NL + "\tboolean isTaskGroup_";
  protected final String TEXT_41 = " = true;" + NL + "\t" + NL + "\t";
  protected final String TEXT_42 = "\t" + NL + "\t\tcom.amazonaws.services.elasticmapreduce.model.InstanceGroupConfig config_";
  protected final String TEXT_43 = " = new com.amazonaws.services.elasticmapreduce.model.InstanceGroupConfig();" + NL + "\t\t";
  protected final String TEXT_44 = NL + "\t\t\tconfig_";
  protected final String TEXT_45 = ".setMarket(\"SPOT\");" + NL + "\t\t\tconfig_";
  protected final String TEXT_46 = ".setBidPrice(";
  protected final String TEXT_47 = ");" + NL + "\t\t";
  protected final String TEXT_48 = NL + "\t\t" + NL + "\t\tcom.amazonaws.services.elasticmapreduce.model.AddInstanceGroupsRequest request_";
  protected final String TEXT_49 = " = new com.amazonaws.services.elasticmapreduce.model.AddInstanceGroupsRequest()" + NL + "\t\t\t.withJobFlowId(";
  protected final String TEXT_50 = ")" + NL + "\t\t\t.withInstanceGroups(config_";
  protected final String TEXT_51 = NL + "\t\t\t\t.withInstanceCount(";
  protected final String TEXT_52 = ")" + NL + "\t\t\t\t.withInstanceRole(\"TASK\")" + NL + "\t\t\t\t.withInstanceType(";
  protected final String TEXT_53 = ")" + NL + "\t\t\t\t.withName(";
  protected final String TEXT_54 = ")" + NL + "\t\t\t\t)" + NL + "\t\t;" + NL + "\t\t" + NL + " \t" + NL + "\t\tcom.amazonaws.services.elasticmapreduce.model.AddInstanceGroupsResult result_";
  protected final String TEXT_55 = " = emr_";
  protected final String TEXT_56 = ".addInstanceGroups(request_";
  protected final String TEXT_57 = ");\t\t" + NL + "\t\tif(result_";
  protected final String TEXT_58 = ".getInstanceGroupIds()!=null && result_";
  protected final String TEXT_59 = ".getInstanceGroupIds().size()>0){" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_60 = "_TASK_GROUP_ID\", result_";
  protected final String TEXT_61 = ".getInstanceGroupIds().get(0));" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_62 = "_TASK_GROUP_NAME\", ";
  protected final String TEXT_63 = ");" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_64 = NL + "\t" + NL + "\t\t//Validate if the instance group type is core" + NL + "\t\tcom.amazonaws.services.elasticmapreduce.model.ListInstanceGroupsRequest listRequest_";
  protected final String TEXT_65 = " = new com.amazonaws.services.elasticmapreduce.model.ListInstanceGroupsRequest()" + NL + "\t\t\t.withClusterId(";
  protected final String TEXT_66 = ");" + NL + "\t\t" + NL + "\t\tcom.amazonaws.services.elasticmapreduce.model.ListInstanceGroupsResult listResult_";
  protected final String TEXT_67 = " = emr_";
  protected final String TEXT_68 = ".listInstanceGroups(listRequest_";
  protected final String TEXT_69 = ");" + NL + "\t\t " + NL + "\t\tList<com.amazonaws.services.elasticmapreduce.model.InstanceGroup> groupList_";
  protected final String TEXT_70 = " = listResult_";
  protected final String TEXT_71 = ".getInstanceGroups();" + NL + "\t" + NL + "\t\tjava.util.Iterator<com.amazonaws.services.elasticmapreduce.model.InstanceGroup> iterator_";
  protected final String TEXT_72 = " = groupList_";
  protected final String TEXT_73 = ".iterator();" + NL + "\t" + NL + "\t\tcom.amazonaws.services.elasticmapreduce.model.InstanceGroup instanceGroup_";
  protected final String TEXT_74 = " = null;" + NL + "\t" + NL + "\t\twhile (iterator_";
  protected final String TEXT_75 = ".hasNext()) {" + NL + "" + NL + "\t\t\tinstanceGroup_";
  protected final String TEXT_76 = " = iterator_";
  protected final String TEXT_77 = ".next();" + NL + "\t\t\tString instanceGroupId_";
  protected final String TEXT_78 = " = instanceGroup_";
  protected final String TEXT_79 = ".getId();" + NL + "\t\t\tString instanceGroupType_";
  protected final String TEXT_80 = " = instanceGroup_";
  protected final String TEXT_81 = ".getInstanceGroupType();" + NL + "\t\t\tif(!instanceGroupType_";
  protected final String TEXT_82 = ".equalsIgnoreCase(\"TASK\") && instanceGroupId_";
  protected final String TEXT_83 = ".equals(";
  protected final String TEXT_84 = ")){" + NL + "\t\t\t\tSystem.err.println(\"Not support resizing master or core instance group: \" + (";
  protected final String TEXT_85 = "));" + NL + "\t\t\t\tisTaskGroup_";
  protected final String TEXT_86 = " = false;" + NL + "\t\t\t\tbreak;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t" + NL + "\t\t//Resize instance group " + NL + "\t\tif(isTaskGroup_";
  protected final String TEXT_87 = "){" + NL + "\t\t\tcom.amazonaws.services.elasticmapreduce.model.ModifyInstanceGroupsRequest request_";
  protected final String TEXT_88 = " = new com.amazonaws.services.elasticmapreduce.model.ModifyInstanceGroupsRequest()" + NL + "\t\t\t\t.withInstanceGroups(new com.amazonaws.services.elasticmapreduce.model.InstanceGroupModifyConfig()" + NL + "\t\t\t\t\t.withInstanceCount(";
  protected final String TEXT_89 = ")" + NL + "\t\t\t\t\t.withInstanceGroupId(";
  protected final String TEXT_90 = ")" + NL + "\t\t\t\t\t);\t" + NL + "\t\t\temr_";
  protected final String TEXT_91 = ".modifyInstanceGroups(request_";
  protected final String TEXT_92 = ");\t\t\t\t" + NL + "\t\t}" + NL + "" + NL + "\t";
  protected final String TEXT_93 = NL + NL + "\t";
  protected final String TEXT_94 = NL + "\t\tif(isTaskGroup_";
  protected final String TEXT_95 = "){" + NL + "\t\t\tboolean clusterReady_";
  protected final String TEXT_96 = " = false;" + NL + "\t\t\tSystem.out.println(\"Wating for cluster to become available.\");" + NL + "\t\t\twhile (!clusterReady_";
  protected final String TEXT_97 = ") {" + NL + "\t\t\t\tcom.amazonaws.services.elasticmapreduce.model.DescribeClusterResult result2_";
  protected final String TEXT_98 = " = emr_";
  protected final String TEXT_99 = ".describeCluster(" + NL + "\t\t\t\t\tnew com.amazonaws.services.elasticmapreduce.model.DescribeClusterRequest()" + NL + "\t\t\t\t\t\t.withClusterId(";
  protected final String TEXT_100 = ")" + NL + "\t\t\t\t);" + NL + "\t\t\t\tString status_";
  protected final String TEXT_101 = " = result2_";
  protected final String TEXT_102 = ".getCluster().getStatus().getState();" + NL + "\t\t\t\tif (\"WAITING\".equalsIgnoreCase(status_";
  protected final String TEXT_103 = ") || \"RUNNING\".equalsIgnoreCase(status_";
  protected final String TEXT_104 = ")) {" + NL + "\t\t\t\t\tclusterReady_";
  protected final String TEXT_105 = " = true;" + NL + "\t\t\t\t} else if(\"TERMINATED_WITH_ERRORS\".equalsIgnoreCase(status_";
  protected final String TEXT_106 = ") || \"TERMINATED\".equalsIgnoreCase(status_";
  protected final String TEXT_107 = ")) {" + NL + "\t\t\t\t\tclusterReady_";
  protected final String TEXT_108 = " = true;" + NL + "\t\t\t\t\tSystem.err.println(\"Fail to start the cluster.\");" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tSystem.out.print(\".\");" + NL + "\t\t\t\t\tThread.sleep(2000);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_109 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	String action = ElementParameterParser.getValue(node, "__ACTION__");
	String region = ElementParameterParser.getValue(node, "__REGION__");
	String cluster_id = ElementParameterParser.getValue(node, "__CLUSTER_ID__");
	String group_name = ElementParameterParser.getValue(node, "__GROUP_NAME__");
	String group_id = ElementParameterParser.getValue(node, "__GROUP_ID__");
	
	boolean request_spot = "true".equals(ElementParameterParser.getValue(node, "__REQUEST_SPOT__"));
	String bid_price = ElementParameterParser.getValue(node, "__BID_PRICE__");
	
	String instance_count = ElementParameterParser.getValue(node, "__INSTANCE_COUNT__");
	
	String task_instance_type = ElementParameterParser.getValue(node, "__TASK_INSTANCE_TYPE__");
		
	boolean wait_for_cluster_ready = false;
	

    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    
	String accesskey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");
	
	boolean inheritCredentials = "true".equals(ElementParameterParser.getValue(node, "__INHERIT_CREDENTIALS__"));
	
	boolean assumeRole = "true".equals(ElementParameterParser.getValue(node, "__ASSUME_ROLE__"));
	
	String arn = ElementParameterParser.getValue(node, "__ARN__");
	
	String roleSessionName = ElementParameterParser.getValue(node, "__ROLE_SESSION_NAME__");
	
	String sessionDuration = ElementParameterParser.getValue(node,"__SESSION_DURATION__");
	if(sessionDuration == null || sessionDuration.isEmpty()) {
		sessionDuration = "15";
	}
	
	boolean setStsEndpoint = "true".equals(ElementParameterParser.getValue(node, "__SET_STS_ENDPOINT__"));
	
	String stsEndpoint = ElementParameterParser.getValue(node, "__STS_ENDPOINT__");

    
	String passwordFieldName = "__SECRET_KEY__";
	
    stringBuffer.append(TEXT_4);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_7);
    } else {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
	if(inheritCredentials) {
	
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    } else {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(accesskey);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    }
	if(assumeRole) {
	
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(sessionDuration);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(arn);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(roleSessionName);
    stringBuffer.append(TEXT_26);
    if(setStsEndpoint) {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(stsEndpoint);
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
	if(region!=null && !region.isEmpty() && !"DEFAULT".equalsIgnoreCase(region)){
		
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_39);
    
	}
	
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    
	if("ADD_TASK_INSTANCE_GROUP".equals(action)) {
	
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    
		if(request_spot) {				
		
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(bid_price );
    stringBuffer.append(TEXT_47);
    
		}
		
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cluster_id);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(instance_count);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(task_instance_type);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(group_name);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(group_name);
    stringBuffer.append(TEXT_63);
    
	} else if ("RESIZE_TASK_INSTANCE_GROUP".equals(action)) {
	
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cluster_id);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(group_id);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(group_id);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(instance_count);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(group_id);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    
	}
	
    stringBuffer.append(TEXT_93);
    
	if(wait_for_cluster_ready) {
	
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cluster_id);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    
	}
	
    stringBuffer.append(TEXT_109);
    return stringBuffer.toString();
  }
}
