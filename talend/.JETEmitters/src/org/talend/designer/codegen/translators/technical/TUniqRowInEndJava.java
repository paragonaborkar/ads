package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;

public class TUniqRowInEndJava
{
  protected static String nl;
  public static synchronized TUniqRowInEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TUniqRowInEndJava result = new TUniqRowInEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "            }" + NL + "            globalMap.put(\"";
  protected final String TEXT_2 = "_NB_UNIQUES\",nb_uniq_";
  protected final String TEXT_3 = ");" + NL + "            globalMap.put(\"";
  protected final String TEXT_4 = "_NB_DUPLICATES\",nb_";
  protected final String TEXT_5 = " - nb_uniq_";
  protected final String TEXT_6 = ");";
  protected final String TEXT_7 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_8 = " - Unique records count: \" + (nb_uniq_";
  protected final String TEXT_9 = ")+\" .\");" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_10 = " - Duplicate records count: \" + (nb_";
  protected final String TEXT_11 = " - nb_uniq_";
  protected final String TEXT_12 = ")+\" .\");" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "            }" + NL + "            globalMap.put(\"";
  protected final String TEXT_14 = "_NB_UNIQUES\", nb_uniq_";
  protected final String TEXT_15 = ");" + NL + "            globalMap.put(\"";
  protected final String TEXT_16 = "_NB_DUPLICATES\", nb_duplicate_";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_19 = " - Unique records count: \" + (nb_uniq_";
  protected final String TEXT_20 = ")+\" .\");" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_21 = " - Duplicate records count: \" + (nb_duplicate_";
  protected final String TEXT_22 = ")+\" .\");" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "            }" + NL + "            globalMap.put(\"";
  protected final String TEXT_24 = "_NB_UNIQUES\", nb_";
  protected final String TEXT_25 = " - nb_duplicate_";
  protected final String TEXT_26 = ");" + NL + "            globalMap.put(\"";
  protected final String TEXT_27 = "_NB_DUPLICATES\", nb_duplicate_";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_30 = " - Unique records count: \" + (nb_";
  protected final String TEXT_31 = " - nb_duplicate_";
  protected final String TEXT_32 = ")+\" .\");" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_33 = " - Duplicate records count: \" + (nb_duplicate_";
  protected final String TEXT_34 = ")+\" .\");" + NL + "\t\t\t";
  protected final String TEXT_35 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = ElementParameterParser.getValue(node, "__CID__");

int UNIQUE = 1;
int UNIQUE_AND_DUPLICATE = 2;
int UNIQUE_AND_DUPLICATE_ONCE = 3;
int DUPLICATE = 4;
int DUPLICATE_ONCE = 5;

int mode = 0;
String connUniqName = null;
String connDuplicateName = null;
boolean onlyOnceEachDuplicatedKey = ("true").equals(ElementParameterParser.getValue(node, "__ONLY_ONCE_EACH_DUPLICATED_KEY__"));
List<? extends IConnection> connsUnique = node.getOutgoingConnections("UNIQUE");
List<? extends IConnection> connsDuplicate = node.getOutgoingConnections("DUPLICATE");
final boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
if(connsUnique.size() > 0){
	connUniqName = connsUnique.get(0).getName();
	if(connsDuplicate.size() > 0){
		connDuplicateName = connsDuplicate.get(0).getName();
		if(onlyOnceEachDuplicatedKey){
			mode =3;
		}else{
			mode = 2;
		}
	}else{
		mode = 1;
	}
}else{
	if(connsDuplicate.size() > 0){
		connDuplicateName = connsDuplicate.get(0).getName();
		if(onlyOnceEachDuplicatedKey){
			mode =5;
		}else{
			mode = 4;
		}
	}
}

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
}else{
	mode = 0;
}

if(mode == UNIQUE){//HSS_____0

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    
			}
			
    
}else if(mode == UNIQUE_AND_DUPLICATE_ONCE || mode == UNIQUE_AND_DUPLICATE){//HSS_____0

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
			}
			
    
}else if(mode == DUPLICATE_ONCE || mode == DUPLICATE){//HSS_____0

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    
			}
			
    
}//HSS_____0


    stringBuffer.append(TEXT_35);
    return stringBuffer.toString();
  }
}
