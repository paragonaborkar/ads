package org.talend.designer.codegen.translators.business.alfresco_deprecated_;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.Map;
import org.talend.core.model.process.IConnection;

public class TAlfrescoOutputMainJava
{
  protected static String nl;
  public static synchronized TAlfrescoOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAlfrescoOutputMainJava result = new TAlfrescoOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "    \t\t";
  protected final String TEXT_3 = " = null;            ";
  protected final String TEXT_4 = NL + "\t          " + NL + "\t    whetherReject_";
  protected final String TEXT_5 = " = false;" + NL + "\t    try { // start reject exception handling" + NL + "\t        " + NL + "\t        // writing document" + NL + "\t        ";
  protected final String TEXT_6 = NL + "         \ttalendAcpXmlWriter_";
  protected final String TEXT_7 = ".writeStartDocument(";
  protected final String TEXT_8 = "," + NL + "         \t\tnull);" + NL + "         \t";
  protected final String TEXT_9 = NL + "        \ttalendAcpXmlWriter_";
  protected final String TEXT_10 = ".writeStartDocument(";
  protected final String TEXT_11 = "," + NL + "         \t\tnew String[][] {" + NL + "         \t\t\t";
  protected final String TEXT_12 = NL + "         \t\t\tnew String[] { ";
  protected final String TEXT_13 = ", \"";
  protected final String TEXT_14 = "\" }" + NL + "         \t\t\t";
  protected final String TEXT_15 = NL + "         \t\t\t});" + NL + "         \t";
  protected final String TEXT_16 = NL + "\t        " + NL + "\t        // properties" + NL + "\t        ";
  protected final String TEXT_17 = NL + "\t\t         talendAcpXmlWriter_";
  protected final String TEXT_18 = ".writeProperty(\"";
  protected final String TEXT_19 = "\", \"";
  protected final String TEXT_20 = "\", ";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "\t        " + NL + "\t        // associations" + NL + "\t        ";
  protected final String TEXT_23 = NL + "\t\t\t         talendAcpXmlWriter_";
  protected final String TEXT_24 = ".writeAssociation(\"";
  protected final String TEXT_25 = "\"," + NL + "\t\t\t         \t\t";
  protected final String TEXT_26 = ");" + NL + "\t                ";
  protected final String TEXT_27 = NL + "            " + NL + "         talendAcpXmlWriter_";
  protected final String TEXT_28 = ".writeEndDocument();" + NL + "         " + NL + "         nbLine_";
  protected final String TEXT_29 = "++;" + NL + "\t        " + NL + "\t    } catch (java.lang.Exception mainEx_";
  protected final String TEXT_30 = ") { // end reject exception handling";
  protected final String TEXT_31 = NL + "            throw(mainEx_";
  protected final String TEXT_32 = ");";
  protected final String TEXT_33 = NL + "\t\t\twhetherReject_";
  protected final String TEXT_34 = " = true;";
  protected final String TEXT_35 = NL + "                ";
  protected final String TEXT_36 = " = new ";
  protected final String TEXT_37 = "Struct();";
  protected final String TEXT_38 = NL + "                    ";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = " = ";
  protected final String TEXT_41 = ".";
  protected final String TEXT_42 = ";";
  protected final String TEXT_43 = NL + "                nb_line_rejected_";
  protected final String TEXT_44 = "++;";
  protected final String TEXT_45 = NL + "                ";
  protected final String TEXT_46 = ".errorMessage = mainEx_";
  protected final String TEXT_47 = ".getMessage();";
  protected final String TEXT_48 = NL + "                ";
  protected final String TEXT_49 = ".errorCode = \"XML\";";
  protected final String TEXT_50 = NL + "\t            // handling exception as std err" + NL + "                System.err.println(mainEx_";
  protected final String TEXT_51 = ".getMessage());";
  protected final String TEXT_52 = NL + "            " + NL + "\t    }" + NL + "\t    ";
  protected final String TEXT_53 = NL + "\t\tif(!whetherReject_";
  protected final String TEXT_54 = ") {" + NL + "\t\t";
  protected final String TEXT_55 = NL + "\t\t\t";
  protected final String TEXT_56 = " = new ";
  protected final String TEXT_57 = "Struct();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\t";
  protected final String TEXT_59 = ".";
  protected final String TEXT_60 = " = ";
  protected final String TEXT_61 = ".";
  protected final String TEXT_62 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_63 = NL + "\t\t}" + NL + "\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    // 2. in main.javajet, we output the document corresponding to the current row

	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
    // getting node metadata and columns
	List<IMetadataColumn> columns = null;
	List<IMetadataTable> metadatas = node.getMetadataList();
	IMetadataTable metadata = null;
	if (metadatas!=null && metadatas.size()>0) {
	    metadata = metadatas.get(0);
	    if (metadata!=null) {
            columns = metadata.getListColumns();
        }
    }
	
	// getting incoming connection and name
    List<? extends IConnection> inConns = node.getIncomingConnections();
	IConnection inConn = null;
	String inConnName = null;
	if(inConns != null && inConns.size()>0){
	    inConn = inConns.get(0);
	    inConnName = inConn.getName();
	}
	List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
	
	// getting reject connection columnList and name
	IConnection rejectConn = null;
	String rejectConnName = null;
	List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
	if(rejectConns != null && rejectConns.size() > 0) {
	    rejectConn = rejectConns.get(0);
	    rejectConnName = rejectConn.getName();
	}
	List<IMetadataColumn> rejectColumns = null;
	IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
	if(metadataTable != null) {
	    rejectColumns = metadataTable.getListColumns();      
	}
		
	// checking that we're in a valid enough case
	if (metadata != null && columns != null && inConn != null) {
	
		// getting useful parameters
	    boolean mapTargetLocationFromColumn = Boolean.valueOf(ElementParameterParser.getValue(node, "__MAP_TARGET_LOCATION_FROM_COLUMN__"));
	    String targetLocationColumn = ElementParameterParser.getValue(node, "__TARGET_LOCATION_COLUMN__");
	    
	    boolean configurePermissions = Boolean.valueOf(ElementParameterParser.getValue(node, "__CONFIGURE_PERMISSIONS__"));
	    List<Map<String, String>> permissionMappings = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__PERMISSIONS__");
	    
	    List<Map<String, String>> propertyMappings = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__PROPERTY_MAPPING__");
	    List<Map<String, String>> associationMappings = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ASSOCIATION_MAPPING__");
	    String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
		for(IConnection conn : outgoingConns) {
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_3);
          	
			}
		}

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
	        // preparing targetLocationBase
			  String targetLocationBaseVariable = "\"\"";
			  if (mapTargetLocationFromColumn && targetLocationColumn != null && targetLocationColumn.length() != 0) {
					// we'll take it from the mapped column
			  		targetLocationBaseVariable = inConnName + '.' + targetLocationColumn;
			  }
	        if (!configurePermissions) {
	        
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(targetLocationBaseVariable);
    stringBuffer.append(TEXT_8);
    
         	} else {
         	
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(targetLocationBaseVariable);
    stringBuffer.append(TEXT_11);
    
         			for (Map<String, String> permissionMapping : permissionMappings) {
					      String authorityColumn = permissionMapping.get("USERORGROUPCOLUMN");
					      String permission = permissionMapping.get("PERMISSION");
					      String authorityVariable;
					      if (authorityColumn == null) {
					      		String authorityValue = permissionMapping.get("USERORGROUP");
			                    if (authorityValue == null) {
			                        // if no mapped column or value, we don't set the property
			                        // TODO reject ?
			                        continue;
			                    }
		                    	// wrapping it with quotes to make a string out of it :
		                    	authorityVariable = "\"" + authorityValue + "\"";
		                    	
					      } else {
                				// we'll take it from the mapped column
					      		authorityVariable = inConnName + '.' + authorityColumn;
					      }
					      if (permission == null || permission.length() == 0) {
					      	continue; // NB. could handle it as a reject
					      }
         			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(authorityVariable);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(permission);
    stringBuffer.append(TEXT_14);
    
         			}
         			
    stringBuffer.append(TEXT_15);
    
         	}
         	
    stringBuffer.append(TEXT_16);
    
            for(Map<String, String> propertyMapping : propertyMappings) {
                String mappedColumnLabel = propertyMapping.get("COLUMN");
                String mappedVariable;
                if (mappedColumnLabel == null || mappedColumnLabel.length() == 0) {
                    // if no mapped column, trying to get mapped value
                    String mappedValue = propertyMapping.get("VALUE");
                    if (mappedValue == null) {
                        // if no mapped column or value, we don't set the property
                        // NB. could handle it as a reject
                        continue;
                    }
                	// wrapping it with quotes to make a string out of it :
                	mappedVariable = "\"" + mappedValue + "\"";
                	
                } else {
                	// we'll take it from the mapped column
                	mappedVariable = inConnName + '.' + mappedColumnLabel;
                }
                
                String propertyName = propertyMapping.get("NAME");
                String propertyType = propertyMapping.get("TYPE");
                
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(propertyName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(propertyType);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(mappedVariable);
    stringBuffer.append(TEXT_21);
    
            }
            
    stringBuffer.append(TEXT_22);
    
	        if (associationMappings != null) {
	            for(Map<String, String> associationMapping : associationMappings) {
                    String mappedColumnLabel = associationMapping.get("COLUMN");
	                if (mappedColumnLabel == null || mappedColumnLabel.length() == 0) {
	                    // if no mapped column, we don't set the association
	                    continue;
	                }
	                
                    String associationName = associationMapping.get("NAME");
	                
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(associationName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(inConnName + '.' + mappedColumnLabel);
    stringBuffer.append(TEXT_26);
    
	            }
            }
            
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    
		if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
		} else {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
	        // handling exception as reject connection or std err
	        if(rejectConnName != null && rejectColumns != null && rejectColumns.size() > 0) {
                
    stringBuffer.append(TEXT_35);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_37);
    
	            // handling exception as reject connection
                for(IMetadataColumn column : columns) {
                    
    stringBuffer.append(TEXT_38);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_42);
    
                }
                
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_49);
    
            } else {
                
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
            }
		}
            
    stringBuffer.append(TEXT_52);
    
	   	if(outgoingConns != null && outgoingConns.size() > 0) {
        
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
			for(IConnection outgoingConn : outgoingConns) {
				if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {
					if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					 
    stringBuffer.append(TEXT_55);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_57);
    
						for(IMetadataColumn column : columns) {
						
    stringBuffer.append(TEXT_58);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(inConnName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_62);
                      
						}
					}
				}
			}
			
    stringBuffer.append(TEXT_63);
    
		}
	}

    return stringBuffer.toString();
  }
}
