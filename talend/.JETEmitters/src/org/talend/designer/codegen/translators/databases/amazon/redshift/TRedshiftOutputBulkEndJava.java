package org.talend.designer.codegen.translators.databases.amazon.redshift;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import java.util.Map;
import java.util.List;

public class TRedshiftOutputBulkEndJava
{
  protected static String nl;
  public static synchronized TRedshiftOutputBulkEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRedshiftOutputBulkEndJava result = new TRedshiftOutputBulkEndJava();
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
  protected final String TEXT_29 = NL + "\tcsvWriter_";
  protected final String TEXT_30 = ".close();" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_31 = "_NB_LINE\",nb_line_";
  protected final String TEXT_32 = ");";
  protected final String TEXT_33 = NL + "\tif(file_";
  protected final String TEXT_34 = ".exists() && (file_";
  protected final String TEXT_35 = ".length() > 0)) {" + NL + "\t\t";
  protected final String TEXT_36 = NL + "\t\tcom.amazonaws.services.s3.AmazonS3Client conn_";
  protected final String TEXT_37 = " = (com.amazonaws.services.s3.AmazonS3Client)globalMap.get(\"";
  protected final String TEXT_38 = "\");" + NL + "\t\t";
  protected final String TEXT_39 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_40 = " - Get an free connection from \" + \"";
  protected final String TEXT_41 = "\" + \".\");" + NL + "\t\t";
  protected final String TEXT_42 = NL + "\t    ";
  protected final String TEXT_43 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_44 = " - Creating new connection.\");" + NL + "\t\t";
  protected final String TEXT_45 = NL + "    " + NL + "    \t\t";
  protected final String TEXT_46 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_47 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_48 = ");";
  protected final String TEXT_49 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_50 = " = ";
  protected final String TEXT_51 = "; ";
  protected final String TEXT_52 = NL + NL + "\t\t\tcom.amazonaws.auth.AWSCredentials credentials_";
  protected final String TEXT_53 = " = new com.amazonaws.auth.BasicAWSCredentials(";
  protected final String TEXT_54 = ",decryptedPassword_";
  protected final String TEXT_55 = ");" + NL + "\t\t\tcom.amazonaws.auth.AWSCredentialsProvider credentialsProvider_";
  protected final String TEXT_56 = " = new com.amazonaws.internal.StaticCredentialsProvider(credentials_";
  protected final String TEXT_57 = ");" + NL + "\t\t";
  protected final String TEXT_58 = NL + "\t\tcom.amazonaws.auth.AWSCredentialsProvider credentialsProvider_";
  protected final String TEXT_59 = " = new com.amazonaws.auth.InstanceProfileCredentialsProvider();" + NL + "\t\t";
  protected final String TEXT_60 = NL + "\t\t\tString masterKey_";
  protected final String TEXT_61 = " = ";
  protected final String TEXT_62 = "; " + NL + "\t\t\tjavax.crypto.spec.SecretKeySpec symmetricKey_";
  protected final String TEXT_63 = " = new javax.crypto.spec.SecretKeySpec(org.apache.commons.codec.binary.Base64.decodeBase64(masterKey_";
  protected final String TEXT_64 = ".getBytes(\"UTF-8\")), \"AES\");" + NL + "\t\t\tcom.amazonaws.services.s3.model.EncryptionMaterials encryptionMaterials_";
  protected final String TEXT_65 = " = new com.amazonaws.services.s3.model.EncryptionMaterials(symmetricKey_";
  protected final String TEXT_66 = ");" + NL + "\t\t\tcom.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider encryptionMaterialsProvider_";
  protected final String TEXT_67 = " = new com.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider(encryptionMaterials_";
  protected final String TEXT_68 = ");" + NL + "\t\t";
  protected final String TEXT_69 = NL + "\t\t\t";
  protected final String TEXT_70 = " " + NL + "\t\t\tfinal String kms_cmk_";
  protected final String TEXT_71 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_72 = ");" + NL + "\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\tfinal String kms_cmk_";
  protected final String TEXT_74 = " = ";
  protected final String TEXT_75 = "; " + NL + "\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t" + NL + "\t\t\tcom.amazonaws.services.s3.model.KMSEncryptionMaterialsProvider encryptionMaterialsProvider_";
  protected final String TEXT_77 = " = new com.amazonaws.services.s3.model.KMSEncryptionMaterialsProvider(kms_cmk_";
  protected final String TEXT_78 = ");" + NL + "\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\t";
  protected final String TEXT_80 = " " + NL + "\t\t\t\tfinal String smk_";
  protected final String TEXT_81 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_82 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\t\tfinal String smk_";
  protected final String TEXT_84 = " = ";
  protected final String TEXT_85 = "; " + NL + "\t\t\t\t";
  protected final String TEXT_86 = NL + "\t\t\t\t" + NL + "\t\t\t\tjavax.crypto.spec.SecretKeySpec symmetricKey_";
  protected final String TEXT_87 = " = new javax.crypto.spec.SecretKeySpec(org.apache.commons.codec.binary.Base64.decodeBase64(smk_";
  protected final String TEXT_88 = ".getBytes(\"UTF-8\")), \"AES\");" + NL + "\t\t\t\tcom.amazonaws.services.s3.model.EncryptionMaterials encryptionMaterials_";
  protected final String TEXT_89 = " = new com.amazonaws.services.s3.model.EncryptionMaterials(symmetricKey_";
  protected final String TEXT_90 = ");" + NL + "\t\t\t\tcom.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider encryptionMaterialsProvider_";
  protected final String TEXT_91 = " = new com.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider(encryptionMaterials_";
  protected final String TEXT_92 = ");" + NL + "\t\t\t";
  protected final String TEXT_93 = NL + "\t\t\t\tjava.io.File keyFile_";
  protected final String TEXT_94 = " = new java.io.File(";
  protected final String TEXT_95 = ");" + NL + "\t\t\t\tjava.io.FileInputStream keyfis_";
  protected final String TEXT_96 = " = null;" + NL + "\t\t\t\tjavax.crypto.spec.SecretKeySpec symmetricKey_";
  protected final String TEXT_97 = " = null;" + NL + "\t\t\t\ttry {" + NL + "\t\t\t        keyfis_";
  protected final String TEXT_98 = " = new java.io.FileInputStream(keyFile_";
  protected final String TEXT_99 = ");" + NL + "\t\t\t        byte[] encodedPrivateKey_";
  protected final String TEXT_100 = " = new byte[(int)keyFile_";
  protected final String TEXT_101 = ".length()];" + NL + "\t\t\t        keyfis_";
  protected final String TEXT_102 = ".read(encodedPrivateKey_";
  protected final String TEXT_103 = ");" + NL + "\t\t\t        symmetricKey_";
  protected final String TEXT_104 = " = new javax.crypto.spec.SecretKeySpec(encodedPrivateKey_";
  protected final String TEXT_105 = ", \"AES\");" + NL + "\t\t        } finally {" + NL + "\t\t        \tif(keyfis_";
  protected final String TEXT_106 = "!=null) {" + NL + "\t\t        \t\tkeyfis_";
  protected final String TEXT_107 = ".close();" + NL + "\t\t        \t}" + NL + "\t\t        }" + NL + "\t\t        " + NL + "\t\t        com.amazonaws.services.s3.model.EncryptionMaterials encryptionMaterials_";
  protected final String TEXT_108 = " = new com.amazonaws.services.s3.model.EncryptionMaterials(symmetricKey_";
  protected final String TEXT_109 = ");" + NL + "\t\t\t\tcom.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider encryptionMaterialsProvider_";
  protected final String TEXT_110 = " = new com.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider(encryptionMaterials_";
  protected final String TEXT_111 = ");" + NL + "\t\t\t";
  protected final String TEXT_112 = NL + "\t\t\tjava.io.File filePublicKey_";
  protected final String TEXT_113 = " = new java.io.File(";
  protected final String TEXT_114 = ");" + NL + "\t\t\tjava.io.FileInputStream fis_";
  protected final String TEXT_115 = " = null;" + NL + "\t\t\tbyte[] encodedPublicKey_";
  protected final String TEXT_116 = " = null;" + NL + "\t\t\ttry {" + NL + "\t\t        fis_";
  protected final String TEXT_117 = " = new java.io.FileInputStream(filePublicKey_";
  protected final String TEXT_118 = ");" + NL + "\t\t        encodedPublicKey_";
  protected final String TEXT_119 = " = new byte[(int) filePublicKey_";
  protected final String TEXT_120 = ".length()];" + NL + "\t\t        fis_";
  protected final String TEXT_121 = ".read(encodedPublicKey_";
  protected final String TEXT_122 = ");" + NL + "\t        } finally {" + NL + "\t        \tif(fis_";
  protected final String TEXT_123 = "!=null) {" + NL + "\t        \t\tfis_";
  protected final String TEXT_124 = ".close();" + NL + "\t        \t}" + NL + "\t        }" + NL + "\t" + NL + "\t        java.io.File filePrivateKey_";
  protected final String TEXT_125 = " = new java.io.File(";
  protected final String TEXT_126 = ");" + NL + "\t        byte[] encodedPrivateKey_";
  protected final String TEXT_127 = " = null;" + NL + "\t        try {" + NL + "\t\t        fis_";
  protected final String TEXT_128 = " = new java.io.FileInputStream(filePrivateKey_";
  protected final String TEXT_129 = ");" + NL + "\t\t        encodedPrivateKey_";
  protected final String TEXT_130 = " = new byte[(int) filePrivateKey_";
  protected final String TEXT_131 = ".length()];" + NL + "\t\t        fis_";
  protected final String TEXT_132 = ".read(encodedPrivateKey_";
  protected final String TEXT_133 = ");" + NL + "\t        } finally {" + NL + "\t        \tif(fis_";
  protected final String TEXT_134 = "!=null) {" + NL + "\t        \t\tfis_";
  protected final String TEXT_135 = ".close();" + NL + "\t        \t}" + NL + "\t        }" + NL + "\t" + NL + "\t        java.security.KeyFactory keyFactory_";
  protected final String TEXT_136 = " = java.security.KeyFactory.getInstance(\"";
  protected final String TEXT_137 = "\");" + NL + "\t        " + NL + "\t        java.security.spec.X509EncodedKeySpec publicKeySpec_";
  protected final String TEXT_138 = " = new java.security.spec.X509EncodedKeySpec(" + NL + "\t                encodedPublicKey_";
  protected final String TEXT_139 = ");" + NL + "\t        java.security.PublicKey publicKey_";
  protected final String TEXT_140 = " = keyFactory_";
  protected final String TEXT_141 = ".generatePublic(publicKeySpec_";
  protected final String TEXT_142 = ");" + NL + "\t" + NL + "\t        java.security.spec.PKCS8EncodedKeySpec privateKeySpec_";
  protected final String TEXT_143 = " = new java.security.spec.PKCS8EncodedKeySpec(" + NL + "\t                encodedPrivateKey_";
  protected final String TEXT_144 = ");" + NL + "\t        java.security.PrivateKey privateKey_";
  protected final String TEXT_145 = " = keyFactory_";
  protected final String TEXT_146 = ".generatePrivate(privateKeySpec_";
  protected final String TEXT_147 = ");" + NL + "\t" + NL + "\t        java.security.KeyPair asymmetricKey_";
  protected final String TEXT_148 = " = new java.security.KeyPair(publicKey_";
  protected final String TEXT_149 = ", privateKey_";
  protected final String TEXT_150 = ");" + NL + "\t        " + NL + "\t        com.amazonaws.services.s3.model.EncryptionMaterials encryptionMaterials_";
  protected final String TEXT_151 = " = new com.amazonaws.services.s3.model.EncryptionMaterials(asymmetricKey_";
  protected final String TEXT_152 = ");" + NL + "\t\t\tcom.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider encryptionMaterialsProvider_";
  protected final String TEXT_153 = " = new com.amazonaws.services.s3.model.StaticEncryptionMaterialsProvider(encryptionMaterials_";
  protected final String TEXT_154 = ");" + NL + "\t\t";
  protected final String TEXT_155 = NL + "\t\tcom.amazonaws.ClientConfiguration cc_";
  protected final String TEXT_156 = " = new com.amazonaws.ClientConfiguration();" + NL + "\t\t";
  protected final String TEXT_157 = NL + "\t\t\t\t\tint scketSendBufferSizeHints_";
  protected final String TEXT_158 = " = 0;" + NL + "\t\t\t\t\tint socketReceiveBufferSizeHints_";
  protected final String TEXT_159 = " = 0;" + NL + "\t\t\t\t";
  protected final String TEXT_160 = NL + "\t\t\t\t\tscketSendBufferSizeHints_";
  protected final String TEXT_161 = " = ";
  protected final String TEXT_162 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_163 = NL + "\t\t\t\t\tsocketReceiveBufferSizeHints_";
  protected final String TEXT_164 = " = ";
  protected final String TEXT_165 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_166 = NL + "\t\t\t\t\tcc_";
  protected final String TEXT_167 = ".setProtocol(com.amazonaws.Protocol.";
  protected final String TEXT_168 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_169 = NL + "\t\t\t\t\tcc_";
  protected final String TEXT_170 = ".set";
  protected final String TEXT_171 = "(";
  protected final String TEXT_172 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_173 = NL + "\t\t\t\tcc_";
  protected final String TEXT_174 = ".setSocketBufferSizeHints(scketSendBufferSizeHints_";
  protected final String TEXT_175 = ",socketReceiveBufferSizeHints_";
  protected final String TEXT_176 = ");" + NL + "\t\t\t";
  protected final String TEXT_177 = NL + "\t\t\tint sessionDurationSeconds_";
  protected final String TEXT_178 = " = ";
  protected final String TEXT_179 = " * 60;" + NL + "\t\t\tcom.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider.Builder stsBuilder_";
  protected final String TEXT_180 = " = " + NL + "\t\t\t\t\tnew com.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider.Builder(";
  protected final String TEXT_181 = ", ";
  protected final String TEXT_182 = ").withLongLivedCredentialsProvider(credentialsProvider_";
  protected final String TEXT_183 = ")" + NL + "\t\t\t\t\t.withRoleSessionDurationSeconds(sessionDurationSeconds_";
  protected final String TEXT_184 = ");" + NL + "\t\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_185 = NL + "\t\t\t\tstsBuilder_";
  protected final String TEXT_186 = ".withServiceEndpoint(";
  protected final String TEXT_187 = ");" + NL + "\t\t\t";
  protected final String TEXT_188 = NL + "\t\t\t\tstsBuilder_";
  protected final String TEXT_189 = ".withClientConfiguration(cc_";
  protected final String TEXT_190 = ");" + NL + "\t\t\t";
  protected final String TEXT_191 = NL + "\t\t\t" + NL + "\t\t\tcredentialsProvider_";
  protected final String TEXT_192 = " = stsBuilder_";
  protected final String TEXT_193 = ".build();" + NL + "\t\t\t" + NL + "\t\t";
  protected final String TEXT_194 = NL + "\t\t\t\tcom.amazonaws.services.s3.AmazonS3Client conn_";
  protected final String TEXT_195 = " = new com.amazonaws.services.s3.AmazonS3EncryptionClient(" + NL + "\t\t\t\t\tcredentialsProvider_";
  protected final String TEXT_196 = "," + NL + "\t\t\t\t\tencryptionMaterialsProvider_";
  protected final String TEXT_197 = ", " + NL + "\t\t\t\t\tcc_";
  protected final String TEXT_198 = "," + NL + "\t\t\t\t\tnew com.amazonaws.services.s3.model.CryptoConfiguration()" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_199 = NL + "\t\t\t\t\t\t.withAwsKmsRegion(com.amazonaws.regions.RegionUtils.getRegion(";
  protected final String TEXT_200 = "))" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_201 = NL + "\t\t\t\t);" + NL + "\t\t\t";
  protected final String TEXT_202 = NL + "\t\t\t\tcom.amazonaws.services.s3.AmazonS3Client conn_";
  protected final String TEXT_203 = " = new com.amazonaws.services.s3.AmazonS3Client(" + NL + "\t\t\t\t\tcredentialsProvider_";
  protected final String TEXT_204 = "," + NL + "\t\t\t\t\tcc_";
  protected final String TEXT_205 = NL + "\t\t\t\t);" + NL + "\t\t\t";
  protected final String TEXT_206 = NL + "\t\t\tconn_";
  protected final String TEXT_207 = ".setRegion(com.amazonaws.regions.RegionUtils.getRegion(";
  protected final String TEXT_208 = "));" + NL + "\t\t";
  protected final String TEXT_209 = "\t" + NL + "\t\t\tlog.info(\"";
  protected final String TEXT_210 = " - Creating new connection successfully.\");" + NL + "\t\t";
  protected final String TEXT_211 = NL + "\t\ttry{" + NL + "\t\t\t";
  protected final String TEXT_212 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_213 = " - Uploading an object with key:\" + ";
  protected final String TEXT_214 = ");" + NL + "\t\t\t";
  protected final String TEXT_215 = NL + "\t\t\tconn_";
  protected final String TEXT_216 = ".putObject(";
  protected final String TEXT_217 = ", ";
  protected final String TEXT_218 = ", file_";
  protected final String TEXT_219 = ");" + NL + "\t\t\t";
  protected final String TEXT_220 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_221 = " - Upload the object successfully.\");" + NL + "\t\t\t";
  protected final String TEXT_222 = NL + "\t\t} finally {" + NL + "\t\t\tif(conn_";
  protected final String TEXT_223 = " !=null){" + NL + "\t\t\t\tconn_";
  protected final String TEXT_224 = ".shutdown();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t} else {";
  protected final String TEXT_225 = NL + "\t\tlog.error(\"";
  protected final String TEXT_226 = " - \" + \"file doesn't exist or content is empty.\");";
  protected final String TEXT_227 = NL + "\t\tSystem.err.println(\"file doesn't exist or content is empty.\");" + NL + "\t}";
  protected final String TEXT_228 = NL + "\tif(file_";
  protected final String TEXT_229 = ".exists()) {" + NL + "\t\tfile_";
  protected final String TEXT_230 = ".delete();" + NL + "\t}";
  protected final String TEXT_231 = NL + "\tresourceMap.put(\"finish_";
  protected final String TEXT_232 = "\", true);";
  protected final String TEXT_233 = NL;

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

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    
	log4jFileUtil.writeDataFinishInfo(node);
	
	//upload the bulk data file to amazon s3
    String bucket = ElementParameterParser.getValue(node,"__BUCKET__");
    String key = ElementParameterParser.getValue(node,"__KEY__");
    String file = ElementParameterParser.getValue(node,"__FILE__");
	
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	
	String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");

	boolean configClient = "true".equals(ElementParameterParser.getValue(node, "__CONFIG_CLIENT__"));
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
	List<Map<String,String>> clientConfiguration = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__CLIENT_CONFIGURATION__");
	String region = ElementParameterParser.getValue(node,"__REGION__");
	
	boolean assumeRole = "true".equals(ElementParameterParser.getValue(node, "__ASSUME_ROLE__"));
	String arn = ElementParameterParser.getValue(node,"__ARN__");
	String roleSessionName = ElementParameterParser.getValue(node,"__ROLE_SESSION_NAME__");
	
	boolean setStsEndpoint = "true".equals(ElementParameterParser.getValue(node,"__SET_STS_ENDPOINT__"));
	String stsEndpoint = ElementParameterParser.getValue(node,"__STS_ENDPOINT__");
	
	String sessionDuration = ElementParameterParser.getValue(node,"__SESSION_DURATION__");
	if(sessionDuration == null || sessionDuration.isEmpty()) {
		sessionDuration = "15";
	}
	
	boolean set_region = (region!=null && !region.isEmpty() && !"DEFAULT".equalsIgnoreCase(region));
	
	if(("true").equals(useExistingConn)) {
		String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		String conn = "conn_" + connection;;
		
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_38);
    
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_41);
    
		}
	}else{
	
    stringBuffer.append(TEXT_42);
    
	    if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
		}
		
		boolean inherit_credentials = "true".equals(ElementParameterParser.getValue(node, "__INHERIT_CREDENTIALS__"));
		if(!inherit_credentials) {
	    	String passwordFieldName = "__SECRET_KEY__";
	    	
    stringBuffer.append(TEXT_45);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_48);
    } else {
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_51);
    }
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
		} else {
		
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
		}
		
		boolean encrypt = "true".equals(ElementParameterParser.getValue(node,"__ENCRYPT__"));
		
		//work for tRedshiftOutputBulk
		String encrypted_key = ElementParameterParser.getValue(node,"__ENCRYPTED_KEY__");
		
		//work for s3 components
		String key_type = ElementParameterParser.getValue(node,"__KEY_TYPE__");
		String algorithm_symmetric_master_key = ElementParameterParser.getValue(node,"__ALGORITHM_SYMMETRIC_MASTER_KEY__");
		String algorithm_asymmetric_master_key = ElementParameterParser.getValue(node,"__ALGORITHM_ASYMMETRIC_MASTER_KEY__");
		String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
		
		String encrypted_key_x509 = ElementParameterParser.getValue(node,"__ENCRYPTED_KEY_X509__");
		String public_key = ElementParameterParser.getValue(node,"__PUBLIC_KEY__");
		String private_key = ElementParameterParser.getValue(node,"__PRIVATE_KEY__");
		
		if(encrypt && cid.startsWith("tRedshift")) {
		
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(encrypted_key);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    
		} else if(encrypt && "KMS_CMK".equals(key_type)) {//KMS
		
    stringBuffer.append(TEXT_69);
    if (ElementParameterParser.canEncrypt(node, "__ENCRYPTED_KEY_CMK__")) {
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, "__ENCRYPTED_KEY_CMK__"));
    stringBuffer.append(TEXT_72);
    } else {
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append( ElementParameterParser.getValue(node, "__ENCRYPTED_KEY_CMK__"));
    stringBuffer.append(TEXT_75);
    }
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    
		} else if(encrypt && "SYMMETRIC_MASTER_KEY".equals(key_type)) {//symmetric master key
			if("AES".equals(algorithm_symmetric_master_key) && "BASE64".equals(encoding)) {
			
    stringBuffer.append(TEXT_79);
    if (ElementParameterParser.canEncrypt(node, "__ENCRYPTED_KEY_BASE64__")) {
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, "__ENCRYPTED_KEY_BASE64__"));
    stringBuffer.append(TEXT_82);
    } else {
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append( ElementParameterParser.getValue(node, "__ENCRYPTED_KEY_BASE64__"));
    stringBuffer.append(TEXT_85);
    }
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    
			} else if("AES".equals(algorithm_symmetric_master_key) && "X509".equals(encoding)) {
			
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(encrypted_key_x509);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
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
    
			}
		} else if(encrypt && "ASYMMETRIC_MASTER_KEY".equals(key_type)) {//asymmetric master key
		
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(public_key);
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
    stringBuffer.append(private_key);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
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
    stringBuffer.append(algorithm_asymmetric_master_key);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    
		}
		
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    
		boolean configClientPresent = false;
		if(configClient && clientConfiguration.size()>0){
			configClientPresent = true;
			boolean setBuffer = false;
			for(Map<String,String> map :clientConfiguration){
				String client_parameter = map.get("CLIENT_PARAMETER");
				String value = map.get("VALUE");
				if(!setBuffer && ("SocketSendBufferSizeHints".equals(client_parameter) || "SocketReceiveBufferSizeHints".equals(client_parameter))){
					setBuffer=true;
					
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    
				}
				if("SocketSendBufferSizeHints".equals(client_parameter)){
				
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_162);
    
				}else if("SocketReceiveBufferSizeHints".equals(client_parameter)){
				
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_165);
    
				}else if("Protocol".equals(client_parameter)){
				
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(value.toUpperCase().replaceAll("\"",""));
    stringBuffer.append(TEXT_168);
    
				}else{
				
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(client_parameter);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_172);
    
				}
			}
			if(setBuffer){
			
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    
			}
			
		}
		
		if(assumeRole) {
		
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(sessionDuration);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(arn);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(roleSessionName);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    
			if(setStsEndpoint) {
			
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(stsEndpoint);
    stringBuffer.append(TEXT_187);
    
			}
			
			if(configClientPresent) {
			
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    
			}
			
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    
		}
			if(encrypt) {
			
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    if("KMS_CMK".equals(key_type) && set_region) {
    stringBuffer.append(TEXT_199);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_200);
    }
    stringBuffer.append(TEXT_201);
    
			} else {
			
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    
			}
		if(set_region){
		
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_208);
    
		}
		if(isLog4jEnabled){
		
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    
		}
	}
	
    stringBuffer.append(TEXT_211);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_214);
    
			}
			
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(bucket);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(key);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    
			}
			
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    
		if(isLog4jEnabled){

    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    
		}

    stringBuffer.append(TEXT_227);
    
	boolean delete = "true".equals(ElementParameterParser.getValue(node,"__DELETE_LOCALFILE__"));
	if(delete) {

    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_230);
    
	}

    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(TEXT_233);
    return stringBuffer.toString();
  }
}
