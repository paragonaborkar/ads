package org.talend.designer.codegen.translators.business_intelligence.olap_cube.palo;

import java.util.List;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TPaloOutputMultiEndJava
{
  protected static String nl;
  public static synchronized TPaloOutputMultiEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPaloOutputMultiEndJava result = new TPaloOutputMultiEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\ttry{" + NL + "\t\t\tplDT_";
  protected final String TEXT_3 = ".setData(pCB_";
  protected final String TEXT_4 = ", org.talend.jpalo.palodata.";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = ",  ";
  protected final String TEXT_7 = " );" + NL + "\t\t}catch(java.lang.Exception plE_";
  protected final String TEXT_8 = "){" + NL + "\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tthrow(plE_";
  protected final String TEXT_10 = ");" + NL + "\t\t";
  protected final String TEXT_11 = NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.error(\"";
  protected final String TEXT_13 = " - \" + plE_";
  protected final String TEXT_14 = ".getMessage());" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tSystem.err.print(plE_";
  protected final String TEXT_16 = ".getMessage());" + NL + "\t\t";
  protected final String TEXT_17 = NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_18 = NL + "\t\tif(pConn_";
  protected final String TEXT_19 = " != null){" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_21 = " - Closing the connection to the database.\");" + NL + "\t\t\t";
  protected final String TEXT_22 = NL + "\t\t\tpConn_";
  protected final String TEXT_23 = ".logout();" + NL + "\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_25 = " - Connection to the database closed.\");" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t}";
  protected final String TEXT_27 = NL;
  protected final String TEXT_28 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	String cid = node.getUniqueName();
	String sCommitSize= ElementParameterParser.getValue(node,"__COMMITSIZE__");
	String sMeasureColumn= ElementParameterParser.getValue(node,"__MEASURE_COLUMN__");
	String sSplashMode= ElementParameterParser.getValue(node,"__SPLASH_MODE__");
	boolean bUseEventprocessor = "true".equals(ElementParameterParser.getValue(node,"__EVENTPROCESSOR__"));
	boolean bAddValues = "true".equals(ElementParameterParser.getValue(node,"__ADDVALUES__"));
	boolean bDieOnError = "true".equals(ElementParameterParser.getValue(node,"__DIE_ON_ERROR__"));
	boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	String strInputConnectionName="";
	List< ? extends IConnection> conns = node.getIncomingConnections();
 	if(conns!=null){
		if (conns.size()>0){
                IConnection conn =conns.get(0);
		    strInputConnectionName=conn.getName();
		}
	}

	if(strInputConnectionName.length()>0){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(sSplashMode);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(bAddValues);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(bUseEventprocessor);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
			if(bDieOnError){
		
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    
			}else{
		
    stringBuffer.append(TEXT_11);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
			}
		
    stringBuffer.append(TEXT_17);
    
	}
	if(!useExistingConnection){

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    
	}

    stringBuffer.append(TEXT_27);
    stringBuffer.append(TEXT_28);
    return stringBuffer.toString();
  }
}
