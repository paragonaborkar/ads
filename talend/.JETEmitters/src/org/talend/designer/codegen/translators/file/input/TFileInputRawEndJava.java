package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;

public class TFileInputRawEndJava
{
  protected static String nl;
  public static synchronized TFileInputRawEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputRawEndJava result = new TFileInputRawEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tif(fis_";
  protected final String TEXT_2 = "!=null)" + NL + "\t\t\t\t\t\t\tfis_";
  protected final String TEXT_3 = ".close();" + NL + "\t\t\t\t\t} catch (java.io.IOException e_";
  protected final String TEXT_4 = ") {";
  protected final String TEXT_5 = NL + "\t\t\t\t\t\tthrow e_";
  protected final String TEXT_6 = ";";
  protected final String TEXT_7 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\t\t\tlog.error(\"";
  protected final String TEXT_9 = " - \" +e_";
  protected final String TEXT_10 = ".getMessage());" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "\t\t\t\t\t}";
  protected final String TEXT_14 = NL;
  protected final String TEXT_15 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	boolean asInputstream = "true".equals(ElementParameterParser.getValue(node, "__AS_INPUTSTREAM__"));
	
	boolean dieOnError = "true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));
	
	java.util.List<IMetadataColumn> columnList = null;
	java.util.List<IMetadataTable> metadatas = node.getMetadataList();
	if(metadatas != null && metadatas.size() > 0) {
		IMetadataTable metadata = metadatas.get(0);
		if(metadata != null) {
		    columnList = metadata.getListColumns();
		}
	}
	java.util.List< ? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
	if(columnList!=null && outgoingConns!=null && outgoingConns.size()>0) {
		IConnection outgoingConn = outgoingConns.get(0);// only have one flow output
		if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			
			final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
			if(asInputstream) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
				if(dieOnError) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
				} else {

    stringBuffer.append(TEXT_7);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
				}

    stringBuffer.append(TEXT_13);
    
				
			}
		}
	}

    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    return stringBuffer.toString();
  }
}
