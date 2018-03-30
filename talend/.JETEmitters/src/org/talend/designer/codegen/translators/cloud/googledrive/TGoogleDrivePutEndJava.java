package org.talend.designer.codegen.translators.cloud.googledrive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.codegen.config.NodeParamsHelper;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;

public class TGoogleDrivePutEndJava
{
  protected static String nl;
  public static synchronized TGoogleDrivePutEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGoogleDrivePutEndJava result = new TGoogleDrivePutEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "\t" + NL + "\t}finally {" + NL + "\t";
  protected final String TEXT_3 = NL + "\t\tif (";
  protected final String TEXT_4 = "_uploader_input != null)" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_5 = "_uploader_input.close();" + NL + "\t\t}" + NL + "\t\tif (";
  protected final String TEXT_6 = "_uploader_output != null)" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_7 = "_uploader_output.close();" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_8 = NL + "\t}" + NL + "\t\t";
  protected final String TEXT_9 = NL + "\t\t\tif(";
  protected final String TEXT_10 = ".content != null){" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\t((java.io.InputStream)";
  protected final String TEXT_11 = ".content).close();" + NL + "\t\t\t\t}catch(Exception e){" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
		CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
		INode node = (INode)codeGenArgument.getArgument();
		String cid = node.getUniqueName();
		NodeParamsHelper helper = new NodeParamsHelper(node);
		List<IMetadataTable> metadatas = node.getMetadataList();
		IMetadataTable metadata = null;
		
		boolean dieOnError = helper.getBoolParam("__DIE_ON_ERROR__");
		boolean overwrite = helper.getBoolParam("__OVERWRITE__");
		String title = helper.getStringParam("__FILE_TITLE__");
		
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
	    boolean exposeOutput = helper.getBoolParam("__EXPOSE_OUTPUT_STREAM__");

    stringBuffer.append(TEXT_2);
    if(exposeOutput){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    }
    stringBuffer.append(TEXT_8);
    if(dataOutputConnection != null){
    stringBuffer.append(TEXT_9);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(dataOutputConnection);
    stringBuffer.append(TEXT_11);
    }
    return stringBuffer.toString();
  }
}
