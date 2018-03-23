package org.talend.designer.codegen.translators.business_intelligence.olap_cube.palo;

import java.util.List;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;

public class TPaloInputMultiEndJava
{
  protected static String nl;
  public static synchronized TPaloInputMultiEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPaloInputMultiEndJava result = new TPaloInputMultiEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_2 = NL + "\t\tif(pConn_";
  protected final String TEXT_3 = " != null){" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_5 = " - Closing the connection to the database.\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\tpConn_";
  protected final String TEXT_7 = ".logout();" + NL + "\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_9 = " - Connection to the database closed.\");" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t}";
  protected final String TEXT_11 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	String strOutputConnectionName="";
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
 	if(conns!=null){
		if (conns.size()>0){
            IConnection conn =conns.get(0);
            if(conn!=null && conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
		    	strOutputConnectionName=conn.getName();
		    }
		}
	}
	if(strOutputConnectionName != null && strOutputConnectionName.length()>0){

    stringBuffer.append(TEXT_1);
    
	}
	if(!useExistingConnection){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    }
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    
	}

    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}
