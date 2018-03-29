package org.talend.designer.codegen.translators.file.output;

import java.util.List;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TFileOutputPropertiesMainJava
{
  protected static String nl;
  public static synchronized TFileOutputPropertiesMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputPropertiesMainJava result = new TFileOutputPropertiesMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tproperties_";
  protected final String TEXT_3 = ".setProperty(";
  protected final String TEXT_4 = ".key, ";
  protected final String TEXT_5 = ".value);";
  protected final String TEXT_6 = NL + "\tini_";
  protected final String TEXT_7 = ".put(";
  protected final String TEXT_8 = ",";
  protected final String TEXT_9 = ".key, ";
  protected final String TEXT_10 = ".value);";
  protected final String TEXT_11 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String fileFormat = ElementParameterParser.getValue(node,"__FILE_FORMAT__");
String inConnName = null;
List< ? extends IConnection> inConns = node.getIncomingConnections();
for(IConnection conn : inConns){
	if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		inConnName = conn.getName();
	}
}
if(inConnName == null){
	return ""; //return immediately, generate nothing
}
if(("PROPERTIES_FORMAT").equals(fileFormat)){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(inConnName );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(inConnName );
    stringBuffer.append(TEXT_5);
    
}else if(("INI_FORMAT").equals(fileFormat)){
	String sectionName = ElementParameterParser.getValue(node,"__SECTION_NAME__");

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(sectionName );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(inConnName );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(inConnName );
    stringBuffer.append(TEXT_10);
    
}


    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}
