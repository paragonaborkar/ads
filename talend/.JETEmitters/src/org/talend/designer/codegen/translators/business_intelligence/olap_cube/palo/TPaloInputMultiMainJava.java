package org.talend.designer.codegen.translators.business_intelligence.olap_cube.palo;

import java.util.List;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;

public class TPaloInputMultiMainJava
{
  protected static String nl;
  public static synchronized TPaloInputMultiMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPaloInputMultiMainJava result = new TPaloInputMultiMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\t\tjava.util.Hashtable <String[], org.talend.jpalo.palodatavalue> htPLD_";
  protected final String TEXT_3 = " = pDT_";
  protected final String TEXT_4 = ".getResultHashTable();" + NL + "\t\tjava.util.Enumeration enPLD_";
  protected final String TEXT_5 = " = htPLD_";
  protected final String TEXT_6 = ".keys();" + NL + "\t\twhile (enPLD_";
  protected final String TEXT_7 = ".hasMoreElements()) {" + NL + "\t\t\tString[] strKey =(String[])enPLD_";
  protected final String TEXT_8 = ".nextElement();" + NL + "\t\t\t// System.out.println(org.talend.jpalo.palohelpers.makeStrinOfArray(strKey)+ \",\" + htPLD_";
  protected final String TEXT_9 = ".get(strKey).getDoubleValue());";
  protected final String TEXT_10 = NL + "\t\t\t\t\t";
  protected final String TEXT_11 = ".";
  protected final String TEXT_12 = " = strKey[";
  protected final String TEXT_13 = "];";
  protected final String TEXT_14 = NL + "\t\t\t";
  protected final String TEXT_15 = ".MEASURE =  htPLD_";
  protected final String TEXT_16 = ".get(strKey).getDoubleValue();" + NL + "\t\t\t";
  protected final String TEXT_17 = ".TEXT =  htPLD_";
  protected final String TEXT_18 = ".get(strKey).getStringValue();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	String cid = node.getUniqueName();

    
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

	if(null!=strOutputConnectionName && strOutputConnectionName.length()>0){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
			List<IMetadataTable> metadatas = node.getMetadataList();
			if ((metadatas!=null)&&(metadatas.size()>0)) {
				IMetadataTable metadata = metadatas.get(0);
				List<IMetadataColumn> columns = metadata.getListColumns();
				for (int i = 0; i < columns.size()-2; i++) {
					IMetadataColumn column = columns.get(i);

    stringBuffer.append(TEXT_10);
    stringBuffer.append(strOutputConnectionName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_13);
    
				}
			}

    stringBuffer.append(TEXT_14);
    stringBuffer.append(strOutputConnectionName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(strOutputConnectionName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    
	}

    return stringBuffer.toString();
  }
}
