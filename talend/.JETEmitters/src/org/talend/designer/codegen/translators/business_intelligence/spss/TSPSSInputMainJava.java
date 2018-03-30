package org.talend.designer.codegen.translators.business_intelligence.spss;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.ElementParameterParser;
import java.util.List;

public class TSPSSInputMainJava
{
  protected static String nl;
  public static synchronized TSPSSInputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSPSSInputMainJava result = new TSPSSInputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t";
  protected final String TEXT_3 = "_sr = ";
  protected final String TEXT_4 = "_sf.readLine();";
  protected final String TEXT_5 = NL + "\t\t\t\t";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = "_sr.getStringAtPos(";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = "\t" + NL + "\t\t\t\t";
  protected final String TEXT_11 = ".";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = "_sr.getDateAtPos(";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL + "\t\t\t\t";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = "_sr.getDoubleAtPos(";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
String cid = node.getUniqueName();

String outputConnName = null;
IConnection outConn = null;
List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
if (conns!=null) {
	if (conns.size()>0) {
		for (int i=0;i<conns.size();i++) {
			IConnection connTemp = conns.get(i);
			if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				outputConnName = connTemp.getName();
				outConn=connTemp;
				break;
			}
		}
	}
}
if(outConn!=null){
	int i=0;
	IMetadataTable outputMetadataTable = outConn.getMetadataTable();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
		for (IMetadataColumn outputCol : outputMetadataTable.getListColumns()) {
			String typeToGenerate = JavaTypesManager.getTypeToGenerate(outputCol.getTalendType(), outputCol.isNullable());
	    		String typeName = JavaTypesManager.getTypeToGenerate(outputCol.getTalendType(), false);
	    		JavaType javaType = JavaTypesManager.getJavaTypeFromId(outputCol.getTalendType());
    			String patternValue = outputCol.getPattern() == null || outputCol.getPattern().trim().length() == 0 ? null : outputCol.getPattern();
			if(javaType == JavaTypesManager.STRING) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(outputCol.getLabel());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_9);
    			
			} else if(javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(outputCol.getLabel());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_14);
    
	    		} else if(JavaTypesManager.isNumberType(javaType, outputCol.isNullable())) { 

    stringBuffer.append(TEXT_15);
    stringBuffer.append(outputConnName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(outputCol.getLabel());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_19);
    
			}
			i++;

    
		}
}

    stringBuffer.append(TEXT_20);
    return stringBuffer.toString();
  }
}
