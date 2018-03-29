package org.talend.designer.codegen.translators.cloud.amazon.emr;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class TAmazonEMRManageBeginJava
{
  protected static String nl;
  public static synchronized TAmazonEMRManageBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAmazonEMRManageBeginJava result = new TAmazonEMRManageBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tjava.util.List<com.amazonaws.services.elasticmapreduce.model.BootstrapActionConfig> actions_";
  protected final String TEXT_3 = " = new java.util.ArrayList<com.amazonaws.services.elasticmapreduce.model.BootstrapActionConfig>();" + NL + "\t" + NL + "\tcom.amazonaws.services.elasticmapreduce.model.BootstrapActionConfig action_";
  protected final String TEXT_4 = " = null;" + NL + "\t";
  protected final String TEXT_5 = NL + "\taction_";
  protected final String TEXT_6 = " = new com.amazonaws.services.elasticmapreduce.model.BootstrapActionConfig(" + NL + "\t\t";
  protected final String TEXT_7 = "," + NL + "\t\t" + NL + "\t\tnew com.amazonaws.services.elasticmapreduce.model.ScriptBootstrapActionConfig()" + NL + "    \t\t.withPath(";
  protected final String TEXT_8 = ")" + NL + "    \t\t" + NL + "    \t\t";
  protected final String TEXT_9 = NL + "    \t\t.withArgs(";
  protected final String TEXT_10 = ")" + NL + "    \t\t";
  protected final String TEXT_11 = NL + "\t);" + NL + "\t" + NL + "\tactions_";
  protected final String TEXT_12 = ".add(action_";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "\tint count_";
  protected final String TEXT_15 = " = 0;" + NL + "\tcom.amazonaws.services.elasticmapreduce.model.HadoopJarStepConfig hadoopConfig1_";
  protected final String TEXT_16 = " = null;" + NL + "\tcom.amazonaws.services.elasticmapreduce.model.StepConfig customStep_";
  protected final String TEXT_17 = " = null;";
  protected final String TEXT_18 = NL + "\tjava.util.List<com.amazonaws.services.elasticmapreduce.model.StepConfig> steps_";
  protected final String TEXT_19 = " = new java.util.ArrayList<com.amazonaws.services.elasticmapreduce.model.StepConfig>();";
  protected final String TEXT_20 = NL + NL + "\tcount_";
  protected final String TEXT_21 = "++;" + NL + "" + NL + "\thadoopConfig1_";
  protected final String TEXT_22 = " = new com.amazonaws.services.elasticmapreduce.model.HadoopJarStepConfig()" + NL + "\t\t\t  ";
  protected final String TEXT_23 = NL + "\t\t      .withMainClass(";
  protected final String TEXT_24 = ")" + NL + "\t\t      ";
  protected final String TEXT_25 = NL + "\t\t      " + NL + "\t\t      .withJar(";
  protected final String TEXT_26 = ")" + NL + "\t\t\t  " + NL + "\t\t\t  ";
  protected final String TEXT_27 = "\t\t      " + NL + "\t\t      .withArgs(";
  protected final String TEXT_28 = ")" + NL + "\t\t      ";
  protected final String TEXT_29 = NL + "\t\t      " + NL + "\t\t      ;" + NL + "    " + NL + "\tcustomStep_";
  protected final String TEXT_30 = " = new com.amazonaws.services.elasticmapreduce.model.StepConfig(\"Step_\" + count_";
  protected final String TEXT_31 = ", hadoopConfig1_";
  protected final String TEXT_32 = ")" + NL + "\t\t   .withActionOnFailure(";
  protected final String TEXT_33 = ")" + NL + "\t\t   .withName(";
  protected final String TEXT_34 = ");" + NL + "" + NL + "\tsteps_";
  protected final String TEXT_35 = ".add(customStep_";
  protected final String TEXT_36 = ");    " + NL;
  protected final String TEXT_37 = NL;
  protected final String TEXT_38 = NL + "\t        " + NL + "\t";
  protected final String TEXT_39 = NL + NL + "\t";
  protected final String TEXT_40 = "\t" + NL + "\t";
  protected final String TEXT_41 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_42 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_43 = ");";
  protected final String TEXT_44 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_45 = " = ";
  protected final String TEXT_46 = "; ";
  protected final String TEXT_47 = NL + "\t" + NL + "\tcom.amazonaws.auth.AWSCredentialsProvider credentialsProvider_";
  protected final String TEXT_48 = " = null;" + NL + "\t" + NL + "\t";
  protected final String TEXT_49 = NL + "\tcredentialsProvider_";
  protected final String TEXT_50 = " = new com.amazonaws.auth.InstanceProfileCredentialsProvider();" + NL + "\t";
  protected final String TEXT_51 = NL + "\t" + NL + "\tcom.amazonaws.auth.AWSCredentials credentials_";
  protected final String TEXT_52 = " = new com.amazonaws.auth.BasicAWSCredentials(";
  protected final String TEXT_53 = ",decryptedPassword_";
  protected final String TEXT_54 = ");" + NL + "\tcredentialsProvider_";
  protected final String TEXT_55 = " = new com.amazonaws.internal.StaticCredentialsProvider(credentials_";
  protected final String TEXT_56 = ");" + NL + "\t" + NL + "\t";
  protected final String TEXT_57 = NL + "\tint sessionDurationSeconds_";
  protected final String TEXT_58 = " = ";
  protected final String TEXT_59 = " * 60;" + NL + "\tcom.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider.Builder credentialsProviderBuilder_";
  protected final String TEXT_60 = " = new com.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider" + NL + "\t\t\t\t\t\t.Builder(";
  protected final String TEXT_61 = ", ";
  protected final String TEXT_62 = ")";
  protected final String TEXT_63 = ".withServiceEndpoint(";
  protected final String TEXT_64 = ")";
  protected final String TEXT_65 = NL + "\t\t\t\t\t\t.withLongLivedCredentialsProvider(credentialsProvider_";
  protected final String TEXT_66 = ")" + NL + "\t\t\t\t\t\t.withRoleSessionDurationSeconds(sessionDurationSeconds_";
  protected final String TEXT_67 = ");" + NL + "\t" + NL + "\tcredentialsProvider_";
  protected final String TEXT_68 = " = credentialsProviderBuilder_";
  protected final String TEXT_69 = ".build();" + NL + "\t";
  protected final String TEXT_70 = NL + "\t" + NL + "\tcom.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceClient emr_";
  protected final String TEXT_71 = " = new com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceClient(credentialsProvider_";
  protected final String TEXT_72 = ");" + NL + "\t" + NL + "\t";
  protected final String TEXT_73 = NL + "\t\temr_";
  protected final String TEXT_74 = ".setRegion(com.amazonaws.regions.RegionUtils.getRegion(";
  protected final String TEXT_75 = "));" + NL + "\t\t";
  protected final String TEXT_76 = NL + "\t" + NL + "\t";
  protected final String TEXT_77 = NL + "\t\tcom.amazonaws.services.elasticmapreduce.model.ListClustersRequest request_";
  protected final String TEXT_78 = " = new com.amazonaws.services.elasticmapreduce.model.ListClustersRequest()" + NL + "\t\t\t.withClusterStates(" + NL + "\t\t\t\tcom.amazonaws.services.elasticmapreduce.model.ClusterState.BOOTSTRAPPING," + NL + "\t\t\t\tcom.amazonaws.services.elasticmapreduce.model.ClusterState.STARTING," + NL + "\t\t\t\tcom.amazonaws.services.elasticmapreduce.model.ClusterState.RUNNING," + NL + "\t\t\t\tcom.amazonaws.services.elasticmapreduce.model.ClusterState.WAITING" + NL + "\t\t\t)" + NL + "\t\t;" + NL + "    \tcom.amazonaws.services.elasticmapreduce.model.ListClustersResult result_";
  protected final String TEXT_79 = " = emr_";
  protected final String TEXT_80 = ".listClusters(request_";
  protected final String TEXT_81 = ");" + NL + "    \tjava.util.List<com.amazonaws.services.elasticmapreduce.model.ClusterSummary> clusters_";
  protected final String TEXT_82 = " = result_";
  protected final String TEXT_83 = ".getClusters();" + NL + "    \t" + NL + "    \tjava.util.List<String> ids_";
  protected final String TEXT_84 = " = new java.util.ArrayList<String>();" + NL + "    \t" + NL + "    \t";
  protected final String TEXT_85 = NL + "    \tfor(com.amazonaws.services.elasticmapreduce.model.ClusterSummary summary_";
  protected final String TEXT_86 = " : clusters_";
  protected final String TEXT_87 = ") {" + NL + "\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\t\tids_";
  protected final String TEXT_89 = ".add(summary_";
  protected final String TEXT_90 = ".getId());" + NL + "\t\t\t";
  protected final String TEXT_91 = NL + "\t\t\t\tif(";
  protected final String TEXT_92 = ".equals(summary_";
  protected final String TEXT_93 = ".getName())) {" + NL + "\t\t\t\t\tids_";
  protected final String TEXT_94 = ".add(summary_";
  protected final String TEXT_95 = ".getId());" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_96 = NL + "\t\t\t\tif(";
  protected final String TEXT_97 = ".equals(summary_";
  protected final String TEXT_98 = ".getId())) {" + NL + "\t\t\t\t\tids_";
  protected final String TEXT_99 = ".add(summary_";
  protected final String TEXT_100 = ".getId());" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_101 = NL + "    \t}" + NL + "    \t" + NL + "    \tcom.amazonaws.services.elasticmapreduce.model.TerminateJobFlowsRequest request2_";
  protected final String TEXT_102 = " = new com.amazonaws.services.elasticmapreduce.model.TerminateJobFlowsRequest();" + NL + "    \tif(!ids_";
  protected final String TEXT_103 = ".isEmpty()) {" + NL + "    \t\trequest2_";
  protected final String TEXT_104 = ".withJobFlowIds(ids_";
  protected final String TEXT_105 = ");" + NL + "    \t\temr_";
  protected final String TEXT_106 = ".terminateJobFlows(request2_";
  protected final String TEXT_107 = ");\t" + NL + "    \t} else {" + NL + "    \t\t";
  protected final String TEXT_108 = NL + "    \t\t\tthrow new RuntimeException(\"can't find any running cluster\");" + NL + "    \t\t";
  protected final String TEXT_109 = NL + "    \t\t\tthrow new RuntimeException(\"can't find any running cluster with name : \" + ";
  protected final String TEXT_110 = ");" + NL + "    \t\t";
  protected final String TEXT_111 = NL + "    \t\t\tthrow new RuntimeException(\"can't find any running cluster with id : \" + ";
  protected final String TEXT_112 = ");" + NL + "    \t\t";
  protected final String TEXT_113 = NL + "    \t}" + NL + "    \t" + NL + "\t";
  protected final String TEXT_114 = NL + "\tcom.amazonaws.services.elasticmapreduce.util.StepFactory stepFactory_";
  protected final String TEXT_115 = " = new com.amazonaws.services.elasticmapreduce.util.StepFactory();" + NL + "" + NL + "\tcom.amazonaws.services.elasticmapreduce.model.StepConfig enabledebugging_";
  protected final String TEXT_116 = " = new com.amazonaws.services.elasticmapreduce.model.StepConfig()" + NL + "    \t.withName(\"Enable debugging\")" + NL + "    \t.withActionOnFailure(" + NL + "    \t\tcom.amazonaws.services.elasticmapreduce.model.ActionOnFailure.TERMINATE_JOB_FLOW" + NL + "    \t)" + NL + "    \t.withHadoopJarStep(stepFactory_";
  protected final String TEXT_117 = ".newEnableDebuggingStep());" + NL + "" + NL + "\tsteps_";
  protected final String TEXT_118 = ".add(0, enabledebugging_";
  protected final String TEXT_119 = ");" + NL + "" + NL + "\t";
  protected final String TEXT_120 = NL + "\t";
  protected final String TEXT_121 = "\tString[] applications_";
  protected final String TEXT_122 = " = " + NL + "\t";
  protected final String TEXT_123 = NL + "\t\t{}" + NL + "\t\t";
  protected final String TEXT_124 = NL + "\t\t{\"Ganglia\",\"Hadoop\",\"Hive\",\"Hue\",\"Mahout\",\"Pig\",\"Spark\"}" + NL + "\t\t";
  protected final String TEXT_125 = NL + "\t\t{\"Ganglia\",\"Hadoop\",\"Hive\",\"Hue\",\"Mahout\",\"Pig\",\"Spark\"}" + NL + "\t\t";
  protected final String TEXT_126 = NL + "\t\t{\"Hadoop\",\"Hive\",\"Hue\",\"Mahout\",\"Pig\",\"Spark\"}" + NL + "\t\t";
  protected final String TEXT_127 = NL + "\t\t{\"Hadoop\",\"Hive\",\"Mahout\",\"Pig\",\"Spark\"}" + NL + "\t\t";
  protected final String TEXT_128 = NL + "\t\t{\"Ganglia\",\"Hadoop\",\"Hive\",\"Hue\",\"Mahout\",\"Pig\"}" + NL + "\t\t";
  protected final String TEXT_129 = NL + "\t\t{\"Ganglia\",\"Hadoop\",\"Hive\",\"Pig\"}" + NL + "\t\t";
  protected final String TEXT_130 = NL + "\t\t{\"Ganglia\",\"Hadoop\",\"Hive\",\"Pig\"}" + NL + "\t\t";
  protected final String TEXT_131 = NL + "\t\t{\"Hadoop\",\"Hive\",\"Pig\"}" + NL + "\t\t";
  protected final String TEXT_132 = NL + "\t\t{\"Hadoop\",\"Hive\",\"Pig\"}" + NL + "\t\t";
  protected final String TEXT_133 = NL + "\t\t{\"Hadoop\",\"Hive\",\"Presto-Sandbox\"}" + NL + "\t\t";
  protected final String TEXT_134 = NL + "\t\t{\"Hadoop\",\"Hive\",\"Presto-Sandbox\"}" + NL + "\t\t";
  protected final String TEXT_135 = NL + "\t\t{\"Hadoop\",\"Hive\",\"Presto-Sandbox\"}" + NL + "\t\t";
  protected final String TEXT_136 = NL + "\t\t{\"Hadoop\",\"Hive\",\"Presto-Sandbox\"}" + NL + "\t\t";
  protected final String TEXT_137 = NL + "\t\t{\"Ganglia\",\"Hadoop\",\"Spark\"}" + NL + "\t\t";
  protected final String TEXT_138 = NL + "\t\t{\"Ganglia\",\"Hadoop\",\"Spark\"}" + NL + "\t\t";
  protected final String TEXT_139 = NL + "\t\t{\"Ganglia\",\"Hadoop\",\"Spark\"}" + NL + "\t\t";
  protected final String TEXT_140 = NL + "\t\t{\"Hadoop\",\"Spark\"}" + NL + "\t\t";
  protected final String TEXT_141 = NL + "\t\t{\"Hadoop\",\"Spark\"}" + NL + "\t\t";
  protected final String TEXT_142 = NL + "\t\t{\"HBase\",\"Ganglia\",\"Hadoop\",\"Hive\",\"Hue\",\"ZooKeeper-Sandbox\"}" + NL + "\t\t";
  protected final String TEXT_143 = NL + "\t;" + NL + "\t" + NL + "\t";
  protected final String TEXT_144 = NL + "\tif(true) {" + NL + "\t\tthrow new java.lang.RuntimeException(\"\\\"All Applications\\\" option is not supported by EMR 4.6.0\");" + NL + "\t}" + NL + "\t";
  protected final String TEXT_145 = NL + "\t\t" + NL + "    java.util.List<com.amazonaws.services.elasticmapreduce.model.Application> apps_";
  protected final String TEXT_146 = " = new java.util.ArrayList<com.amazonaws.services.elasticmapreduce.model.Application>();" + NL + "\tfor(String application_";
  protected final String TEXT_147 = " : applications_";
  protected final String TEXT_148 = ") {" + NL + "    \tcom.amazonaws.services.elasticmapreduce.model.Application app_";
  protected final String TEXT_149 = " = new com.amazonaws.services.elasticmapreduce.model.Application();" + NL + "    \tapp_";
  protected final String TEXT_150 = ".withName(application_";
  protected final String TEXT_151 = ");" + NL + "    \tapps_";
  protected final String TEXT_152 = ".add(app_";
  protected final String TEXT_153 = ");" + NL + "    }" + NL + "\t";
  protected final String TEXT_154 = NL + "\t\t\t\tjava.util.List<com.amazonaws.services.elasticmapreduce.model.Configuration> configs_";
  protected final String TEXT_155 = " = new java.util.ArrayList<com.amazonaws.services.elasticmapreduce.model.Configuration>();" + NL + "\t\t\t\tjava.util.Map<String,String> properties_";
  protected final String TEXT_156 = " = null;" + NL + "\t\t\t\tcom.amazonaws.services.elasticmapreduce.model.Configuration config_";
  protected final String TEXT_157 = " = null;" + NL + "\t\t\t";
  protected final String TEXT_158 = NL + "    \t\t\tproperties_";
  protected final String TEXT_159 = " = new java.util.HashMap<String,String>();" + NL + "    \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_160 = NL + "    \t\t\t\tproperties_";
  protected final String TEXT_161 = ".put(";
  protected final String TEXT_162 = ", ";
  protected final String TEXT_163 = ");" + NL + "    \t\t\t";
  protected final String TEXT_164 = NL + "    \t\t\t" + NL + "            \tconfig_";
  protected final String TEXT_165 = " = new com.amazonaws.services.elasticmapreduce.model.Configuration()" + NL + "                    .withClassification(";
  protected final String TEXT_166 = ")" + NL + "                    .withProperties(properties_";
  protected final String TEXT_167 = ");" + NL + "                    " + NL + "                configs_";
  protected final String TEXT_168 = ".add(config_";
  protected final String TEXT_169 = ");" + NL + "\t\t\t";
  protected final String TEXT_170 = NL + "\t" + NL + "\tcom.amazonaws.services.elasticmapreduce.model.RunJobFlowRequest request_";
  protected final String TEXT_171 = " = new com.amazonaws.services.elasticmapreduce.model.RunJobFlowRequest()" + NL + "    \t.withName(";
  protected final String TEXT_172 = ")" + NL + "    \t";
  protected final String TEXT_173 = NL + "    \t.withLogUri(";
  protected final String TEXT_174 = ")" + NL + "    \t";
  protected final String TEXT_175 = NL + "    \t" + NL + "    \t";
  protected final String TEXT_176 = NL + "    \t\t.withAmiVersion(";
  protected final String TEXT_177 = ")" + NL + "    \t";
  protected final String TEXT_178 = NL + "    \t\t.withReleaseLabel(";
  protected final String TEXT_179 = ")" + NL + "    \t";
  protected final String TEXT_180 = NL + "    \t" + NL + "    \t";
  protected final String TEXT_181 = NL + "    \t\t.withApplications(apps_";
  protected final String TEXT_182 = ")" + NL + "    \t";
  protected final String TEXT_183 = NL + "    \t" + NL + "    \t";
  protected final String TEXT_184 = NL + "    \t.withSteps(steps_";
  protected final String TEXT_185 = ")" + NL + "    \t";
  protected final String TEXT_186 = NL + "    \t" + NL + "    \t.withServiceRole(";
  protected final String TEXT_187 = ")" + NL + "    \t.withJobFlowRole(";
  protected final String TEXT_188 = ")" + NL + "    \t" + NL + "    \t";
  protected final String TEXT_189 = NL + "    \t.withVisibleToAllUsers(true)" + NL + "    \t";
  protected final String TEXT_190 = NL + "    \t" + NL + "    \t";
  protected final String TEXT_191 = NL + "    \t.withBootstrapActions(actions_";
  protected final String TEXT_192 = ")" + NL + "    \t";
  protected final String TEXT_193 = NL + "    \t" + NL + "    \t";
  protected final String TEXT_194 = NL + "    \t.withConfigurations(configs_";
  protected final String TEXT_195 = ")" + NL + "    \t";
  protected final String TEXT_196 = NL + "    \t" + NL + "    \t.withInstances(" + NL + "    \t\tnew com.amazonaws.services.elasticmapreduce.model.JobFlowInstancesConfig()" + NL + "    \t\t\t.withInstanceCount(";
  protected final String TEXT_197 = ")" + NL + "    \t\t\t";
  protected final String TEXT_198 = NL + "    \t\t\t.withEc2KeyName(";
  protected final String TEXT_199 = ")" + NL + "    \t\t\t";
  protected final String TEXT_200 = NL + "    \t\t\t.withMasterInstanceType(";
  protected final String TEXT_201 = ")" + NL + "    \t\t\t.withSlaveInstanceType(";
  protected final String TEXT_202 = ")" + NL + "    \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_203 = NL + "    \t\t\t.withEc2SubnetId(";
  protected final String TEXT_204 = ")" + NL + "    \t\t\t";
  protected final String TEXT_205 = NL + "    \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_206 = NL + "    \t\t\t.withPlacement(new com.amazonaws.services.elasticmapreduce.model.PlacementType().withAvailabilityZone(";
  protected final String TEXT_207 = "))" + NL + "    \t\t\t";
  protected final String TEXT_208 = NL + "    \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_209 = NL + "    \t\t\t.withEmrManagedMasterSecurityGroup(";
  protected final String TEXT_210 = ")" + NL + "    \t\t\t";
  protected final String TEXT_211 = NL + "    \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_212 = NL + "    \t\t\t.withAdditionalMasterSecurityGroups(";
  protected final String TEXT_213 = ".split(\",\"))" + NL + "    \t\t\t";
  protected final String TEXT_214 = NL + "    \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_215 = NL + "    \t\t\t.withEmrManagedSlaveSecurityGroup(";
  protected final String TEXT_216 = ")" + NL + "    \t\t\t";
  protected final String TEXT_217 = NL + "    \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_218 = NL + "    \t\t\t.withAdditionalSlaveSecurityGroups(";
  protected final String TEXT_219 = ".split(\",\"))" + NL + "    \t\t\t";
  protected final String TEXT_220 = NL + "    \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_221 = NL + "    \t\t\t.withTerminationProtected(true)" + NL + "    \t\t\t";
  protected final String TEXT_222 = NL + "    \t\t\t" + NL + "    \t\t\t.withKeepJobFlowAliveWhenNoSteps(";
  protected final String TEXT_223 = ")" + NL + "    \t);" + NL + "" + NL + "\tcom.amazonaws.services.elasticmapreduce.model.RunJobFlowResult result_";
  protected final String TEXT_224 = " = emr_";
  protected final String TEXT_225 = ".runJobFlow(request_";
  protected final String TEXT_226 = ");" + NL + "\t" + NL + "\t";
  protected final String TEXT_227 = NL + "\tlog.info(\"";
  protected final String TEXT_228 = " - cluster status : \" + result_";
  protected final String TEXT_229 = ");" + NL + "\t";
  protected final String TEXT_230 = NL + "\t" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_231 = "_CLUSTER_FINAL_ID\", result_";
  protected final String TEXT_232 = ".getJobFlowId());" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_233 = "_CLUSTER_FINAL_NAME\", ";
  protected final String TEXT_234 = ");" + NL + "\t" + NL + "\t";
  protected final String TEXT_235 = NL + "\t\tboolean clusterIsAlive_";
  protected final String TEXT_236 = " = false;" + NL + "        System.out.println(\"Wating for cluster to become available.\");" + NL + "        while (true) {" + NL + "            com.amazonaws.services.elasticmapreduce.model.DescribeClusterResult result2_";
  protected final String TEXT_237 = " = emr_";
  protected final String TEXT_238 = ".describeCluster(" + NL + "            \tnew com.amazonaws.services.elasticmapreduce.model.DescribeClusterRequest()" + NL + "               \t\t.withClusterId(result_";
  protected final String TEXT_239 = ".getJobFlowId())" + NL + "            );" + NL + "            String status_";
  protected final String TEXT_240 = " = result2_";
  protected final String TEXT_241 = ".getCluster().getStatus().getState();" + NL + "            if (\"WAITING\".equalsIgnoreCase(status_";
  protected final String TEXT_242 = ") || \"RUNNING\".equalsIgnoreCase(status_";
  protected final String TEXT_243 = ")) {" + NL + "            \tclusterIsAlive_";
  protected final String TEXT_244 = " = true;" + NL + "                break;" + NL + "            } else if(\"TERMINATED\".equalsIgnoreCase(status_";
  protected final String TEXT_245 = ")) {" + NL + "                break;" + NL + "            } else if(\"TERMINATED_WITH_ERRORS\".equalsIgnoreCase(status_";
  protected final String TEXT_246 = ")) {" + NL + "            \tSystem.err.println(\"Fail to start the cluster.\");" + NL + "            \tbreak;" + NL + "            } else {" + NL + "                System.out.print(\".\");" + NL + "                Thread.sleep(2000);" + NL + "            }" + NL + "        }" + NL + "\t";
  protected final String TEXT_247 = NL + NL + "\t";
  protected final String TEXT_248 = NL + "\t\tboolean waitForStep_";
  protected final String TEXT_249 = " = clusterIsAlive_";
  protected final String TEXT_250 = " && (steps_";
  protected final String TEXT_251 = ".size() > 1);" + NL + "\t\t" + NL + "\t\tif(waitForStep_";
  protected final String TEXT_252 = ") {" + NL + "        \tSystem.out.println(\"Wating for steps to complete.\");" + NL + "        }" + NL + "        " + NL + "        while (waitForStep_";
  protected final String TEXT_253 = ") {" + NL + "            com.amazonaws.services.elasticmapreduce.model.DescribeClusterResult result2_";
  protected final String TEXT_254 = " = emr_";
  protected final String TEXT_255 = ".describeCluster(" + NL + "            \tnew com.amazonaws.services.elasticmapreduce.model.DescribeClusterRequest()" + NL + "               \t\t.withClusterId(result_";
  protected final String TEXT_256 = ".getJobFlowId())" + NL + "            );" + NL + "            String status_";
  protected final String TEXT_257 = " = result2_";
  protected final String TEXT_258 = ".getCluster().getStatus().getState();" + NL + "            if (\"WAITING\".equalsIgnoreCase(status_";
  protected final String TEXT_259 = ") || \"TERMINATED\".equalsIgnoreCase(status_";
  protected final String TEXT_260 = ") || \"TERMINATING\".equalsIgnoreCase(status_";
  protected final String TEXT_261 = ")) {" + NL + "            \tbreak;" + NL + "            } else if(\"TERMINATED_WITH_ERRORS\".equalsIgnoreCase(status_";
  protected final String TEXT_262 = ")) {" + NL + "            \tSystem.err.println(\"Fail to complete steps.\");" + NL + "            \tbreak;" + NL + "            } else {" + NL + "                System.out.print(\".\");" + NL + "                Thread.sleep(2000);" + NL + "            }" + NL + "        }" + NL + "\t";
  protected final String TEXT_263 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	class ParameterUtil {
		boolean isValid(String parameterValue) {
			return parameterValue!=null && !parameterValue.isEmpty() && !"\"\"".equals(parameterValue);
		}
	}
	
	ParameterUtil parameterUtil = new ParameterUtil();
	
	List<Map<String, String>> bootstrap_actions = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__BOOTSTRAP_ACTIONS__");
	if(!bootstrap_actions.isEmpty()) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
	}
	
	for (int i=0; i<bootstrap_actions.size(); i++) {
	Map<String, String> bootstrap_action = bootstrap_actions.get(i);

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(bootstrap_action.get("NAME") );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(bootstrap_action.get("SCRIPT_PATH") );
    stringBuffer.append(TEXT_8);
    if(parameterUtil.isValid(bootstrap_action.get("ARGS"))){
    stringBuffer.append(TEXT_9);
    stringBuffer.append(bootstrap_action.get("ARGS") );
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
	}
	
	List<Map<String, String>> lines = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__STEP_TABLE__");

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
	boolean enable_debug = "true".equals(ElementParameterParser.getValue(node, "__ENABLE_DEBUG__"));
	boolean haveSteps = enable_debug || !lines.isEmpty();
	
	if(haveSteps) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    
	}
	
	for (int i=0; i<lines.size(); i++) {
	Map<String, String> line = lines.get(i);

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    if(parameterUtil.isValid(line.get("MAIN_CLASS"))){
    stringBuffer.append(TEXT_23);
    stringBuffer.append( line.get("MAIN_CLASS") );
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    stringBuffer.append( line.get("JAR") );
    stringBuffer.append(TEXT_26);
    if(parameterUtil.isValid(line.get("ARGS"))){
    stringBuffer.append(TEXT_27);
    stringBuffer.append( line.get("ARGS") );
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append( line.get("ACTION_ON_FAILURE") );
    stringBuffer.append(TEXT_33);
    stringBuffer.append( line.get("NAME") );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    
	}

    stringBuffer.append(TEXT_37);
    
	String action = ElementParameterParser.getValue(node, "__ACTION__");
	String region = ElementParameterParser.getValue(node, "__REGION__");
	String cluster_name = ElementParameterParser.getValue(node, "__CLUSTER_NAME__");
	String cluster_version = ElementParameterParser.getValue(node, "__CLUSTER_VERSION__");
	
	String service_role = ElementParameterParser.getValue(node, "__SERVICE_ROLE__");
	String jobflow_role = ElementParameterParser.getValue(node, "__JOBFLOW_ROLE__");
	
	boolean enable_log = "true".equals(ElementParameterParser.getValue(node, "__ENABLE_LOG__"));
	String log_url = ElementParameterParser.getValue(node, "__LOG_URL__");
	
	boolean enable_key_pair = "true".equals(ElementParameterParser.getValue(node, "__ENABLE_KEY_PAIR__"));
	String key_pair = ElementParameterParser.getValue(node, "__KEY_PAIR__");
	
	String instance_count = ElementParameterParser.getValue(node, "__INSTANCE_COUNT__");
	
	String master_instance_type = ElementParameterParser.getValue(node, "__MASTER_INSTANCE_TYPE__");
	String slave_instance_type = ElementParameterParser.getValue(node, "__SLAVE_INSTANCE_TYPE__");
	
	boolean visible_to_all_users = "true".equals(ElementParameterParser.getValue(node, "__VISIBLE_TO_ALL_USERS__"));
	
	boolean termination_protected = "true".equals(ElementParameterParser.getValue(node, "__TERMINATION_PROTECTED__"));
	
	String master_security_group = ElementParameterParser.getValue(node, "__MASTER_SECURITY_GROUP__");
	String additional_master_security_groups = ElementParameterParser.getValue(node, "__ADDITIONAL_MASTER_SECURITY_GROUPS__");
	String slave_security_group = ElementParameterParser.getValue(node, "__SLAVE_SECURITY_GROUP__");
	String additional_slave_security_groups = ElementParameterParser.getValue(node, "__ADDITIONAL_SLAVE_SECURITY_GROUPS__");
	
	boolean wait_for_cluster_ready = "true".equals(ElementParameterParser.getValue(node, "__WAIT_FOR_CLUSTER_READY__"));
	boolean wait_for_steps_complete = "true".equals(ElementParameterParser.getValue(node, "__WAIT_FOR_STEPS_COMPLETE__"));
	
	
	String availability_zone = ElementParameterParser.getValue(node, "__AVAILABILITY_ZONE__");
	
	String subnet_id = ElementParameterParser.getValue(node, "__SUBNET_ID__");
	
	boolean isLog4jEnabled = "true".equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

	boolean keep_alive = "true".equals(ElementParameterParser.getValue(node, "__KEEP_ALIVE__"));

    stringBuffer.append(TEXT_38);
    stringBuffer.append(TEXT_39);
    
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
	
    stringBuffer.append(TEXT_40);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_43);
    } else {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
	if(inheritCredentials) {
	
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    } else {
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(accesskey);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    }
	if(assumeRole) {
	
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(sessionDuration);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(arn);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(roleSessionName);
    stringBuffer.append(TEXT_62);
    if(setStsEndpoint) {
    stringBuffer.append(TEXT_63);
    stringBuffer.append(stsEndpoint);
    stringBuffer.append(TEXT_64);
    }
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    }
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
	if(region!=null && !region.isEmpty() && !"DEFAULT".equalsIgnoreCase(region)){
		
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_75);
    
	}
	
    stringBuffer.append(TEXT_76);
    
	if("STOP".equals(action)) {
	
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
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
    
    	String predicates = ElementParameterParser.getValue(node, "__PREDICATES__");
    	String name = ElementParameterParser.getValue(node, "__NAME_OF_CLUSTER__");
    	String id = ElementParameterParser.getValue(node, "__ID_OF_CLUSTER__");
    	
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
			if("RUNNING".equals(predicates)) {
			
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    
			} else if("RUNNING_WITH_NAME".equals(predicates)) {
			
    stringBuffer.append(TEXT_91);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
			} else if("RUNNING_WITH_ID".equals(predicates)) {
			
    stringBuffer.append(TEXT_96);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    
			}
			
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
    
    		if("RUNNING".equals(predicates)) {
    		
    stringBuffer.append(TEXT_108);
    
    		} else if("RUNNING_WITH_NAME".equals(predicates)) {
    		
    stringBuffer.append(TEXT_109);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_110);
    
    		} else if("RUNNING_WITH_ID".equals(predicates)) {
    		
    stringBuffer.append(TEXT_111);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_112);
    
    		}
    		
    stringBuffer.append(TEXT_113);
    
		return stringBuffer.toString();
	}
	
	if(enable_debug) {

    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    
	}
	
	final boolean newApi = cluster_version!=null && "\"emr-4.2.0\",\"emr-4.1.0\",\"emr-4.0.0\",\"emr-4.5.0\",\"emr-4.6.0\"".contains(cluster_version);
	
	boolean setApps = newApi;
	if(setApps) {
	
    stringBuffer.append(TEXT_120);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    
	String application = ElementParameterParser.getValue(node, "__APPLICATION__");
	if("ALL_APPLICATIONS".equals(application)) {
		if("\"emr-4.6.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_123);
    
		} else if("\"emr-4.5.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_124);
    
		} else if("\"emr-4.2.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_125);
    
		} else if("\"emr-4.1.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_126);
    
		} else if("\"emr-4.0.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_127);
    
		}
	} else if("CORE_HADOOP".equals(application)) {
		if("\"emr-4.6.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_128);
    
		} else if("\"emr-4.5.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_129);
    
		} else if("\"emr-4.2.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_130);
    		
		} else if("\"emr-4.1.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_131);
    
		} else if("\"emr-4.0.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_132);
    
		}
	} else if("PRESTO_SANDBOX".equals(application)) {
		if("\"emr-4.6.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_133);
    
		} else if("\"emr-4.5.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_134);
    
		} else if("\"emr-4.2.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_135);
    
		} else if("\"emr-4.1.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_136);
    
		}
	} else if("SPARK".equals(application)) {
		if("\"emr-4.6.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_137);
    
		} else if("\"emr-4.5.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_138);
    
		} else if("\"emr-4.2.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_139);
    
		} else if("\"emr-4.1.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_140);
    
		} else if("\"emr-4.0.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_141);
    
		}
	} else if("HBASE".equals(application)) {
		if("\"emr-4.6.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_142);
    
		}
	}
	
    stringBuffer.append(TEXT_143);
    
	if("ALL_APPLICATIONS".equals(application) && "\"emr-4.6.0\"".equals(cluster_version)) {
	
    stringBuffer.append(TEXT_144);
    
	}
	
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    
	}
	
	Map<String, List<Map<String,String>>> classification2Properties = new HashMap<String, List<Map<String,String>>>();
	if(newApi) {
		List<Map<String, String>> property_table = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__PROPERTY_TABLE__");
		if(property_table!=null) {
			for (int i=0; i<property_table.size(); i++) {
				Map<String, String> property = property_table.get(i);
				String classification = property.get("CLASSIFICATION");
				
				List<Map<String,String>> properties = classification2Properties.get(classification);
				if(properties == null) {
					properties = new ArrayList<Map<String,String>>();
					classification2Properties.put(classification, properties);
				}
				
				properties.add(property);
			}
			
			if(!classification2Properties.isEmpty()) {
			
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    
			}
			
			for(java.util.Map.Entry<String, List<Map<String,String>>> entry : classification2Properties.entrySet()) {
				String classification = entry.getKey();
				List<Map<String,String>> properties = entry.getValue();
				
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    
    			for(Map<String,String> property : properties) {
    			
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(property.get("KEY"));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(property.get("VALUE"));
    stringBuffer.append(TEXT_163);
    
    			}
    			
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(classification);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    
			}
		}
	}
	
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cluster_name);
    stringBuffer.append(TEXT_172);
    if(enable_log){
    stringBuffer.append(TEXT_173);
    stringBuffer.append(log_url);
    stringBuffer.append(TEXT_174);
    }
    stringBuffer.append(TEXT_175);
    
    	if(cluster_version!=null && cluster_version.length()>1){
    		if(Character.isDigit(cluster_version.charAt(1))) {//AMI version
    	
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cluster_version);
    stringBuffer.append(TEXT_177);
    
    		} else {//EMR version
    	
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cluster_version);
    stringBuffer.append(TEXT_179);
    
    		}
    	}
    	
    stringBuffer.append(TEXT_180);
    
    	if(setApps) {
    	
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    
    	}
    	
    stringBuffer.append(TEXT_183);
    if(haveSteps){
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    }
    stringBuffer.append(TEXT_186);
    stringBuffer.append(service_role);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(jobflow_role);
    stringBuffer.append(TEXT_188);
    if(visible_to_all_users){
    stringBuffer.append(TEXT_189);
    }
    stringBuffer.append(TEXT_190);
    if(!bootstrap_actions.isEmpty()){
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    }
    stringBuffer.append(TEXT_193);
    if(!classification2Properties.isEmpty()){
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    }
    stringBuffer.append(TEXT_196);
    stringBuffer.append(instance_count);
    stringBuffer.append(TEXT_197);
    if(enable_key_pair){
    stringBuffer.append(TEXT_198);
    stringBuffer.append(key_pair);
    stringBuffer.append(TEXT_199);
    }
    stringBuffer.append(TEXT_200);
    stringBuffer.append(master_instance_type);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(slave_instance_type);
    stringBuffer.append(TEXT_202);
    if(parameterUtil.isValid(subnet_id)){
    stringBuffer.append(TEXT_203);
    stringBuffer.append(subnet_id);
    stringBuffer.append(TEXT_204);
    }
    stringBuffer.append(TEXT_205);
    if(parameterUtil.isValid(availability_zone)){
    stringBuffer.append(TEXT_206);
    stringBuffer.append(availability_zone);
    stringBuffer.append(TEXT_207);
    }
    stringBuffer.append(TEXT_208);
    if(parameterUtil.isValid(master_security_group)){
    stringBuffer.append(TEXT_209);
    stringBuffer.append(master_security_group);
    stringBuffer.append(TEXT_210);
    }
    stringBuffer.append(TEXT_211);
    if(parameterUtil.isValid(additional_master_security_groups)){
    stringBuffer.append(TEXT_212);
    stringBuffer.append(additional_master_security_groups);
    stringBuffer.append(TEXT_213);
    }
    stringBuffer.append(TEXT_214);
    if(parameterUtil.isValid(slave_security_group)){
    stringBuffer.append(TEXT_215);
    stringBuffer.append(slave_security_group);
    stringBuffer.append(TEXT_216);
    }
    stringBuffer.append(TEXT_217);
    if(parameterUtil.isValid(additional_slave_security_groups)){
    stringBuffer.append(TEXT_218);
    stringBuffer.append(additional_slave_security_groups);
    stringBuffer.append(TEXT_219);
    }
    stringBuffer.append(TEXT_220);
    if(termination_protected) {
    stringBuffer.append(TEXT_221);
    }
    stringBuffer.append(TEXT_222);
    stringBuffer.append(keep_alive);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    }
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cluster_name);
    stringBuffer.append(TEXT_234);
    
	if(wait_for_cluster_ready) {
	
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    
	}
	
    stringBuffer.append(TEXT_247);
    
	if(haveSteps && wait_for_steps_complete && wait_for_cluster_ready) {
	
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    
	}
	
    stringBuffer.append(TEXT_263);
    return stringBuffer.toString();
  }
}
