package org.talend.designer.codegen.translators.bigdata.googlebigquery;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TBigQueryInputBeginJava
{
  protected static String nl;
  public static synchronized TBigQueryInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBigQueryInputBeginJava result = new TBigQueryInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_3 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_5 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_6 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_8 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_9 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_11 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_12 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_14 = " - Written records count: \" + nb_line_";
  protected final String TEXT_15 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_17 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_19 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_20 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_22 = " - Writing the record \" + nb_line_";
  protected final String TEXT_23 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_25 = " - Processing the record \" + nb_line_";
  protected final String TEXT_26 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_28 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_29 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_30 = NL + "\t";
  protected final String TEXT_31 = NL + "\tfinal String CLIENT_ID_";
  protected final String TEXT_32 = " = ";
  protected final String TEXT_33 = ";" + NL + "\t" + NL + "\t";
  protected final String TEXT_34 = NL + NL + "\t";
  protected final String TEXT_35 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_36 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_37 = ");";
  protected final String TEXT_38 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_39 = " = ";
  protected final String TEXT_40 = "; ";
  protected final String TEXT_41 = NL + "\t" + NL + "\tfinal String CLIENT_SECRET_";
  protected final String TEXT_42 = " = \"{\\\"web\\\": {\\\"client_id\\\": \\\"\"+";
  protected final String TEXT_43 = "+\"\\\",\\\"client_secret\\\": \\\"\" +decryptedPassword_";
  protected final String TEXT_44 = "+ \"\\\",\\\"auth_uri\\\": \\\"https://accounts.google.com/o/oauth2/auth\\\",\\\"token_uri\\\": \\\"https://accounts.google.com/o/oauth2/token\\\"}}\";" + NL + "\tfinal String PROJECT_ID_";
  protected final String TEXT_45 = " = ";
  protected final String TEXT_46 = ";" + NL + "" + NL + "\t// Static variables for API scope, callback URI, and HTTP/JSON functions" + NL + "\tfinal List<String> SCOPES_";
  protected final String TEXT_47 = " = java.util.Arrays.asList(\"https://www.googleapis.com/auth/bigquery\");" + NL + "\tfinal String REDIRECT_URI_";
  protected final String TEXT_48 = " = \"urn:ietf:wg:oauth:2.0:oob\";" + NL + "\tfinal com.google.api.client.http.HttpTransport TRANSPORT_";
  protected final String TEXT_49 = " = new com.google.api.client.http.javanet.NetHttpTransport();" + NL + "\tfinal com.google.api.client.json.JsonFactory JSON_FACTORY_";
  protected final String TEXT_50 = " = new com.google.api.client.json.jackson2.JacksonFactory();" + NL + "" + NL + "\tcom.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets clientSecrets_";
  protected final String TEXT_51 = " = com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets.load(" + NL + "\t\t\t\t\tnew com.google.api.client.json.jackson2.JacksonFactory(), new java.io.InputStreamReader(new java.io.ByteArrayInputStream(" + NL + "\t\t\t\t\t\t\tCLIENT_SECRET_";
  protected final String TEXT_52 = ".getBytes())));" + NL + "" + NL + "\tcom.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow flow_";
  protected final String TEXT_53 = " = null;" + NL + "\tcom.google.api.services.bigquery.Bigquery bigqueryclient_";
  protected final String TEXT_54 = " = null;" + NL + "\tlong nb_line_";
  protected final String TEXT_55 = " = 0;" + NL + "\t";
  protected final String TEXT_56 = NL + "\t\tlog.info(\"";
  protected final String TEXT_57 = " - Service Account Scopes [https://www.googleapis.com/auth/bigquery]\");" + NL + "\t\tlog.info(\"";
  protected final String TEXT_58 = " - Redirect uris [urn:ietf:wg:oauth:2.0:oob]\");" + NL + "\t\tlog.info(\"";
  protected final String TEXT_59 = " - Attempt to load existing refresh token.\");" + NL + "\t";
  protected final String TEXT_60 = NL + NL + "\t// Attempt to load existing refresh token" + NL + "    String tokenFile_";
  protected final String TEXT_61 = " = ";
  protected final String TEXT_62 = ";" + NL + "\tjava.util.Properties properties_";
  protected final String TEXT_63 = " = new java.util.Properties();" + NL + "\ttry {" + NL + "\t\tjava.io.FileInputStream inputStream_";
  protected final String TEXT_64 = " = new java.io.FileInputStream(tokenFile_";
  protected final String TEXT_65 = ");" + NL + "\t\tproperties_";
  protected final String TEXT_66 = ".load(inputStream_";
  protected final String TEXT_67 = ");" + NL + "\t\tinputStream_";
  protected final String TEXT_68 = ".close();" + NL + "\t} catch (java.io.FileNotFoundException e_";
  protected final String TEXT_69 = ") {" + NL + "\t\t";
  protected final String TEXT_70 = NL + "\t\t\tlog.warn(\"";
  protected final String TEXT_71 = " - \"+e_";
  protected final String TEXT_72 = ".getMessage());" + NL + "\t\t";
  protected final String TEXT_73 = NL + "\t} catch (java.io.IOException ee_";
  protected final String TEXT_74 = ") {" + NL + "\t\t";
  protected final String TEXT_75 = NL + "\t\t\tlog.warn(\"";
  protected final String TEXT_76 = " - \"+ee_";
  protected final String TEXT_77 = ".getMessage());" + NL + "\t\t";
  protected final String TEXT_78 = NL + "\t}" + NL + "\tString storedRefreshToken_";
  protected final String TEXT_79 = " = (String) properties_";
  protected final String TEXT_80 = ".get(\"refreshtoken\");" + NL + "" + NL + "\t// Check to see if the an existing refresh token was loaded." + NL + "\t// If so, create a credential and call refreshToken() to get a new" + NL + "\t// access token." + NL + "\tif (storedRefreshToken_";
  protected final String TEXT_81 = " != null) {" + NL + "\t\t// Request a new Access token using the refresh token." + NL + "\t\tcom.google.api.client.googleapis.auth.oauth2.GoogleCredential credential_";
  protected final String TEXT_82 = " = new com.google.api.client.googleapis.auth.oauth2. GoogleCredential.Builder().setTransport(TRANSPORT_";
  protected final String TEXT_83 = ")" + NL + "\t\t\t\t.setJsonFactory(JSON_FACTORY_";
  protected final String TEXT_84 = ").setClientSecrets(clientSecrets_";
  protected final String TEXT_85 = ")" + NL + "\t\t\t\t.build().setFromTokenResponse(new com.google.api.client.auth.oauth2.TokenResponse().setRefreshToken(storedRefreshToken_";
  protected final String TEXT_86 = "));" + NL + "" + NL + "\t\tcredential_";
  protected final String TEXT_87 = ".refreshToken();" + NL + "\t\t";
  protected final String TEXT_88 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_89 = " - An existing refresh token was loaded.\");" + NL + "\t\t";
  protected final String TEXT_90 = NL + "\t\tbigqueryclient_";
  protected final String TEXT_91 = " = new com.google.api.services.bigquery.Bigquery.Builder(new com.google.api.client.http.javanet.NetHttpTransport(),new com.google.api.client.json.jackson2.JacksonFactory(),credential_";
  protected final String TEXT_92 = ").setApplicationName(\"Talend\").build();" + NL + "\t} else {" + NL + "\t\t";
  protected final String TEXT_93 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_94 = " - The refresh token does not exist.\");" + NL + "\t\t";
  protected final String TEXT_95 = NL + "\t\tString authorizationCode_";
  protected final String TEXT_96 = " = ";
  protected final String TEXT_97 = ";" + NL + "\t\tif(authorizationCode_";
  protected final String TEXT_98 = " == null || \"\".equals(authorizationCode_";
  protected final String TEXT_99 = ") || \"\\\"\\\"\".equals(authorizationCode_";
  protected final String TEXT_100 = ")) {" + NL + "\t\t\tString authorizeUrl_";
  protected final String TEXT_101 = " = new com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl(" + NL + "\t\t\t\t\tclientSecrets_";
  protected final String TEXT_102 = ", REDIRECT_URI_";
  protected final String TEXT_103 = ", SCOPES_";
  protected final String TEXT_104 = ").setState(\"\").build();" + NL + "" + NL + "\t\t\tSystem.out" + NL + "\t\t\t\t\t.println(\"Paste this URL into a web browser to authorize BigQuery Access:\\n\"" + NL + "\t\t\t\t\t\t\t+ authorizeUrl_";
  protected final String TEXT_105 = ");" + NL + "\t\t\t";
  protected final String TEXT_106 = NL + "\t\t\t\tlog.warn(\"";
  protected final String TEXT_107 = " - Paste this URL into a web browser to authorize BigQuery Access:\\n\"" + NL + "\t\t\t\t\t\t\t\t+ authorizeUrl_";
  protected final String TEXT_108 = ");" + NL + "\t\t\t";
  protected final String TEXT_109 = NL + "\t\t\tthrow new java.lang.Exception(\"Authorization Code error\");" + NL + "\t\t} else {" + NL + "\t\t\t";
  protected final String TEXT_110 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_111 = " - Exchange the auth code for an access token and refesh token.\");" + NL + "\t\t\t";
  protected final String TEXT_112 = NL + "\t\t\t// Exchange the auth code for an access token and refesh token" + NL + "\t\t\tif (flow_";
  protected final String TEXT_113 = " == null) {" + NL + "\t\t\t\tflow_";
  protected final String TEXT_114 = " = new com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow.Builder(new com.google.api.client.http.javanet.NetHttpTransport()," + NL + "\t\t\t\t\t\tnew com.google.api.client.json.jackson2.JacksonFactory(), clientSecrets_";
  protected final String TEXT_115 = ", SCOPES_";
  protected final String TEXT_116 = ")" + NL + "\t\t\t\t\t\t.setAccessType(\"offline\").setApprovalPrompt(\"force\")" + NL + "\t\t\t\t\t\t.build();" + NL + "\t\t\t}" + NL + "\t\t\tcom.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse response_";
  protected final String TEXT_117 = " = flow_";
  protected final String TEXT_118 = ".newTokenRequest(authorizationCode_";
  protected final String TEXT_119 = ").setRedirectUri(REDIRECT_URI_";
  protected final String TEXT_120 = ").execute();" + NL + "\t\t\tcom.google.api.client.auth.oauth2.Credential credential_";
  protected final String TEXT_121 = " = flow_";
  protected final String TEXT_122 = ".createAndStoreCredential(response_";
  protected final String TEXT_123 = ", null);" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_124 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_125 = " - Store the refresh token for future use.\");" + NL + "\t\t\t";
  protected final String TEXT_126 = NL + "\t\t\t// Store the refresh token for future use." + NL + "\t\t\tjava.util.Properties storeProperties_";
  protected final String TEXT_127 = " = new java.util.Properties();" + NL + "\t\t\tstoreProperties_";
  protected final String TEXT_128 = ".setProperty(\"refreshtoken\", credential_";
  protected final String TEXT_129 = ".getRefreshToken());" + NL + "\t\t\tjava.io.FileOutputStream outputStream_";
  protected final String TEXT_130 = " = new java.io.FileOutputStream(tokenFile_";
  protected final String TEXT_131 = ");" + NL + "\t\t\tstoreProperties_";
  protected final String TEXT_132 = ".store(outputStream_";
  protected final String TEXT_133 = ",null);" + NL + "\t\t\tif (outputStream_";
  protected final String TEXT_134 = " != null) {" + NL + "\t\t\t    outputStream_";
  protected final String TEXT_135 = ".close();" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tbigqueryclient_";
  protected final String TEXT_136 = " = new com.google.api.services.bigquery.Bigquery.Builder(new com.google.api.client.http.javanet.NetHttpTransport(),new com.google.api.client.json.jackson2.JacksonFactory(),credential_";
  protected final String TEXT_137 = ").build();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "" + NL + "\t";
  protected final String TEXT_138 = NL + "\t";
  protected final String TEXT_139 = NL + NL + "class BigQueryUtil_";
  protected final String TEXT_140 = " {" + NL + "\tString projectId;" + NL + "\tcom.google.api.services.bigquery.Bigquery bigqueryclient = null;" + NL + "\tString tokenFile;" + NL + "\tboolean useLargeResult = false;" + NL + "\tString tempDataset;" + NL + "\tString tempTable;" + NL + "\t" + NL + "\tpublic BigQueryUtil_";
  protected final String TEXT_141 = "(String projectId, com.google.api.services.bigquery.Bigquery bigqueryclient, String tokenFile) {" + NL + "\t\tthis.projectId = projectId;" + NL + "\t\tthis.bigqueryclient = bigqueryclient;" + NL + "\t\tthis.tokenFile = tokenFile;" + NL + "\t}" + NL + "\t" + NL + "\tprivate String genTempName(String prefix){" + NL + "\t\treturn \"temp_\" + prefix + java.util.UUID.randomUUID().toString().replaceAll(\"-\", \"\") + \"";
  protected final String TEXT_142 = "\".toLowerCase().replaceAll(\"[^a-z0-9]\", \"0\").replaceAll(\"^[^a-z]\", \"a\") + Integer.toHexString(java.util.concurrent.ThreadLocalRandom.current().nextInt());" + NL + "\t}" + NL + "\t" + NL + "\tpublic void cleanup() throws Exception{" + NL + "\t\tif(useLargeResult){" + NL + "\t\t\tbigqueryclient.tables().delete(projectId, tempDataset, tempTable).execute();" + NL + "\t\t\tbigqueryclient.datasets().delete(projectId, tempDataset).execute();" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\tprivate void createDataset(String location) throws Exception {" + NL + "\t\tcom.google.api.services.bigquery.model.Dataset dataset = new com.google.api.services.bigquery.model.Dataset().setDatasetReference(new com.google.api.services.bigquery.model.DatasetReference().setProjectId(projectId).setDatasetId(tempDataset));" + NL + "\t\tString description = \"Dataset for BigQuery query job temporary table\";" + NL + "\t\tdataset.setFriendlyName(description);" + NL + "    \tdataset.setDescription(description);" + NL + "    \tbigqueryclient.datasets().insert(projectId, dataset).execute();" + NL + "\t}" + NL + "\t" + NL + "\tpublic com.google.api.services.bigquery.model.Job executeQuery(String query, boolean useLargeResult) throws Exception{" + NL + "\t\tcom.google.api.services.bigquery.model.JobConfigurationQuery queryConfig = new com.google.api.services.bigquery.model.JobConfigurationQuery();" + NL + "\t\tqueryConfig.setQuery(query);" + NL + "\t\tif(useLargeResult){" + NL + "\t\t\tthis.useLargeResult = true;" + NL + "\t\t\ttempDataset = genTempName(\"dataset\");" + NL + "\t\t\ttempTable = genTempName(\"table\");" + NL + "\t\t\tcreateDataset(null);" + NL + "\t\t\tqueryConfig.setAllowLargeResults(true);" + NL + "\t\t\tqueryConfig.setDestinationTable(new com.google.api.services.bigquery.model.TableReference()" + NL + "\t\t\t\t\t\t\t\t\t\t\t.setProjectId(projectId)" + NL + "\t\t\t\t\t\t\t\t\t\t\t.setDatasetId(tempDataset)" + NL + "\t\t\t\t\t\t\t\t\t\t\t.setTableId(tempTable));" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tcom.google.api.services.bigquery.model.JobConfiguration config = new com.google.api.services.bigquery.model.JobConfiguration();" + NL + "\t\tconfig.setQuery(queryConfig);" + NL + "\t\t" + NL + "\t\tcom.google.api.services.bigquery.model.Job job = new com.google.api.services.bigquery.model.Job();" + NL + "\t\tjob.setConfiguration(config);" + NL + "\t\t" + NL + "\t\tcom.google.api.services.bigquery.model.Job insert = null;" + NL + "\t\tcom.google.api.services.bigquery.model.JobReference jobId = null;" + NL + "\t\ttry {" + NL + "\t\t\tinsert = bigqueryclient.jobs().insert(projectId, job).execute();" + NL + "\t\t\tjobId = insert.getJobReference();" + NL + "\t\t} catch (com.google.api.client.googleapis.json.GoogleJsonResponseException e) {" + NL + "\t\t\tif(tokenFile != null){" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tjava.io.File f = new java.io.File(tokenFile);" + NL + "\t\t\t\t\tboolean isRemoved = f.delete();" + NL + "\t\t\t\t\tif(isRemoved){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_143 = NL + "\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_144 = " - Unable to connect. This might come from the token expiration. Execute again the job with an empty authorization code.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_145 = NL + "\t\t\t\t\t\t\tSystem.err.println(\"---> Unable to connect. This might come from the token expiration. Execute again the job with an empty authorization code.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_146 = NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tthrow new java.lang.Exception();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} catch (java.lang.Exception ee) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_147 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_148 = " - Unable to connect. This might come from the token expiration. Remove the file \" + tokenFile + \" Execute again the job with an empty authorization code.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_149 = NL + "\t\t\t\t\t\tSystem.err.println(\"---> Unable to connect. This might come from the token expiration. Remove the file \" + tokenFile + \" Execute again the job with an empty authorization code.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_150 = NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tthrow e;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_151 = NL + "\t\t\tlog.info(\"";
  protected final String TEXT_152 = " - Wait for query execution\");" + NL + "\t\t";
  protected final String TEXT_153 = NL + "\t\t// wait for query execution" + NL + "\t\twhile (true) {" + NL + "\t\t\tcom.google.api.services.bigquery.model.Job pollJob = bigqueryclient.jobs().get(projectId, jobId.getJobId()).execute();" + NL + "\t\t\tcom.google.api.services.bigquery.model.JobStatus status = pollJob.getStatus();" + NL + "\t\t\tif (status.getState().equals(\"DONE\")) {" + NL + "\t\t\t\tcom.google.api.services.bigquery.model.ErrorProto errorProto = status.getErrorResult();" + NL + "\t\t\t\tif(errorProto != null){// job failed, handle it" + NL + "\t\t\t\t\t";
  protected final String TEXT_154 = NL + "\t\t\t\t\t\tif(!useLargeResult && \"responseTooLarge\".equals(errorProto.getReason())){// try with large result flag" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_155 = NL + "\t\t\t\t\t\t\t\tlog.info(\"";
  protected final String TEXT_156 = " - Try with allow large results flag\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_157 = NL + "\t\t\t\t\t\t\treturn executeQuery(query, true);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_158 = NL + "\t\t\t\t\t// Do not throw exception to avoid behavior changed(because it may throw \"duplicate\" exception which do not throw before);" + NL + "        \t\t\t";
  protected final String TEXT_159 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_160 = " - Reason: \" + errorProto.getReason() + \"\\nMessage: \" + errorProto.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_161 = NL + "\t\t\t\t\t\tSystem.err.println(\"---> Reason: \" + errorProto.getReason() + \"\\nMessage: \" + errorProto.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_162 = NL + "\t\t\t\t\t}// else job successful" + NL + "\t\t\t\t\tbreak;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t// Pause execution for one second before polling job status again, to " + NL + "\t\t\t\t// reduce unnecessary calls to the BigQUery API and lower overall" + NL + "\t\t\t\t// application bandwidth." + NL + "\t\t\t\tThread.sleep(1000);" + NL + "\t\t\t}" + NL + "\t\t" + NL + "\t\t\treturn insert;" + NL + "\t\t}" + NL + " \t\t" + NL + "\t}\t" + NL + "" + NL + "\t// Start a Query Job" + NL + "\tString querySql_";
  protected final String TEXT_163 = " = ";
  protected final String TEXT_164 = ";" + NL + "\tSystem.out.format(\"Running Query : %s\\n\", querySql_";
  protected final String TEXT_165 = ");" + NL + "\t";
  protected final String TEXT_166 = NL + "\t\tlog.debug(\"";
  protected final String TEXT_167 = " - Running Query: \"+querySql_";
  protected final String TEXT_168 = ");" + NL + "\t";
  protected final String TEXT_169 = NL + "\t" + NL + "\tBigQueryUtil_";
  protected final String TEXT_170 = " bigQueryUtil_";
  protected final String TEXT_171 = " = new BigQueryUtil_";
  protected final String TEXT_172 = "(PROJECT_ID_";
  protected final String TEXT_173 = ", bigqueryclient_";
  protected final String TEXT_174 = ", tokenFile_";
  protected final String TEXT_175 = ");" + NL + "\t" + NL + "\t";
  protected final String TEXT_176 = NL + "\t\tlog.info(\"";
  protected final String TEXT_177 = " - Try ";
  protected final String TEXT_178 = " allow large results flag\");" + NL + "\t";
  protected final String TEXT_179 = NL + "\tcom.google.api.services.bigquery.model.Job insert_";
  protected final String TEXT_180 = " = bigQueryUtil_";
  protected final String TEXT_181 = ".executeQuery(querySql_";
  protected final String TEXT_182 = ", ";
  protected final String TEXT_183 = ");" + NL + "" + NL + "\t";
  protected final String TEXT_184 = NL + "\t\tlog.info(\"";
  protected final String TEXT_185 = " - Retrieving records from dataset.\");" + NL + "\t";
  protected final String TEXT_186 = NL + "\tString pageToken_";
  protected final String TEXT_187 = " = null;" + NL + "\twhile (true) {" + NL + "\t\t// Fetch Results" + NL + "\t\tcom.google.api.services.bigquery.model.TableDataList dataList_";
  protected final String TEXT_188 = " = bigqueryclient_";
  protected final String TEXT_189 = ".tabledata()" + NL + "\t\t\t\t\t.list(PROJECT_ID_";
  protected final String TEXT_190 = "," + NL + "\t\t\t\t\t\t\tinsert_";
  protected final String TEXT_191 = ".getConfiguration().getQuery()" + NL + "\t\t\t\t\t\t\t\t\t.getDestinationTable().getDatasetId()," + NL + "\t\t\t\t\t\t\tinsert_";
  protected final String TEXT_192 = ".getConfiguration().getQuery()" + NL + "\t\t\t\t\t\t\t\t\t.getDestinationTable().getTableId())" + NL + "\t\t\t\t\t.setPageToken(pageToken_";
  protected final String TEXT_193 = ").execute();" + NL + "\t\t" + NL + "\t\tList<com.google.api.services.bigquery.model.TableRow> rows_";
  protected final String TEXT_194 = " = dataList_";
  protected final String TEXT_195 = ".getRows();" + NL + "" + NL + "\t\tif(rows_";
  protected final String TEXT_196 = " == null) {" + NL + "\t\t\t// Means there is no record." + NL + "\t\t\trows_";
  protected final String TEXT_197 = " = new java.util.ArrayList<com.google.api.services.bigquery.model.TableRow>();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tfor (com.google.api.services.bigquery.model.TableRow row_";
  protected final String TEXT_198 = " : rows_";
  protected final String TEXT_199 = ") {" + NL + "\t\t\tjava.util.List<com.google.api.services.bigquery.model.TableCell> field_";
  protected final String TEXT_200 = " = row_";
  protected final String TEXT_201 = ".getF();" + NL + "\t\t\tObject value_";
  protected final String TEXT_202 = " = null;" + NL + "\t\t\tnb_line_";
  protected final String TEXT_203 = " ++;" + NL + "\t\t";
  protected final String TEXT_204 = NL + "\t\t\t\t\t\t\t\tvalue_";
  protected final String TEXT_205 = " = field_";
  protected final String TEXT_206 = ".get(";
  protected final String TEXT_207 = ").getV();" + NL + "\t\t\t\t\t\t\t\tif(com.google.api.client.util.Data.isNull(value_";
  protected final String TEXT_208 = ")) value_";
  protected final String TEXT_209 = " = null;" + NL + "\t\t\t\t\t\t\t\tif(value_";
  protected final String TEXT_210 = " != null){" + NL + "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_211 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_212 = ".";
  protected final String TEXT_213 = " = value_";
  protected final String TEXT_214 = ".toString();" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_215 = "\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_216 = ".";
  protected final String TEXT_217 = " = value_";
  protected final String TEXT_218 = ";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_219 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_220 = ".";
  protected final String TEXT_221 = " = ParserUtils.parseTo_Date(value_";
  protected final String TEXT_222 = ".toString(), ";
  protected final String TEXT_223 = ");\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_224 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_225 = ".";
  protected final String TEXT_226 = " = ParserUtils.parseTo_";
  protected final String TEXT_227 = "(ParserUtils.parseTo_Number(value_";
  protected final String TEXT_228 = ".toString(), ";
  protected final String TEXT_229 = ", ";
  protected final String TEXT_230 = "));" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_231 = "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_232 = ".";
  protected final String TEXT_233 = " = value_";
  protected final String TEXT_234 = ".toString().getBytes(";
  protected final String TEXT_235 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_236 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_237 = ".";
  protected final String TEXT_238 = " = ParserUtils.parseTo_";
  protected final String TEXT_239 = "(value_";
  protected final String TEXT_240 = ".toString());" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_241 = NL + "\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_242 = ".";
  protected final String TEXT_243 = " = ";
  protected final String TEXT_244 = ";" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_245 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
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
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_20);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_21);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_24);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_27);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    stringBuffer.append(TEXT_30);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;

	INode node = (INode)codeGenArgument.getArgument();

	String cid = node.getUniqueName();

	String clientId = ElementParameterParser.getValue(node,"__CLIENT_ID__");
	String clientSecret = ElementParameterParser.getValue(node,"__CLIENT_SECRET__");
	String projectId = ElementParameterParser.getValue(node,"__PROJECT_ID__");
	String authorizationCode = ElementParameterParser.getValue(node,"__AUTHORIZATION_CODE__");
	String query = ElementParameterParser.getValue(node,"__QUERY__");
	query = query.replaceAll("\n"," ");
	query = query.replaceAll("\r"," ");
	
    String tokenFile = ElementParameterParser.getValue(node,"__TOKEN_NAME__");
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(clientId );
    stringBuffer.append(TEXT_33);
    
	String passwordFieldName = "__CLIENT_SECRET__";
	
    stringBuffer.append(TEXT_34);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_37);
    } else {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(clientId);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(projectId );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
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
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
	}
	
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(tokenFile);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
    	if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
		}
    	
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    
    	if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
		}
    	
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
		}
		
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
		
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(authorizationCode);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
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
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    
			}
			
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
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    
			}
			
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    
	String resultSizeType = ElementParameterParser.getValue(node,"__RESULT_SIZE__");
	
    stringBuffer.append(TEXT_138);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    
				    	if(isLog4jEnabled){
						
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    
						}else{
				    	
    stringBuffer.append(TEXT_145);
    
						}
						
    stringBuffer.append(TEXT_146);
    
			    	if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    
					}else{
			    	
    stringBuffer.append(TEXT_149);
    
					}
					
    stringBuffer.append(TEXT_150);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    
		}
		
    stringBuffer.append(TEXT_153);
    if("AUTO".equals(resultSizeType)){
    stringBuffer.append(TEXT_154);
    
							if(isLog4jEnabled){
							
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    
							}
							
    stringBuffer.append(TEXT_157);
    }
    stringBuffer.append(TEXT_158);
    
			    	if(isLog4jEnabled){
					
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    
					}else{
			    	
    stringBuffer.append(TEXT_161);
    
					}
					
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(query );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    
	}
	
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append("LARGE".equals(resultSizeType) ? "with" : "without");
    stringBuffer.append(TEXT_178);
    
	}
	
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append("LARGE".equals(resultSizeType) ? true : false);
    stringBuffer.append(TEXT_183);
    
	if(isLog4jEnabled){
	
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    
	}
	
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    
		List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		if (conns != null){
			if (conns.size()>0){
				IConnection conn =conns.get(0);
				String connName = conn.getName();
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					List<IMetadataTable> metadatas = node.getMetadataList();
					if ((metadatas!=null) && (metadatas.size() > 0)) {
						IMetadataTable metadata = metadatas.get(0);
						if (metadata != null) {
							String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
							String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
							boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
							String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
							String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
						
							List<IMetadataColumn> columns = metadata.getListColumns();
							int nbColumns = columns.size();
							for (int i = 0; i < nbColumns; i++ ) {
								IMetadataColumn column = columns.get(i);
								String columnName = column.getLabel();
							
								String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
								JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
								String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern(); 
								
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    
									if (javaType == JavaTypesManager.STRING) {
									
    stringBuffer.append(TEXT_211);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    
									}else if (javaType == JavaTypesManager.OBJECT) {
									
    stringBuffer.append(TEXT_215);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    		
									} else if(javaType == JavaTypesManager.DATE) {						
									
    stringBuffer.append(TEXT_219);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_223);
    		
									}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) { 
									
    stringBuffer.append(TEXT_224);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_226);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_229);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_230);
    
									} else if(javaType == JavaTypesManager.BYTE_ARRAY) { 
									
    stringBuffer.append(TEXT_231);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_235);
    
									} else {
									
    stringBuffer.append(TEXT_236);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_238);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    
									}
									
    stringBuffer.append(TEXT_241);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault()));
    stringBuffer.append(TEXT_244);
    
							}
							log4jFileUtil.debugRetriveData(node);
						}
					}
				}
			}
		}
		
    stringBuffer.append(TEXT_245);
    return stringBuffer.toString();
  }
}
