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

public class THashInputEndJava
{
  protected static String nl;
  public static synchronized THashInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THashInputEndJava result = new THashInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    ";
  protected final String TEXT_2 = NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t";
  protected final String TEXT_4 = NL + NL + "\t";
  protected final String TEXT_5 = "\t" + NL + "\t\t\tnb_line_";
  protected final String TEXT_6 = "++;" + NL + "\t\t}\t" + NL + "    \t";
  protected final String TEXT_7 = "\t" + NL + "    \t\tmf_";
  protected final String TEXT_8 = ".clearCache(\"tHashFile_";
  protected final String TEXT_9 = "_\" + pid +\"_";
  protected final String TEXT_10 = "\");" + NL + "    \t";
  protected final String TEXT_11 = NL + "\t\torg.talend.designer.components.hashfile.common.MapHashFile.resourceLockMap.remove(\"tHashFile_";
  protected final String TEXT_12 = "_\" + pid +\"_";
  protected final String TEXT_13 = "\");";
  protected final String TEXT_14 = NL + "\t";
  protected final String TEXT_15 = NL + NL + NL + "\tglobalMap.put(\"";
  protected final String TEXT_16 = "_NB_LINE\", nb_line_";
  protected final String TEXT_17 = ");       ";
  protected final String TEXT_18 = NL;

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
    
 	if(outputDataConnName != null && tHashOutput_incommingDataConnName != null){
	
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    
     	boolean release_cache = "true".equals(ElementParameterParser.getValue(node, "__RELEASE_CACHE__"));
		String jobName = codeGenArgument.getJobName();
    	if(release_cache){
		
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(jobName );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(tHashOutputName );
    stringBuffer.append(TEXT_10);
    	
    	}
    	
    stringBuffer.append(TEXT_11);
    stringBuffer.append(jobName );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(tHashOutputName );
    stringBuffer.append(TEXT_13);
    //release lock the tHashOutput used
    stringBuffer.append(TEXT_14);
    
	}
	
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(TEXT_18);
    return stringBuffer.toString();
  }
}
