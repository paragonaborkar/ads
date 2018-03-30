package org.talend.designer.codegen.translators.business.centriccrm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import java.util.List;
import java.util.Map;
import org.talend.core.model.process.IConnectionCategory;

public class TCentricCRMInputBeginJava
{
  protected static String nl;
  public static synchronized TCentricCRMInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCentricCRMInputBeginJava result = new TCentricCRMInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "      int nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "       org.aspcfs.utils.CRMConnection crm";
  protected final String TEXT_4 = " = new org.aspcfs.utils.CRMConnection();" + NL + "       System.out.println(crm";
  protected final String TEXT_5 = ".getDescription());" + NL + "       crm";
  protected final String TEXT_6 = ".setUrl(";
  protected final String TEXT_7 = ");" + NL + "       crm";
  protected final String TEXT_8 = ".setId(";
  protected final String TEXT_9 = ");" + NL + "       ";
  protected final String TEXT_10 = NL + "        ";
  protected final String TEXT_11 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_12 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_15 = " = ";
  protected final String TEXT_16 = "; ";
  protected final String TEXT_17 = NL + "\t       " + NL + "       " + NL + "       crm";
  protected final String TEXT_18 = ".setCode(decryptedPassword_";
  protected final String TEXT_19 = ");" + NL + "       crm";
  protected final String TEXT_20 = ".setClientId(";
  protected final String TEXT_21 = ");" + NL + "       java.util.ArrayList meta";
  protected final String TEXT_22 = " = new java.util.ArrayList();    " + NL + "       ";
  protected final String TEXT_23 = NL + "\t\tmeta";
  protected final String TEXT_24 = ".add(\"";
  protected final String TEXT_25 = "\");";
  protected final String TEXT_26 = "      " + NL + "     \tcrm";
  protected final String TEXT_27 = ".setTransactionMeta(meta";
  protected final String TEXT_28 = ");" + NL + "        org.aspcfs.apps.transfer.DataRecord ";
  protected final String TEXT_29 = " = new org.aspcfs.apps.transfer.DataRecord();";
  protected final String TEXT_30 = NL + "        ";
  protected final String TEXT_31 = ".setName(\"";
  protected final String TEXT_32 = "\");";
  protected final String TEXT_33 = NL + "        ";
  protected final String TEXT_34 = ".setAction(org.aspcfs.apps.transfer.DataRecord.SELECT);";
  protected final String TEXT_35 = NL + "        ";
  protected final String TEXT_36 = ".addField(";
  protected final String TEXT_37 = ",";
  protected final String TEXT_38 = ");" + NL + "\t";
  protected final String TEXT_39 = "      " + NL + "        crm";
  protected final String TEXT_40 = ".load(";
  protected final String TEXT_41 = ");" + NL + "        if(crm";
  protected final String TEXT_42 = ".getStatus()==1)" + NL + "        {" + NL + "       \t\tSystem.out.println(crm";
  protected final String TEXT_43 = ".getLastResponse());" + NL + "       \t}" + NL + "        java.util.Iterator iter";
  protected final String TEXT_44 = " = crm";
  protected final String TEXT_45 = ".getRecords(";
  protected final String TEXT_46 = ".class.getName()).iterator();" + NL + "         while (iter";
  protected final String TEXT_47 = ".hasNext()) {" + NL + "       \t\tObject o = iter";
  protected final String TEXT_48 = ".next();" + NL + "      \t\t";
  protected final String TEXT_49 = " tempObj=(";
  protected final String TEXT_50 = ")o;" + NL + "      \t\t";
  protected final String TEXT_51 = NL + " \t\t\t" + NL + " \t\t\t";
  protected final String TEXT_52 = ".";
  protected final String TEXT_53 = "=tempObj.get";
  protected final String TEXT_54 = "();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	List<Map<String, String>> condition = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__CONDITION__");
	String url = ElementParameterParser.getValue(node, "__CENTRIC-URL__");
	String modulename = ElementParameterParser.getValue(node, "__MODULENAME__");
	String userid = ElementParameterParser.getValue(node, "__CLIENT__");
	String server = ElementParameterParser.getValue(node, "__SERVER-ID__");
	String classname=ElementParameterParser.getValue(node, "__CLASSNAME__");
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();

    stringBuffer.append(TEXT_1);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {    

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(url);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(server);
    stringBuffer.append(TEXT_9);
    
       String passwordFieldName = "__CODE__";
       
    stringBuffer.append(TEXT_10);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_13);
    } else {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(userid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
	//get the select fields from schema
    List<IMetadataColumn> columnsFields=metadata.getListColumns();
    for (int i=0;i < columnsFields.size();i++) {
		IMetadataColumn column=columnsFields.get(i);

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_25);
    
	}

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(modulename);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(modulename);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(modulename);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(modulename);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    
        for (int size = 0; size < condition.size(); size++) {
            Map<String, String> line = condition.get(size);
	
    stringBuffer.append(TEXT_35);
    stringBuffer.append(modulename);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append( line.get("NAME") );
    stringBuffer.append(TEXT_37);
    stringBuffer.append( line.get("VALUE") );
    stringBuffer.append(TEXT_38);
    
        }
	
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(modulename);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(classname);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(classname);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(classname);
    stringBuffer.append(TEXT_50);
    
	
	if(conns!=null){
    		if (conns.size()>0){
       		IConnection conn =conns.get(0);
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			List<IMetadataColumn> columns = metadata.getListColumns();
    			int sizeColumns = columns.size();
    			for (int j = 0; j < sizeColumns; j++) {
    			IMetadataColumn column = columns.get(j);
    			
 
    stringBuffer.append(TEXT_51);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_54);
    
    				}
				}
		
			}
      }

  }
}

    return stringBuffer.toString();
  }
}
