package org.talend.designer.codegen.translators.business.sap;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TSAPRollbackMainJava
{
  protected static String nl;
  public static synchronized TSAPRollbackMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSAPRollbackMainJava result = new TSAPRollbackMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tcom.sap.conn.jco.JCoDestination dest_";
  protected final String TEXT_3 = " = (com.sap.conn.jco.JCoDestination)globalMap.get(\"";
  protected final String TEXT_4 = "\");";
  protected final String TEXT_5 = NL + "\t\t\tif(dest_";
  protected final String TEXT_6 = " == null){" + NL + "\t\t\t\tdest_";
  protected final String TEXT_7 = " = com.sap.conn.jco.JCoDestinationManager.getDestination(";
  protected final String TEXT_8 = ");" + NL + "\t\t\t}";
  protected final String TEXT_9 = NL + "\tif(dest_";
  protected final String TEXT_10 = " != null)" + NL + "\t{" + NL + "\t\tcom.sap.conn.jco.JCoRepository repository_";
  protected final String TEXT_11 = " = dest_";
  protected final String TEXT_12 = ".getRepository();" + NL + "\t\t" + NL + "\t\tcom.sap.conn.jco.JCoFunctionTemplate functionTemplate_";
  protected final String TEXT_13 = " = repository_";
  protected final String TEXT_14 = ".getFunctionTemplate(\"BAPI_TRANSACTION_ROLLBACK\");" + NL + "\t\t" + NL + "\t\tcom.sap.conn.jco.JCoFunction function_";
  protected final String TEXT_15 = " = functionTemplate_";
  protected final String TEXT_16 = ".getFunction();" + NL + "\t\t" + NL + "\t\ttry{" + NL + "\t\t\tfunction_";
  protected final String TEXT_17 = ".execute(dest_";
  protected final String TEXT_18 = ");" + NL + "\t\t}catch (java.lang.Exception e_";
  protected final String TEXT_19 = ") {" + NL + "\t\t\tcom.sap.conn.jco.JCoContext.end(dest_";
  protected final String TEXT_20 = ");" + NL + "\t\t    throw new RuntimeException(e_";
  protected final String TEXT_21 = ".getMessage());" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_22 = NL + "\t\tcom.sap.conn.jco.JCoContext.end(dest_";
  protected final String TEXT_23 = ");" + NL + "\t\t";
  protected final String TEXT_24 = NL + "\t}";
  protected final String TEXT_25 = NL + "\torg.talend.sap.ISAPConnection connection_";
  protected final String TEXT_26 = " = (org.talend.sap.ISAPConnection)globalMap.get(\"";
  protected final String TEXT_27 = "\");";
  protected final String TEXT_28 = NL + "\t\t\tif(connection_";
  protected final String TEXT_29 = " == null){" + NL + "\t\t\t\tconnection_";
  protected final String TEXT_30 = " = ((org.talend.sap.impl.SAPConnectionFactory)(org.talend.sap.impl.SAPConnectionFactory.getInstance())).createConnection(";
  protected final String TEXT_31 = ");" + NL + "\t\t\t}";
  protected final String TEXT_32 = NL + "\tif(connection_";
  protected final String TEXT_33 = "!=null && connection_";
  protected final String TEXT_34 = ".isAlive()) {" + NL + "\t\torg.talend.sap.ISAPTransaction transaction_";
  protected final String TEXT_35 = " = connection_";
  protected final String TEXT_36 = ".getTransaction();" + NL + "\t\tif(transaction_";
  protected final String TEXT_37 = "!=null && transaction_";
  protected final String TEXT_38 = ".isAlive()) {" + NL + "\t\t\ttry {" + NL + "\t     \t\ttransaction_";
  protected final String TEXT_39 = ".rollback();" + NL + "\t    \t} catch (org.talend.sap.exception.SAPException e_";
  protected final String TEXT_40 = ") {" + NL + "\t    \t\tconnection_";
  protected final String TEXT_41 = ".close();" + NL + "\t    \t\tthrow new RuntimeException(e_";
  protected final String TEXT_42 = ".getMessage());" + NL + "\t\t    }" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_43 = NL + "\t\tconnection_";
  protected final String TEXT_44 = ".close();" + NL + "\t\t";
  protected final String TEXT_45 = NL + "\t\tconnection_";
  protected final String TEXT_46 = ".beginTransaction();" + NL + "\t\t";
  protected final String TEXT_47 = NL + "\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();

    String cid = node.getUniqueName();

    String connection = ElementParameterParser.getValue(node, "__CONNECTION__");

    boolean close = ("true").equals(ElementParameterParser.getValue(node,"__CLOSE__"));
	
    String conn = "conn_" + connection;
    
    
    String VERSION_SAP3 = "sapjco3.jar";
    
    String version = VERSION_SAP3;
    List<? extends INode> nodes = node.getProcess().getGeneratingNodes();
    for(INode targetNode : nodes){
    	if (targetNode.getUniqueName().equals(connection)) {
	      version = ElementParameterParser.getValue(targetNode, "__DB_VERSION__");
	    }
    }
    

    if(VERSION_SAP3.equals(version)){
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_4);
    	
	INode connectionNode = null; 
	for (INode processNode : node.getProcess().getGeneratingNodes()) { 
		if(connection.equals(processNode.getUniqueName())) { 
			connectionNode = processNode; 
			break; 
		} 
	} 
	boolean specify_alias = "true".equals(ElementParameterParser.getValue(connectionNode, "__SPECIFY_DATASOURCE_ALIAS__"));
	if(specify_alias){
		String alias = ElementParameterParser.getValue(connectionNode, "__SAP_DATASOURCE_ALIAS__");
		if(null != alias && !("".equals(alias))){

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(alias);
    stringBuffer.append(TEXT_8);
    
		}
	}

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    if(close){
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    } else {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_27);
    
	INode connectionNode = null; 
	for (INode processNode : node.getProcess().getGeneratingNodes()) { 
		if(connection.equals(processNode.getUniqueName())) { 
			connectionNode = processNode; 
			break; 
		} 
	} 
	boolean specify_alias = "true".equals(ElementParameterParser.getValue(connectionNode, "__SPECIFY_DATASOURCE_ALIAS__"));
	if(specify_alias){
		String alias = ElementParameterParser.getValue(connectionNode, "__SAP_DATASOURCE_ALIAS__");
		if(null != alias && !("".equals(alias))){

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(alias);
    stringBuffer.append(TEXT_31);
    
		}
	}

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    if(close){
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    } else {//begin a new transaction for next commit or rollback
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    }
    return stringBuffer.toString();
  }
}
