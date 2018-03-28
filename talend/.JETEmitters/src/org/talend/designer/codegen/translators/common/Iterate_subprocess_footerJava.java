package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.INode;
import org.talend.core.model.temp.ECodePart;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.NodesSubTree;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

public class Iterate_subprocess_footerJava
{
  protected static String nl;
  public static synchronized Iterate_subprocess_footerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Iterate_subprocess_footerJava result = new Iterate_subprocess_footerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\t\tif(execStat){" + NL + "\t\t\t\t\t\trunStat.updateStatOnConnection(\"";
  protected final String TEXT_3 = "\",2,\"exec\"+iterateId);" + NL + "\t\t\t\t\t}\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\t\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t\t\t\t\tthis.status = \"failure\";" + NL + "\t\t\t\t\t\t\tInteger localErrorCode = (Integer) (((java.util.Map) threadLocal.get()).get(\"errorCode\"));" + NL + "\t\t\t\t\t\t\tif (localErrorCode != null) {" + NL + "\t\t\t\t\t\t\t\tif (this.errorCode == null || localErrorCode.compareTo(this.errorCode) > 0) {" + NL + "\t\t\t\t\t\t\t\t\tthis.errorCode = localErrorCode;" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}\t\t\t\t\t" + NL + "\t\t\t\t            \t\t            " + NL + "\t\t                    TalendException te = new TalendException(e, currentComponent, globalMap);" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_5 = NL + "\t\t\t\t\t\t\t\tte.setVirtualComponentName(currentVirtualComponent);" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\t\t\t\tthis.exception = te;" + NL + "\t\t\t\t\t\t\ttalendThreadPool.setErrorThread(this);" + NL + "\t\t\t\t            talendThreadPool.stopAllWorkers();" + NL + "\t" + NL + "\t\t\t\t\t\t} catch (java.lang.Error error){" + NL + "\t\t\t\t\t\t\tthis.status = \"failure\";" + NL + "\t\t\t\t\t\t\tInteger localErrorCode = (Integer) (((java.util.Map) threadLocal.get()).get(\"errorCode\"));" + NL + "\t\t\t\t\t\t\tif (localErrorCode != null) {" + NL + "\t\t\t\t\t\t\t\tif (this.errorCode == null || localErrorCode.compareTo(this.errorCode) > 0) {" + NL + "\t\t\t\t\t\t\t\t\tthis.errorCode = localErrorCode;" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tthis.error = error;\t\t\t\t            \t\t            " + NL + "\t\t\t\t\t\t\ttalendThreadPool.setErrorThread(this);" + NL + "\t\t\t\t            talendThreadPool.stopAllWorkers();" + NL + "\t\t\t\t\t\t} finally {" + NL + "\t\t\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\t\t\t\t}catch(java.lang.Exception e){\t" + NL + "\t\t\t\t\t\t\t\t//ignore" + NL + "\t\t\t\t\t\t\t}catch(java.lang.Error error){" + NL + "\t\t\t\t\t\t\t\t//ignore" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tresourceMap = null;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tthis.isRunning = false;" + NL + "\t\t\t\t" + NL + "\t\t\t\t\t\tInteger localErrorCode = (Integer) (((java.util.Map) threadLocal.get()).get(\"errorCode\"));" + NL + "\t\t\t\t\t\tString localStatus = (String) (((java.util.Map) threadLocal.get()).get(\"status\"));" + NL + "\t\t\t\t\t\tif (localErrorCode != null) {" + NL + "\t\t\t\t\t\t\tif (this.errorCode == null || localErrorCode.compareTo(this.errorCode) > 0) {" + NL + "\t\t\t\t\t\t\t\tthis.errorCode = localErrorCode;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t} " + NL + "\t\t\t\t\t\tif (!this.status.equals(\"failure\")) {" + NL + "\t\t\t\t\t\t\tthis.status = localStatus;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\ttalendThreadPool.getTalendThreadResult().setErrorCode(this.errorCode);" + NL + "\t\t\t\t\t\ttalendThreadPool.getTalendThreadResult().setStatus(this.status);\t\t\t\t\t\t" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_8 = "Thread bt_";
  protected final String TEXT_9 = " = new ";
  protected final String TEXT_10 = "Thread(globalMap";
  protected final String TEXT_11 = ",threadIdCounter_";
  protected final String TEXT_12 = "++);" + NL + "\t\t\t\tmtp_";
  protected final String TEXT_13 = ".execute(bt_";
  protected final String TEXT_14 = ");" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_15 = NL + "\t\t      \t\t\tif(execStat){" + NL + "\t\t\t\t\t\t\trunStat.updateStatOnIterate(\"";
  protected final String TEXT_16 = "\", RunStat.END);" + NL + "\t\t\t\t\t\t}  " + NL + "\t      \t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\t\t\tif(execStat){" + NL + "\t\t\t\t\t\t\trunStat.updateStatOnConnection(\"";
  protected final String TEXT_18 = "\", 2, \"exec\" + NB_ITERATE_";
  protected final String TEXT_19 = ");" + NL + "\t\t\t\t\t\t}\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_20 = NL;

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
	Vector v = (Vector) codeGenArgument.getArgument();
    INode node = (INode) v.get(0);
    String finallyPart = v.get(1).toString();
	
	ECodePart codePart = codeGenArgument.getCodePart();
	//boolean trace = codeGenArgument.isTrace();
	boolean stat = codeGenArgument.isStatistics();
	
	Set<IConnection> connSet =  new HashSet<IConnection>();
	connSet.addAll(node.getOutgoingConnections(EConnectionType.FLOW_MAIN));
	connSet.addAll(node.getOutgoingConnections(EConnectionType.FLOW_MERGE));
	//String incomingName = codeGenArgument.getIncomingName();
	NodesSubTree subTree = (NodesSubTree) codeGenArgument.getSubTree();
	
	Set<IConnection> iterateConnSet =  new HashSet<IConnection>();
	iterateConnSet.addAll(node.getIncomingConnections(EConnectionType.ITERATE));
	
	String iterateNodeName = node.getUniqueName();
	
	List<IConnection> allSubProcessConnection = codeGenArgument.getAllMainSubTreeConnections();

    stringBuffer.append(TEXT_1);
    
	if (codePart.equals(ECodePart.END)) {//1
		boolean parallelIterate = false;
		for (IConnection iterateConn : iterateConnSet) {//2
			parallelIterate = "true".equals(ElementParameterParser.getValue(iterateConn, "__ENABLE_PARALLEL__")); 
	        if (parallelIterate) {//3
    			String schemaInstanceDeclaration = createPrivateClassMethodInstance(subTree.getRootNode(), subTree.getRootNode().getOutgoingConnections().get(0).getName(), false, new java.util.HashSet<String>());
    			if (schemaInstanceDeclaration.length()>0) {
    				schemaInstanceDeclaration = "," + schemaInstanceDeclaration.substring(0,schemaInstanceDeclaration.length()-1); 
    			}
				if(stat){
				
    stringBuffer.append(TEXT_2);
    stringBuffer.append(iterateConn.getUniqueName() );
    stringBuffer.append(TEXT_3);
    
				}
				
    stringBuffer.append(TEXT_4);
    
							if(NodeUtil.hasVirtualComponent(subTree.getNodes())){
							
    stringBuffer.append(TEXT_5);
    
							}
							
    stringBuffer.append(TEXT_6);
    stringBuffer.append(finallyPart);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(schemaInstanceDeclaration );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_14);
    
				continue;
			}else {//3
	      		if(stat){
	      			if(node.getDesignSubjobStartNode().getComponent().getName().equals("tCollector")){
	      			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(iterateConn.getUniqueName() );
    stringBuffer.append(TEXT_16);
    
					}else{
    stringBuffer.append(TEXT_17);
    stringBuffer.append(iterateConn.getUniqueName() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(iterateNodeName );
    stringBuffer.append(TEXT_19);
    
					}
		  		}
		  	}//3				
		}//2
	}//1

    stringBuffer.append(TEXT_20);
    return stringBuffer.toString();
  }
}