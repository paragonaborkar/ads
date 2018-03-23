package org.talend.designer.codegen.translators.cloud.box;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TBoxGetEndJava
{
  protected static String nl;
  public static synchronized TBoxGetEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBoxGetEndJava result = new TBoxGetEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t";
  protected final String TEXT_3 = NL + "\t\t\tif(";
  protected final String TEXT_4 = ".content != null){" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\t((java.io.InputStream)";
  protected final String TEXT_5 = ".content).close();" + NL + "\t\t\t\t}catch(Exception e){" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_6 = NL + "\t\t\tjava.io.InputStream in = (java.io.InputStream)globalMap.get(\"";
  protected final String TEXT_7 = "_INPUT_STREAM\");" + NL + "\t\t\tif(in != null) {" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\tin.close();" + NL + "\t\t\t\t}catch(Exception e){" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
		CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
		INode node = (INode)codeGenArgument.getArgument();
		String cid = node.getUniqueName();
		
		List<IMetadataTable> metadatas = node.getMetadataList();
		IMetadataTable metadata = null;
		if ((metadatas!=null)&&(metadatas.size()>0)) {
			metadata = metadatas.get(0);    
	    }
		
		List< ? extends IConnection> outputConnections = node.getOutgoingSortedConnections();
		
        String dataOutputConnection = null;	
	    for(IConnection conn : outputConnections) {
	        if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	        	dataOutputConnection = conn.getName();
	        	break;
	        } // if(conn) end
	    } // for(conns) end

    stringBuffer.append(TEXT_2);
    if(dataOutputConnection != null){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_5);
    } else {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    }
    return stringBuffer.toString();
  }
}
