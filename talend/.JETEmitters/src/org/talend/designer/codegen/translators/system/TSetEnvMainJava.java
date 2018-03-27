package org.talend.designer.codegen.translators.system;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import java.util.Map;
import java.util.List;

public class TSetEnvMainJava
{
  protected static String nl;
  public static synchronized TSetEnvMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSetEnvMainJava result = new TSetEnvMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t        \tlog.info(\"";
  protected final String TEXT_3 = " - Setting environment variables.\");" + NL + "\t\t\t\t";
  protected final String TEXT_4 = NL + "                        if(System.getProperty(";
  protected final String TEXT_5 = ")!=null){" + NL + "                            System.setProperty(";
  protected final String TEXT_6 = ", System.getProperty(";
  protected final String TEXT_7 = ")+System.getProperty(\"path.separator\")+";
  protected final String TEXT_8 = ");" + NL + "                        }else{" + NL + "                           System.setProperty(";
  protected final String TEXT_9 = ",";
  protected final String TEXT_10 = ");                         " + NL + "                        }";
  protected final String TEXT_11 = NL + "                        System.setProperty(";
  protected final String TEXT_12 = ",";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "\t\t\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\t\t\tlog.debug(\"";
  protected final String TEXT_16 = " - Set environment variable: Key='\" + ";
  protected final String TEXT_17 = " + \"',Value='\" + System.getProperty(";
  protected final String TEXT_18 = ") + \"'.\");" + NL + "\t\t\t\t\t";
  protected final String TEXT_19 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {
            // component id
            String cid = node.getUniqueName();
            boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__")); 
            List<Map<String, String>> params = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__PARAMS__");
				if(isLog4jEnabled){
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    }
        	    for (int i = 0; i < params.size(); i++) {
    	            Map<String, String> line = params.get(i);
	                if(("true").equals(line.get("APPEND"))==true){

    stringBuffer.append(TEXT_4);
    stringBuffer.append( line.get("NAME") );
    stringBuffer.append(TEXT_5);
    stringBuffer.append( line.get("NAME") );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( line.get("NAME") );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( line.get("VALUE") );
    stringBuffer.append(TEXT_8);
    stringBuffer.append( line.get("NAME") );
    stringBuffer.append(TEXT_9);
    stringBuffer.append( line.get("VALUE") );
    stringBuffer.append(TEXT_10);
    
               		}else{
                        
 
    stringBuffer.append(TEXT_11);
    stringBuffer.append( line.get("NAME") );
    stringBuffer.append(TEXT_12);
    stringBuffer.append( line.get("VALUE") );
    stringBuffer.append(TEXT_13);
    
                    }

    stringBuffer.append(TEXT_14);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(line.get("NAME"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append( line.get("NAME") );
    stringBuffer.append(TEXT_18);
    }
    
                }
        }
    }
   
    stringBuffer.append(TEXT_19);
    return stringBuffer.toString();
  }
}
