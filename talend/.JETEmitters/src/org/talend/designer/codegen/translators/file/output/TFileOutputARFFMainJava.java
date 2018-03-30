package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TFileOutputARFFMainJava
{
  protected static String nl;
  public static synchronized TFileOutputARFFMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputARFFMainJava result = new TFileOutputARFFMainJava();
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
  protected final String TEXT_31 = NL + "        vals";
  protected final String TEXT_32 = "=new double[m_Data";
  protected final String TEXT_33 = ".numAttributes()];" + NL + "        weka.core.Instance instt";
  protected final String TEXT_34 = ";";
  protected final String TEXT_35 = NL + "                                    //insert String value" + NL + "                                    vals";
  protected final String TEXT_36 = "[";
  protected final String TEXT_37 = "]=m_Data";
  protected final String TEXT_38 = ".attribute(";
  protected final String TEXT_39 = ").addStringValue(";
  protected final String TEXT_40 = ".";
  protected final String TEXT_41 = ");";
  protected final String TEXT_42 = NL + "                                    //insert Numeric value" + NL + "                                    vals";
  protected final String TEXT_43 = "[";
  protected final String TEXT_44 = "]=";
  protected final String TEXT_45 = ".";
  protected final String TEXT_46 = ";";
  protected final String TEXT_47 = NL + "                                    //insert Date value" + NL + "                                    vals";
  protected final String TEXT_48 = "[";
  protected final String TEXT_49 = "]=m_Data";
  protected final String TEXT_50 = ".attribute(";
  protected final String TEXT_51 = ").parseDate(new java.text.SimpleDateFormat(";
  protected final String TEXT_52 = ").format(";
  protected final String TEXT_53 = ".";
  protected final String TEXT_54 = "));";
  protected final String TEXT_55 = NL + "                                    //insert Nominal value          " + NL + "                                    vals";
  protected final String TEXT_56 = "[";
  protected final String TEXT_57 = "]=classValues";
  protected final String TEXT_58 = ".indexOf(";
  protected final String TEXT_59 = ".";
  protected final String TEXT_60 = ");";
  protected final String TEXT_61 = "  " + NL + "             instt";
  protected final String TEXT_62 = "=new weka.core.Instance(1.0,vals";
  protected final String TEXT_63 = ");" + NL + "             m_Data";
  protected final String TEXT_64 = ".add(instt";
  protected final String TEXT_65 = ");\t\t\t";
  protected final String TEXT_66 = NL + "        " + NL + "        nb_line_";
  protected final String TEXT_67 = "++;     " + NL + "        " + NL + "        ";
  protected final String TEXT_68 = NL;

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
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	List<IMetadataColumn> columnList;

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
    	//get data from IncomingConnections
        for (IConnection conn : conns) {
            if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                INode inNode=conn.getSource();
                List<IMetadataTable> inMetaTables=inNode.getMetadataList();           
                if(inMetaTables !=null && inMetaTables.size()>0){
                    IMetadataTable inMetaTable=inMetaTables.get(0);
                    if(inMetaTable != null){
                        columnList = inMetaTable.getListColumns();
                int colNum=0;
                //for(Map<String, String> colD:colDef){
                        for(IMetadataColumn column:columnList){
                           // if(colDef.get(colNum).get("REFCOL").equals(column.getLabel())){
                                if(("String").equals(colDef.get(colNum).get("TYPE"))){
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(colNum);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(colNum);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_41);
                        }else if(("Numeric").equals(colDef.get(colNum).get("TYPE"))){
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(colNum);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_46);
                        }else if(("Date").equals(colDef.get(colNum).get("TYPE"))){
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(colNum);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(colNum);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(colDef.get(colNum).get("PATTERN"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_54);
                        }else if(("Nominal").equals(colDef.get(colNum).get("TYPE"))){
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(colNum);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(colNum);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_60);
                        }
                         //   }
                        //}
                        colNum++;
                 }
                }
              }
                
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
       		
            }//end if connection is DATA
        }//end for Iconnection conn:conns

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
           
		log4jFileUtil.debugWriteData(node);
	}//end if metadata!=null

}

    stringBuffer.append(TEXT_68);
    return stringBuffer.toString();
  }
}
