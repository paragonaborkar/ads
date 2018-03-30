package org.talend.designer.codegen.translators.business_intelligence.olap_cube.palo;

import java.util.List;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TPaloDimensionListEndJava
{
  protected static String nl;
  public static synchronized TPaloDimensionListEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPaloDimensionListEndJava result = new TPaloDimensionListEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\t}" + NL + "   }" + NL + "\tbreak;" + NL + "  }" + NL + "\t";
  protected final String TEXT_4 = NL + "\telse {" + NL + "\t\t    throw new RuntimeException (\"Cube '\" + ";
  protected final String TEXT_5 = " + " + NL + "\t\t                              \"' not found in database '\" + ";
  protected final String TEXT_6 = " + \"'. exiting...\" );" + NL + "\t\t}" + NL + "\t}" + NL + "\t";
  protected final String TEXT_7 = NL + "\t\tif(pConn_";
  protected final String TEXT_8 = " != null) {" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_10 = " - Closing the connection to the database.\");" + NL + "\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\tpConn_";
  protected final String TEXT_12 = ".logout();" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_14 = " - Connection to the database closed.\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t}";
  protected final String TEXT_16 = NL + "//globalMap.put(\"";
  protected final String TEXT_17 = "_NB_RULES\", NB_RULES";
  protected final String TEXT_18 = ");" + NL + "" + NL + "\t";
  protected final String TEXT_19 = NL + "\t\tlog.info(\"";
  protected final String TEXT_20 = " - List dimensions count \" + NB_DIMENSIONS";
  protected final String TEXT_21 = " + \" .\");" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	String cid = node.getUniqueName();
	String sDatabaseName = ElementParameterParser.getValue(node,"__DATABASE__");
    String sCubeName = ElementParameterParser.getValue(node,"__CUBE__");
	boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
    boolean useRetriveFromCube = "true".equals(ElementParameterParser.getValue(node,"__RETRIEVE_DIMENSIONS_FROM_CUBE__"));


    
String outputConnName = null;
boolean bIterate=false;
List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
if (conns!=null) {
	if (conns.size()>0) {
		for (int i=0;i<conns.size();i++) {
			IConnection connTemp = conns.get(i);
			if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				outputConnName = connTemp.getName();
				break;
			}
		}
		for (int i=0;i<conns.size();i++) {
			IConnection connTemp = conns.get(i);
			if(connTemp.getLineStyle().toString().equals("ITERATE")) {
				bIterate=true;
				//break;
			}
		}
	}
}

    stringBuffer.append(TEXT_2);
    
if (outputConnName != null || bIterate){

    stringBuffer.append(TEXT_3);
    
	if(useRetriveFromCube){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(sCubeName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(sDatabaseName);
    stringBuffer.append(TEXT_6);
    }
    
}
	if(!useExistingConnection)	{

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    
	}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    }
    return stringBuffer.toString();
  }
}
