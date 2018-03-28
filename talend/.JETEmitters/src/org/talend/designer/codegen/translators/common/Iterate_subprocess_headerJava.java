package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.INode;
import org.talend.core.model.temp.ECodePart;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IExternalNode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.codegen.config.NodesSubTree;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.process.IContextParameter;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public class Iterate_subprocess_headerJava
{
  protected static String nl;
  public static synchronized Iterate_subprocess_headerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Iterate_subprocess_headerJava result = new Iterate_subprocess_headerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tNB_ITERATE_";
  protected final String TEXT_2 = "++;" + NL + "\t";
  protected final String TEXT_3 = NL + "\t\titerateLoop++;" + NL + "\t";
  protected final String TEXT_4 = NL + "\t";
  protected final String TEXT_5 = "\t\t\t" + NL + "\t\t\tclass ";
  protected final String TEXT_6 = "Thread extends TalendThread {//implements routines.system.TalendThreadPool.PropertySettable" + NL + "\t\t\t\tclass ThreadedMap extends java.util.HashMap<String, Object> {" + NL + "\t\t\t" + NL + "\t\t\t\t\tprivate static final long serialVersionUID = 0L;" + NL + "\t\t" + NL + "\t\t\t\t\tpublic ThreadedMap(java.util.Map<String, Object> globalMap) {" + NL + "\t\t\t\t\t\tsuper(globalMap);" + NL + "\t\t\t\t\t}" + NL + "\t\t" + NL + "\t\t\t\t\t@Override" + NL + "\t\t\t\t\tpublic Object put(String key, Object value) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\t\t\tsynchronized (";
  protected final String TEXT_8 = ".this.obj) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\t\t\t\tsuper.put(key, value);" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_10 = ".this.globalMap.put(key, value);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_11 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}\t" + NL + "\t\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\t\tprivate final ContextProperties localContext = new ContextProperties();" + NL + "\t\t\t\t";
  protected final String TEXT_14 = NL + "\t\t\t\tprivate java.util.Map<String, Object> globalMap = null;" + NL + "\t\t\t\tboolean isRunning = false;" + NL + "\t\t\t\tString iterateId = \"\";" + NL + "\t\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\t\tint iterateLoop = 0;" + NL + "\t\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t\t";
  protected final String TEXT_19 = "\t\t  " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_22 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_23 = NL + "\t" + NL + "\t\t\t\tpublic ";
  protected final String TEXT_24 = "Thread(java.util.Map<String, Object> globalMap";
  protected final String TEXT_25 = ", int threadID) {" + NL + "\t\t\t\t\tsuper();" + NL + "\t\t\t\t\t";
  protected final String TEXT_26 = NL + "\t\t        \t\tif(";
  protected final String TEXT_27 = " != null){" + NL + "\t\t            \t\t";
  protected final String TEXT_28 = NL + "\t\t    \t\t\t\t\tthis.";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = " = ";
  protected final String TEXT_31 = ".";
  protected final String TEXT_32 = ";" + NL + "\t\t    \t            ";
  protected final String TEXT_33 = NL + "\t\t        \t\t}" + NL + "\t\t        \t\t";
  protected final String TEXT_34 = NL + "\t\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\t\tsynchronized (globalMap) {" + NL + "\t\t\t\t\t\t\tthis.globalMap = java.util.Collections.synchronizedMap(new ThreadedMap(globalMap));" + NL + "\t\t\t\t\t";
  protected final String TEXT_36 = NL + "\t\t\t\t\t\tsynchronized (";
  protected final String TEXT_37 = ".this.obj) {" + NL + "\t\t\t\t\t\t\tthis.globalMap = new ThreadedMap(globalMap);" + NL + "\t\t\t\t\t";
  protected final String TEXT_38 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\titerateId = \".\" + threadID;" + NL + "\t\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t\t\titerateLoop++;" + NL + "\t\t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t\t\t\t//bug21906 copy context to local for mutilthread" + NL + "\t\t\t\t\t\tcontext.synchronizeContext();" + NL + "\t\t\t\t\t\tjava.util.Enumeration<?> propertyNames = context.propertyNames();" + NL + "\t\t\t\t\t\twhile(propertyNames.hasMoreElements()) {" + NL + "\t\t\t\t\t\t\tString propertyName = (String)propertyNames.nextElement();" + NL + "\t\t\t\t\t\t\tString propertyValue = context.getProperty(propertyName);" + NL + "\t\t\t\t\t\t\tlocalContext.setProperty(propertyName, propertyValue);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\t\t\t\tlocalContext.";
  protected final String TEXT_43 = " = context.";
  protected final String TEXT_44 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\t}" + NL + "" + NL + "" + NL + "\t\t\t\tpublic void run() {\t\t" + NL + "\t\t" + NL + "\t\t\t\t\tjava.util.Map threadRunResultMap = new java.util.HashMap();" + NL + "\t\t\t\t\tthreadRunResultMap.put(\"errorCode\", null);" + NL + "\t\t\t\t\tthreadRunResultMap.put(\"status\", \"\");" + NL + "\t\t\t\t\tthreadLocal.set(threadRunResultMap);" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tthis.isRunning = true;" + NL + "\t\t\t\t\tString currentComponent = \"\";" + NL + "\t\t\t\t\tjava.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();" + NL + "\t\t\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\t\t\t\tString currentVirtualComponent = null;" + NL + "\t\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\t\ttry {\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\t\t\t\tif(execStat){" + NL + "\t\t\t\t\t\t\t\trunStat.updateStatOnConnection(\"";
  protected final String TEXT_49 = "\",0,\"exec\"+iterateId);" + NL + "\t\t\t\t\t\t\t}\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\t\tif(execStat){\t\t\t\t" + NL + "\t       \t\t\t\trunStat.updateStatOnConnection(\"";
  protected final String TEXT_51 = "\", 3, 0);" + NL + "\t\t\t\t\t}           \t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\tif(execStat){" + NL + "\t\t\t\t\trunStat.updateStatOnIterate(\"";
  protected final String TEXT_53 = "\", RunStat.RUNNING);" + NL + "\t\t\t\t}        \t\t" + NL + "\t\t\t";
  protected final String TEXT_54 = NL + "\t\t\t\tif(execStat){" + NL + "\t\t\t\t\trunStat.updateStatOnConnection(\"";
  protected final String TEXT_55 = "\", 1, \"exec\" + NB_ITERATE_";
  protected final String TEXT_56 = ");" + NL + "\t\t\t\t\t//Thread.sleep(1000);" + NL + "\t\t\t\t}\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_57 = NL;

    // add the list of the connection names to avoid to declare two times the same name.
    public String createPrivateClassInstance(INode node, String parentLastRoot, boolean force) {
    	return createPrivateClassInstance(node, parentLastRoot, force, new HashSet<String>());
    }

    public String createPrivateClassInstance(INode n, String parentLastRoot, boolean force, Set<String> names) {
        String toReturn = "";
        // declare root structs (all main outgoing connections)
        for (IConnection conn : n.getOutgoingConnections()) {
            if (conn.getLineStyle().equals(EConnectionType.FLOW_MAIN) || conn.getLineStyle().equals(EConnectionType.FLOW_MERGE)) {
                if ((force)||(n.isSubProcessStart() || !(NodeUtil.isDataAutoPropagated(n)))) {
                    // new Instance
                    if (!names.contains(conn.getName())) {
	                    toReturn += conn.getName() + "Struct " + conn.getName() + " = new " + conn.getName()
	                            + "Struct();\n";
	                    names.add(conn.getName());
	                    parentLastRoot = conn.getName();
                    }
	            } else {
                    // copy
                    if (!names.contains(conn.getName())) {
	                    toReturn += parentLastRoot + "Struct " + conn.getName() + " = " + parentLastRoot + ";\n";
	                    names.add(conn.getName());
                    }
                }
                if(!conn.getTarget().getComponent().useMerge()) {
                   toReturn += createPrivateClassInstance(conn.getTarget(), parentLastRoot, false, names);
                }
            } else if (conn.getLineStyle().equals(EConnectionType.ITERATE)||conn.getLineStyle().equals(EConnectionType.ON_ROWS_END)) {
            	toReturn += createPrivateClassInstance(conn.getTarget(), parentLastRoot, true, names);
            }
        }
        return toReturn;
    }
    
    public String createPriveClassMethodDeclaration(INode n, String parentLastRoot, boolean force, Set<String> names) {
    	String toReturn = "";
        // declare root structs (all main outgoing connections)
        for (IConnection conn : n.getOutgoingConnections()) {
            if (conn.getLineStyle().equals(EConnectionType.FLOW_MAIN) || conn.getLineStyle().equals(EConnectionType.FLOW_MERGE)) {
                if ((force)||(n.isSubProcessStart() || !(NodeUtil.isDataAutoPropagated(n)))) {
                    // new Instance
                    if (!names.contains(conn.getName())) {
	                    toReturn += conn.getName() + "Struct " + conn.getName() + ",";
	                    names.add(conn.getName());
	                    parentLastRoot = conn.getName();
                    }
	            } else {
                    // copy
                    if (!names.contains(conn.getName())) {
	                    toReturn += parentLastRoot + "Struct " + conn.getName() + ",";
	                    names.add(conn.getName());
                    }
                }
                if(!conn.getTarget().getComponent().useMerge()) {
                   toReturn += createPriveClassMethodDeclaration(conn.getTarget(), parentLastRoot, false, names);
                }
            } else if (conn.getLineStyle().equals(EConnectionType.ITERATE)||conn.getLineStyle().equals(EConnectionType.ON_ROWS_END)) {
            	toReturn += createPriveClassMethodDeclaration(conn.getTarget(), parentLastRoot, true, names);
            }
        }
        return toReturn;
    }
    
    public String createPrivateClassMethodInstance(INode n, String parentLastRoot, boolean force, Set<String> names) {
        String toReturn = "";
        // declare root structs (all main outgoing connections)
        for (IConnection conn : n.getOutgoingConnections()) {
            if (conn.getLineStyle().equals(EConnectionType.FLOW_MAIN) || conn.getLineStyle().equals(EConnectionType.FLOW_MERGE)) {
                if ((force) || (n.isSubProcessStart() || !(NodeUtil.isDataAutoPropagated(n)))) {
                    // new Instance
                    if (!names.contains(conn.getName())) {
                        toReturn += conn.getName() + ",";
                        names.add(conn.getName());
                        parentLastRoot = conn.getName();
                    }
                } else {
                    // copy
                    if (!names.contains(conn.getName())) {
                        toReturn += conn.getName() + ",";
                        names.add(conn.getName());
                    }
                }
                if (!conn.getTarget().getComponent().useMerge()) {
                    toReturn += createPrivateClassMethodInstance(conn.getTarget(), parentLastRoot, false, names);
                }
            } else if (conn.getLineStyle().equals(EConnectionType.ITERATE)
                    || conn.getLineStyle().equals(EConnectionType.ON_ROWS_END)) {
                toReturn += createPrivateClassMethodInstance(conn.getTarget(), parentLastRoot, true, names);
            }
        }
        return toReturn;
    }
		 
    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
boolean containsTPartitioner = node.getProcess().getNodesOfType("tPartitioner").size() > 0 ? true : false;
boolean isRunJob = "tRunJob".equals(node.getComponent().getName());
IProcess process = node.getProcess();
 
NodesSubTree subTree = (NodesSubTree) codeGenArgument.getSubTree();
ECodePart codePart = codeGenArgument.getCodePart();
//boolean trace = codeGenArgument.isTrace();
boolean stat = codeGenArgument.isStatistics();

boolean isRunInMultiThread = codeGenArgument.getIsRunInMultiThread();

Set<IConnection> connSet =  new HashSet<IConnection>();
connSet.addAll(node.getOutgoingConnections(EConnectionType.FLOW_MAIN));
connSet.addAll(node.getOutgoingConnections(EConnectionType.FLOW_MERGE));

Set<IConnection> iterateConnSet =  new HashSet<IConnection>();
iterateConnSet.addAll(node.getIncomingConnections(EConnectionType.ITERATE));

String iterateNodeName = node.getUniqueName();

List<IContextParameter> params = new ArrayList<IContextParameter>();
params = process.getContextManager().getDefaultContext().getContextParameterList();

List<IConnection> allSubProcessConnection = codeGenArgument.getAllMainSubTreeConnections();
boolean parallelIterate = false;
for (IConnection iterateConn : iterateConnSet) { //1

    stringBuffer.append(TEXT_1);
    stringBuffer.append(iterateNodeName );
    stringBuffer.append(TEXT_2);
    if(containsTPartitioner){
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    	
	parallelIterate = "true".equals(ElementParameterParser.getValue(iterateConn, "__ENABLE_PARALLEL__"));
	if (parallelIterate) {//2
		if (codePart.equals(ECodePart.BEGIN)) {//3
			String rowList=","; 
			for (IConnection conn : allSubProcessConnection) {
				rowList += conn.getUniqueName()+"Struct "+conn.getUniqueName()+",";
			}
			rowList = rowList.substring(0, rowList.length()-1);
			
    stringBuffer.append(TEXT_5);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_6);
    if(!isRunInMultiThread){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_10);
    if(!isRunInMultiThread){
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
     if(isRunJob) {
    stringBuffer.append(TEXT_13);
     } 
    stringBuffer.append(TEXT_14);
    if(containsTPartitioner){
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    
				if(!subTree.isMergeSubTree()) {
					List< ? extends IConnection> rootConns = subTree.getRootNode().getOutgoingConnections();
					if ((rootConns!=null)&&(rootConns.size()>0)) {
					
    stringBuffer.append(TEXT_17);
    stringBuffer.append(createPrivateClassInstance(subTree.getRootNode(), rootConns.get(0).getName(), false));
    stringBuffer.append(TEXT_18);
    
					}
	  			} else {  
	    			List<INode> sortedMergeBranchStarts = subTree.getSortedMergeBranchStarts();    
	    			for (INode startNode : sortedMergeBranchStarts) {
	    				List< ? extends IConnection> rootConns = startNode.getOutgoingConnections();
	    				if ((rootConns!=null)&&(rootConns.size()>0)) {
						
    stringBuffer.append(TEXT_19);
    stringBuffer.append(createPrivateClassInstance(startNode, rootConns.get(0).getName(), false));
    stringBuffer.append(TEXT_20);
    
						}
					}
    
					List<INode> mergeNodes =subTree.getMergeNodes();
				    for(INode mNode:mergeNodes){
						List< ? extends IConnection> rootConns = mNode.getOutgoingConnections();
						if ((rootConns!=null)&&(rootConns.size()>0)) {
						
    stringBuffer.append(TEXT_21);
    stringBuffer.append(createPrivateClassInstance(mNode, rootConns.get(0).getName(), false));
    stringBuffer.append(TEXT_22);
    
						}
					}
				}
			
				String schemaInstanceDeclaration = createPriveClassMethodDeclaration(subTree.getRootNode(), subTree.getRootNode().getOutgoingConnections().get(0).getName(), false, new java.util.HashSet<String>());
				if (schemaInstanceDeclaration.length()>0) {
					schemaInstanceDeclaration = "," + schemaInstanceDeclaration.substring(0,schemaInstanceDeclaration.length()-1); 
				}
				
    stringBuffer.append(TEXT_23);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(schemaInstanceDeclaration );
    stringBuffer.append(TEXT_25);
    
					for (IConnection connection : allSubProcessConnection) {
		        		IMetadataTable table = connection.getMetadataTable();
		        		
    stringBuffer.append(TEXT_26);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_27);
    
		            		List<IMetadataColumn> listColumns = table.getListColumns();
		                	for (IMetadataColumn column : listColumns) {
		    				
    stringBuffer.append(TEXT_28);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_30);
    stringBuffer.append( connection.getName() );
    stringBuffer.append(TEXT_31);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_32);
    
		            		}
		            		
    stringBuffer.append(TEXT_33);
    
					} 
					
    stringBuffer.append(TEXT_34);
    
					// if codeGenArgument.getIsRunInMultiThread() is true, the job.this.globalMap will wrapped with synchronizedMap, use synchronized(job.this.globalMap) when use globalMap.keySet().iterator()
					// when codeGenArgument.getIsRunInMultiThread() is false, the job.this.globalMap is HashMap, use synchronized(job.this.object) when do the job.this.globalMap.put() operation(tMap,tIterateToFlow).
					if(isRunInMultiThread){
    stringBuffer.append(TEXT_35);
    }else{
    stringBuffer.append(TEXT_36);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
    if(containsTPartitioner){
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    if(isRunJob) {
    stringBuffer.append(TEXT_41);
     for (IContextParameter ctxParam : params){
    stringBuffer.append(TEXT_42);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_44);
    
						}
					}
					
    stringBuffer.append(TEXT_45);
    
					if(NodeUtil.hasVirtualComponent(subTree.getNodes())){
					
    stringBuffer.append(TEXT_46);
    
					}
					
    stringBuffer.append(TEXT_47);
    
	        			if(stat){
						
    stringBuffer.append(TEXT_48);
    stringBuffer.append(iterateConn.getUniqueName() );
    stringBuffer.append(TEXT_49);
    
						}
		}//3	
		continue;
	}else {//2
  		if(stat){
  			//iterateConn.getSource().getVirtualLinkTo() only works on the first component of a virtual component, if it works for the second one, the code should change 
  			boolean iterateInVComp = iterateConn.getSource().getVirtualLinkTo() != null && iterateConn.getSource().getVirtualLinkTo() == EConnectionType.ITERATE;
  			if(!iterateInVComp){ 
				Set<? extends IConnection> allInLineJobConns = NodeUtil.getAllInLineJobConnections(iterateConn.getTarget());
				for (IConnection inLineConn : allInLineJobConns) {
				
    stringBuffer.append(TEXT_50);
    stringBuffer.append(inLineConn.getUniqueName() );
    stringBuffer.append(TEXT_51);
            		
				}
			}
			if(node.getDesignSubjobStartNode().getComponent().getName().equals("tCollector")){
			
    stringBuffer.append(TEXT_52);
    stringBuffer.append(iterateConn.getUniqueName() );
    stringBuffer.append(TEXT_53);
    
			}else{
			
    stringBuffer.append(TEXT_54);
    stringBuffer.append(iterateConn.getUniqueName() );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(iterateNodeName );
    stringBuffer.append(TEXT_56);
    
			}
  		}
	}//2
}//1

    stringBuffer.append(TEXT_57);
    return stringBuffer.toString();
  }
}