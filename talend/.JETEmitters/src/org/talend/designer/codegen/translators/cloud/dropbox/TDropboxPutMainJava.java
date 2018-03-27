package org.talend.designer.codegen.translators.cloud.dropbox;

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

public class TDropboxPutMainJava
{
  protected static String nl;
  public static synchronized TDropboxPutMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDropboxPutMainJava result = new TDropboxPutMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\tObject content_";
  protected final String TEXT_3 = " = ";
  protected final String TEXT_4 = ".content;" + NL + "\t\tif (content_";
  protected final String TEXT_5 = " == null) {" + NL + "\t\t\tthrow new Exception(\"The Uploaded Dropbox file Content can't be null\");" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tjava.io.InputStream inputStream_";
  protected final String TEXT_6 = " = null;" + NL + "\t\tif (content_";
  protected final String TEXT_7 = " instanceof byte[]) {" + NL + "\t\t\tinputStream_";
  protected final String TEXT_8 = " = new java.io.ByteArrayInputStream((byte[]) content_";
  protected final String TEXT_9 = ");" + NL + "\t\t} else if (content_";
  protected final String TEXT_10 = " instanceof java.io.InputStream) {" + NL + "\t\t\tinputStream_";
  protected final String TEXT_11 = " = (java.io.InputStream) content_";
  protected final String TEXT_12 = ";" + NL + "\t\t} else {" + NL + "\t\t\tinputStream_";
  protected final String TEXT_13 = " = new java.io.ByteArrayInputStream(content_";
  protected final String TEXT_14 = ".toString().getBytes());" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\ttry {" + NL + "\t\t\tcom.dropbox.core.v2.files.UploadBuilder uploadBuilder_";
  protected final String TEXT_15 = " = filesClient_";
  protected final String TEXT_16 = ".uploadBuilder(";
  protected final String TEXT_17 = ").withMode(";
  protected final String TEXT_18 = ").withAutorename(true);" + NL + "\t\t\tuploadBuilder_";
  protected final String TEXT_19 = ".uploadAndFinish(inputStream_";
  protected final String TEXT_20 = ");" + NL + "\t\t} finally {" + NL + "\t\t\tinputStream_";
  protected final String TEXT_21 = ".close();" + NL + "\t\t}\t\t";
  protected final String TEXT_22 = NL + "\tjava.io.InputStream inputStream_";
  protected final String TEXT_23 = " = new java.io.BufferedInputStream(new java.io.FileInputStream(";
  protected final String TEXT_24 = "));" + NL + "\ttry {" + NL + "\t\tcom.dropbox.core.v2.files.UploadBuilder uploadBuilder_";
  protected final String TEXT_25 = " = filesClient_";
  protected final String TEXT_26 = ".uploadBuilder(";
  protected final String TEXT_27 = ").withMode(";
  protected final String TEXT_28 = ").withAutorename(true);" + NL + "\t\tuploadBuilder_";
  protected final String TEXT_29 = ".uploadAndFinish(inputStream_";
  protected final String TEXT_30 = ");" + NL + "\t} finally {" + NL + "\t\tinputStream_";
  protected final String TEXT_31 = ".close();" + NL + "\t}";
  protected final String TEXT_32 = NL + "\tuploader_";
  protected final String TEXT_33 = ".finish();" + NL + "\tuploader_";
  protected final String TEXT_34 = ".close();" + NL + "\tuploader_";
  protected final String TEXT_35 = " = uploadBuilder_";
  protected final String TEXT_36 = ".start();" + NL + "\tuploaderStream_";
  protected final String TEXT_37 = " = uploader_";
  protected final String TEXT_38 = ".getOutputStream();" + NL + "\tuploaderFilterStream_";
  protected final String TEXT_39 = " = new java.io.FilterOutputStream(new com.dropbox.core.NoThrowOutputStream(uploaderStream_";
  protected final String TEXT_40 = ")) {" + NL + "\t\t@Override" + NL + "\t\tpublic void close() {" + NL + "\t\t\t// overridden exception throwing" + NL + "\t\t}" + NL + "\t};" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_41 = "_OUTPUTSTREAM\", uploaderFilterStream_";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = NL + "\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
		CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
		INode node = (INode)codeGenArgument.getArgument();
		String cid = node.getUniqueName();
		
		String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
		String accessToken = ElementParameterParser.getValue(node,"__ACCESS_TOKEN__");
	    String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	    String connectionKey = "conn_" + connection;
	    
	    String uploadLocalFile = ElementParameterParser.getValue(node, "__UPLOAD_LOCAL_FILE__");
	    String localFilePath = ElementParameterParser.getValue(node, "__LOCAL_FILE_PATH__");
	    
		String readContentFromInput = ElementParameterParser.getValue(node, "__READ_CONTENT_FROM_INPUT__");
		String exposeOutput = ElementParameterParser.getValue(node, "__EXPOSE_OUTPUT_STREAM__");
		
		String filePath = ElementParameterParser.getValue(node, "__FILE_PATH__");
		
        String dataInputConnection = null;	
        String dataOutputConnection = null;	
        
        if("true".equals(readContentFromInput)){
	        List< ? extends IConnection> inputConnections = node.getIncomingConnections();
		    for(IConnection conn : inputConnections) {
		        if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		        	dataInputConnection = conn.getName();
		        	break;
		        } // if(conn) end
		    } // for(conns) end
		    
		    
			List< ? extends IConnection> outputConnections = node.getOutgoingSortedConnections();
		    for(IConnection conn : outputConnections) {
		        if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		        	dataOutputConnection = conn.getName();
		        	break;
		        } // if(conn) end
		    } // for(conns) end
        }
		String mode = "com.dropbox.core.v2.files.WriteMode.ADD";
		if("true".equals(ElementParameterParser.getValue(node,"__FORCE_MODE__"))){
			mode = "com.dropbox.core.v2.files.WriteMode.OVERWRITE";
		}else if("true".equals(ElementParameterParser.getValue(node,"__UPDATE_MODE__"))){
			mode = "com.dropbox.core.v2.files.WriteMode.update("+ElementParameterParser.getValue(node,"__REVISION__")+")";
		}

    
if ("true".equals(readContentFromInput)) {

    
	if (dataInputConnection != null) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(dataInputConnection);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(filePath);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(mode);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
	}

    
} else if ("true".equals(uploadLocalFile)) {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(localFilePath);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(filePath);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(mode);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
} else if ("true".equals(exposeOutput)) {

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
    
}

    stringBuffer.append(TEXT_43);
    return stringBuffer.toString();
  }
}
