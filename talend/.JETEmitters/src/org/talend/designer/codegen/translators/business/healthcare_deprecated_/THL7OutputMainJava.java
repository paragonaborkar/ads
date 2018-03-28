package org.talend.designer.codegen.translators.business.healthcare_deprecated_;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

/**
 * add by xzhang
 */
public class THL7OutputMainJava {


  protected static String nl;
  public static synchronized THL7OutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THL7OutputMainJava result = new THL7OutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tif(msg_";
  protected final String TEXT_2 = "==null){" + NL + "\t\tmsg_";
  protected final String TEXT_3 = "= new ca.uhn.hl7v2.model.v";
  protected final String TEXT_4 = ".message.";
  protected final String TEXT_5 = "();" + NL + "\t\tterser_";
  protected final String TEXT_6 = " = new ca.uhn.hl7v2.util.Terser(msg_";
  protected final String TEXT_7 = ");" + NL + "\t\tutil_";
  protected final String TEXT_8 = ".findSegments(msg_";
  protected final String TEXT_9 = ",map2Seg_";
  protected final String TEXT_10 = ");" + NL + "\t}";
  protected final String TEXT_11 = NL + "\tif(";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = " != null) {";
  protected final String TEXT_14 = NL + "\ttmpValue_";
  protected final String TEXT_15 = " =";
  protected final String TEXT_16 = NL + "    \t\t\t\t\t\tFormatterUtils.format_Date(";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = ", ";
  protected final String TEXT_19 = ");" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_20 = NL + "    \t\t\t\t\t\t";
  protected final String TEXT_21 = ".toPlainString();" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_22 = NL + "    \t\t\t\t\t\tjava.nio.charset.Charset.forName(";
  protected final String TEXT_23 = ").decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_24 = ".";
  protected final String TEXT_25 = ")).toString();" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_26 = NL + "    \t\t\t\t\t\tString.valueOf(";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = ");" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_29 = "   \t\t\t\t" + NL + "\t}";
  protected final String TEXT_30 = NL + "tmpValue_";
  protected final String TEXT_31 = " = ";
  protected final String TEXT_32 = ";";
  protected final String TEXT_33 = NL + "\tterser_";
  protected final String TEXT_34 = ".set(";
  protected final String TEXT_35 = ",tmpValue_";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = NL + "\ti_";
  protected final String TEXT_38 = "_";
  protected final String TEXT_39 = "++;";
  protected final String TEXT_40 = NL;

// *************************************************************************
//  the following part is for NULL
//*************************************************************************
    static class HL7Node {

        // table parameter of component

        public String path = null;
        
        public String addPath = "";

        public String column = null;
        
        public String defaultValue = "";
        
        public String connName = "";
        
        public String hl7SegType = "";

        // column
        public IMetadataColumn relatedColumn = null;
        
        
        // /MFN_M02/MSH/MSH-1(1)[ST]/MSH-1(1)-1-1[ST]
        private void init(String path) {
            String[] paths = path.split("/");

            String hl7MsgType = paths[1]; // MFN_M02
            
//            for (int i=0; i< paths.length; i++) {
//                System.out.println(i+"="+paths[i]+",");
//            }
//            System.out.println("hl7MsgType=" + hl7MsgType);

            path = path.replace("/"+hl7MsgType, ""); //  /MSH/MSH-1(1)[ST]/MSH-1(1)-1-1[ST]
            
            String xpath= paths[paths.length-1]; //MSH-1(1)-1-1[ST]
            if (xpath.contains("[")) {
                xpath = xpath.substring(0, xpath.indexOf("["));
            }
//            System.out.println("isRepStartFromZero"+isRepStartFromZero);

            int indexOfRWrap = xpath.indexOf("(");
            int indexOfLWrap = xpath.indexOf(")");
            if (indexOfRWrap>0 && indexOfRWrap < indexOfLWrap) {
                int rep = Integer.parseInt(xpath.substring(indexOfRWrap+1, indexOfLWrap));
//                    System.out.println("xpath beore:"+xpath + ",rep="+rep);
                if(rep==0) {
                } else {
                    xpath = xpath.replace("("+rep + ")", "("+(rep-1) + ")");
                }
            }

            
            this.path = xpath;
            this.hl7SegType = this.path.split("-")[0]; // MSH
//            System.out.println("xpath after:"+xpath +",SegType=" + this.hl7SegType);
            if (!path.startsWith("/" + this.hl7SegType + "/")) { // this path is a group path
                this.path = path.substring(0, path.indexOf("/" + this.hl7SegType + "/")+1) + this.path;
            } else {
                this.path = "/" + this.path;
            }
            
        }


        public HL7Node(String path, String column, String value) {
            init(path);

            this.column = column;
            if(this.column.contains(":")) {
                this.connName = this.column.substring(0, this.column.indexOf(":"));
            } else {
                this.connName = this.column;
            }
            if(value!=null){
                this.defaultValue = value;
            }
        }
        
        public boolean isRepeating = false;
        public void calAddPath(List<String> repeatingNodes) {
            if(repeatingNodes == null || repeatingNodes.size() == 0) {
                return;
            }
            
            for (String repeatingNode : repeatingNodes) {
                int index = this.path.indexOf("/"+repeatingNode);
                if (index >= 0) {
                    this.addPath = this.path.substring(index+repeatingNode.length()+1);
                    this.path = this.path.substring(0, index + repeatingNode.length()+1);
                    this.isRepeating = true;
                    break;
                }
            }
        }
       
    }
    
    /**
    * return the table which is related to the connection name
    */
    public List<Map<String, String>> getTable(List<Map<String, String>> rootTable, String connName){
        List<Map<String, String>> resultTable = new ArrayList<Map<String, String>>();
        for(Map<String, String> map: rootTable){
            if(map.get("COLUMN").contains(connName)){
                resultTable.add(map);
            }
        }
        return resultTable;
    }

    /**
     * result Map:
     * key: segment/group name
     * value: the original path
     */
    public java.util.List<String> findRepeatingNodes (List<Map<String, String>> rootTable) {
        java.util.List<String> result = new java.util.ArrayList<String>();
        for (Map<String, String> map : rootTable) {
            String strTemp = map.get("REPEATABLE");
            
            if ("true".equalsIgnoreCase(strTemp)) {
                String[] tempArr = map.get("PATH").split("/");
                result.add(tempArr[tempArr.length-1]);
            }
        }
        return result;
        
    }
    
    // return [0] is root(HL7Node), [1] is groups(List<HL7Node>), [2] loop(HL7Node)
    public List<HL7Node> getTree(List<Map<String, String>> rootTable, List<IMetadataColumn> colList, String incomingName) {
        
        List<HL7Node> nodes = new java.util.ArrayList<HL7Node>();

        List<Map<String, String>> maps = getTable(rootTable, incomingName);
        
        List<String> repeativeNodes = findRepeatingNodes (rootTable);

        Map<String, String> prevMap = null;
        for (Map<String, String> tmpMap : maps) {
            if (prevMap!=null) {
                if (!tmpMap.get("PATH").startsWith(prevMap.get("PATH"))) {
                    HL7Node node = new HL7Node(prevMap.get("PATH"),prevMap.get("COLUMN"),prevMap.get("VALUE"));
                    node.calAddPath(repeativeNodes);
                    setIMetadataColumn(node, colList);
                    nodes.add(node);
                }
            }
            prevMap = tmpMap;
        }
        if (prevMap != null) {
            HL7Node node = new HL7Node(prevMap.get("PATH"),prevMap.get("COLUMN"),prevMap.get("VALUE"));
            node.calAddPath(repeativeNodes);
            setIMetadataColumn(node, colList);
            nodes.add(node);
        }

        return nodes;
    }

    private void setIMetadataColumn(HL7Node node, List<IMetadataColumn> colList) {
        String value = null;
        JavaType javaType = null;
        String[] str = node.column.split(":");
        if (node.column != null && node.column.length() > 0 && node.column.indexOf(":")>0) {
            for (IMetadataColumn column : colList) {
                if (column.getLabel().equals(node.column.substring(node.column.indexOf(":")+1))) {
                    node.relatedColumn = column;
                    break;
                }
            }
        }
        // test
//        System.out.println("xpath:"+node.path+",column:"+node.column+"relatedColumn:"+node.relatedColumn+",defaultValue="+node.defaultValue);
    }
    
    public String getHL7MsgType (List<Map<String, String>> rootTable) {
        String result = "";
        for (Map<String, String> map : rootTable) {
            String strTemp = map.get("PATH");
            String[] strArr = strTemp.split("/");
            if (strArr.length == 2) {
                result = strArr[1];
                break;
            }
        }
        return result;
    }
    
    public boolean isHL7Group(List<HL7Node> nodes) {
        boolean isHL7Group = false;
        
        if (nodes==null || nodes.isEmpty()) {
            return false;
        }
        
        for (HL7Node node: nodes) {
            if (node.path.startsWith("/")) {
                isHL7Group = true;
                break;
            }
        }
        
        return isHL7Group;
        
    }

    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
final String cid = node.getUniqueName();

String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
String hl7Version = ElementParameterParser.getValue(node, "__HL7_VER__");

String incomingName = (String)codeGenArgument.getIncomingName();

List<Map<String, String>> rootTable = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ROOT__");

//get the right input connection and the previous input node and metadatas
    
List< ? extends IConnection> incomingConns = node.getIncomingConnections();

	if (incomingName == null && incomingConns.size() > 0) {
		   incomingName = incomingConns.get(0).getName(); 
	}
	
	IMetadataTable preMetadataTable = null;
	for (IConnection incomingConn : incomingConns) {
		if ( incomingConn.getLineStyle().equals(EConnectionType.FLOW_MERGE) && incomingConn.getName().equals(incomingName)) {
			preMetadataTable = incomingConn.getMetadataTable();
		    break;
		}
	}
	
	if(preMetadataTable==null){
		return "";
	}

	if (incomingConns != null && incomingConns.size() > 0) {
		if (incomingConns.get(0).getName().equals(incomingName) ) { // the first connector

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(hl7Version);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(getHL7MsgType(rootTable) );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    
		}
		for (IConnection conn : incomingConns) {
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA) && conn.getName().equals(incomingName)){

				IMetadataTable metadata = conn.getMetadataTable();
				if(metadata!=null) {
					List<IMetadataColumn> columns = metadata.getListColumns();
					List<HL7Node> xmlNodes = getTree(rootTable, columns, incomingName);
//					boolean isHL7TreeWithGroup = isHL7Group(xmlNodes);
					if(xmlNodes != null && xmlNodes.size() > 0) {

    
						for (int i = 0 ; i< xmlNodes.size(); i++) {
							IMetadataColumn column = xmlNodes.get(i).relatedColumn;
							if (column != null) {
								JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
								boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
				    			if(!isPrimitive) {

    stringBuffer.append(TEXT_11);
    stringBuffer.append(incomingName );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_13);
     
    							} 

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    
		    			        String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
		    			        if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {
    			            
    stringBuffer.append(TEXT_16);
    stringBuffer.append(incomingName );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_19);
    	
								} else if(javaType == JavaTypesManager.BIGDECIMAL){
    						
    stringBuffer.append(TEXT_20);
    stringBuffer.append(column.getPrecision() == null? incomingName + "." + column.getLabel() : incomingName + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_21);
    
								} else if(javaType == JavaTypesManager.BYTE_ARRAY){
    						
    stringBuffer.append(TEXT_22);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(incomingName );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_25);
    
    			        		} else {
    			            
    stringBuffer.append(TEXT_26);
    stringBuffer.append(incomingName );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_28);
    				
	    			        	}
								if(!isPrimitive) {

    stringBuffer.append(TEXT_29);
    
								}
							} else { // use the default value

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append((xmlNodes.get(i).defaultValue==null || "".equals(xmlNodes.get(i).defaultValue)? "\"\"":xmlNodes.get(i).defaultValue) );
    stringBuffer.append(TEXT_32);
    
							}
							StringBuilder nodePath = new StringBuilder("\"");
							if (xmlNodes.get(i).isRepeating) {
								nodePath.append(xmlNodes.get(i).path);
								nodePath.append("(\"+i_" + incomingName + "_" + cid + "+\")"+xmlNodes.get(i).addPath);
							} else {
								nodePath.append(xmlNodes.get(i).path);
							}
							nodePath.append("\"");

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(nodePath.toString());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    
						} // for (int i = 0 ; i< xmlNodes.size(); i++);

    stringBuffer.append(TEXT_37);
    stringBuffer.append(incomingName );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    
					}
				} //if(metadata!=null)
				break; // each input connector generate one segment
			}
		} // for (IConnection conn : incomingConns)
	}

    stringBuffer.append(TEXT_40);
    return stringBuffer.toString();
  }
}
