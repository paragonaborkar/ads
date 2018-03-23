package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TFileOutputLDIFBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputLDIFBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputLDIFBeginJava result = new TFileOutputLDIFBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
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
  protected final String TEXT_30 = NL;
  protected final String TEXT_31 = NL + NL + "java.io.File file_";
  protected final String TEXT_32 = " = new java.io.File(";
  protected final String TEXT_33 = ");" + NL + "boolean isFileGenerated_";
  protected final String TEXT_34 = " = true;";
  protected final String TEXT_35 = NL + "if(file_";
  protected final String TEXT_36 = ".exists()){" + NL + "  isFileGenerated_";
  protected final String TEXT_37 = " = false;" + NL + "}";
  protected final String TEXT_38 = NL + " //create directory only if not exists" + NL + " java.io.File parentFile_";
  protected final String TEXT_39 = " = file_";
  protected final String TEXT_40 = ".getParentFile();" + NL + "  if(parentFile_";
  protected final String TEXT_41 = " != null && !parentFile_";
  protected final String TEXT_42 = ".exists()) {" + NL + "     parentFile_";
  protected final String TEXT_43 = ".mkdirs();" + NL + "  }";
  protected final String TEXT_44 = NL + "        class Util_";
  protected final String TEXT_45 = NL + "            {" + NL + "                public void breakString( StringBuilder pw, String value, int max) {" + NL + "                    int leftToGo = value.length();" + NL + "                    int written = 0;" + NL + "                    int maxChars = max;" + NL + "                    while( leftToGo > 0 ) {" + NL + "                        int toWrite = Math.min( maxChars, leftToGo );" + NL + "                        String s = value.substring( written, written+toWrite);" + NL + "                        if ( written != 0 ) {" + NL + "                          pw.append( \" \" + s );" + NL + "                        } else {" + NL + "                          pw.append( s );" + NL + "                            maxChars -= 1;" + NL + "                        }" + NL + "                        written += toWrite;" + NL + "                        leftToGo -= toWrite;" + NL + "                        pw.append( '\\n' );" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                public String getBase64StringOrNot(boolean encodingBase64,String srcData,String encoding){" + NL + "                  String returnValue = \"\";" + NL + "                  try {" + NL + "                        if(encodingBase64 ";
  protected final String TEXT_46 = NL + "                                      && !netscape.ldap.util.LDIF.isPrintable(srcData.getBytes(encoding))";
  protected final String TEXT_47 = NL + "                                         && needEncodeBase64(srcData)";
  protected final String TEXT_48 = "){" + NL + "                                returnValue = \":: \" + org.apache.commons.codec.binary.Base64.encodeBase64String(srcData.getBytes(encoding));" + NL + "                            }else{" + NL + "                                returnValue = \": \" + srcData;" + NL + "                            }" + NL + "                      }catch(java.lang.Exception e){" + NL + "                        e.printStackTrace();" + NL + "                      }" + NL + "                                return returnValue;" + NL + "                }" + NL + "" + NL + "            //Feature: TDI-31864" + NL + "            public boolean isSafeUTF8String(String distinguishedName){" + NL + "                    boolean isSafeString = true;" + NL + "                            isSafeString = !distinguishedName.startsWith(\"#\")" + NL + "                                        && !distinguishedName.startsWith(\" \")" + NL + "                                        && !distinguishedName.endsWith(\" \")" + NL + "                                        && !distinguishedName.endsWith(\"\\t\");" + NL + "" + NL + "                            if(!isSafeString){" + NL + "                                return isSafeString;" + NL + "                            }" + NL + "" + NL + "                            String[] unsafeCharactersArr = new String[]{" + NL + "                                    \",\", \"+\", \"\\\"\", \"\\\\\", \"<\", \">\", \";\"" + NL + "                            };" + NL + "" + NL + "                            for(String str: unsafeCharactersArr){" + NL + "                                isSafeString = isSafeString && !distinguishedName.contains(str);" + NL + "                                if(!isSafeString){" + NL + "                                    break;" + NL + "                                }" + NL + "                            }" + NL + "" + NL + "                     return isSafeString;" + NL + "                }" + NL + "" + NL + "                /*" + NL + "                 * NUL ==> \\0 ==> 0" + NL + "                 * LF  ==> \\n ==> 10" + NL + "                 * CR  ==> \\r ==> 13" + NL + "                 *         \\t ==> 9" + NL + "                 * SP  ==>    ==> 32" + NL + "                 * colon ==> : ==> 58" + NL + "                 * < ==> 60" + NL + "                 * reference: https://www.ietf.org/rfc/rfc2849.txt" + NL + "                 */" + NL + "" + NL + "                public boolean consistOfSafeCharacters(byte[] bytArr){" + NL + "                       boolean consistOfSafeCharacters = true;" + NL + "                       for(int i=0; i < bytArr.length; i++){" + NL + "                           if(i==0){" + NL + "                               consistOfSafeCharacters =" + NL + "                                         ((bytArr[0] > 0) && (bytArr[0] <= 127))" + NL + "                                      && (bytArr[0] != 10)" + NL + "                                      && (bytArr[0] != 13)" + NL + "                                      && (bytArr[0] != 32)" + NL + "                                      && (bytArr[0] != 58)" + NL + "                                      && (bytArr[0] != 60)" + NL + "                                     ;" + NL + "                           }else{" + NL + "                               consistOfSafeCharacters =" + NL + "                                    consistOfSafeCharacters &&" + NL + "                                    (" + NL + "                                         ((bytArr[i] > 0) && (bytArr[i] <= 127))" + NL + "                                       && (bytArr[i] != 10)" + NL + "                                       && (bytArr[i] != 13)" + NL + "                                    );" + NL + "                           }" + NL + "                           if(!consistOfSafeCharacters){" + NL + "                               return consistOfSafeCharacters;" + NL + "                           }" + NL + "                       }" + NL + "                       return consistOfSafeCharacters;" + NL + "                }" + NL + "" + NL + "                public boolean needEncodeBase64(String distinguishedName){" + NL + "                    byte[] bytArr = null;" + NL + "                           try{" + NL + "                               bytArr = distinguishedName.getBytes(";
  protected final String TEXT_49 = ");" + NL + "                           }catch(java.io.UnsupportedEncodingException e){" + NL + "                                throw new RuntimeException(e);" + NL + "                           }" + NL + "                    return !isSafeUTF8String(distinguishedName) || !consistOfSafeCharacters(bytArr);" + NL + "                }" + NL + "" + NL + "                public boolean asciiCharactersOnly(String str){" + NL + "                       char[] charArr = str.toCharArray();" + NL + "                       for(char x: charArr){" + NL + "                                if(x < 0 || x > 127){" + NL + "                                    return false;" + NL + "                                }" + NL + "                            }" + NL + "                       return true;" + NL + "                }" + NL + "" + NL + "                //Reference: http://www.ietf.org/rfc/rfc2253.txt" + NL + "                public boolean needBase64ForDN(String dn){" + NL + "                    if(!asciiCharactersOnly(dn)){" + NL + "                        return true;" + NL + "                    }" + NL + "" + NL + "                    String[] splitByComma = dn.replace(\"\\\\,\", \"\").split(\",\");" + NL + "                    for(String str: splitByComma){" + NL + "                        String[] splitByPlus = str.replace(\"\\\\+\", \"\").split(\"\\\\+\");" + NL + "                        for(String strX: splitByPlus){" + NL + "                            String[] splitByEquals = strX.replace(\"\\\\=\", \"\").split(\"=\");" + NL + "                            if(!isValidAttributeType(splitByEquals[0].trim())){" + NL + "                                return true;" + NL + "                            }" + NL + "                            if(!isValidAttributeValue(splitByEquals[1])){" + NL + "                                return true;" + NL + "                            }" + NL + "                        }" + NL + "                    }" + NL + "                    return false;" + NL + "                   }" + NL + "" + NL + "             public boolean isValidAttributeType(String attributeType){" + NL + "                return attributeType.matches(\"^([A-Za-z][A-Za-z0-9\\\\-]+)|(\\\\d+(.\\\\d+)*)$\");" + NL + "             }" + NL + "" + NL + "             public  boolean isValidAttributeValue(String attriValue){" + NL + "                if(attriValue.equals(\"\")){" + NL + "                    return true;" + NL + "                }" + NL + "                if(attriValue.startsWith(\" \")){" + NL + "                    return false;" + NL + "                }" + NL + "                if(attriValue.endsWith(\" \") && !attriValue.endsWith(\"\\\\ \")){" + NL + "                    return false;" + NL + "                }" + NL + "                if(attriValue.startsWith(\"\\\\ \")){" + NL + "                  attriValue = attriValue.substring(2,attriValue.length());" + NL + "                }" + NL + "                if(attriValue.endsWith(\"\\\\ \")){" + NL + "                    attriValue = attriValue.substring(0,attriValue.length()-2);" + NL + "                }" + NL + "                return attriValue.matches(\"^(#([0-9A-Fa-f]{2})+)|(\\\"(([^\\\"\\\\\\\\])|(\\\\\\\\([\\\\\\\\,=+<>#;\\\"]|[0-9A-Fa-f]{2})))*\\\")|([^\\\\\\\\,=+<>#;\\\"]|(\\\\\\\\([\\\\\\\\,=+<>#;\\\"]|[0-9A-Fa-f]{2})))+$\");" + NL + "             }" + NL + "" + NL + "    }" + NL + "" + NL + "    Util_";
  protected final String TEXT_50 = " util_";
  protected final String TEXT_51 = " = new Util_";
  protected final String TEXT_52 = "();" + NL + "" + NL + "    int nb_line_";
  protected final String TEXT_53 = " = 0;" + NL + "    String dn_";
  protected final String TEXT_54 = " = \"dn: \";" + NL + "    final String changetype_";
  protected final String TEXT_55 = " = \"changetype: \";" + NL + "    final int wrap_";
  protected final String TEXT_56 = " = ";
  protected final String TEXT_57 = ";";
  protected final String TEXT_58 = NL + "        java.io.PrintWriter pw_";
  protected final String TEXT_59 = " = new java.io.PrintWriter(file_";
  protected final String TEXT_60 = ", ";
  protected final String TEXT_61 = ");";
  protected final String TEXT_62 = NL + "    java.io.PrintWriter pw_";
  protected final String TEXT_63 = " = new java.io.PrintWriter" + NL + "                    (new java.io.BufferedWriter" + NL + "                    (new java.io.OutputStreamWriter" + NL + "                    (new java.io.FileOutputStream" + NL + "                    (file_";
  protected final String TEXT_64 = ",true),";
  protected final String TEXT_65 = ")),false);";
  protected final String TEXT_66 = NL + NL + "if(file_";
  protected final String TEXT_67 = ".length()==0){" + NL + "  pw_";
  protected final String TEXT_68 = ".write(\"version: 1\\n\");" + NL + "}";
  protected final String TEXT_69 = NL;

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
    boolean willValidateDN = "true".equals(ElementParameterParser.getValue(node,"__VALIDATE_DISTINGUISHED_NAME__"));
    String cid = node.getUniqueName();
    String wrap = ElementParameterParser.getValue(node, "__WRAP__");
    String filename = ElementParameterParser.getValue(node, "__FILENAME__");
    String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
    boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));

    log4jFileUtil.componentStartInfo(node);

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    
    if(isAppend){

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    
    }
if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    }
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    
                              if(!willValidateDN){
                                   
    stringBuffer.append(TEXT_46);
    
                                }else{
                                      
    stringBuffer.append(TEXT_47);
    
                                }
                         
    stringBuffer.append(TEXT_48);
    stringBuffer.append( encoding );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(wrap );
    stringBuffer.append(TEXT_57);
    if(!isAppend){
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append( encoding);
    stringBuffer.append(TEXT_61);
    }else{
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append( encoding);
    stringBuffer.append(TEXT_65);
    }
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(TEXT_69);
    return stringBuffer.toString();
  }
}
