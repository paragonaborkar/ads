package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TFileOutputARFFBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputARFFBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputARFFBeginJava result = new TFileOutputARFFBeginJava();
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
  protected final String TEXT_31 = "        " + NL + " int nb_line_";
  protected final String TEXT_32 = " = 0;" + NL + " int splitedFileNo_";
  protected final String TEXT_33 = " =0;" + NL + " int currentRow_";
  protected final String TEXT_34 = " = 0;" + NL + " double vals";
  protected final String TEXT_35 = "[];" + NL + " String fileNewName_";
  protected final String TEXT_36 = " = ";
  protected final String TEXT_37 = ";" + NL + " java.io.File createFile";
  protected final String TEXT_38 = " = new java.io.File(fileNewName_";
  protected final String TEXT_39 = ");" + NL + " boolean isFileGenerated_";
  protected final String TEXT_40 = " = true;";
  protected final String TEXT_41 = NL + "if(createFile";
  protected final String TEXT_42 = ".exists()){" + NL + "\tisFileGenerated_";
  protected final String TEXT_43 = " = false;" + NL + "}";
  protected final String TEXT_44 = NL + "\t \t//create directory only if not exists" + NL + "" + NL + "\t\tjava.io.File parentFile_";
  protected final String TEXT_45 = " = createFile";
  protected final String TEXT_46 = ".getParentFile();" + NL + "\t\tif(parentFile_";
  protected final String TEXT_47 = " != null && !parentFile_";
  protected final String TEXT_48 = ".exists()) {" + NL + "\t\t\tparentFile_";
  protected final String TEXT_49 = ".mkdirs();" + NL + "\t\t}";
  protected final String TEXT_50 = NL + "       //initialize nominal array" + NL + "      weka.core.FastVector classValues";
  protected final String TEXT_51 = ";" + NL + "      String nom";
  protected final String TEXT_52 = "[] = ";
  protected final String TEXT_53 = ".split(\",\");" + NL + "      classValues";
  protected final String TEXT_54 = " = new weka.core.FastVector(nom";
  protected final String TEXT_55 = ".length);" + NL + "      for(int j=0;j<nom";
  protected final String TEXT_56 = ".length;j++){" + NL + "          classValues";
  protected final String TEXT_57 = ".addElement(nom";
  protected final String TEXT_58 = "[j]);" + NL + "      }";
  protected final String TEXT_59 = NL + "   \t\tString[] headColu";
  protected final String TEXT_60 = "=new String[";
  protected final String TEXT_61 = "];\t" + NL + "   \t\tcreateFile";
  protected final String TEXT_62 = ".createNewFile();" + NL + "   \t\tweka.core.Instances data";
  protected final String TEXT_63 = ";" + NL + "   \t\tweka.core.Instances m_Data";
  protected final String TEXT_64 = ";" + NL + "   \t\t";
  protected final String TEXT_65 = NL + "   \t\t java.io.BufferedReader buf_Read_";
  protected final String TEXT_66 = " =null;" + NL + "   \t\t try{" + NL + "             //read existing Instances" + NL + "            buf_Read_";
  protected final String TEXT_67 = " = new java.io.BufferedReader(new java.io.FileReader(fileNewName_";
  protected final String TEXT_68 = "));" + NL + "   \t\t    m_Data";
  protected final String TEXT_69 = " = new weka.core.Instances(buf_Read_";
  protected final String TEXT_70 = ");" + NL + "         }catch(java.lang.Exception e){" + NL + "               // Create vector of attributes." + NL + "               int numAtts";
  protected final String TEXT_71 = "=";
  protected final String TEXT_72 = ";" + NL + "               weka.core.FastVector attributes";
  protected final String TEXT_73 = " = new weka.core.FastVector(numAtts";
  protected final String TEXT_74 = ");";
  protected final String TEXT_75 = NL + "                      //A String attribute" + NL + "                      attributes";
  protected final String TEXT_76 = ".addElement(new weka.core.Attribute(\"";
  protected final String TEXT_77 = "\", (weka.core.FastVector) null));";
  protected final String TEXT_78 = NL + "                      //A Numeric attribute" + NL + "                      attributes";
  protected final String TEXT_79 = ".addElement(new weka.core.Attribute(\"";
  protected final String TEXT_80 = "\"));";
  protected final String TEXT_81 = NL + "                      //A Date attribute" + NL + "                      attributes";
  protected final String TEXT_82 = ".addElement(new weka.core.Attribute(\"";
  protected final String TEXT_83 = "\", ";
  protected final String TEXT_84 = "));";
  protected final String TEXT_85 = NL + "                      //A Nominal attribute" + NL + "                      attributes";
  protected final String TEXT_86 = ".addElement(new weka.core.Attribute(\"";
  protected final String TEXT_87 = "\", classValues";
  protected final String TEXT_88 = "));";
  protected final String TEXT_89 = NL + "            //Create a new Instances" + NL + "             m_Data";
  protected final String TEXT_90 = " = new weka.core.Instances(";
  protected final String TEXT_91 = ", attributes";
  protected final String TEXT_92 = ", 100);" + NL + "             m_Data";
  protected final String TEXT_93 = ".setClassIndex(m_Data";
  protected final String TEXT_94 = ".numAttributes() - 1);" + NL + "        }";
  protected final String TEXT_95 = NL + "        int numAtts";
  protected final String TEXT_96 = "=";
  protected final String TEXT_97 = ";" + NL + "        weka.core.FastVector attributes";
  protected final String TEXT_98 = " = new weka.core.FastVector(numAtts";
  protected final String TEXT_99 = ");";
  protected final String TEXT_100 = NL + "               //A String attribute" + NL + "               attributes";
  protected final String TEXT_101 = ".addElement(new weka.core.Attribute(\"";
  protected final String TEXT_102 = "\", (weka.core.FastVector) null));";
  protected final String TEXT_103 = NL + "               //A Numeric attribute" + NL + "               attributes";
  protected final String TEXT_104 = ".addElement(new weka.core.Attribute(\"";
  protected final String TEXT_105 = "\"));";
  protected final String TEXT_106 = NL + "               //A Date attribute" + NL + "               attributes";
  protected final String TEXT_107 = ".addElement(new weka.core.Attribute(\"";
  protected final String TEXT_108 = "\", ";
  protected final String TEXT_109 = "));";
  protected final String TEXT_110 = NL + "               //A Nominal attribute" + NL + "               attributes";
  protected final String TEXT_111 = ".addElement(new weka.core.Attribute(\"";
  protected final String TEXT_112 = "\", classValues";
  protected final String TEXT_113 = "));";
  protected final String TEXT_114 = NL + "            //Create a new Instances" + NL + "            m_Data";
  protected final String TEXT_115 = " = new weka.core.Instances(";
  protected final String TEXT_116 = ", attributes";
  protected final String TEXT_117 = ", 100);" + NL + "            m_Data";
  protected final String TEXT_118 = ".setClassIndex(m_Data";
  protected final String TEXT_119 = ".numAttributes() - 1);";
  protected final String TEXT_120 = NL + NL + "int oldInsNum";
  protected final String TEXT_121 = "=m_Data";
  protected final String TEXT_122 = ".numInstances();" + NL + "    " + NL;
  protected final String TEXT_123 = NL + NL + NL + NL + "   " + NL + NL + NL;
  protected final String TEXT_124 = NL;

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
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
     	String cid = node.getUniqueName();
        String filename = ElementParameterParser.getValue(node,"__FILENAME__");
	    boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));
	    List<Map<String, String>> colDef = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__COLDEFINE__");
	    String relation = ElementParameterParser.getValue(node,"__RELATION__");
	    
        log4jFileUtil.componentStartInfo(node);
 
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
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    
   	if(isAppend){

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    
	}
   	if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
	}

    List<IMetadataColumn> columns = metadata.getListColumns();
    	int sizeColumns = columns.size();
    	
    
    for(int i=0;i<colDef.size();i++){
        if(("Nominal").equals(colDef.get(i).get("TYPE"))){

    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(colDef.get(i).get("PATTERN"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_58);
      
        }
    }
   
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    if(isAppend){
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
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
    stringBuffer.append(colDef.size());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
                int attIndex=0;
               for(Map<String, String> colD:colDef){
                  if(("String").equals(colD.get("TYPE"))){
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(columns.get(attIndex).getLabel());
    stringBuffer.append(TEXT_77);
                    }else if(("Numeric").equals(colD.get("TYPE"))){
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(columns.get(attIndex).getLabel());
    stringBuffer.append(TEXT_80);
                    }else if(("Date").equals(colD.get("TYPE"))){
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(columns.get(attIndex).getLabel());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(colD.get("PATTERN"));
    stringBuffer.append(TEXT_84);
                    }else if(("Nominal").equals(colD.get("TYPE"))){
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(columns.get(attIndex).getLabel());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(attIndex);
    stringBuffer.append(TEXT_88);
                    }
                  attIndex++;
               }
 
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(relation);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
           }else{
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(colDef.size());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
          int attIndex=0;
        for(Map<String, String> colD:colDef){//for 1
           if(("String").equals(colD.get("TYPE"))){
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(columns.get(attIndex).getLabel());
    stringBuffer.append(TEXT_102);
             }else if(("Numeric").equals(colD.get("TYPE"))){
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(columns.get(attIndex).getLabel());
    stringBuffer.append(TEXT_105);
             }else if(("Date").equals(colD.get("TYPE"))){
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(columns.get(attIndex).getLabel());
    stringBuffer.append(TEXT_108);
    stringBuffer.append(colD.get("PATTERN"));
    stringBuffer.append(TEXT_109);
             }else if(("Nominal").equals(colD.get("TYPE"))){
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(columns.get(attIndex).getLabel());
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(attIndex);
    stringBuffer.append(TEXT_113);
             }
           attIndex++;
        }//for 1

    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(relation);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
      	}
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
        	}
    }

    stringBuffer.append(TEXT_123);
    stringBuffer.append(TEXT_124);
    return stringBuffer.toString();
  }
}
