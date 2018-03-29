package org.talend.designer.codegen.translators.logs_errors;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TFlowMeterMainJava
{
  protected static String nl;
  public static synchronized TFlowMeterMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFlowMeterMainJava result = new TFlowMeterMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "    count_";
  protected final String TEXT_3 = "++; ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
        
		}
	}

    return stringBuffer.toString();
  }
}
