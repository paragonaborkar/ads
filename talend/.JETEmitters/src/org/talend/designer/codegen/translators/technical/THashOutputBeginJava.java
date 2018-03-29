package org.talend.designer.codegen.translators.technical;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class THashOutputBeginJava
{
  protected static String nl;
  public static synchronized THashOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THashOutputBeginJava result = new THashOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t";
  protected final String TEXT_4 = NL + NL;
  protected final String TEXT_5 = NL + "org.talend.designer.components.hashfile.common.MapHashFile mf_";
  protected final String TEXT_6 = "=org.talend.designer.components.hashfile.common.MapHashFile.getMapHashFile();";
  protected final String TEXT_7 = "    " + NL + "\t\torg.talend.designer.components.hashfile.memory.AdvancedMemoryHashFile<";
  protected final String TEXT_8 = "Struct> tHashFile_";
  protected final String TEXT_9 = " = null;" + NL + "\t\tString hashKey_";
  protected final String TEXT_10 = " = \"tHashFile_";
  protected final String TEXT_11 = "_\" + pid + \"_";
  protected final String TEXT_12 = "\";";
  protected final String TEXT_13 = NL + "\t\t\tsynchronized(org.talend.designer.components.hashfile.common.MapHashFile.resourceLockMap.get(hashKey_";
  protected final String TEXT_14 = ")){" + NL + "\t\t\t    if(mf_";
  protected final String TEXT_15 = ".getResourceMap().get(hashKey_";
  protected final String TEXT_16 = ") == null){" + NL + "\t      \t\t    mf_";
  protected final String TEXT_17 = ".getResourceMap().put(hashKey_";
  protected final String TEXT_18 = ", new org.talend.designer.components.hashfile.memory.AdvancedMemoryHashFile<";
  protected final String TEXT_19 = "Struct>(org.talend.designer.components.hashfile.common.MATCHING_MODE.";
  protected final String TEXT_20 = "));" + NL + "\t      \t\t    tHashFile_";
  protected final String TEXT_21 = " = mf_";
  protected final String TEXT_22 = ".getResourceMap().get(hashKey_";
  protected final String TEXT_23 = ");" + NL + "\t\t\t    }else{" + NL + "\t\t\t    \ttHashFile_";
  protected final String TEXT_24 = " = mf_";
  protected final String TEXT_25 = ".getResourceMap().get(hashKey_";
  protected final String TEXT_26 = ");" + NL + "\t\t\t    }" + NL + "\t\t\t}";
  protected final String TEXT_27 = NL + "\t\t\tsynchronized(org.talend.designer.components.hashfile.common.MapHashFile.resourceLockMap.get(hashKey_";
  protected final String TEXT_28 = ")){" + NL + "\t\t\t\tmf_";
  protected final String TEXT_29 = ".getResourceMap().put(hashKey_";
  protected final String TEXT_30 = ", new org.talend.designer.components.hashfile.memory.AdvancedMemoryHashFile<";
  protected final String TEXT_31 = "Struct>(org.talend.designer.components.hashfile.common.MATCHING_MODE.";
  protected final String TEXT_32 = "));" + NL + "\t\t\t\ttHashFile_";
  protected final String TEXT_33 = " = mf_";
  protected final String TEXT_34 = ".getResourceMap().get(hashKey_";
  protected final String TEXT_35 = ");" + NL + "\t\t\t}";
  protected final String TEXT_36 = NL + "\t\torg.talend.designer.components.hashfile.memory.AdvancedMemoryHashFile<";
  protected final String TEXT_37 = "Struct> tHashFile_";
  protected final String TEXT_38 = " = null; " + NL + "\t\t//use this map to keep the present key and the previous key of AdvancedMemoryHashFile" + NL + "\t\tmf_";
  protected final String TEXT_39 = ".getKeyMap().put(\"tHashFile_";
  protected final String TEXT_40 = "_\" +pid + \"_";
  protected final String TEXT_41 = "\", \"tHashFile_";
  protected final String TEXT_42 = "_\" + pid + \"_";
  protected final String TEXT_43 = "\");";
  protected final String TEXT_44 = NL + "        int nb_line_";
  protected final String TEXT_45 = " = 0;";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	class Util{
		//keep the tHashOutput Name when on the searching patch, in order to avoid the cycle reference problem.
		Set<String> nodeNames = new HashSet<String>();
		List<? extends INode> nodes = null;
		//the parameter node is tHashInput/tHashOutput
		public INode getOriginaltHashOutputNode(INode node) throws java.lang.Exception{	
			//initial it only once.
			if(nodes == null){
				nodes = node.getProcess().getGeneratingNodes();
			}
			
			String uniqueName = node.getUniqueName();
			if(nodeNames.contains(uniqueName)){
				//happen the cycle problem!!!
				//return null;
				throw new java.lang.Exception("Problem with " + uniqueName + " caused by cross-linking two tHashOutput components to each other.");
			}else{
				nodeNames.add(uniqueName);
				//1. get the tHashOuput node
				boolean isLinked = "true".equals(ElementParameterParser.getValue(node, "__LINK_WITH__"));
				String tHashOutputName = ElementParameterParser.getValue(node, "__LIST__");
				if(isLinked){
				
					//System.out.println("Node:" + uniqueName);
					//System.out.println("__LINK_WITH__:" + isLinked);
					//System.out.println("__LIST__:" + tHashOutputName);
					
					if(tHashOutputName != null && !tHashOutputName.trim().equals("")){
						INode tHashOutput = getNodeFromProcess(tHashOutputName);
						if(tHashOutput != null){
							//recursive call it!!!
							return getOriginaltHashOutputNode(tHashOutput);
						}else{
							//if go here, it means that user delete the original tHashOutput 
							//return null;
							throw new java.lang.Exception("if go here, it means that user delete the original tHashOutput.");
						}
					}else{
						//if go here, it means there should link to a tHashOutput, but user doesn't it.
						//return null;
						throw new java.lang.Exception("if go here, it means there should link to a tHashOutput, but user doesn't it.");
					}
				}else{
					//get it!!! it can be a 1).tHashInput(read file directly), 2). tHashOuput (the original one)  
					return node;
				}				
			}			
		}
		
		private INode getNodeFromProcess(String nodeName){			
	    	for (INode nd : nodes) {
	     	   if (nd.getUniqueName().equals(nodeName)) {
	     	      return nd;
	     	   }
	     	}			
			return null;
		}	
		
	}

    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	String jobName = codeGenArgument.getJobName();
	INode node = (INode)codeGenArgument.getArgument();	
	String cid = node.getUniqueName();
	
	//1. get the tHashOuput node
	boolean isLinked = "true".equals(ElementParameterParser.getValue(node, "__LINK_WITH__"));
	String tHashOutputName = ElementParameterParser.getValue(node, "__LIST__");
	INode tHashOutputNode = null;
	if(isLinked){
		try{
			Util util = new Util();
			tHashOutputNode = util.getOriginaltHashOutputNode(node);	
			//System.out.println(tHashOutputNode.getUniqueName());
		}catch(java.lang.Exception e){
    stringBuffer.append(TEXT_2);
    stringBuffer.append(e.getMessage() );
    stringBuffer.append(TEXT_3);
    }
	}
	
	//2. get tHashInput medadata
	IMetadataTable metadata = null;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if (metadatas != null && metadatas.size() > 0) {
    	metadata = metadatas.get(0);
    }
    
    //3. get tHashOutput medadata
	IMetadataTable tHashOutput_metadata = null;	
	if(tHashOutputNode != null){
    	List<IMetadataTable> tHashOutput_metadatas = tHashOutputNode.getMetadataList();
    	if (tHashOutput_metadatas != null && tHashOutput_metadatas.size() > 0) {
        	tHashOutput_metadata = tHashOutput_metadatas.get(0);
        }
	}
	
	//5. get tHashInput output connectionName
	IConnection outputDataConn = null;
	String outputDataConnName = null;
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	if (conns != null) {
		for (IConnection conn : conns) {
			if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
				outputDataConn = conn;
				outputDataConnName = outputDataConn.getName();
				break;
			}
		}
	}
	
	//6. get tHashOutput incomming connectionName
	IConnection tHashOutput_incommingDataConn = null;
	String tHashOutput_incommingDataConnName = null;
	if(tHashOutputNode != null){
    	List< ? extends IConnection> tHashOutput_conns = tHashOutputNode.getIncomingConnections();
    	if (conns != null) {
    		for (IConnection conn : tHashOutput_conns) {
    			if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
    				tHashOutput_incommingDataConn = conn;
    				tHashOutput_incommingDataConnName = tHashOutput_incommingDataConn.getName();
    				break;
    			}
    		}
    	}
	}

    stringBuffer.append(TEXT_4);
    	
	String matchingMode = ElementParameterParser.getValue(node,"__KEYS_MANAGEMENT__");
	
	//7. get input data connection	
	IConnection incommingDataConn = null;
    List< ? extends IConnection> connections = node.getIncomingConnections();
	if (connections != null) {
		for (IConnection conn : connections) {
			if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
				incommingDataConn = conn;
				break;
			}
		}
	}

    
//fix bug 21630,add a class MapHashFile,when the AdvancedMemoryHashFile of the linked tHashOutput is null,use method getAdvancedMemoryHashFile to get previous AdvancedMemoryHashFile.

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    	
if(!isLinked){//111
	//////////////////////////////////////////////////////////////
	//it doesn't link to another tHashOutput, it is a new HashFile.
	
	boolean isAppend = "true".equals(ElementParameterParser.getValue(node, "__APPEND__"));
	
	if(incommingDataConn != null){//222
		String connectionName = incommingDataConn.getName();

    stringBuffer.append(TEXT_7);
    stringBuffer.append(connectionName );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(jobName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
		if (isAppend) {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(matchingMode);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    
		} else {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(connectionName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(matchingMode);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    
		}
	}//222
}else{//111
	//////////////////////////////////////////////////////////////
	//it link to another tHashOutput, it works in append model.

    stringBuffer.append(TEXT_36);
    stringBuffer.append(tHashOutput_incommingDataConnName );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(jobName );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(jobName );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(tHashOutputName );
    stringBuffer.append(TEXT_43);
    
}//111

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    return stringBuffer.toString();
  }
}
