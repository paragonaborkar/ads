package org.talend.designer.codegen.translators.system;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.List;

public class TSSHEndJava
{
  protected static String nl;
  public static synchronized TSSHEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSSHEndJava result = new TSSHEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\tif(stringStdout_";
  protected final String TEXT_3 = ".length() > 0) {" + NL + "\t\t\t\t\tSystem.out.println(stringStdout_";
  protected final String TEXT_4 = ".toString());" + NL + "\t\t\t\t}";
  protected final String TEXT_5 = NL + "\t\t\t\tif(stringStderr_";
  protected final String TEXT_6 = ".length() > 0) {" + NL + "\t\t\t\t\tSystem.out.println(stringStderr_";
  protected final String TEXT_7 = ".toString());" + NL + "\t\t\t\t}";
  protected final String TEXT_8 = NL + "\t/* Close the connection */" + NL + "\t";
  protected final String TEXT_9 = NL + "\t\tlog.info(\"";
  protected final String TEXT_10 = " - Closing the connection to the server.\");" + NL + "\t";
  protected final String TEXT_11 = NL + "\tconn_";
  protected final String TEXT_12 = ".close();" + NL + "\t";
  protected final String TEXT_13 = NL + "\t\tlog.info(\"";
  protected final String TEXT_14 = " - Connection to the server closed.\");" + NL + "\t";
  protected final String TEXT_15 = NL + "\tglobalMap.put(\"";
  protected final String TEXT_16 = "_EXIT_CODE\",sess_";
  protected final String TEXT_17 = ".getExitStatus());" + NL + "\t";
  protected final String TEXT_18 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
	boolean stats = codeGenArgument.isStatistics();
	String standardOutput = ElementParameterParser.getValue(node, "__STANDARDOUTPUT__");
	String errorOutput = ElementParameterParser.getValue(node, "__ERROROUTPUT__");
	List<IMetadataTable> metadatas = node.getMetadataList();
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    	if (metadata!=null) {	
			if("TO_CONSOLE".equals(standardOutput) || "TO_CONSOLE_AND_GLOBAL_VARIABLE".equals(standardOutput)){

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
			}
			
			if("TO_CONSOLE".equals(errorOutput) || "TO_CONSOLE_AND_GLOBAL_VARIABLE".equals(errorOutput)){

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
			}
		}
	}

    stringBuffer.append(TEXT_8);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(TEXT_18);
    return stringBuffer.toString();
  }
}
