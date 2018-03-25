package org.talend.designer.codegen.translators.databases.ldap;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;

public class TLDAPRenameEntryMainJava
{
  protected static String nl;
  public static synchronized TLDAPRenameEntryMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLDAPRenameEntryMainJava result = new TLDAPRenameEntryMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "        ";
  protected final String TEXT_3 = " = null;            ";
  protected final String TEXT_4 = NL + "        \t\t\twhetherReject_";
  protected final String TEXT_5 = " = false;" + NL + "\t\t\t\t\ttry{" + NL + "\t\t\t\t" + NL + "\t\t\t\t\t\tLDAPRenameEntryUtil_";
  protected final String TEXT_6 = " renameUtil";
  protected final String TEXT_7 = " = new LDAPRenameEntryUtil_";
  protected final String TEXT_8 = "();" + NL + "\t\t\t\t\t\trenameUtil";
  protected final String TEXT_9 = ".renameWithChilds(";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = ".trim()," + NL + "\t\t\t\t\t\t";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = ".trim()," + NL + "\t\t\t\t\t\tctx_";
  protected final String TEXT_14 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\t\t\t\tlog.trace(\"";
  protected final String TEXT_16 = " - Content of the record : old entry is '\" + ";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = ".trim() + \" and new entry is '\" + ";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = ".trim() + \"'.\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\t\t}catch(java.lang.Exception e){" + NL + "       \t\t\t\t\twhetherReject_";
  protected final String TEXT_22 = " = true;";
  protected final String TEXT_23 = NL + "\t\t\t\t\t        throw(e);";
  protected final String TEXT_24 = NL + "        \t\t\t\t\t\t";
  protected final String TEXT_25 = " = new ";
  protected final String TEXT_26 = "Struct();";
  protected final String TEXT_27 = NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = " = ";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = ";";
  protected final String TEXT_32 = NL + "                \t\t\t\t";
  protected final String TEXT_33 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_34 = ";";
  protected final String TEXT_35 = NL + "               \t\t\t\t\tSystem.err.print(e.getMessage());";
  protected final String TEXT_36 = NL + "\t\t\t\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_37 = " - \" + e.getMessage());";
  protected final String TEXT_38 = NL + "    \t\t\t\t}";
  protected final String TEXT_39 = NL + "        \t\t\t\tif(!whetherReject_";
  protected final String TEXT_40 = ") {";
  protected final String TEXT_41 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_42 = " = new ";
  protected final String TEXT_43 = "Struct();";
  protected final String TEXT_44 = NL + "           \t\t\t\t\t\t\t\t\t";
  protected final String TEXT_45 = ".";
  protected final String TEXT_46 = " = ";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = ";";
  protected final String TEXT_49 = NL + "        \t\t\t\t}";
  protected final String TEXT_50 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
		
	String rejectConnName = null;
	List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
	if(rejectConns != null && rejectConns.size() > 0) {
	    IConnection rejectConn = rejectConns.get(0);
	    rejectConnName = rejectConn.getName();
	}
	List<IMetadataColumn> rejectColumnList = null;
	IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
	if(metadataTable != null) {
	    rejectColumnList = metadataTable.getListColumns();	    
	}
	List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
    for(IConnection conn : outgoingConns) {
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_3);
          }
    }
    
	String cid = node.getUniqueName();
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		List<IMetadataColumn> columnList = metadata.getListColumns();
		
		List< ? extends IConnection> conns = node.getIncomingConnections();
		for(IConnection conn:conns){
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.MAIN)) {
     			String firstConnName = conn.getName();
    			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {	

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(ElementParameterParser.getObjectValue(node, "__REMANE_DN_OLD__"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(ElementParameterParser.getObjectValue(node, "__REMANE_DN_NEW__"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(ElementParameterParser.getObjectValue(node, "__REMANE_DN_OLD__"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(ElementParameterParser.getObjectValue(node, "__REMANE_DN_NEW__"));
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
        				if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_23);
    
				        } else {
				            if(rejectConnName != null && rejectColumnList != null && rejectColumnList.size() > 0) {

    stringBuffer.append(TEXT_24);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_26);
    
                				for(IMetadataColumn column : columnList) {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_31);
    
              					}

    stringBuffer.append(TEXT_32);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_34);
    
            				} else {

    stringBuffer.append(TEXT_35);
    
								if(isLog4jEnabled){

    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    
								}
            				}
				        }

    stringBuffer.append(TEXT_38);
    
    				if(outgoingConns != null && outgoingConns.size() > 0) {

    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
				            for(IConnection outgoingConn : outgoingConns) {
				                if(rejectConnName == null || (rejectConnName != null && !outgoingConn.getName().equals(rejectConnName))) {
				                    if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_41);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_43);
    
                        				for(IMetadataColumn column : columnList) {

    stringBuffer.append(TEXT_44);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_48);
     
				                        }
				                    }
				                }
				            }

    stringBuffer.append(TEXT_49);
    
    				}
				}
			}
		}
	}

    stringBuffer.append(TEXT_50);
    return stringBuffer.toString();
  }
}
